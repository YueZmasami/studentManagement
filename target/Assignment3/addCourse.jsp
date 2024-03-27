
<%--
  Created by IntelliJ IDEA.
  User: zhaiyue
  Date: 2024/3/26
  Time: 2:34 am
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Course</title>
    <style>
        body {
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
            background-image: linear-gradient(to right, #fbc2eb, #a6c1ee);
            margin: 0;
            padding: 0;
        }

        h2 {
            color: #333;
            text-align: center;
        }

        form {
            background-color: white;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
        }

        table {
            width: 100%;
        }

        table td {
            padding: 10px 0;
        }

        input[type="text"],
        input[type="password"] {
            width: 100%;
            padding: 8px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        input[type="submit"] {
            width: 100%;
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
<h2>Add Course</h2>
<form action="addCourse" method="post">

    <table>
        <tr>
            <td>Coursename:</td>
            <td><input type="text" name="coursename" required></td>
        </tr>
        <tr>
            <td>Semester:</td>
            <td><input type="text" name="semester" required></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="Add Course"></td>
        </tr>
    </table>
</form>
</body>
</html>
