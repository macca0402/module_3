<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 10/5/2023
  Time: 10:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cập nhập thông tin</title>
</head>
<body>
<center>
        <form action="/student-servlet?action=edit" method="post">
            <table border="1">
                <tr>
                    <td>ID</td>
                    <td><input type="text" name="id"  readonly value="${student.id}"></td>
                </tr>
                <tr>
                    <td>Tên</td>
                    <td><input type="text" name="name" value="${student.name}"></td>
                </tr>
                <tr>
                    <td>Giới tính</td>
                    <td>
                        <select name="gender" value="${student.gender}">
                            <option name="gender" value="false">Nữ</option>
                            <option name="gender" value="true">Nam</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Điểm</td>
                    <td><input type="text" name="point" value="${student.point}"></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Cập nhập"></td>
                </tr>
            </table>
        </form>
</center>

</body>
</html>
