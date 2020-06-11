<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: VanHuan
  Date: 6/11/2020
  Time: 1:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cart </title>
    <style type="text/css">
        tr,th,td{
            border: 1px solid;

        }
    </style>
</head>
<body>
<h1>Giỏ Hàng</h1>
<form action="/cart" method="post">


</form>
<form>
    <table style="border: 1px solid;border-collapse:collapse;text-align: center">
        <tr>
            <th>Mã sản phẩm</th>
            <th>Tên sản phẩm</th>
            <th>Đơn giá</th>
            <th>Số lượng</th>
            <th>Thành tiền</th>
            <th>Tùy chọn</th>
        </tr>
        <c:forEach items="${cart}" var="cartItem" varStatus="loop">
            <tr>
                <td>
                    <c:out value="${cartItem.getProduct().getId()}"></c:out>
                </td>
                <td style="width: 300px">
                    <c:out value="${cartItem.getProduct().getName()}"></c:out>
                </td>
                <td>
                    <c:out value="${cartItem.getProduct().getPrince()}"></c:out>
                </td>
                <td>
                    <c:out value="${cartItem.getQuantity()}"></c:out>
                </td><td>
                    <c:out value="${cartItem.getQuantity()*cartItem.getProduct().getPrince()}"></c:out>
                </td>
                <td>
                    <a href="./cart?command=delete&id=${product.getId()}">Xoá</a>
                </td>
            </tr>

        </c:forEach>

    </table>
</form>
</body>
</html>