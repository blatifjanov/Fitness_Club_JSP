<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Cabinet</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
</head>
<body>
<div class="container">
    <center><h2 style="margin-right: 0px">Welcome to your dashboard</h2></center>

    <center><h4>Hi, <c:out value="${requestScope.get('currentUser').firstName}"/>
        <c:out value="${requestScope.get('currentUser').lastName}"/>!
    </h4></center>
    <br>
    <br>
    <h4>
        <c:if test="${requestScope.get('currentUser').role == 'ADMIN'}">
            <div class="sidebar">
                <ul class="nav-link">
                <li>
                    <a href="${pageContext.request.contextPath}/register">
                        <i class='bx bx-user'></i>
                        <span class="link_name">Add User</span>
                    </a>
                </li>
                </ul>
                <ul class="nav-link">
                    <li>
                        <a href="${pageContext.request.contextPath}/list-users">
                            <i class='bx bx-list-ul'></i>
                            <span class="link_name">View Users</span>
                        </a>
                    </li>
                </ul>
                <ul class="nav-link">
                    <li>
                        <a href="${pageContext.request.contextPath}/list-trainers">
                            <i class='bx bx-list-ul'></i>
                            <span class="link_name">View Trainers</span>
                        </a>
                    </li>
                </ul>
                <ul class="nav-link">
                    <li>
                        <a href="${pageContext.request.contextPath}/add-exercise">
                            <i class='bx bx-grid-alt'></i>
                            <span class="link_name">Add Exercise</span>
                        </a>
                    </li>
                </ul>
                <ul class="nav-link">
                    <li>
                        <a href="${pageContext.request.contextPath}/list-exercises">
                            <i class='bx bx-list-ul'></i>
                            <span class="link_name">View Exercises</span>
                        </a>
                    </li>
                </ul>
                <ul class="nav-link">
                    <li>
                        <a href="${pageContext.request.contextPath}/add-nutrition">
                            <i class='bx bx-grid-alt'></i>
                            <span class="link_name">Add Nutrition</span>
                        </a>
                    </li>
                </ul>
                <ul class="nav-link">
                    <li>
                        <a href="${pageContext.request.contextPath}/list-nutrition">
                            <i class='bx bx-list-ul'></i>
                            <span class="link_name">View Nutrition</span>
                        </a>
                    </li>
                </ul>
                <ul class="nav-link">
                    <li>
                        <a href="${pageContext.request.contextPath}/list-assignments">
                            <i class='bx bx-list-ul'></i>
                            <span class="link_name">View Assignments</span>
                        </a>
                    </li>
                </ul>
                <ul class="nav-link">
                    <li>
                        <a href="${pageContext.request.contextPath}/list-reviews">
                            <i class='bx bx-message'></i>
                            <span class="link_name">View Reviews</span>
                        </a>
                    </li>
                </ul>
                <ul class="nav-link">
                    <li>
                        <a href="${pageContext.request.contextPath}/orders">
                            <i class='bx bx-book-alt'></i>
                            <span class="link_name">Orders</span>
                        </a>
                    </li>
                </ul>
                <ul class="nav-link">
                    <li>
                        <a href="${pageContext.request.contextPath}/add-membership">
                            <i class='bx bx-grid-alt'></i>
                            <span class="link_name">Add membership</span>
                        </a>
                    </li>
                </ul>
                <ul class="nav-link">
                    <li>
                        <a href="${pageContext.request.contextPath}/list-memberships">
                            <i class='bx bx-list-ul'></i>
                            <span class="link_name">View memberships</span>
                        </a>
                    </li>
                </ul>
                <ul class="nav-link">
                    <li>
                        <a href="${pageContext.request.contextPath}/index.jsp">
                            <i class='bx bx-log-out'></i>
                            <span class="link_name">Log out</span>
                        </a>
                    </li>
                </ul>
            </div>
        </c:if>

        <c:if test="${requestScope.get('currentUser').role == 'USER'}">
            <div class="sidebar">
                <ul class="nav-link">
                    <li>
                        <a href="${pageContext.request.contextPath}/user-profile?id=${requestScope.get('currentUser').id}">
                            <i class='bx bx-male'></i>
                            <span class="link_name" >Profile</span>
                        </a>
                    </li>
                </ul>
                <ul class="nav-link">
                    <li>
                        <a href="${pageContext.request.contextPath}/assigned-tasks?id=${requestScope.get('currentUser').id}">
                            <i class='bx bx-task' ></i>
                            <span class="link_name">Tasks</span>
                        </a>
                    </li>
                </ul>
                <ul class="nav-link">
                    <li>
                        <a href="${pageContext.request.contextPath}/reviews">
                            <i class='bx bx-comment'></i>
                            <span class="link_name">Reviews</span>
                        </a>
                    </li>
                </ul>
                <ul class="nav-link">
                    <li>
                        <a href="${pageContext.request.contextPath}/orders">
                            <i class='bx bx-notepad'></i>
                            <span class="link_name">Orders</span>
                        </a>
                    </li>
                </ul>
                <ul class="nav-link">
                    <li>
                        <a href="${pageContext.request.contextPath}/payments">
                            <i class='bx bx-money-withdraw'></i>
                            <span class="link_name">Payments</span>
                        </a>
                    </li>
                </ul>
                <ul class="nav-link">
                    <li>
                        <a href="${pageContext.request.contextPath}/index.jsp">
                            <i class='bx bx-log-out' ></i>
                            <span class="link_name">Log out</span>
                        </a>
                    </li>
                </ul>
            </div>
        </c:if>

        <c:if test="${requestScope.get('currentUser').role=='TRAINER'}">
        <div class="sidebar">
            <ul class="nav-link">
                <li>
                    <a href="${pageContext.request.contextPath}/user-assignments">
                        <i class='bx bx-task'></i>
                        <span class="link_name">Assign Task</span>
                    </a>
                </li>
            </ul>
            <ul class="nav-link">
                <li>
                    <a href="${pageContext.request.contextPath}/accepted-assignments">
                        <i class='bx bx-dumbbell'></i>
                        <span class="link_name">Accepted Tasks</span>
                    </a>
                </li>
            </ul>
            <ul class="nav-link">
                <li>
                    <a href="${pageContext.request.contextPath}/ongoing-assignments">
                        <i class='bx bx-run'></i>
                        <span class="link_name">Ongoing Tasks</span>
                    </a>
                </li>
            </ul>
            <ul class="nav-link">
                <li>
                    <a href="${pageContext.request.contextPath}/completed-assignments">
                        <i class='bx bxs-check-square'></i>
                        <span class="link_name">Completed Tasks</span>
                    </a>
                </li>
            </ul>
            <ul class="nav-link">
                <li>
                    <a href="${pageContext.request.contextPath}/view-reviews">
                        <i class='bx bxs-comment-detail'></i>
                        <span class="link_name">View Reviews</span>
                    </a>
                </li>
            </ul>
            <ul class="nav-link">
                <li>
                    <a href="${pageContext.request.contextPath}/index.jsp">
                        <i class='bx bx-log-out' ></i>
                        <span class="link_name">Log out</span>
                    </a>
                </li>
            </ul>
        </div>
        </c:if>


    </h4>
</div>


</body>
</html>