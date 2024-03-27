<%--
  Created by IntelliJ IDEA.
  User: zhaiyue
  Date: 2024/3/25
  Time: 6:54 am
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.sql.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Course Information</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
        }

        .container {
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
        }

        table {
            width: 50%;
            background-color: white;
            border-collapse: collapse;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
            border-radius: 10px;
        }

        th, td {
            padding: 10px;
            border-bottom: 1px solid #ddd;
            text-align: left;
        }

        th {
            background-color: #f2f2f2;
            font-weight: bold;
        }

        td form {
            display: flex;
            justify-content: center;
        }

        input[type="submit"] {
            padding: 10px;
            color: white;
            background-image: linear-gradient(to right, #fbc2eb, #a6c1ee);
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
    </style>
</head>
<body>
<%
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;

    try {
//get all courses from DB and display
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_4assignment?useSSL=false", "root", "zhaiyue123");
        stmt = conn.createStatement();
        String sql = "SELECT * FROM Course_Table";
        rs = stmt.executeQuery(sql);
%>

<table border="1">
    <tr>
        <th>Course ID</th>
        <th>Course Name</th>
        <th>Semester</th>
        <th>Action</th>
    </tr>
    <% while (rs.next()) { %>
    <tr>
        <td><%= rs.getInt("CourseID") %></td>
        <td><%= rs.getString("CourseName") %></td>
        <td><%= rs.getString("Semester") %></td>
        <td>
            <form action="register" method="post">
                <input type="hidden" name="courseId" value="<%= rs.getInt("CourseID") %>">
                <input type="submit" value="Register">
            </form>
        </td>
    </tr>
    <% } %>
</table>

<%
    } catch (Exception e) {
        e.printStackTrace();
    } finally {

        if (rs != null) rs.close();
        if (stmt != null) stmt.close();
        if (conn != null) conn.close();
    }
%>

</body>
</html>

