<%--
  Created by IntelliJ IDEA.
  User: Toxa
  Date: 01.05.2020
  Time: 19:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored = "false" %>

<html>
<head>

    <title>Input mail</title>
</head>
<body>
<p>Input your email for activation your account</p>
<p>${error}</p>
<c:url value="/send" var="send"/>
<form action="send" method="post">
    <label for="email">Email</label>
    <input type="email" id="email"  name="email">
    <input type="submit" name="Send">
</form>
</body>
</html>
