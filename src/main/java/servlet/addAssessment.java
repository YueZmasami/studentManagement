package servlet;

import dao.AssessmentDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: yue
 * @description:
 */

@WebServlet("/addAssessment")
public class addAssessment extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      //get parameters from jsp file and call setAssessment method to store or update student's grade in DB
        AssessmentDao assessmentDao=new AssessmentDao();
        int studentId=Integer.parseInt(req.getParameter("studentid").trim());
        int courseId=Integer.parseInt(req.getParameter("courseid").trim());
        int quizMark=Integer.parseInt(req.getParameter("QuizMark").trim());
        int assignmentMark=Integer.parseInt(req.getParameter("QuizMark").trim());
        int finalExamMark=Integer.parseInt(req.getParameter("FinalExamMark").trim());
        try {
            assessmentDao.setAssessment(studentId, courseId, quizMark, assignmentMark, finalExamMark );
        } catch (Exception e) {
            e.printStackTrace();
        }
        resp.sendRedirect("teacher_dashboard.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       this.doGet(req,resp);
    }
}
