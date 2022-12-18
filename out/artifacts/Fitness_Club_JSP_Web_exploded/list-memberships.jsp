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
    <title>Users</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link href="bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css"/>
</head>
<body>


<table class="table table-hover">
    <thead>
    <tr>
        <th scope="col">#</th>
        <th scope="col">Name</th>
        <th scope="col">Price</th>
        <th scope="col" colspan="2">Action</th>

    </tr>
    </thead>
    <tbody>

    <c:forEach
            items="${requestScope.get('memberships')}"
            var="membership" varStatus="loop">

        <tr>
            <th scope="row">${loop.index + 1}</th>
            <td>${membership.membershipName}</td>
            <td>${membership.price}</td>
            <td><a href="${pageContext.request.contextPath}/updateMembership?id=${membership.id}">Edit</a></td>
            <td><a href="${pageContext.request.contextPath}/deleteMembership?id=${membership.id}">Delete</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a class="btn btn-primary" style="margin-left: 1300px" href="${pageContext.request.contextPath}/cabinet">BACK</a>
</body>
</html>


