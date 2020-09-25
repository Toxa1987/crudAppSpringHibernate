<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored = "false" %>

<html >
<head>
    <title>Edit</title>
</head>
<body>
<c:url value="/edit" var="var"/>
<form   action="${var}" method="post">
    <input type="hidden" name="id" value="${user.id}">
    <label for="email">Title </label>
    <input type="email" name="email" id="email" value="${user.email}">
    <label for="password">password </label>
    <input type="password" name="password" id="password" value="${user.password}">
    <label >activate </label>
    <c:set var = "activated"  value = "${user.activated}"/>
    <c:if test="${activated==true}">
        <input type="radio" name="watched"  value="true" checked>
        <input type="radio" name="watched" value="false">
    </c:if>
    <c:if test="${activated==false}">
        <input type="radio" name="activated"  value="true" >
        <input type="radio" name="activated" value="false" checked>
    </c:if>
    <input type="submit" value="Edit user">
</form>
</body>
</html>