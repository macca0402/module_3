<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div align="center">
    <h1>Danh sách học viên</h1>
    <table border="1px">
        <thead>
        <tr>
            <th>ID</th>
            <th>Tên</th>
            <th>Giới tính</th>
            <th>Điểm</th>
            <th>Xếp loại</th>
            <th colspan="3">Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="student" varStatus="loop">
            <tr>
                <td>${student.id}</td>
                <td>${student.name}</td>

                <c:if test="${student.gender == false}">
                    <td>Nữ</td>
                </c:if>
                <c:if test="${student.gender == true}">
                    <td>Nam</td>
                </c:if>
                <td>${student.point}</td>

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
                <td><a href="/student-servlet?action=demoUpdate&id=${student.id}">demo update</a></td>
<%--                <td><a href="/student-servlet?action=update&id=${student.id}">UPDATE</a></td>--%>
                <td><a href="/student-servlet?action=delete&id=${student.id}">Delete</a></td>
                <td><a href="/student-servlet?action=view&id=${student.id}">View</a></td>

            </tr>

        </c:forEach>
        <tr>
            <td colspan="8">
                <a href="/student-servlet?action=create">Add new student</a>
            </td>
        </tr>
        </tbody>
    </table>
</div>

</body>
</html>
