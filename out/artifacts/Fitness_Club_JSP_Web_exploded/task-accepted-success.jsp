<%--
  Created by IntelliJ IDEA.
  User: blati
  Date: 12/17/2022
  Time: 3:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <title>Delete Success</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link href="bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<br><br>
<center><h1>You have accepted the assigned task</h1></center>
<br><br>
<form action="${pageContext.request.contextPath}/cabinet">
    <div align="center">
        <button type="submit" class="btn btn-info">Go back to cabinet</button>
    </div>
</form>
</body>
</html>
