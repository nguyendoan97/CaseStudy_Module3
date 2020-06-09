<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Case Study Module 3</title>

    <link rel="stylesheet" href="product/style.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/js/all.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css"/>
    <link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">

</head>
<body background="http://doancode.mobie.in/4.jpg">
<div id="header">
    <div id="logo" >
        <img src="http://doancode.mobie.in/logoshop.png" height="72" width="197" style="margin-left:30px"/></div>
    <div id="bander">
        <ul>
            <li><a href="">Trang Chủ</a></li>
            <li><a href="">Bộ Sưu Tập</a>
                <ul>
                    <li><a href="">Hot Tháng 5</a></li>
                    <li><a href="">Mẫu Nam 2020</a></li>
                    <li><a href="">Thanh Lịch</a></li>
                </ul>
            </li>
            <li><a href="">Sự Kiện</a></li>
            <li><a href="">Bán Chạy</a></li>
            <li><a href="">Flash Sale</a></li>

        </ul>
        <div id="sidebar__search">
            <i class="fas fa-search" style="margin-top:2px; margin-left:9px"></i>
            <input id="" type="text" name="search" placeholder= "Search..."/>
        </div>

    </div>


</div>
<div id="sidebar">

    <div id="login">
        <p>Xin Chào,<b>${user.getName()}</b></p>
    </div>

    <ul>
        <li><a href="">Thời Trang Nữ</a>
            <ul>
                <li><a href="">Áo Sơ Mi</a></li>
                <li><a href="">Quần Thời Trang</a></li>
                <li><a href="">Đồ Ở Nhà</a></li>
                <li><a href="">Váy Thời Trang</a></li>
                <li><a href="">Đồ Lót</a></li>
            </ul>
        </li>

        <li><a href="">Thời Trang Nam</a>
            <ul>
                <li><a href="">Quần Dài Nam</a></li>
                <li><a href="">Áo Sơ Mi</a></li>
                <li><a href="">Đồ Ngắn,Thể Thao</a></li>
                <li><a href="">Đồ Lót</a></li>
            </ul>
        </li>
        <li><a href="">Giày Thời Trang</a>
            <ul>
                <li><a href="">Giày Nữ</a></li>
                <li><a href="">Giày Nam</a></li>
                <li><a href="">Giày Thể Thao</a></li>
            </ul>
        </li>
        <li><a href="">Phụ Kiện</a>
            <ul>
                <li><a href="">Túi Xách</a></li>
                <li><a href="">Vòng Tay</a></li>
                <li><a href="">Trang Sức</a></li>
                <li><a href="">Mũ Nam Nữ</a></li>
            </ul>
        </li>
    </ul>
</div>

<div id="main">

    <img src="http://doancode.mobie.in/hang-moi-ve-1.jpg" height="80" width="100%"/>
    <div class="col-sm-3 poly-prod">
        <c:forEach items="${listProduct}" var="product">
            <div class="card card-default" >
                <div class="card-body">
                    <img src="${product.image}" width="260px" height="330px" alt="Ảnh"/>
                    <div id="chitiet">
                        <button type="submit" style="margin-top: -40px;margin-left: 175px;">đặt hàng</button>
                    </div>
                </div>
                <div class="card-footer" style="height: 60px">
                    <c:out value="${product.name}"></c:out>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
</body>
</html>

