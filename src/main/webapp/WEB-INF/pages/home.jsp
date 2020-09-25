<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
    <c:url value="/add" var="add"/>
    <a href="${add}">Add new user</a>
    <c:url value="/users" var="users"/>
    <a href="${users}">Users</a>
    <c:url value="/login" var="login"/>
    <a href="${login}">Sign up</a>

</body>
</html>
