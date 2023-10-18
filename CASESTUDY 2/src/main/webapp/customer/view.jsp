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
    <label class="form-label">Mã khách hàng</label>
    <input readonly name="Ma_khach" type="text" class="form-control" value="${customer.id}">
  </div>
  <div class="col-md-6">
    <label class="form-label">Họ và tên</label>
    <input readonly name="ho_va_ten" type="text" class="form-control" value="${customer.customerName}">
  </div>
  <div class="col-md-6">
    <label class="form-label">Ngày sinh</label>
    <input readonly name="ngay_sinh" type="text" class="form-control" value="${customer.customerBirthday}">
  </div>
  <div class="col-md-6">
    <label class="form-label">Giới tính</label>
    <input readonly name="gioi_tinh" type="text" class="form-control" value="${customer.customerGender}" >

  </div>
  <div class="col-md-6">
    <label class="form-label">Số điện thoại</label>
    <input readonly name="so_dien_thoai" type="text" class="form-control" value="${customer.customerPhone}">
  </div>
  <div class="col-md-6">
    <label  class="form-label">Địa chỉ</label>
    <input readonly name="dia_chi" type="text" class="form-control" value="${customer.customerAddress}">
  </div>
  <div class="col-md-6">
    <label  class="form-label">Số chứng minh nhân dân</label>
    <input readonly name="so_cmnd" type="text" class="form-control" value="${customer.customerIdCard}">
  </div>
  <div class="col-md-6">
    <label  class="form-label">Email</label>
    <input readonly name="email" type="text" class="form-control" value="${customer.customerEmail}">
  </div>
  <div class="col-md-6">
    <label  class="form-label">Mã loại khách</label>
    <input readonly name="ma_loai_khach" type="text" class="form-control" value="${customer.customerTypeId}">
  </div>
</form>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</body>
</html>
