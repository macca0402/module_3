<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 10/9/2023
  Time: 8:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body>
<table class="table">
    <thead>
    <tr>
        <th scope="col">ID</th>
        <th scope="col">Họ và tên</th>
        <th scope="col">Ngày sinh</th>
        <th scope="col">Giới tính</th>
        <th scope="col">Số điện thoại</th>
        <th scope="col">Địa chỉ</th>
    </tr>
    </thead>
    <%--    private int id;--%>
    <%--    private int customerTypeId;--%>
    <%--    private String customerName;--%>
    <%--    private String customerBirthday;--%>
    <%--    private String customerGender;--%>
    <%--    private String customerIdCard;--%>
    <%--    private String customerPhone;--%>
    <%--    private String customerEmail;--%>
    <%--    private String customerAddress;--%>
    <tbody>
    <c:forEach items="${customerList}" var="customer" varStatus="">
        <tr>
            <th scope="row">${customer.id}</th>
            <td>${customer.customerName}</td>
            <td>${customer.customerBirthday}</td>
            <td>${customer.customerGender}</td>
            <td>${customer.customerPhone}</td>
            <td>${customer.customerAddress}</td>
            <td><a href="customer-servlet?action=customer?id=${customer.id}">Delete</a></td>
            <td><a href="customer-servlet?action=update?id=${customer.id}">Update</a></td>
            <td><a href="customer-servlet?action=view?id=${customer.id}">view</a></td>
        </tr>
    </c:forEach>
    </tbody>
        <tr>

            <th colspan="9">
                <button class="btn btn-dark" style="width: 200px"><a style="text-decoration: none;color: white"
                                                                     href="customer-servlet?action=create">Create</a>
                </button>
            </th>
        </tr>
</table>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
        crossorigin="anonymous"></script>
</body>
</html>
