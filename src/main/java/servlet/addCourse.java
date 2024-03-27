package servlet;

import dao.CourseDao;

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

@WebServlet("/addCourse")
public class addCourse  extends HttpServlet {

// get course info from jsp file / form and call createCourse to store new created course in DB
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CourseDao courseDao=new CourseDao();
        String CourseName=req.getParameter("coursename");
        String Semester=req.getParameter("semester");
        try {
            courseDao.createCourse(CourseName, Semester);
            resp.sendRedirect("admin_dashboard.jsp");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

}
