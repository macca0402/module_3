<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 10/11/2023
  Time: 3:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <style>
        label{
            color: #4478bf;
        }
    </style>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
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
<form>
    <div class="col-md-6">
        <label class="form-label">Mã nhân viên</label>
        <input  readonly name="ma_nhan_vien" type="text" class="form-control" value="${employee.id}">
    </div>
    <div class="col-md-6">
        <label class="form-label">Họ và tên</label>
        <input  readonly name="ho_ten" type="text" class="form-control" value="${employee.name}">
    </div>
    <div class="col-md-6">
        <label class="form-label">Ngày sinh</label>
        <input readonly  name="ngay_sinh" type="text" class="form-control" value="${employee.birthDay}">
    </div>
    <div class="col-md-6">
        <label class="form-label">Số chứng minh nhân dân</label>
        <input  readonly name="so_cmnd" type="text" class="form-control" value="${employee.cmnd}" >

    </div>
    <div class="col-md-6">
        <label class="form-label">Lương</label>
        <input readonly  name="luong" type="text" class="form-control" value="${employee.salary}">
    </div>
    <div class="col-md-6">
        <label class="form-label">Số điện thoại</label>
        <input readonly name="so_dien_thoai" type="text" class="form-control" value="${employee.phone}">
    </div>

    <div class="col-md-6">
        <label  class="form-label">Email</label>
        <input readonly name="email" type="text" class="form-control" value="${employee.email}">
    </div>
    <div class="col-md-6">
        <label  class="form-label">Địa chỉ</label>
        <input readonly name="dia_chi" type="text" class="form-control"value="${employee.address}">
    </div>
    <div class="col-md-6">
        <label class="form-label">Mã vị trí</label>
        <input readonly name="ma_vi_tri" type="text" class="form-control" value="${employee.codePosition}">
    </div>
    <div class="col-md-6">
        <label class="form-label">Mã trình độ</label>
        <input readonly name="ma_trinh_do" type="text" class="form-control" value="${employee.codeDegree}">
    </div>
    <div class="col-md-6">
        <label class="form-label">Mã bộ phận</label>
        <input readonly name="ma_bo_phan" type="text" class="form-control" value="${employee.codeDepartment}">
    </div>
</form>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</body>
</html>
