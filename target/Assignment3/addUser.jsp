<%--
  Created by IntelliJ IDEA.
  User: zhaiyue
  Date: 2024/3/26
  Time: 2:15 am
  To change this template use File | Settings | File Templates.
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add User</title>
    <style>
        .container {
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
            background-image: linear-gradient(to right, #fbc2eb, #a6c1ee);
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
        input[type="password"],
        select {
            width: 100%;
            padding: 8px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        input[type="submit"] {
            width: 100%;
            padding: 10px;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
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

<div  class="container" >
    <h2>Add User</h2>
    <form action="addUser" method="post">

        <table>

            <tr>
                <td>Username:</td>
                <td><input type="text" name="username" required></td>
            </tr>
            <tr>
                <td>Default Password:</td>
                <td><input type="password" name="password" required></td>
            </tr>
            <tr>
                <td>First Name:</td>
                <td><input type="text" name="firstName" required></td>
            </tr>
            <tr>
                <td>Last Name:</td>
                <td><input type="text" name="lastName" required></td>
            </tr>
            <tr>
                <td>Phone:</td>
                <td><input type="text" name="phone"></td>
            </tr>
            <tr>
                <td>Role:</td>
                <td>
                    <select name="role" required>
                        <option value="student">Student</option>
                        <option value="teacher">Teacher</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Add User" ></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>

