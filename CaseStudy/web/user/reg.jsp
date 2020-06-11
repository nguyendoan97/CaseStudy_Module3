<%--
  Created by IntelliJ IDEA.
  User: NguyenDoan
  Date: 6/9/2020
  Time: 11:15 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    <link rel="stylesheet" href="/user/login.css">
    <!------ Include the above in your HEAD tag ---------->
<%--    <script src="/product/da.js"></script>--%>
</head>
<body>
    <div class="container">
        <div class="row">
            <div class="col-md-6 col-md-offset-3">
                <div class="panel panel-login">
                    <div class="panel-heading">
                        <div class="row">
<%--                            <div class="col-xs-6">--%>
<%--                                <a href="#" class="active" id="login-form-link">ĐĂNG NHẬP</a>--%>
<%--                            </div>--%>
                            <div class="col-xs-12">
                                <a href="#" id="register-form-link">ĐĂNG KÝ</a>
                            </div>
                        </div>
                        <hr>
                    </div>
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-lg-12">
<%--                                <form id="login-form" action="/login" method="post" role="form" style="display: block;">--%>
<%--                                    <div class="form-group">--%>
<%--                                        <c:if test="${requestScope['message'] != null}">--%>
<%--                                            <c:out value="${message}"></c:out>--%>
<%--                                        </c:if>--%>
<%--                                        <input type="text" name="username" id="username" tabindex="1" class="form-control" placeholder="Username" value="">--%>
<%--                                    </div>--%>
<%--                                    <div class="form-group">--%>
<%--                                        <input type="password" name="password" id="password" tabindex="2" class="form-control" placeholder="Password">--%>
<%--                                    </div>--%>
<%--                                    <div class="form-group text-center">--%>
<%--                                        <input type="checkbox" tabindex="3" class="" name="remember" id="remember">--%>
<%--                                        <label for="remember"> Ghi nhớ</label>--%>
<%--                                    </div>--%>
<%--                                    <div class="form-group">--%>
<%--                                        <div class="row">--%>
<%--                                            <div class="col-sm-6 col-sm-offset-3">--%>
<%--                                                <input type="submit" name="login-submit" id="login-submit" tabindex="4" class="form-control btn btn-login" value="ĐĂNG NHẬP">--%>
<%--                                            </div>--%>
<%--                                        </div>--%>
<%--                                    </div>--%>
<%--                                    <div class="form-group">--%>
<%--                                        <div class="row">--%>
<%--                                            <div class="col-lg-12">--%>
<%--                                                <div class="text-center">--%>
<%--                                                    <a href="https://phpoll.com/recover" tabindex="5" class="forgot-password">Quên mật khẩu?</a>--%>
<%--                                                </div>--%>
<%--                                            </div>--%>
<%--                                        </div>--%>
<%--                                    </div>--%>
<%--                                </form>--%>
                                <form id="register-form" action="/admin?action=reg" method="post" role="form" style="display: none;">
                                    <div class="form-group">
                                        <input type="text" name="username" id="username" tabindex="1" class="form-control" placeholder="Username" value="">
                                    </div>
                                    <div class="form-group">
                                        <input type="password" name="password" id="password" tabindex="2" class="form-control" placeholder="Password">
                                    </div>
                                    <div class="form-group">
                                        <input type="password" name="confirm-password" id="confirm-password" tabindex="2" class="form-control" placeholder="Confirm Password">
                                    </div>
                                    <div class="form-group">
                                        <div class="row">
                                            <div class="col-sm-6 col-sm-offset-3">
                                                <input type="submit" name="register-submit" id="register-submit" tabindex="4" class="form-control btn btn-register" value="ĐĂNG KÝ">
                                            </div>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>