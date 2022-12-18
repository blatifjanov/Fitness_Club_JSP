<%--
  Created by IntelliJ IDEA.
  User: blati
  Date: 12/3/2022
  Time: 10:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Add Membership</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link href="bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<center><h1>Add Membership Form</h1></center>
<div class="container">
    <div class="card">
        <div class="card-body">
            <form action="<%=request.getContextPath()%>/add-membership" method="post">

                <div class="form-group row">
                    <label for="name" class="col-sm-2 col-form-label">Name</label>
                    <div class="col-sm-7">
                        <input type="text"
                               class="form-control"
                               id="name"
                               name="name"
                               placeholder="Enter name">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="price" class="col-sm-2 col-form-label">Price</label>
                    <div class="col-sm-7">
                        <input type="number"
                               class="form-control"
                               id="price"
                               name="price"
                               placeholder="Enter price">
                    </div>
                </div>
                <div align="right">
                    <button type="submit" value="submit" name="submit" class="btn btn-info">Add</button>
                    <button type="reset" value="reset" name="reset" class="btn btn-warning">Reset</button>

                </div>
            </form>
            <div align="right">
                <a class="btn btn-primary" href="${pageContext.request.contextPath}/cabinet">BACK</a>
            </div>
        </div>
    </div>
</div>
</body>
</html>
