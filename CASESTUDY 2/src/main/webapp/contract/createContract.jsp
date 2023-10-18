<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 10/10/2023
  Time: 2:55 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
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

    <form action="/contract-servlet?action=create" method="post">
        <div class="col-md-6">
            <label class="form-label">Ngày làm hợp đồng</label>
            <input name="ngay_lam_hop_dong" type="text" class="form-control">
        </div>
        <div class="col-md-6">
            <label class="form-label">Ngày kết thúc</label>
            <input name="ngay_ket_thuc" type="text" class="form-control" >
        </div>
        <div class="col-md-6">
            <label class="form-label">Tiền đặt cọc</label>
            <input name="tien_dat_coc" type="text" class="form-control" >
        </div>
        <div class="col-md-6">
            <label  class="form-label">Mã nhân viên</label>
            <input name="ma_nhan_vien" type="text" class="form-control">
        </div>
        <div class="col-md-6">
            <label  class="form-label">Mã khách hàng</label>
            <input name="ma_khach_hang" type="text" class="form-control">
        </div>
        <div class="col-md-6">
            <label  class="form-label">Mã dịch vụ</label>
            <input name="ma_dich_vu" type="text" class="form-control">
        </div>
        <div class="col-md-6">
            <button type="submit" class="btn btn-primary">Tạo mới hợp đồng</button>
        </div>
    </form>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</body>
</html>
