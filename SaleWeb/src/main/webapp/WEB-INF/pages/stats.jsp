<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: FShop
  Date: 4/24/2024
  Time: 1:18 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<h1 class="text-center text-info mt-1">THỐNG KÊ , BÁO CÁO</h1>
<div class="row">
    <div class="col-md-5 col-12">
        <table class="table">
            <tr>
                <th>ID</th>
                <th>Tên Sản Phẩm</th>
                <th>
                    Doanh thu
                </th>
            </tr>
            <c:forEach items="${RenvenueByProduct}" var="p">
            <tr>
                <td>${p[0]}</td>
                <td>${p[1]}</td>
                <td>${String.format("%,d",p[2])} vnd</td>
            </tr>
            </c:forEach>
        </table>
    </div>
    <div class="col-md-7 col-12">

    </div>
</div>
