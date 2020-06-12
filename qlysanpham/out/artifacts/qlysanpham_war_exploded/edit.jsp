<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Quản Lý Sản Phẩm</title>
</head>
<body>
<div style="text-align: center;">
    <h1>Quản Lý Sản Phẩm</h1>
    <h2>
        <a href="./products?action=list">Quay Lại Danh Sách</a>
    </h2>

</div>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>Sửa Thông Tin</h2>
            </caption>
            <c:if test="${product!=null}">
                <input type="hidden" name="id" value="<c:out value='${product.id}'/>"/>
            </c:if>
            <tr>
                <th>Tên SP:</th>
                <td>
                    <input type="text" name="name" size="45" value="<c:out value='${product.name}'/>"/>
                </td>
            </tr>
            <tr>
                <th>Giá Sp :</th>
                <td>
                    <input type="number" name="price" size="45" value="<c:out value='${product.price}'/>">
                </td>
            </tr><tr>
            <th>Số lượng :</th>
            <td>
                <input type="number" name="quantity" size="45" value="<c:out value='${product.quantity}'/>">
            </td>
        </tr>
            <tr>
                <th>Màu sắc :</th>
                <td>
                    <input type="text" name="color" size="45" value="<c:out value='${product.color}'/>"/>
                </td>
            </tr>
            <tr>
                <th>Loại SP :</th>
                <td>
                    <input type="text" name="category" size="45" value="<c:out value='${product.category}'/>"/>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Thay Đổi"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
