<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Register</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link href="bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css"/>


    <%--    <link href="${contextPath}/resource/bootstrap.min.css" rel="stylesheet">--%>
</head>
<body>
<center><h1>REGISTRATION FORM </h1> </center>
<div class="container">
    <div class="card">
        <div class="card-body">
            <form action="<%=request.getContextPath()%>/register" method="post">

                <div class="form-group row">
                    <label for="firstName" class="col-sm-2 col-form-label">First Name</label>
                    <div class="col-sm-7">
                        <input type="text"
                               class="form-control"
                               id="firstName"
                               name="firstName"
                               placeholder="Enter first name">
                    </div>
                </div>

                <div class="form-group row">
                    <label for="lastName" class="col-sm-2 col-form-label">Last Name</label>
                    <div class="col-sm-7">
                        <input
                                id="lastName"
                                type="text" class="form-control"
                                name="lastName"
                                placeholder="Enter last name">
                    </div>
                </div>

                <div class="form-group row">
                    <label for="email" class="col-sm-2 col-form-label">Email</label>
                    <div class="col-sm-7">
                        <input
                                id="email"
                                type="email" class="form-control" name="email"
                                placeholder="Enter email address">
                    </div>
                </div>

                <div class="form-group row">
                    <label for="password" class="col-sm-2 col-form-label">Password</label>
                    <div class="col-sm-7">
                        <input
                                id="password"
                                type="password" class="form-control" name="password"
                                placeholder="Enter password">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="dateOfBirth" class="col-sm-2 col-form-label">Date of Birth</label>
                    <div class="col-sm-7">
                        <input
                                id="dateOfBirth"
                                type="date" class="form-control" name="dateOfBirth"
                                placeholder="Enter date of birth">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="phone" class="col-sm-2 col-form-label">Phone</label>
                    <div class="col-sm-7">
                        <input
                                id="phone"
                                type="tel" class="form-control"
                                name="phone"
                                placeholder="Enter phone number">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="gender" class="col-sm-2 col-form-label">Gender</label>
                    <div class="col-sm-7">
                        <input
                                id="gender"
                                type="text" class="form-control" name="gender"
                                placeholder="Enter gender">
                    </div>
                </div>
                <div align="right">
                    <button type="submit" value="submit" name="submit" class="btn btn-info">Register</button>
                    <button type="reset" value="reset" name="reset" class="btn btn-warning">Reset</button>
                    <a href="${pageContext.request.contextPath}/login.jsp">Already have an account? </a>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>