<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: blati
  Date: 12/3/2022
  Time: 1:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List exercises</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<table class="table table-hover">
    <thead>
    <tr>
        <th scope="col">#</th>
        <th scope="col">Name</th>
        <th scope="col" colspan="2">Action</th>

    </tr>
    </thead>
    <tbody>

    <c:forEach
            items="${requestScope.get('exercises')}"
            var="exercise" varStatus="loop">

        <tr>
            <th scope="row">${loop.index + 1}</th>
            <td>${exercise.name}</td>
            <td><a href="${pageContext.request.contextPath}/updateExercise?id=${exercise.id}">Edit</a></td>
            <td><a href="${pageContext.request.contextPath}/deleteExercise?id=${exercise.id}">Delete</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a class="btn btn-primary" style="margin-left: 1300px" href="${pageContext.request.contextPath}/cabinet">BACK</a>
</body>
</html>
