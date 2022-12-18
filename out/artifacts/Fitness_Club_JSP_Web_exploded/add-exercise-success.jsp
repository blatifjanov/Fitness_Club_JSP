<%--
  Created by IntelliJ IDEA.
  User: blati
  Date: 12/3/2022
  Time: 5:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Add exercise success</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link href="bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<br><br>
<center><h1>Congratulations!!!</h1></center>
<br><br>
<center><h1>Exercise has been added successfully</h1></center>
<br><br>
<form action="${pageContext.request.contextPath}/cabinet">
    <div align="center">
        <button type="submit" class="btn btn-info">Go back to cabinet</button>

    </div>
</form>
</body>
</html>
