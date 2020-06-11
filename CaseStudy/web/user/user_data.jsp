<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Quản Lý Sản Phẩm</h1>
<h2>
    <a href="./user/login.jsp">Thêm tài khoản</a><br>
    <a href="./products?action=listbycountry">Phân Loại</a><br>
    <a href="./products?action=index">Show Index</a>
    <a href="./admin?action=product">Quản lý sản phẩm</a>
</h2>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>Danh Sách tài khoản</h2></caption>
        <tr>
            <th>ID</th>
            <th>Tên tài khoản</th>
            <th>Mật khảu</th>
            <th>Quyền truy cập</th>
            <th>Tùy Chọn</th>
        </tr>
        <c:forEach var="user" items="${listUser}">
            <tr>
                <td><c:out value="${user.id}"/></td>
                <td><c:out value="${user.username}"/></td>
                <td><c:out value="${user.password}"/></td>
                <td><c:out value="${user.role}"/></td>
                <td>
                    <a href="./admin?action=delete&id=${user.id}">Xóa</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>

</body>
</html>