 <%--
  Created by IntelliJ IDEA.
  User: blati
  Date: 12/4/2022
  Time: 10:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>User Assignment List</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<table class="table table-hover">
    <thead>
    <tr>
        <th scope="col">#</th>
        <th scope="col">Client</th>
        <th scope="col">Trainer</th>
        <th scope="col">Exercise</th>
        <th scope="col">Quantity</th>
        <th scope="col">Nutrition</th>
        <th scope="col">Date</th>
        <th scope="col">Status</th>
    </tr>
    </thead>
    <tbody>

    <c:forEach
            items="${requestScope.get('userAssignments')}"
            var="assignment" varStatus="loop">

        <tr>
            <th scope="row">${loop.index + 1}</th>
            <td>${assignment.to_user.firstName}</td>
            <td>${assignment.from_trainer.firstName}</td>
            <td>${assignment.exercise.name}</td>
            <td>${assignment.quantity}</td>
            <td>${assignment.nutrition.name}</td>
            <td>${assignment.date}</td>
            <td>${assignment.status}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a class="btn btn-primary" style="margin-left: 1300px" href="${pageContext.request.contextPath}/cabinet">BACK</a>
</body>
</html>
