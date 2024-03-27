package servlet;

/**
 * @author: yue
 * @description:
 */


        import dao.UserDao;
        import entity.User;

        import javax.servlet.ServletException;
        import javax.servlet.annotation.WebServlet;
        import javax.servlet.http.HttpServlet;
        import javax.servlet.http.HttpServletRequest;
        import javax.servlet.http.HttpServletResponse;
        import javax.servlet.http.HttpSession;
        import java.io.IOException;
        import java.io.PrintWriter;

/**
 * @author: yue
 * @description:
 */

@WebServlet("/login")
public class loginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        //create session
        HttpSession session = req.getSession();
        // get parameters from form in the index.jsp
        String username = req.getParameter("username").trim();
        String password = req.getParameter("password").trim();
        //method for authentication is written in userDao
        UserDao userDao = new UserDao();
        User user = new User();
        try {
            user = userDao.checkAccount(username, password);
            // if no input from user, return an alert
            if(user==null){
                out.print("<script>alert(\"User not found\");</script>");
                resp.sendRedirect("index.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (user != null) {
            // check is this user an admin or a student, a teacher, after checking its identity, forward to different dashboard.jsp
            String role = user.getRole();

            if (user.getUsername().equals("admin")) {
                // set attribute to session
                session.setAttribute("admin", user);
                resp.sendRedirect("admin_dashboard.jsp");
            } else if ("student".equals(role)) {
                session.setAttribute("student", user);
                resp.sendRedirect("student_dashboard.jsp");
            } else if ("teacher".equals(role)) {
                session.setAttribute("teacher", user);
                resp.sendRedirect("teacher_dashboard.jsp");
            }
        } else {
            // pop an alert for wrong username or password.
            out.print("<script>alert(\"wrong username or password！\");");
            resp.sendRedirect("index.jsp");
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}


