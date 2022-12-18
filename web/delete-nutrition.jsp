<%@ page import="com.company.dao.nutrition.NutritionDAOImpl" %>
<%@ page import="com.company.model.Nutrition" %><%--
  Created by IntelliJ IDEA.
  User: blati
  Date: 12/3/2022
  Time: 8:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String id = request.getParameter("id");
    NutritionDAOImpl nutritionDAO =NutritionDAOImpl.getInstance();
    Nutrition nutrition = nutritionDAO.findById(Integer.valueOf(id));

%>
<html>
<head>
    <title>Delete nutrition</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link href="bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<div class="container">
    <center><h1>Delete Form</h1></center>
    <div class="card">
        <div class="card-body">
            <form action="${pageContext.request.contextPath}/deleteNutrition" method="post">
                <input type="hidden" name="id" value="<%=id %>">
                <div class="form-group row">
                    <label for="name" class="col-sm-2 col-form-label">Name</label>
                    <div class="col-sm-7">
                        <input type="text"
                               class="form-control"
                               id="name"
                               name="name"
                               value="<%=nutrition.getName() %>">
                    </div>
                </div>
                <br><br>
                <div align="right">
                    <button type="submit" value="submit" name="submit" class="btn btn-info">Delete</button>
                    <button type="reset" value="reset" name="reset" class="btn btn-warning">Cancel</button>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
