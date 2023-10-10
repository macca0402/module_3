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
<center>
    <form action="/customer-servlet?action=create" method="post">
        <div class="col-md-6">
            <label class="form-label">Họ và tên</label>
            <input name="ho_va_ten" type="text" class="form-control">
        </div>
        <div class="col-md-6">
            <label class="form-label">Ngày sinh</label>
            <input name="ngay_sinh" type="text" class="form-control">
        </div>
        <div class="col-md-6">
            <label class="form-label">Giới tính</label>
            <input name="gioi_tinh" type="text" class="form-control" >
        </div>
        <div class="col-md-6">
            <label class="form-label">Số điện thoại</label>
            <input name="so_dien_thoai" type="text" class="form-control" >
        </div>
        <div class="col-md-6">
            <label  class="form-label">Địa chỉ</label>
            <input name="dia_chi" type="text" class="form-control">
        </div>
        <div class="col-md-6">
            <label  class="form-label">Số chứng minh nhân dân</label>
            <input name="cmnd" type="text" class="form-control">
        </div>
        <div class="col-md-6">
            <label  class="form-label">Email</label>
            <input name="email" type="text" class="form-control">
        </div>
        <div class="col-md-6">
            <label  class="form-label">Mã loại khách</label>
            <input name="ma_loai_khach" type="text" class="form-control">
        </div>
        <div class="col-md-6">
            <button type="submit" class="btn btn-primary">Tạo mới khách hàng</button>
        </div>
    </form>
</center>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</body>
</html>
