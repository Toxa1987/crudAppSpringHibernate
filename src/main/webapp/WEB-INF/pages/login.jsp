<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored = "false" %>
<!DOCTYPE html>
<html>
<head>
    <title> Login </title>
</head>
<body>
<c:url value="/add" var="add"/>
<a href="${add}">Add new user</a>
<c:url value="/" var="home"/>
<a href="${home}">Home</a>

<div >

    <c:if test="${error}">
        Invalid email or password.
    </c:if>

</div>
<c:url value="/login/process" var="var"/>
<form action="${var}" method="post">
    <div><label> Email : <input type="email" name="email"/> </label></div>
    <div><label> Password: <input type="password" name="password"/> </label></div>
    <div><input type="submit" value="Sign In"/></div>
</form>
</body>
</html>