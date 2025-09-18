<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <style>
        form, form * {
            width: 100%;
        }
    </style>
</head>
<body>
<div style="width: 300px; display: flex; flex-direction: column; align-items: center;">
    <h1>Registration</h1>

    <c:if test="${not empty errors}">
        <ul style="color: red;">
            <c:forEach var="error" items="${errors}">
                <li>${error.propertyPath}: ${error.message}</li>
            </c:forEach>
        </ul>
    </c:if>

    <form method="POST" action="validate">
        <table>
            <tr>
                <td><input type="text" name="name" placeholder="Name" /></td>
            </tr>
            <tr>
                <td><input type="text" name="email" placeholder="Email" /></td>
            </tr>
            <tr>
                <td><input type="text" name="country" placeholder="Country" /></td>
            </tr>
            <tr>
                <td><input type="submit" onClick="return confirm('Are you sure?')" /></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>