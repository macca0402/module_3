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
<nav style="margin-top: 0" class="navbar navbar-expand-lg bg-light">
    <div class="container-fluid">
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="#">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/employee-servlet">Employee</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/customer-servlet">Customer</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/service-servlet">Service</a>
                </li>
                <li class="nav-item">
                    <div class="dropdown">
                        <button class="btn btn-secondary dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
                            Contract
                        </button>
                        <ul class="dropdown-menu">
                            <li><a class="nav-link" href="contract-servlet?action=contract">Contract</a></li>
                            <li><a class="nav-link" href="contract-servlet?action=contractDetail">Contract detail</a></li>
                        </ul>
                    </div>
                </li>
            </ul>

            <form class="d-flex" role="search">
                <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success" type="submit">Search</button>
            </form>
        </div>
    </div>
</nav>
<table class="table">
    <thead>
    <tr>
        <th scope="col">Mã hợp đồng chi tiết</th>
        <th scope="col">Mã hợp đồng</th>
        <th scope="col">Mã dịch vụ đi kèm</th>
        <th scope="col">Số lượng</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${list}" var="contractDetail" varStatus="">
        <tr>
            <th scope="row">${contractDetail.code}</th>
            <td>${contractDetail.codeContract}</td>
            <td>${contractDetail.codeServiceAttach}</td>
            <td>${contractDetail.quantity}</td>
        </tr>
    </c:forEach>
    </tbody>
    <tr>

        <th colspan="9">
            <button class="btn btn-dark" style="width: 200px">
                <a style="text-decoration: none;color: white"
                   href="contract-servlet?action=createContractDetail">Create</a>
            </button>
        </th>
    </tr>
</table>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
        crossorigin="anonymous"></script>
</body>
</html>
