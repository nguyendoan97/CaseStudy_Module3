<%--
  Created by IntelliJ IDEA.
  User: NguyenDoan
  Date: 6/6/2020
  Time: 7:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Quản Lý Sản Phẩm</h1>
<h2>
    <a href="./products?action=create">Thêm Sản Phẩm</a><br>
    <a href="./products?action=listbycountry">Phân Loại</a><br>
    <a href="./products?action=index">Show Index</a>
</h2>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>Danh Sách Sản Phẩm</h2></caption>
        <tr>
            <th>ID</th>
            <th>Tên Sản Phẩm</th>
            <th>URL Hình Ảnh</th>
            <th>Phân Loại</th>
            <th>Tùy Chọn</th>
        </tr>
        <c:forEach var="product" items="${listProduct}">
            <tr>
                <td><c:out value="${product.id}"/></td>
                <td><c:out value="${product.name}"/></td>
                <td><c:out value="${product.email}"/></td>
                <td><c:out value="${product.country}"/></td>
                <td>
                    <a href="./products?action=edit&id=${product.id}">Edit</a>
                    <a href="./products?action=delete&id=${product.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>

</body>
</html>
