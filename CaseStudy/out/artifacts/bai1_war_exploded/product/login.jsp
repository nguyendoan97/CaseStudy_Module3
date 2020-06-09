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
    <title>Title</title>
</head>
<body>
    <c:if test="${requestScope['message'] != null}">
        <c:out value="${message}"></c:out>
    </c:if>

    <form action="/login" method="post">

        <input type="text" name="username" placeholder="Username Here"/>
        <input type="password" name="password"/>

        <button type="submit">Login</button>

    </form>
</body>
</html>
