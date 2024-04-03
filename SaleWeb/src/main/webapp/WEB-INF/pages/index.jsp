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

    <ul>

    </ul>
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

                    <c:forEach items="${categories}" var="c">
                        <li class="nav-item">

<%--                            Xay dung duong dan url--%>
                            <c:url value="/" var="myUrl">
                                <c:param name="cateId" value="${c.id}"/>
                            </c:url>
                            <a class="nav-link" href="${myUrl}">${c.name}</a>
                        </li>
                    </c:forEach>


                </ul>
    <%--            form tìm kiếm--%>
                <form action="<c:url value=""/> " class="d-flex">
                    <input class="form-control me-2" type="text" name="kw" placeholder="Nhập tên..">
                    <button class="btn btn-primary" type="submit">Search</button>
                </form>
            </div>
        </div>
    </nav>

    <section class="container">
        <div class="row ">
            <c:forEach items="${products}" var="p">
                <div class="col-md-3 col-12">
                    <div class="card">
                        <img class="card-img-top" src="${p.image}" alt="${p.name}">
                        <div class="card-body">
                            <h4 class="card-title">${p.name}</h4>
                            <p class="card-text">${p.price}</p>
                            <a href="#" class="btn btn-primary">Xem chi tiết</a>
                            <a href="#" class="btn btn-danger">Đặt hàng</a>
                        </div>
                    </div>
                </div>
            </c:forEach>

        </div>
    </section>
</body>
</html>
