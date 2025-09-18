<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.time.LocalDate" %>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <script>
        const day_value = {
            1: [31],
            2: [28, 29],
            3: [31],
            4: [30],
            5: [31],
            6: [30],
            7: [31],
            8: [30],
            9: [31],
            10: [30],
            11: [31],
            12: [30]
        }

        function dayProcess() {
            let month = document.getElementsByName("month")[0].value
            let year = document.getElementsByName("year")[0].value
            let day = document.getElementsByName("day")[0].value

            let day_month = day_value[month][month != 2? 0 : isLeapYear(year)]
        document.getElementsByName("day")[0].innerHTML = "<option>Day</option>"
        for (let i = 1; i <= day_month; i++) {
        document.getElementsByName("day")[0].innerHTML += `<option value="` + i + `">` + i + `</option>`
        }
        document.getElementsByName("day")[0].value = day > day_month? 1 : day
        }

        function isLeapYear(year) {
            return (year % 4 === 0 && (year % 100 !== 0 || year % 400 === 0))? 1 : 0
        }
    </script>
</head>
<body>
<div>
    <h1>Hello World</h1>

    <c:if test="${not empty errors}">
        <ul style="color: red">
            <c:forEach var="error" items="${errors}">
                <li>${error.propertyPath}: ${error.message}</li>
            </c:forEach>
        </ul>
    </c:if>

    <form action="register" method="post">
        <input type="text" name="firstName" placeholder="First Name" />
        <input type="text" name="lastName" placeholder="Last Name" />
        <input type="text" name="email" placeholder="Your Email" />
        <input type="text" name="reEmail" placeholder="Re-enter Email" />
        <input type="text" name="password" placeholder="New Password" />
        <label>Birthday</label>
        <div>
            <select name="month" onChange="dayProcess()">
                <option>Month</option>
                <c:forEach var="i" begin="1" end="12">
                    <option value="${i}">${i}</option>
                </c:forEach>
            </select>
            <select name="day">
                <option value="Day">Day</option>
            </select>
            <select name="year" onChange="dayProcess()">
                <option>Year</option>
                <c:forEach var="i" begin="0" end="${LocalDate.now().getYear() - 1900}">
                    <option value="${LocalDate.now().getYear() - i}">${LocalDate.now().getYear() - i}</option>
                </c:forEach>
            </select>
        </div>
        <div>
            <input type="radio"  value="male" name="gender"/>
            <input type="radio"  value="female" name="gender"/>
        </div>
        <input type="submit" value="Sign Up" />
    </form>
</div>
</body>
</html>