<%-- 
    Document   : index
    Created on : Mar 27, 2024, 1:23:05 PM
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>

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
            <td>${String.format("%,d",p.price)} VNĐ</td>
            <td>
                <a class="btn btn-info" href="<c:url value="/products/${p.id}" />">Cập nhật</a>
                <button class="btn btn-danger">Xóa</button>
            </td>
        </tr>
    </c:forEach>
</table>
