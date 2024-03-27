package servlet;

import dao.CourseDao;
import entity.Course;
import entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author: yue
 * @description:
 */

@WebServlet("/register")
// user register courses
public class register extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession(false);
        System.out.println(session);
        User student=null;
        User teacher=null;
        if(session!=null){
           student = (User)session.getAttribute("student");
           teacher =(User) session.getAttribute("teacher");
        }
// check whether the user is a teacher or a student
        if(student!=null){
            CourseDao courseDao=new CourseDao();
            int courseId = Integer.parseInt(req.getParameter("courseId"));
            try {
                // call method enroll courses for student and go back to student_dashboard
                Course course = courseDao.getCourseById(courseId);
                courseDao.enrollCourse4User(student.getUserID(),course.getCourseId());
            } catch (Exception e) {
                e.printStackTrace();
            }
            resp.sendRedirect("student_dashboard.jsp");
            return;
        }else if(teacher!=null){
            // call method enroll courses for teacher  and go back to teacher_dashboard
            CourseDao courseDao=new CourseDao();
            int courseId = Integer.parseInt(req.getParameter("courseId"));
            Course course = null;
            try {
                course = courseDao.getCourseById(courseId);
                courseDao.enrollCourse4User(teacher.getUserID(),course.getCourseId());
            } catch (Exception e) {
                e.printStackTrace();
            }
            resp.sendRedirect("teacher_dashboard.jsp");
            return;
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
