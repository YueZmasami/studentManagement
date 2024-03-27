package dao;

import entity.Assessment;
import entity.Course;

import java.sql.*;

/**
 * @author: yue
 * @description:
 */


public class AssessmentDao {
    private Connection conn = null;
//public Assessment getAssessmentsByUserAndCourse(int UserID, int CourseID)  throws Exception{
//    initConnection();
//
//    String sql = "SELECT * FROM Assessment_Table  WHERE UserID=? and CourseID = ?";
//    Assessment assessment=new Assessment();
//    try (PreparedStatement statement = conn.prepareStatement(sql)) {
//        statement.setInt(1, UserID);
//        statement.setInt(2, CourseID);
//        try (ResultSet resultSet = statement.executeQuery()) {
//            while (resultSet.next()) {
//                int assessmentID = resultSet.getInt("AssessmentID");
//                int userID = resultSet.getInt("UserID");
//                int courseID = resultSet.getInt("CourseID");
//                int quizMarks = resultSet.getInt("QuizMarks");
//                int assignmentMarks = resultSet.getInt("AssignmentMarks");
//                int finalExamMarks = resultSet.getInt("FinalExamMarks");
//               assessment = new Assessment(assessmentID, userID, courseID, quizMarks, assignmentMarks, finalExamMarks);
//
//            }
//        }
//    }
//    return assessment;
//
//}
// the teacher grades students, if the the student has already been graded, the teacher update or regrade his/her score
public void setAssessment(int studentId, int courseId, int quizMark, int assignmentMark, int finalExamMark) throws Exception {
    initConnection();
    String checkSql = "SELECT * FROM Assessment_Table WHERE UserID=? AND CourseID=?";
    try (PreparedStatement checkStatement = conn.prepareStatement(checkSql)) {
        checkStatement.setInt(1, studentId);
        checkStatement.setInt(2, courseId);
        ResultSet resultSet = checkStatement.executeQuery();
        if (resultSet.next()) {
            String updateSql = "UPDATE Assessment_Table SET QuizMarks=?, AssignmentMarks=?, FinalExamMarks=? WHERE UserID=? AND CourseID=?";
            try (PreparedStatement updateStatement = conn.prepareStatement(updateSql)) {
                updateStatement.setInt(1, quizMark);
                updateStatement.setInt(2, assignmentMark);
                updateStatement.setInt(3, finalExamMark);
                updateStatement.setInt(4, studentId);
                updateStatement.setInt(5, courseId);
                updateStatement.executeUpdate();
            }
        } else {
            String insertSql = "INSERT INTO Assessment_Table (UserID, CourseID, QuizMarks, AssignmentMarks, FinalExamMarks) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement insertStatement = conn.prepareStatement(insertSql)) {
                insertStatement.setInt(1, studentId);
                insertStatement.setInt(2, courseId);
                insertStatement.setInt(3, quizMark);
                insertStatement.setInt(4, assignmentMark);
                insertStatement.setInt(5, finalExamMark);
                insertStatement.executeUpdate();
            }
        }
    }
}
// get student's assessment by student's id and course's id
    public Assessment getAssessmentByStudentIdAndCourseId(int studentId, int courseId) throws Exception{
    initConnection();
    String sql="select * from Assessment_Table where UserID=? and CourseID=?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, studentId);
        statement.setInt(2, courseId);
        ResultSet resultSet = statement.executeQuery();
        Assessment assessment=new Assessment();
        while (resultSet.next()) {
            int assessmentID = resultSet.getInt("AssessmentID");
            int userID = resultSet.getInt("UserID");
            int courseID = resultSet.getInt("CourseID");
            int quizMarks = resultSet.getInt("QuizMarks");
            int assignmentMarks = resultSet.getInt("AssignmentMarks");
            int finalExamMarks = resultSet.getInt("FinalExamMarks");
           assessment = new Assessment(assessmentID, userID, courseID, quizMarks, assignmentMarks, finalExamMarks);

        }
return assessment;
    }

    private void initConnection() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_4assignment?useSSL=false", "root", "zhaiyue123");
    }

    private void closeConnection() throws Exception{
        conn.close();
    }



}
