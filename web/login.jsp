<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Login</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link href="bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css"/>


</head>
<body>
<div class="container">
    <h1>Login</h1>
    <div class="card">
        <div class="card-body">
            <form action="<%=request.getContextPath()%>/login" method="post">

                <div class="form-group row">
                    <label for="email" class="col-sm-2 col-form-label">Email</label>
                    <div class="col-sm-7">
                        <input type="email"
                               class="form-control"
                               id="email"
                               name="email"
                               placeholder="Enter email">
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
                <div align="right">
                    <button type="submit" value="submit" name="submit" class="btn btn-info">Login</button>
                    <button type="reset" value="reset" name="reset" class="btn btn-warning">Reset</button>
                    <a href="${pageContext.request.contextPath}/register.jsp">Don't have an account? </a>
                </div>

            </form>
        </div>
    </div>
</div>
</body>
</html>