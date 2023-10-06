<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 10/6/2023
  Time: 2:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thêm mới học viên</title>
</head>
<body>
<center>
    <form action="/student-servlet?action=create" method="post">
        <table border="1">
<%--            <tr>--%>
<%--                <td>ID</td>--%>
<%--                <td><input type="text" name="id"></td>--%>
<%--            </tr>--%>
            <tr>
                <td>Tên</td>
                <td><input type="text" name="name"></td>
            </tr>
            <tr>
                <td>Giới tính</td>
                <td>
                    <select name="gender">
                        <option name="gender" value="false">Nữ</option>
                        <option name="gender" value="true">Nam</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>Điểm</td>
                <td><input type="text" name="point"></td>
            </tr>
            <tr>
                <td><input type="submit" value="Thêm"></td>
            </tr>
        </table>
    </form>
</center>
</body>
</html>
