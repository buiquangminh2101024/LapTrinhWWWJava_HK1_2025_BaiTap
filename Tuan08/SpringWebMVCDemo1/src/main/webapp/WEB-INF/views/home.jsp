<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/home.css">
    <title>Spring Web MVC Demo</title>
</head>
<body>
    <h1>EMPLOYEE LIST</h1>
    <hr>
    <div class="option">
        <form action="${pageContext.request.contextPath}/find" method="post">
            <input name="email_name" placeholder="Name Or Email" class="input">
            <button class="button-gray">Search</button>
        </form>
        <button
            class="button-light_blue"
            onclick="window.location.href='${pageContext.request.contextPath}/register'"
        >
            Add Employee
        </button>
    </div>
    <div>
        <table style="width:100%; border-spacing: 0;">
            <tr>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Gender</th>
                <th>Date of birth</th>
                <th>Email</th>
                <th>Phone</th>
                <th>Action</th>
            </tr>
            <c:forEach var="employee" items="${employees}">
                <tr>
                    <td>${employee.firstName}</td>
                    <td>${employee.lastName}</td>
                    <td>${employee.email}</td>
                    <td>${employee.dateOfBirth}</td>
                    <td>${employee.phone}</td>
                    <td>${employee.gender? "male": "female"}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/update_intermediate?id=${employee.id}">Update</a>
                        |
                        <a
                            href="${pageContext.request.contextPath}/delete_intermediate?id=${employee.id}"
                            onclick="return confirm('Are you sure?')"
                        >
                            Delete
                        </a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>