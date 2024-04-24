<%-- 
    Document   : header
    Created on : Apr 10, 2024, 1:40:36 PM
    Author     : admin
--%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<nav class="navbar navbar-expand-sm navbar-dark bg-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="javascript:void(0)">MY SALE APP</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#mynavbar">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="mynavbar">
            <ul class="navbar-nav me-auto">
                <li class="nav-item">

                    <a class="nav-link" href="<c:url value="/"/>">Trang chủ</a>
                </li>

                <c:forEach items="${categories}" var="c">
                    <li class="nav-item">

                            <%--                            Xay dung duong dan url--%>
                        <c:url value="/" var="myUrl">
                            <c:param name="cateId" value="${c.id}"/>
                        </c:url>
                        <a class="nav-link" href="${myUrl}">${c.name}</a>
                    </li>
                </c:forEach>

                <c:choose>
                    <%--                        chua dangnhap--%>
                    <c:when test="${pageContext.request.userPrincipal.name == null}">
                        <li class="nav-item">

                            <a class="nav-link btn btn-info" href="<c:url value="/login" />">Dang Nhap</a>
                        </li>
                    </c:when>
                    <%--                        Dang nhapthanh cong--%>
                    <c:when test="${pageContext.request.userPrincipal.name != null}">
                        <li class="nav-item">

                            <a class="nav-link"
                               href="<c:url value="/"/>">Chao ${pageContext.request.userPrincipal.name}</a>
                        </li>
                        <li class="nav-item">

                            <a class="nav-link btn btn-info" href="<c:url value="/logout" />">Dang xuat</a>
                        </li>

                    </c:when>
                </c:choose>
                <li class="nav-item">

                    <a class="nav-link btn btn-info" href="<c:url value="/stats"/>">Thống kê, báo cáo</a>
                </li>

            </ul>
            <%--            form tìm kiếm--%>
            <form action="<c:url value=""/> " class="d-flex">
                <input class="form-control me-2" type="text" name="kw" placeholder="Nhập tên..">
                <button class="btn btn-primary" type="submit">Search</button>
            </form>
        </div>
    </div>
</nav>
