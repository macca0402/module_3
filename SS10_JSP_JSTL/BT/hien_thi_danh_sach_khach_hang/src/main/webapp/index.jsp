<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title></title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<%--<a href="/khach-hang-servlet">Danh sach khach hang</a>--%>
<c:redirect url="customers"></c:redirect>
</body>
</html>