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
</head>
<body>
<h1>chào đại K</h1>
<form>
    <table style="border: 1px solid">
        <tr>
            <td>tên sản phẩm</td>
            <td>mã sản phẩm</td>
            <td>đơn giá</td>
            <td>số lượng</td>
            <td>thành tiền</td>
        </tr>
        <c:forEach items="${productAddToCart.cartItemList}" var="cartIterm">
            <tr>
                <td><c:out value='${cartIterm.getProduct().getName()}'></c:out></td>
                <td><c:out value='${cartIterm.getProduct().getId()}'></c:out></td>
                <td><c:out value='${cartIterm.getProduct().getPrice()}'></c:out></td>
                <td><c:out value='${cartIterm.getQuantity()}'></c:out></td>
                <td><c:out value='${cartIterm.getProduct().getPrice()*cartIterm.getQuantity()}'></c:out></td>

            </tr>
        </c:forEach>

    </table>
</form>
</body>
</html>