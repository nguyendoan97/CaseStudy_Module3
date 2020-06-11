<%--
  Created by IntelliJ IDEA.
  User: NguyenDoan
  Date: 6/11/2020
  Time: 11:43 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>

    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"/>
    <link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
</head>
<link rel="stylesheet" href="product/new.css"/>
</head>
<body>
<header class="fixed-top">
    <nav class="navbar navbar-expand-lg navbar-light" style="box-shadow: 0px 3px 3px #80bdff; ;background-color: white" >
        <a class="navbar-brand" href="#"><img src="http://doancode.mobie.in/logoshop.png" alt=""></a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active" style="padding-left: 30px;padding-right: 30px;">
                    <a class="nav-link" href="#"><b>Trang Chủ</b> <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item active" style="padding-left: 30px;padding-right: 30px;">
                    <a class="nav-link" href="#"><b>Sự Kiện</b></a>
                </li>
                <li class="nav-item dropdown active" style="padding-left: 30px;padding-right: 30px;">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <b>Bộ Sưu Tập</b>
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <a class="dropdown-item" href="#">Đồ Công Sở</a>
                        <a class="dropdown-item" href="#">Váy,Đầm</a>
                        <a class="dropdown-item" href="#">Đồ ngủ</a>
                        <a class="dropdown-item" href="#">Đồ Biển</a>
                        <a class="dropdown-item" href="#">Bộ Sưu Tập Hot 2020</a>
                    </div>
                </li>
                <li class="nav-item active" style="padding-left: 30px;padding-right: 30px;">
                    <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true"><b>Flash Sale</b></a>
                </li>
            </ul>
            <form class="form-inline my-2 my-lg-0">
                <%--                <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search" style="border-radius: 15px">--%>
                <%--                <button class="btn btn-outline-success my-2 my-sm-0" type="submit" style="border-radius: 15px">Search</button>--%>
                <div class="form-control mr-sm-2" style="border-radius:30px ">
                    <i class="fa fa-search" style="margin-top:2px; margin-left:9px;padding-right: 5px"></i>
                    <input id="search_input" type="text" name="search" placeholder= "Search..."/>
                </div>
            </form>
            <%
                HttpSession ses = request.getSession();
                Boolean islogin = (Boolean)ses.getAttribute("IS_LOGGINED");
            %>
            <c:set var="login" value="<%=islogin%>"/>
            <c:choose>
                <c:when test="${login==null}">
                    <a href="/login">Đăng nhập</a>
                    <b style="padding-right: 10px;padding-left: 10px">|</b>
                    <a href="/admin">Đăng ký</a>
                </c:when>
                <c:when test="${login==true}">
                    <a href="/logout">Đăng Xuất</a>
                </c:when><c:when test="${login==false}">
                <a href="/login">Đăng nhập</a>
                <b style="padding-right: 10px;padding-left: 10px">|</b>
                <a href="/admin">Đăng ký</a>
                </c:when>
            </c:choose>


        </div>
    </nav>
</header>
<div class="container-fluid">
    <div class="row">
        <div class="col-3" style="position: fixed">
            <div class="poly-cart" style="margin-top: 100px">
                <div class="card">
                    <div class="card-body" style="padding-left: 10px">
                        <b>Xin Chào,
                            <%--                                <%--%>
                            <%--                                HttpSession ses = request.getSession();--%>
                            <%--                                Boolean islogin = (Boolean)ses.getAttribute("IS_LOGGINED");--%>
                            <%--                              %>--%>

                            <c:choose>
                                <c:when test="${login==null}">
                                    <a href="login">
                                        <button class="btn btn-secondary" type="button">
                                            <i class="fas fa-user-friends"></i> Khách !

                                        </button>
                                    </a>
                                </c:when>
                                <c:when test="${login==false}">
                                    <a href="login">
                                        <button class="btn btn-secondary" type="button">
                                            <i class="fas fa-user-friends"></i> Khách !
                                        </button>
                                    </a>
                                </c:when>
                                <c:when test="${login==true}">
                                    <%String displayName = ses.getAttribute("name_display").toString();%>
                                    <a href="">
                                        <button class="btn btn-secondary disabled" type="button">

                                            <i class="fas fa-user-friends"></i> <%=displayName%>

                                        </button>
                                        <br>
                                    </a>
                                    <%String role = ses.getAttribute("ROLE").toString();%>
                                    <c:set var="rolee" value="<%=role%>"/>
                                    <c:if test="${rolee.equals('admin')}">
                                        <a href="/admin" style="color: red">Chức năng quản lý</a><br>
                                    </c:if>
                                    <a href="/cart"><b>Xem giỏ hàng</b></a>

                                </c:when>

                            </c:choose>
                        </b>
                    </div>
                </div>
            </div>

            <div class="panel panel-default">
                <div class="panel-heading">
                    <span class="glyphicon glyphicon-th-list"></span>
                    <strong>Tin tức</strong>
                </div>
                <div class="list-group">
                    <a href="#" class="list-group-item"><b>Xu hướng mùa hè</b> </a>
                    <a href="#" class="list-group-item"><b>Hướng dẫn chọn mẫu</b></a>
                    <a href="#" class="list-group-item"><b>Hướng dẫn thanh toán</b></a>
                    <a href="#" class="list-group-item"><b>Liên hệ</b></a>
                    <a href="#" class="list-group-item"><b>Chính sách giao nhận</b> </a>
                    <a href="#" class="list-group-item"><b>Quy định chung</b></a>
                </div>
            </div>
        </div>
        <div class="col-9" style="margin-left: 300px">
            <img style="margin-top: 100px ; margin-left: 15px" src="http://doancode.mobie.in/hang-moi-ve-1.jpg" height="80" width="100%"/>
            <div class="row">
                <div class="col-sm-3 poly-prod" style="min-width: 300px ;min-height: 360px;margin-left: 30px">
                    <div class="card card-default">
                        <img src="<c:out value="${productt.image}"></c:out>" width="300px" height="360px" alt="">
                    </div>
                </div>
                <div class="col-sm-3 poly-prod" style="min-width: 300px ;min-height: 360px;margin-left: 30px">
                    <div class="card card-default" style="line-height: 30px;min-width: 300px ;min-height: 360px;padding: 10px">
                        <p>Tên Sản Phẩm : <b><c:out value="${productt.name}"></c:out></b></p>
                        <p>Giá : <b><c:out value="${productt.prince}"></c:out></b></p>
                        <p>Loại Sản Phẩm : <b><c:out value="${productt.classify}"></c:out></b></p>
                        <br>
                        <div id="nut">
                            <button type="submit" style="margin-top: -30px;margin-left:0;">
                                <a style="text-decoration: none ; color: white" href="/cart?action=cart&id=${product.id}">Đặt Hàng</a></button>
                        </div>
                        <br>
                        <a href="/products?action=list_customer">Quay lại</a>
                        <br>
                    </div>

                </div>
            </div>

        </div>
    </div>
    <div class="card-footer text-muted" style="text-align: center;height: 80px;margin-top: 30px">
        Case Study Module 3 <br>
        Nguyễn Hồng Đoàn C0220I1
    </div>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
</body>
</html>


