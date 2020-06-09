<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Quản Lý Sản Phẩm</title>
</head>
<body>
<div style="text-align: center;">
    <h1>Quản Lý Sản Phẩm</h1>
    <h2>
        <a href="products?action=list">Quay Lại Danh Sách</a>
    </h2>

</div>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>Thêm Sản Phẩm</h2>
            </caption>
            <tr>
                <th>Tên SP :</th>
                <td>
                    <input type="text" name="name" id="name" size="45">
                </td>
            </tr>
            <tr>
                <th>URL Hình Ảnh:</th>
                <td>
                    <input type="text" name="image" id="image" size="45">
                </td>
            </tr><tr>
                <th>Giá SP:</th>
                <td>
                    <input type="number" name="prince" id="prince" size="45">
                </td>
            </tr>
            <tr>
                <th>Phân Loại:</th>
                <td>
                    <input type="text" name="classify" id="classify" size="45">
                </td>

            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Tạo SP"/>
                </td>
            </tr>
        </table>
    </form>

</div>
</body>
</html>
