<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap Classic Modal Login Modal Form with Avatar Icon</title>
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <style type="text/css">
        body {
            font-family: 'Varela Round', sans-serif;
        }
        .form-control {
            box-shadow: none;
            border-color: #ddd;
        }
        .form-control:focus {
            border-color: #FB6E9D;
            box-shadow: 0 0 8px rgba(251,110,157,0.4);
        }
        .modal-login {
            color: #434343;
            width: 350px;
        }
        .modal-login .modal-content {
            padding: 20px;
            border-radius: 1px;
            border: none;
            position: relative;
        }
        .modal-login .modal-header {
            border-bottom: none;
        }
        .modal-login h4 {
            text-align: center;
            font-size: 22px;
            margin-bottom: -10px;
        }
        .modal-login .avatar {
            color: #fff;
            margin: 0 auto;
            text-align: center;
            width: 100px;
            height: 100px;
            border-radius: 50%;
            z-index: 9;
            background: #FB6E9D;
            padding: 15px;
            box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.1);
        }
        .modal-login .avatar i {
            font-size: 62px;
        }
        .modal-login .form-control, .modal-login .btn {
            min-height: 40px;
            border-radius: 1px;
            transition: all 0.5s;
        }
        .modal-login .hint-text {
            text-align: center;
            padding-top: 10px;
        }
        .modal-login .close {
            position: absolute;
            top: 15px;
            right: 15px;
        }
        .modal-login .btn {
            background: #FB6E9D;
            border: none;
            line-height: normal;
        }
        .modal-login .btn:hover, .modal-login .btn:focus {
            background: #fb3c7a;
        }
        .modal-login .hint-text a {
            color: #999;
        }
        .trigger-btn {
            display: inline-block;
            margin: 5px;
        }
    </style>
</head>
<body>

<div class="modal-dialog modal-login">
    <div class="modal-content">
        <div class="modal-header">
            <div class="avatar"><i class="material-icons">&#xE7FD;</i></div>
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        </div>
        <div class="modal-body">
            <form action="/login" method="post">
                <c:if test='${requestScope["message_erro"] != null}'>
                    <span>${requestScope["message"]}</span>
                </c:if>
                <div class="form-group">
                    <input type="text" name="username" class="form-control" placeholder=" Tài khoản" required="required">
                </div>
                <div class="form-group">
                    <input type="password" name="password" class="form-control" placeholder=" Mật khẩu" required="required">
                </div>
                <div class="form-group">
                    <input type="submit" class="btn btn-primary btn-block btn-lg" value="ĐĂNG NHẬP">
                </div>
            </form>

            <div class="hint-text small"><a href="/user/reg.jsp">Đăng ký</a></div>
            <div class="hint-text small"><a href="#">Quên mật khẩu ?</a></div>
        </div>
    </div>
</div>
</body>
</html>