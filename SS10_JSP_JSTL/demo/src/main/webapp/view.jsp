<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 10/6/2023
  Time: 3:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thông tin học viên</title>
</head>
<body>
<center>

    <table border="1">
        <tr>
            <td>ID</td>
            <td><input name="id" readonly value="${student.id}"></td>
        </tr>
        <tr>
            <td>Tên</td>
            <td><input name="name" readonly value="${student.name}"></td>
        </tr>
        <tr>
            <td>Giới tính</td>
            <c:if test="${student.gender == false}">
            <td><input name="name" readonly value="nữ"></td>
            </c:if>
            <c:if test="${student.gender == true}">
                <td><input name="name" readonly value="nam"></td>
            </c:if>
        </tr>
        <tr>
            <td>Điểm</td>
            <td><input name="point" readonly value="${student.point}"></td>
        </tr>
        <tr>
            <td>Xếp loại</td>
            <c:choose>
                <c:when test="${student.point >= 8}">
                    <td>Giỏi</td>
                </c:when>
                <c:when test="${student.point > 6}">
                    <td>Khá</td>
                </c:when>
                <c:when test="${student.point > 3}">
                    <td>Trung bình</td>
                </c:when>
                <c:otherwise>
                    <td>Yếu</td>
                </c:otherwise>
            </c:choose>
        </tr>
    </table>


</center>

</body>
</html>
