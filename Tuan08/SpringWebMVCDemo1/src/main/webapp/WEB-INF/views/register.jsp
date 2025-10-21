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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/register.css">
    <title>Register New Employee</title>
</head>
<body>
    <c:if test="${employee.id != 0}">
        <h1>UPDATE EMPLOYEE</h1>
    </c:if>
    <c:if test="${employee.id == 0}">
        <h1>REGISTRATION<br>EMPLOYEE</h1>
    </c:if>
    <div class="register">
        <%--@elvariable id="employee" type="iuh.fit.se.entities.Employee"--%>
        <form:form action="${pageContext.request.contextPath}/save" method="POST" modelAttribute="employee">
            <form:input path="id" type="hidden"/>

            <form:label path="firstName" cssClass="label">First Name</form:label>
            <form:input path="firstName" cssClass="input" placeHolder="First Name"/>
            <form:errors path="firstName" cssClass="error"/>

            <form:label path="lastName" cssClass="label">Last Name</form:label>
            <form:input path="lastName" cssClass="input" placeHolder="Last Name"/>
            <form:errors path="lastName" cssClass="error"/>

            <form:label path="email" cssClass="label">Email</form:label>
            <form:input path="email" cssClass="input" placeHolder="Email"/>
            <form:errors path="email" cssClass="error"/>

            <form:label path="dateOfBirth" cssClass="label">Date of Birth</form:label>
            <form:input path="dateOfBirth" type="date" cssClass="input"/>
            <form:errors path="dateOfBirth" cssClass="error"/>

            <form:label path="phone" cssClass="label">Phone number</form:label>
            <form:input path="phone" cssClass="input" placeHolder="Phone number"/>
            <form:errors path="phone" cssClass="error"/>

            <form:label path="gender" cssClass="label">Gender</form:label>
            <div class="input-div">
                <label><form:radiobutton path="gender" value="true"/>Male</label>
                <label><form:radiobutton path="gender" value="false" selected="true"/>Female</label>
            </div>

            <form:label path="address" cssClass="label">Address</form:label>
            <form:input path="address" cssClass="input" placeHolder="Address"/>
            <form:errors path="address" cssClass="error"/>

            <div></div>
            <div>
                <form:button
                        class="button-gray"
                        type="button"
                        onclick="window.location.href='${pageContext.request.contextPath}'"
                >
                    Back
                </form:button>
                <c:if test="${employee.id != 0}">
                    <form:button class="button-light_blue">Update</form:button>
                </c:if>
                <c:if test="${employee.id == 0}">
                    <form:button class="button-light_blue">Register</form:button>
                </c:if>
            </div>
        </form:form>
    </div>
</body>
</html>