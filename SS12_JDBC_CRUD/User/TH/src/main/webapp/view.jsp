<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 10/4/2023
  Time: 9:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>View</title>
</head>
<body>
<table border="1">
    <tr>
        <td>ID</td>
        <td width="100px"><input type="text" readonly value="${user.id}"></td>
    </tr>
    <tr>
        <td>Tên</td>
        <td width="100px"><input type="text"  readonly value="${user.name}"></td>
    </tr>
    <tr>
        <td>Số lượng</td>
        <td width="100px"><input type="text" readonly value="${user.email}"></td>
    </tr>
    <tr>
        <td>Xuất xứ</td>
        <td width="100px"><input type="text" readonly value="${user.country}"></td>
    </tr>
</table>
</body>
</html>
