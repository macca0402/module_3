<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title></title>
</head>
<body>
    <h1>Danh sách khách hàng</h1>
    <table class="table" border="1">
        <thead>
        <tr>
            <th scope="col">Tên</th>
            <th scope="col">Ngày sinh</th>
            <th scope="col">Địa chỉ</th>
            <th scope="col">Ảnh</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach items="${list}" var="khachHang" varStatus="loop">
            <tr>
                <th scope="row">${khachHang.ten}</th>
                <td>${khachHang.ngaySinh}</td>
                <td>${khachHang.diaChi}</td>
                <td>${khachHang.anh}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</body>
</html>