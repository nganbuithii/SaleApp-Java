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
    <form:errors path="name" element="div" cssClass="alert alert-danger "/>
    <div class="form-floating mb-3 mt-3">

        <form:input class="form-control" id="name" placeholder="Tên sản phẩm" path="name"/>
        <label for="name">Tên sản phẩm</label>

    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="file" class="form-control" id="image" path="file"/>
        <label for="image">ảnh sản phẩm</label>
            <%--        Neu co anh thi hien anh ra--%>
        <c:if test="${product.id > 0}">
            <img src="${product.image}" width="200" class="img-fluid"/>
        </c:if>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input class="form-control" id="price" placeholder="Gía" path="price"/>
        <label for="price">Giá sản phẩm</label>
    </div>
    <%--    nap danh muc--%>
    <div class="form-floating">
        <form:select class="form-select" id="categoryId" path="categoryId">
            <c:forEach items="${categories}" var="c">
                <c:choose>
                    <%--                    c when la neu c.id === id cua danh muc san pham thi bat co selected--%>
                    <c:when test="${c.id == product.categoryId.id}">
                        <option value="${c.id}" selected>${c.name}</option>
                    </c:when>
                    <%--                    nguoc lai -default--%>
                    <c:otherwise>
                        <option value="${c.id}">${c.name}</option>
                    </c:otherwise>
                </c:choose>

            </c:forEach>
        </form:select>
        <label for="categoryId" class="form-label">Danh mục:</label>
    </div>
    <div class="form-floating">
            <%--    Nếu cập nhật sản phẩm thì thay nút thành CHỮ cập nhật--%>

        <button type="submit" class="btn btn-info">
            <c:choose>
                <c:when test="${product.id > 0}">
                    Cập nhật
                </c:when>
                <c:otherwise>
                    Thêm sản phẩm
                </c:otherwise>
            </c:choose>
        </button>

            <%--        <button type="submit" class="btn btn-info"></button>--%>
        <form:hidden path="id" />
    </div>


</form:form>