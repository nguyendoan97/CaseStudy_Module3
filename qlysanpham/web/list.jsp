
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <style type="text/css">
        th,td{
            padding: 20px;
        }
    </style>
</head>
<body>
<h1>Quản Lý Sản Phẩm</h1>
<h2>
    <a href="./products?action=create">Thêm Sản Phẩm</a><br>
    <a href="./products?action=search">Tìm Sản Phẩm</a><br>
</h2>
<div align="center">
    <table border="1" cellpadding="5" style="border-collapse:collapse;padding: 15px">
        <caption><h2>Danh Sách Sản Phẩm</h2></caption>
        <tr>
            <th>ID</th>
            <th>Tên Sản Phẩm</th>
            <th>Giá SP</th>
            <th>Số lượng</th>
            <th>Màu sắc</th>
            <th>Loại SP</th>
            <th>Tùy Chọn</th>
        </tr>
        <c:forEach var="product" items="${listProduct}">
            <tr>
                <td><c:out value="${product.id}"/></td>
                <td><c:out value="${product.name}"/></td>
                <td><c:out value="${product.price}"/></td>
                <td><c:out value="${product.quantity}"/></td>
                <td><c:out value="${product.color}"/></td>
                <td><c:out value="${product.category}"/></td>
                <td>
                    <a href="./products?action=edit&id=${product.id}">Sửa</a>
                    <a href="./products?action=delete&id=${product.id}">Xóa</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>

</body>
</html>
