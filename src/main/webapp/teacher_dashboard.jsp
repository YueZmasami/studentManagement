<%@ page import="entity.User" %>
<%@ page import="dao.CourseDao" %>
<%@ page import="entity.Course" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="entity.Assessment" %>
<%@ page import="dao.AssessmentDao" %><%--
  Created by IntelliJ IDEA.
  User: zhaiyue
  Date: 2024/3/25
  Time: 6:12 am
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Teacher_dashboard</title>
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
            text-align: center;
        }

        th {
            background-color: #f2f2f2;
            font-weight: bold;
        }
    </style>
</head>
<body>
<%
    // get session of user who log in currently
    User teacher = (User) session.getAttribute("teacher");
    int teacherId = teacher.getUserID();
    CourseDao courseDao = new CourseDao();
    // get all courses assigned to this teacher
    List<Course> registeredCourses = new ArrayList<>();
    registeredCourses = courseDao.getCourses4User(teacherId);
    AssessmentDao assessmentDao = new AssessmentDao();

%>
<div id="page" class="container">
    <div>
        <div id="header">
            <div id="logo">
                <img src="imgs/<%= teacher.getUsername() %>.jpeg"/>
                <h1><%=teacher.getUsername() + ", welcome!"%>
                </h1>
            </div>
        </div>
        <%--        if the teacher hasn't register any courses, go to courses page --%>
        <% if (registeredCourses.isEmpty()) { %>
        <p>You haven't registered any courses</p>
        <p><a href="all_courses.jsp">go to register courses</a></p>
        <% } %>

        <ul>
                <% for (Course course : registeredCourses) { %>
            <li>
                <h2><%= course.getCourseName() %>
                </h2>

                <%--            get all students who registed this course --%>
                <ul>
                    <%
                        int courseId = course.getCourseId();
                        List<User> studentsEnrolledThisCourse = courseDao.getStudentsByCourseId(courseId);
                        for (User user : studentsEnrolledThisCourse) {
                    %>
                    <%--            display students and assessment function--%>
                    <li>
                        <h3><%= user.getUsername()%>
                        </h3>
                        <br>
                        <%--            get assessment of this student who registered this specific course --%>
                            <%
    Assessment assessmentByStudentIdAndCourseId = assessmentDao.getAssessmentByStudentIdAndCourseId(user.getUserID(), course.getCourseId());

%>
                            <% if (assessmentByStudentIdAndCourseId.getAssignmentMarks()!=0||assessmentByStudentIdAndCourseId.getFinalExamMarks()!=0||assessmentByStudentIdAndCourseId.getQuizMarks()!=0) { %>
                        <table>
                            <tr>
                                <th>Quiz Marks</th>
                                <th>Assignment Marks</th>
                                <th>Final Exam Marks</th>
                            </tr>
                            <tr>
                                <td><%= assessmentByStudentIdAndCourseId.getQuizMarks() %>
                                </td>
                                <td><%= assessmentByStudentIdAndCourseId.getAssignmentMarks() %>
                                </td>
                                <td><%= assessmentByStudentIdAndCourseId.getFinalExamMarks() %>
                                </td>
                            </tr>
                        </table>
                            <% } else { %>

                        <form action="addAssessment.jsp" method="post">
                            <input type="hidden" name="courseid" value="<%=course.getCourseId()%>">
                            <input type="hidden" name="studentid" value="<%=user.getUserID()%>">
                            <input type="submit" value="add assessment">
                        </form>
                            <% } %>


                    </li>
                    <% } %>
                </ul>
            </li>
            <% } %>
        </ul>


                <p><a href="all_courses.jsp">go to register courses</a></p>
    </div>
</div>
<form action="index.jsp" method="post">
    <input type="submit" value="log out">
</form>
</body>
</html>


