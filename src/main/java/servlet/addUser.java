package servlet;

import dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author: yue
 * @description:
 */

@WebServlet("/addUser")
public class addUser extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        UserDao userDao=new UserDao();
        // get parameters from form in addUser.jsp
        String Username=req.getParameter("username");
        String Password=req.getParameter("password");
        String FirstName=req.getParameter("firstName");
        String LastName=req.getParameter("lastName");
        String Phone=req.getParameter("phone");
        String Role=req.getParameter("role");
        try {
            // create a new user by calling method
            userDao.createNewUser(Username, Password,FirstName,LastName,Phone,Role);
            // go back to admin_dashboard
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
