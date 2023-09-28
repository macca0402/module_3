<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Máy tính" %>
</h1>
<br/>
<form action="hello-servlet" method="get">
    <input type="text" name="num1">
    <br>
    <select name="operator" id="">
        <option name="operator" value="+">+</option>
        <option name="operator" value="-">-</option>
        <option name="operator" value="*">*</option>
        <option name="operator" value="/">/</option>
    </select>
    <br>
    <input type="text" name="num2">
    <br>
    <input type="submit" value="Tinh">
</form>
Kết quả: ${result}
</body>
</html>