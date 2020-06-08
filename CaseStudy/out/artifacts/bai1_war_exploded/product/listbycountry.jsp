<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 05/06/2020
  Time: 8:39 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div align="center">
    <h2><a href="./products?action=products">Back to List</a></h2>
    <table border="1" cellpadding="5">
        <caption><h2>List of Users</h2></caption>
        <tr>
            <th>ID</th>
            <th>Tên SP</th>
            <th>URL Hình Ảnh</th>
            <th>Giá SP</th>
            <th>Phân Loại</th>
        </tr>
        <c:forEach var="product" items="${listCountry}">
            <tr>
                <td><c:out value="${product.id}"/></td>
                <td><c:out value="${product.name}"/></td>
                <td><c:out value="${product.image}"/></td>
                <td><c:out value="${product.prince}"/></td>
                <td><c:out value="${product.classify}"/></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
