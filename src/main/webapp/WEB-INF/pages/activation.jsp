<%--
  Created by IntelliJ IDEA.
  User: Toxa
  Date: 20.09.2020
  Time: 19:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>Activation</title>
</head>
<body>
<p>Input your password</p>
<p>${error}</p>
<c:url value="/activation" var="activation"/>
<form action="${activation}" method="post">
    <input type="hidden" id="id" name="id" value="${user.id}">
    <input type="hidden" id="email" name="email" value="${user.email}">
    <label>Password</label>
    <input id="password1" type="password" name ="password1" ><br>
    <label>Repeat password</label>
    <input id="password2" type="password" name="password2">
    <input type="submit" value="activate">

</form>

</body>
</html>
