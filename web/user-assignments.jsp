<%@ page import="com.company.model.enums.Assignment_Status" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: blati
  Date: 11/28/2022
  Time: 1:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% Assignment_Status[] values = Assignment_Status.values();
%>
<html>
<head>
    <title>List of users</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link href="bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<center><h1>List of users</h1></center>
<table class="table table-hover">
    <thead>
    <tr>
        <th scope="col">#</th>
        <th scope="col">User ID</th>
        <th scope="col">FirstName</th>
        <th scope="col">LastName</th>

    </tr>
    </thead>
    <tbody>

    <c:forEach
            items="${requestScope.get('users')}"
            var="user" varStatus="loop">

        <tr>
            <th scope="row">${loop.index + 1}</th>
            <td>${user.id}</td>
            <td>${user.firstName}</td>
            <td>${user.lastName}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<br>
<center><h1>List of exercises</h1></center>
<table class="table table-hover">
    <thead>
    <tr>
        <th scope="col">#</th>
        <th scope="col">Exercise ID</th>
        <th scope="col">Name</th>
    </tr>
    </thead>
    <tbody>

    <c:forEach
            items="${requestScope.get('exercises')}"
            var="exercise" varStatus="loop">

        <tr>
            <th scope="row">${loop.index + 1}</th>
            <td>${exercise.id}</td>
            <td>${exercise.name}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<center><h1>List of nutrition</h1></center>
<table class="table table-hover">
    <thead>
    <tr>
        <th scope="col">#</th>
        <th scope="col">Nutrition ID</th>
        <th scope="col">Name</th>
    </tr>
    </thead>
    <tbody>

    <c:forEach
            items="${requestScope.get('nutritionList')}"
            var="nutrition" varStatus="loop">

        <tr>
            <th scope="row">${loop.index + 1}</th>
            <td>${nutrition.id}</td>
            <td>${nutrition.name}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<br><br/>
<center><h1>Assign Task Form</h1></center>
<div class="container">
    <div class="card">
        <div class="card-body">
            <form action="<%=request.getContextPath()%>/user-assignments" method="post">

                <div class="form-group row">
                    <label for="userId" class="col-sm-2 col-form-label">User ID</label>
                    <div class="col-sm-7">
                        <input type="number"
                               class="form-control"
                               id="userId"
                               name="userId"
                               placeholder="Enter user ID">
                    </div>
                </div>

                <div class="form-group row">
                    <label for="trainerId" class="col-sm-2 col-form-label">Trainer ID</label>
                    <div class="col-sm-7">
                        <input
                                id="trainerId"
                                type="number" class="form-control"
                                name="trainerId"
                                placeholder="Enter trainer ID">
                    </div>
                </div>

                <div class="form-group row">
                    <label for="exerciseId" class="col-sm-2 col-form-label">Exercise ID</label>
                    <div class="col-sm-7">
                        <input
                                id="exerciseId"
                                type="number" class="form-control" name="exerciseId"
                                placeholder="Enter exercise ID">
                    </div>
                </div>

                <div class="form-group row">
                    <label for="quantity" class="col-sm-2 col-form-label">Quantity</label>
                    <div class="col-sm-7">
                        <input
                                id="quantity"
                                type="number" class="form-control" name="quantity"
                                placeholder="Enter quantity">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="nutritionId" class="col-sm-2 col-form-label">Nutrition ID</label>
                    <div class="col-sm-7">
                        <input
                                id="nutritionId"
                                type="number" class="form-control" name="nutritionId"
                                placeholder="Enter nutrition ID">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="date" class="col-sm-2 col-form-label">Date</label>
                    <div class="col-sm-7">
                        <input
                                id="date"
                                type="date" class="form-control"
                                name="date"
                                placeholder="Enter date">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="status" class="col-sm-2 col-form-label">Status</label>
                    <div class="col-sm-7">
                        <input
                                id="status"
                                type="text" class="form-control" name="status"
                                placeholder="Enter status">
                    </div>
                </div>
                <div align="right">
                    <button type="submit" value="submit" name="submit" class="btn btn-primary">ASSIGN</button>
                    <a class="btn btn-primary" href="${pageContext.request.contextPath}/cabinet">BACK</a>
                </div>
            </form>
        </div>
    </div>
</div>
<br/><br/><br/>
</body>
</html>
