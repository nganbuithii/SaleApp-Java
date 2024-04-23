<%-- 
    Document   : products
    Created on : Apr 10, 2024, 2:09:31 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<h1>QUẢN TRỊ SẢN PHẨM!</h1>
<%--Tao action--%>
<c:url value="/products" var="action"/>
<%--@elvariable id="products" type=""--%>
<form:form method="post" action="${action}" modelAttribute="product" enctype="multipart/form-data">
<%--    Xuat loi--%>
    <form:errors path="name" cssClass="alert alert-danger "/>
    <div class="form-floating mb-3 mt-3">

        <form:input class="form-control" id="name" placeholder="Tên sản phẩm" path="name"/>
        <label for="name">Tên sản phẩm</label>

    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="file" class="form-control" id="image" path="file"/>
        <label for="image">ảnh sản phẩm</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input class="form-control" id="price" placeholder="Gía" path="price"/>
        <label for="price">Giá sản phẩm</label>
    </div>
    <%--    nap danh muc--%>
    <div class="form-floating">
        <form:select class="form-select" id="categoryId" path="categoryId">
            <c:forEach items="${categories}" var="c">
                <option value="${c.id}">${c.name}</option>
            </c:forEach>
        </form:select>
        <label for="categoryId" class="form-label">Danh mục:</label>
    </div>
    <div class="form-floating">
        <button type="submit" class="btn btn-info">Thêm sản phẩm</button>
    </div>
</form:form>