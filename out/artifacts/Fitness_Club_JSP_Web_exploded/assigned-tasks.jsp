<%@ page import="com.company.model.UserAssignment" %><%--
  Created by IntelliJ IDEA.
  User: blati
  Date: 12/17/2022
  Time: 10:34 AM
  To change this template use File | Settings | File Templates.
--%>
<% UserAssignment userAssignment = (UserAssignment) session.getAttribute("userAssignment");
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>My Task</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link href="bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css"/>
</head>
<body>

<div class="container">
    <div class="card-body">
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">User</label>
            <div class="col-sm-7">
                ${userAssignment.to_user.firstName}
            </div>
        </div>

        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Trainer</label>
            <div class="col-sm-7">
                ${userAssignment.from_trainer.firstName}
            </div>
        </div>

        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Exercise</label>
            <div class="col-sm-7">
                ${userAssignment.exercise.name}
            </div>
        </div>

        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Quantity</label>
            <div class="col-sm-7">
                ${userAssignment.quantity}
            </div>
        </div>

        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Nutrition</label>
            <div class="col-sm-7">
                ${userAssignment.nutrition.name}
            </div>
        </div>

        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Date</label>
            <div class="col-sm-7">
                ${userAssignment.date}
            </div>
        </div>

        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Status</label>
            <div class="col-sm-7">
                ${userAssignment.status}
            </div>
        </div>

    </div>
</div>


<div align="left">
    <a class="btn btn-primary" style="margin-left: 1300px" href="${pageContext.request.contextPath}/task-accepted-success.jsp">Accept</a>
    <a class="btn btn-primary" style="margin-left: 1300px" href="${pageContext.request.contextPath}/cabinet">BACK</a>
</div>

</body>
</html>
