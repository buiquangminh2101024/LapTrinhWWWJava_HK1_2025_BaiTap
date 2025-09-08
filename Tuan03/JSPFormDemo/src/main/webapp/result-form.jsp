<%@ page import="iuh.fit.se.models.Student" %><%--
  Created by IntelliJ IDEA.
  User: Student
  Date: 9/7/2025
  Time: 2:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        Student student = (Student) request.getAttribute("student");
        out.println(
                "First name: " + student.getFirstName() +
                        "<br/> Last name: " + student.getLastName() +
                        "<br/> Email: " + student.getEmail() +
                        "<br/> Gender: " + (student.isGender()? "male" : "female") +
                        "<br/> Birth day: " + student.getDateOfBirth()
        );
    %>
</body>
</html>
