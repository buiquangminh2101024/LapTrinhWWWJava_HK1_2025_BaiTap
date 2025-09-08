<%--
  Created by IntelliJ IDEA.
  User: QUANG MINH
  Date: 9/8/2025
  Time: 8:23 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.time.LocalDate" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>User Registration Form</title>
  <style>
    input[type="text"], input[type="password"], input[type="submit"], table {
      width: 100%;
    }
  </style>
  <script>
    const urlParams = new URLSearchParams(window.location.search);
    const error = urlParams.get("error");
    if (error === "null")
      alert('Error: ' + 'Không được để trống ô nào');

    if (error === "re-email")
      alert('Error: ' + 'Re-Email phải trùng với Email');

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

      let day_month = month != 2? day_value[month][0] : day_value[month][isLeapYear(year)]
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
  <div style="width: 500px;">
    <form action="userservlet" method="post" style="width: 100%;  display: flex; flex-direction: column; align-items: center;">
      <h1>User Registration Form</h1>
      <table>
        <tr>
          <td><input type="text" name="firstName" placeholder="First Name"></td>
          <td><input type="text" name="lastName" placeholder="Last Name"></td>
        </tr>
        <tr>
          <td colspan="2"><input type="text" name="email" placeholder="Your Email"></td>
        </tr>
        <tr>
          <td colspan="2">
            <input type="text" name="re-email" placeholder="Re-enter Email">
            <span id="re-email-announce"></span>
          </td>
        </tr>
        <tr>
          <td colspan="2"><input type="password" name="password" placeholder="New Password"></td>
        </tr>
        <tr>
          <td>
            <table>
              <tr>
                <td>Birthday</td>
                <td></td>
                <td></td>
              </tr>
              <tr>
                <td>
                  <select name="month" onChange="dayProcess()">
                    <option>Month</option>
                    <c:forEach var="i" begin="1" end="12">
                      <option value="${i}">${i}</option>
                    </c:forEach>
                  </select>
                </td>
                <td>
                  <select name="day">
                    <option value="Day">Day</option>
                  </select>
                </td>
                <td>
                  <select name="year" onChange="dayProcess()">
                    <option>Year</option>
                    <c:forEach var="i" begin="0" end="${LocalDate.now().getYear() - 1900}">
                      <option value="${LocalDate.now().getYear() - i}">${LocalDate.now().getYear() - i}</option>
                    </c:forEach>
                  </select>
                </td>
              </tr>
            </table>
          </td>
        </tr>
        <tr>
          <td style="display: flex; gap: 4px;">
            <label>
              <input type="radio" value="Female" name="gender" checked="checked">
              Female
            </label>
            <label>
              <input type="radio" value="Male"  name="gender">
              Male
            </label>
          </td>
        </tr>
        <tr>
          <td colspan="2">
            <input type="submit" value="Submit">
          </td>
        </tr>
      </table>
    </form>
  </div>
</body>
</html>
