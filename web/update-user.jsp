<%@ page import="java.time.LocalDate" %>
<%@ page import="com.company.model.User" %>
<%@ page import="com.company.dao.user.UserDAOImpl" %><%--
  Created by IntelliJ IDEA.
  User: blati
  Date: 12/1/2022
  Time: 8:08 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String id = request.getParameter("id");
    UserDAOImpl userDAO = UserDAOImpl.getInstance();
//    User user = userDAO.findById(Integer.valueOf(id));
    User user = (User)request.getAttribute("user");


%>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Update Form</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link href="bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<div class="container">
<center><h1>Update Form</h1></center>

<div class="card">
    <div class="card-body">
        <form action="${pageContext.request.contextPath}/update" method="post" >
            <input type="hidden" name="id" value="<%=id %>">
            <div class="form-group row">
                <label for="firstName" class="col-sm-2 col-form-label">First Name</label>
                <div class="col-sm-7">
                    <input type="text"
                           class="form-control"
                           id="firstName"
                           name="firstName"
                           value="<%=user.getFirstName() %>">
                </div>
            </div>
            <div class="form-group row">
                <label for="lastName" class="col-sm-2 col-form-label">Last Name</label>
                <div class="col-sm-7">
                    <input type="text"
                           class="form-control"
                           id="lastName"
                           name="lastName"
                           value="<%=user.getLastName() %>">
                </div>
            </div>
            <div class="form-group row">
                <label for="email" class="col-sm-2 col-form-label">Email</label>
                <div class="col-sm-7">
                    <input type="email"
                           class="form-control"
                           id="email"
                           name="email"
                           value="<%=user.getEmail() %>">
                </div>
            </div>
            <div class="form-group row">
                <label for="dateOfBirth" class="col-sm-2 col-form-label">Date of birth</label>
                <div class="col-sm-7">
                    <input type="date"
                           class="form-control"
                           id="dateOfBirth"
                           name="dateOfBirth"
                           value="<%=user.getDateOfBirth() %>">
                </div>
            </div>
            <div class="form-group row">
                <label for="phone" class="col-sm-2 col-form-label">Phone</label>
                <div class="col-sm-7">
                    <input type="tel"
                           class="form-control"
                           id="phone"
                           name="phone"
                           value="<%=user.getPhone() %>">
                </div>
            </div>
            <div class="form-group row">
                <label for="gender" class="col-sm-2 col-form-label">Gender</label>
                <div class="col-sm-7">
                    <input type="text"
                           class="form-control"
                           id="gender"
                           name="gender"
                           value="<%=user.getGender() %>">
                </div>
            </div>
            <c:if test="${requestScope.get('user').role=='USER'}">
            <div class="form-group row">
                <label for="balance" class="col-sm-2 col-form-label">Balance</label>
                <div class="col-sm-7">
                    <input type="number"
                           class="form-control"
                           id="balance"
                           name="balance"
                           value="<%=user.getBalance() %>">
                </div>
            </div>
        </c:if>
            <div class="form-group row">
                <label for="role" class="col-sm-2 col-form-label">Role</label>
                <div class="col-sm-7">
                    <input type="text"
                           class="form-control"
                           id="role"
                           name="role"
                           value="<%=user.getRole() %>">
                </div>
            </div>
            <br><br>
            <div align="right">
                <button type="submit" value="submit" name="submit" class="btn btn-info">Save</button>
                <button type="reset" value="reset" name="reset" class="btn btn-warning">Reset</button>
            </div>
        </form>
    </div>
</div>
</div>
</body>
</html>
