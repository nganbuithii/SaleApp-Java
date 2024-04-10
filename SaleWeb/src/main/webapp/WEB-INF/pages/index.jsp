<%-- 
    Document   : index
    Created on : Mar 27, 2024, 1:23:05 PM
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Trang chủ</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>
</head>
<body>
<%--<h1>Hello World!</h1>--%>
<h1 class="text-center text-info mt-1">DANH MỤC SẢN PHẨM</h1>
<a href="<c:url value="/products" />" class ="btn btn-success mb-1">Thêm sản phẩm</a>
   <table class="container table table-striped">
    <tr>
        <th></th>
        <th>Id</th>
        <th>Tên</th>
        <th>Gía</th>
        <th></th>
    </tr>
    <c:forEach items="${products}" var="p">
        <tr>
            <td> <img class="card-img-top" src="${p.image}" alt="${p.name}" style="width:300px;"></td>
            <td>${p.id}</td>
            <td>${p.name}</td>
            <td>${p.price} VNĐ</td>
            <td>
                <button class="btn btn-info">Cập nhật</button>
                <button class="btn btn-danger">Xóa</button>
            </td>
        </tr>
    </c:forEach>
</table>
</html>