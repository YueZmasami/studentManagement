<%--
  Created by IntelliJ IDEA.
  User: zhaiyue
  Date: 2024/3/26
  Time: 6:10 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>add Assessment</title>
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

        form {
            background-color: white;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
        }

        h2 {
            color: #333;
            text-align: center;
        }

        table {
            width: 100%;
        }

        table td {
            padding: 10px 0;
        }

        input[type="text"],
        input[type="submit"] {
            width: 100%;
            padding: 8px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        input[type="submit"] {
            width: auto;
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
<h2>Add Assessment</h2>
<form action="addAssessment" method="post">

    <table>
        <tr>
            <td>CourseId:</td>
            <td><input type="text" name="courseid" value="<%=request.getParameter("courseid")%>" required></td>
        </tr>
        <tr>
            <td>StudentId:</td>
            <td><input type="text" name="studentid" value="<%=request.getParameter("studentid")%>" required></td>
        </tr>
        <tr>
            <td>QuizMark: </td>
            <td><input type="text" name="QuizMark" required></td>
        </tr>
        <tr>
            <td>AssignmentMark:</td>
            <td><input type="text" name="AssignmentMark" required></td>
        </tr>
        <tr>
            <td>FinalExamMark:</td>
            <td><input type="text" name="FinalExamMark" required></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="Add"></td>
        </tr>
    </table>
</form>
</body>
</html>
