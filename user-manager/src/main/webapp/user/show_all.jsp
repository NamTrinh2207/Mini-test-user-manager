<%--
  Created by IntelliJ IDEA.
  User: Nam
  Date: 3/9/2023
  Time: 2:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300&display=swap" rel="stylesheet">
    <title>User List</title>
    <style>
        body{
            max-width: 500px;
            margin: auto;
        }
        h2 {
            text-align: center;
            font-weight: bold;
        }
    </style>
</head>
<body>
<table class="table table-success table-striped">
    <h2>LIST OF USERS</h2>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Province</th>
    </tr>
    <c:forEach var="user" items="${requestScope.users}">
        <tr>
            <td><c:out value="${user.id}"/></td>
            <td><c:out value="${user.name}"/></td>
            <td><c:out value="${user.province.name}"/></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
