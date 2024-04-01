package dao;

import entity.Course;
import entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import Exception.CourseExistException;

/**
 * @author: yue
 * @description:
 */


public class CourseDao {
    private Connection conn = null;

// enroll course for student or teacher according to userid and courseid; if they had enrolled the specific course, then update in db
    public void  enrollCourse4User(int UserID, int CourseID) throws Exception {
        initConnection();
        String checkSql="select * from User_Course_Table where UserID=? and CourseID=? ";
        PreparedStatement statement = conn.prepareStatement(checkSql);
        statement.setInt(1, UserID);
        statement.setInt(2, CourseID);
        ResultSet checkSet = statement.executeQuery();
        if(checkSet.next()){
            String updateSql="update User_Course_Table set CourseID=? where UserID=? ";
            PreparedStatement updateStatement = conn.prepareStatement(updateSql);
            updateStatement.setInt(1, CourseID);
            updateStatement.setInt(2, UserID);
            updateStatement.executeUpdate();
        }else {
            String sql = "INSERT INTO User_Course_Table (UserID, CourseID) VALUES (?, ?)";
            try (PreparedStatement insertStatement = conn.prepareStatement(sql)) {
                insertStatement.setInt(1, UserID);
                insertStatement.setInt(2, CourseID);
                insertStatement.executeUpdate();
            }
        }

        closeConnection();
    }
// get courses according to id return a list of course
    public List<Course> getCourses4User(int UserID) throws Exception {
        initConnection();
        List<Course> courses = new ArrayList<>();
        String sql = "SELECT c.* FROM Course_Table c JOIN User_Course_Table uc ON c.CourseID = uc.CourseID WHERE uc.UserID = ?";
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, UserID);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    int courseId = resultSet.getInt("CourseID");
                    String courseName = resultSet.getString("CourseName");
                    String semester = resultSet.getString("Semester");
                    Course course = new Course(courseId, courseName, semester);
                    courses.add(course);
                }
            }
        }
        return courses;
    }
    // get course by courseid
public Course getCourseById(int CourseID) throws Exception{
    initConnection();

    String sql="SELECT * FROM Course_Table  WHERE CourseID = ?";
    Course course=new Course();
    try (PreparedStatement statement = conn.prepareStatement(sql)) {
        statement.setInt(1, CourseID);
        try (ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int courseId = resultSet.getInt("CourseID");
                String courseName = resultSet.getString("CourseName");
                String semester = resultSet.getString("Semester");
               course = new Course(courseId, courseName, semester);

            }
        }
    }
return course;
}



// get students who registered a specific course by courseid
public List<User> getStudentsByCourseId(int CourseId)  throws Exception{
    initConnection();
    List<User> students=new ArrayList<>();
     String sql="SELECT u.UserID, u.Username FROM User_Table u JOIN User_Course_Table uc ON u.UserID = uc.UserID WHERE u.Role='student' and uc.CourseID = ? ";
    try (PreparedStatement statement = conn.prepareStatement(sql)) {
        statement.setInt(1,CourseId );
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    int studentId = resultSet.getInt("UserID");
                    String UserName=resultSet.getString("Username");
                    User student= new User(studentId,UserName );
                    students.add(student);
                }
            }

    }
    return students;
}
//create a course, if course exists which means there is the same course name in db, alert; else insert new course
    public void createCourse(String CourseName, String Semester) throws Exception{
        initConnection();
        String checkSql ="select * from Course_Table where CourseName=? ";
        PreparedStatement checkStatement = conn.prepareStatement(checkSql);
        checkStatement.setString(1, CourseName);
        ResultSet checkSet = checkStatement.executeQuery();
        if(checkSet.next()){
            throw new CourseExistException(" course exist!");
        }else {
            String sql="INSERT INTO Course_Table (CourseName, Semester) VALUES (?,?)";
            try (PreparedStatement statement = conn.prepareStatement(sql)) {
                statement.setString(1, CourseName);
                statement.setString(2, Semester);
                statement.executeUpdate();
            }
        }

        closeConnection();
    }
    private void initConnection() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_4assignment?useSSL=false", "root", "zhaiyue123");
    }

    private void closeConnection() throws Exception{
        conn.close();
    }
}
