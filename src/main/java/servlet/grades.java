package servlet;

import dao.AssessmentDao;
import entity.Assessment;
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

@WebServlet("/grades")
public class grades extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
 // get assessment through student'id and courseid
        HttpSession session = req.getSession(false);
        User student = (User)session.getAttribute("student");
        AssessmentDao assessmentDao=new AssessmentDao();
        int courseId = Integer.parseInt(req.getParameter("courseId"));
        try {
            Assessment assessment = assessmentDao.getAssessmentByStudentIdAndCourseId(student.getUserID(), courseId);
            // store info in the request
            req.setAttribute("assessment", assessment);
            req.getRequestDispatcher("student_dashboard.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       this.doGet(req, resp);
    }
}
