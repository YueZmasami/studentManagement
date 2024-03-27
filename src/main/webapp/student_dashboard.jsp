<%@ page import="entity.User" %>
<%@ page import="entity.Course" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="dao.CourseDao" %>
<%@ page import="entity.Assessment" %>
<%@ page import="dao.AssessmentDao" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>student_dashboard</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
        }

        .container {
            max-width: 1200px;
            margin: 0 auto;
            padding: 20px;
        }

        #header {
            background-color: #fff;
            border-bottom: 1px solid #ddd;
            padding: 20px;
            text-align: center;
        }

        #header h1 {
            margin: 0;
            color: #333;
        }

        #logo img {
            width: 100px;
            height: auto;
        }

        ul {
            list-style-type: none;
            padding: 0;
        }

        ul li {
            background-color: #fff;
            margin-bottom: 20px;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0px 2px 5px rgba(0, 0, 0, 0.1);
        }

        ul li:hover {
            box-shadow: 0px 5px 10px rgba(0, 0, 0, 0.2);
        }

        form {
            margin-top: 20px;
        }

        input[type="submit"] {
            padding: 10px 20px;
            background-image: linear-gradient(to right, #a6c1ee, #fbc2eb);
            color: #fff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        table {
            width: 100%;
            border-collapse: collapse;
        }

        th, td {
            padding: 10px;
            border-bottom: 1px solid #ddd;
        }

        th {
            background-color: #f2f2f2;
            font-weight: bold;
        }
    </style>
</head>
<body>
<%
    User student = (User) session.getAttribute("student");
    // get id of user who logged in currently
    int studentId = student.getUserID();

    CourseDao courseDao = new CourseDao();
    AssessmentDao assessmentDao = new AssessmentDao();
    // get courses the student registered
    List<Course> registeredCourses = new ArrayList<>();
    registeredCourses = courseDao.getCourses4User(studentId);
%>
<div id="page" class="container">
    <div>
        <div id="header">
            <div id="logo">
                <%--            display student's name which obtained from session --%>
                <img src="imgs/<%= student.getUsername() %>.jpeg"/>
                <h1><%=student.getUsername() + ", welcome!"%>
                </h1>
            </div>
        </div>
        <%--    if no registered courses, go to register --%>
        <% if (registeredCourses.isEmpty()) { %>
        <p>You haven't registered any courses</p>
        <p><a href="all_courses.jsp">go to register courses</a></p>
        <% }       else { %>

        <ul>
            <%--        if student has registed courses, display courses --%>
            <% for (Course course : registeredCourses) { %>
            <li>
                <%--  obtain courseid and send it to grades servlet where getting assessment according to this student'id and course id          --%>
                <%= course.getCourseName() %>
                <form action="grades" method="post">
                    <input type="hidden" name="courseId" value="<%= course.getCourseId() %>">
                    <input type="submit" value="check grades">
                </form>
<%--        get assessment according from request, i store assessment in the request in servlet of grades --%>
                <%
                    if (request.getParameter("courseId") != null && request.getParameter("courseId").equals(String.valueOf(course.getCourseId()))) {
                    Assessment assessment = (Assessment)request.getAttribute("assessment");
                        if (assessment != null) { %>
                <table>
                    <tr>
<%--                        display marks --%>
                        <th>Quiz Marks</th>
                        <th>Assignment Marks</th>
                        <th>Final Exam Marks</th>
                    </tr>
                    <tr>
                        <td><%= assessment.getQuizMarks() %>
                        </td>
                        <td><%= assessment.getAssignmentMarks() %>
                        </td>
                        <td><%= assessment.getFinalExamMarks() %>
                        </td>
                    </tr>
                </table>
                <% }
                } %>
            </li>
                <%
                    } %>
        </ul>

        <p><a href="all_courses.jsp">go to register courses</a></p>


        <%}%>
    </div>
</div>
<form action="index.jsp" method="post">
    <input type="submit" value="log out">
</form>
</body>
</html>
