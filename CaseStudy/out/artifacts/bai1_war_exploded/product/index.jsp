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

    <div id="login"> <p>Xin Chào,
            <%
        HttpSession ses = request.getSession();
        Boolean islogin = (Boolean)ses.getAttribute("IS_LOGGINED");
      %>
        <c:set var="login" value="<%=islogin%>"/>
        <c:choose>
        <c:when test="${login==null}">
        <a href="login">
            <button class="btn btn-secondary" type="button">
                <i class="fas fa-user-friends"></i> Log In

            </button>
        </a>
        </c:when>
        <c:when test="${login==false}">
        <a href="login">
            <button class="btn btn-secondary" type="button">
                <i class="fas fa-user-friends"></i> Log In

            </button>
        </a>
        </c:when>
        <c:when test="${login==true}">
                <%String displayName = ses.getAttribute("name_display").toString();%>
        <a href="">
            <button class="btn btn-secondary disabled" type="button">

                <i class="fas fa-user-friends"></i> <%=displayName%>

            </button>
        </a>

        </c:when>

        </c:choose>

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
                    <div id="nut">
                        <button type="submit" style="margin-top: -40px;margin-left: 168px;">Đặt Hàng</button>
                        <button type="submit" style="margin-top: -40px;margin-left: 90px;">
                            <a class="non-textdecoration" href="/products?action=view&id=${product.id}">Chi Tiết</a>
                        </button>
                    </div>


<%--                        <div id="chitiet">--%>
<%--                            <br>--%>
<%--                            <br>--%>
<%--                            <b>Tên Sản Phẩm : <c:out value="${product.name}"></c:out> </b>--%>
<%--                            <br>--%>
<%--                            <br>--%>
<%--                            <b>Mã Sản Phẩm :<c:out value="${product.id}"></c:out> </b>--%>
<%--                            <br>--%>
<%--                            <br>--%>
<%--                            <b>Giá : <c:out value="${product.prince}"></c:out></b>--%>
<%--                            <br>--%>
<%--                            <br>--%>
<%--                            <b>Cảm ơn bạn đã ghé xem !</b>--%>
<%--                            <br>--%>
<%--                            <br>--%>
<%--                        </div>--%>

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

