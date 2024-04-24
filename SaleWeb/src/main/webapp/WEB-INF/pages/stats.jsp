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
        <canvas id="myChart"></canvas>
    </div>
</div>
<hr class="hr"/>
<div class="row">

    <div class="col-md-5 col-12">
        <form>
            <div class="mb-3 mt-3">
                <label for="year" class="form-label">Chon nam:</label>
                <input class="form-control" id="year" placeholder="Nam" name="year">
            </div>
            <div class="form-floating mt-3">
                <select class="form-select" id="period" name="period">
                    <option selected value="MONTH">Theo thang</option>
                    <option value="QUATER">Theo quy</option>

                </select>
                <label for="period" class="form-label">Chon thoi gian</label>
            </div>
            <div class="mt-3">
                <button class="btn btn-success" type="submit" >Loc</button>
            </div>
        </form>
        <div class="alert alert-info">
            <h4>Nam: ${param.year}</h4>
            <h4>Thoi gian: ${param.period}</h4>
        </div>
        <table class="table">
            <tr>

                <th>Thơì Gian</th>
                <th>
                    Doanh thu
                </th>
            </tr>
            <c:forEach items="${RevenueByPeriod}" var="p">
                <tr>
                    <td>${p[0]}</td>
                    <td>${String.format("%,d",p[1])} vnd</td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <div class="col-md-7 col-12">
        <canvas id="myChart2"></canvas>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<script src="<c:url value="js/script.js"/> "></script>
<script>
    // bat su kien on load de xem no nap du lieu chua
    let label = [];
    let data = [];
    let label2 = [];
    let data2 = [];
    <c:forEach items="${RenvenueByProduct}" var="p">
    label.push('${p[1]}');
    data.push('${p[2]}');

    </c:forEach>
    <c:forEach items="${RevenueByPeriod}" var="p">
    label2.push(${p[0]});
    data2.push('${p[1]}');

    </c:forEach>
    window.onload = function () {
        let ctx1 = document.getElementById("myChart");
        let ctx2 = document.getElementById("myChart2");
        drawChartRevenue(ctx1, label, data, "DOANH THU");
        drawChartRevenue(ctx2, label2, data2, "DOANH THU THANG");
    }
</script>