<%-- 
    Document   : products
    Created on : Apr 10, 2024, 2:09:31 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<h1>QUẢN TRỊ SẢN PHẨM!</h1>
<form:form method="post"  modelAttribute="product" enctype="multipart/form-data">
      <div class="form-floating mb-3 mt-3">
        <form:input class="form-control"  id="name"  placeholder="Tên sản phẩm" path="name" />
        <label for="name">Tên sản phẩm</label>
    </div>
     <div class="form-floating mb-3 mt-3">
        <form:input class="form-control"  id="price"  placeholder="Gía" path="price" />
        <label for="name">Giá sản phẩm</label>
    </div>
    <div class="form-floating">
        <form:select class="form-select" id="categoryId"  path="categoryId">
            <c:forEach items="${categories}" var="c">
                <c:choose>
                    <c:when test="${c.id==product.categoryId.id}">
                        <option value="${c.id}" selected>${c.name}</option>
                    </c:when>
                    <c:otherwise>
                        <option value="${c.id}">${c.name}</option>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </form:select>
        <label for="categoryId" class="form-label">Danh mục:</label>
    </div>
        <div class="form-floating">
            <button type="submit" class="btn btn-info">Thêm sản phẩm</button>
        </div>
</form:form>