<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored = "false" %>

<html>
<head>
<title>USERS</title>
</head>
<body>

<h2>USERS</h2>
<c:url value="/" var="var"/>
<a href="${var}">Home</a>
<a href="logout">Logout</a>

<table>
    <tr>
        <th>id</th>
        <th>email</th>
        <th>password</th>
        <th>activated</th>
        <th>action</th>
    </tr>
    <c:forEach var="user" items="${userList}">
        <tr>
            <td>${user.id}</td>
            <td>${user.email}</td>
            <td>${user.password}</td>
            <td>${user.activated}</td>
            <td>
                <c:url value="/edit/${user.id}" var="edit"/>
                <a href="${edit}">edit</a>
                <c:url value="/delete/${user.id}" var="delete"/>
                <a href="${delete}">delete</a>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>