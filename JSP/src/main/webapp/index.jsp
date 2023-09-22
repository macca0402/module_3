<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <style>
       *{
           font-family: "Times New Roman",Arial;
       }
    </style>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<%--<a href="hello-servlet">Hello Servlet</a>--%>
<form action="hello-servlet" method="get">
    <lable>Product Description: <input type="text" name="description"></lable> <br>
    <lable>List Price: <input type="text" name="price"></lable><br>
    <lable>Discount Percent: <input type="text" name="percent"></lable><br>
    <button type="submit">Calculate Discount</button>
</form>
</body>
</html>