<%--
  Created by IntelliJ IDEA.
  User: blati
  Date: 11/17/2022
  Time: 1:08 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Trainers</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>

<table class="table table-hover">
    <thead>
    <tr>
        <th scope="col">#</th>
        <th scope="col">FirstName</th>
        <th scope="col">LastName</th>
        <th scope="col">Email</th>
        <th scope="col">DateOfBirth</th>
        <th scope="col">Phone</th>
        <th scope="col">Gender</th>
        <th scope="col" colspan="2">Action</th>

    </tr>
    </thead>
    <tbody>

    <c:forEach
            items="${requestScope.get('trainers')}"
            var="user" varStatus="loop">

        <tr>
            <th scope="row">${loop.index + 1}</th>
            <td>${user.firstName}</td>
            <td>${user.lastName}</td>
            <td>${user.email}</td>
            <td>${user.dateOfBirth}</td>
            <td>${user.phone}</td>
            <td>${user.gender}</td>
            <td><a href="/update?id=${user.id}">Edit</a></td>
            <td><a href="/delete?id=${user.id}">Delete</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a class="btn btn-primary" style="margin-left: 1300px" href="${pageContext.request.contextPath}/cabinet">BACK</a>

</body>
</html>


