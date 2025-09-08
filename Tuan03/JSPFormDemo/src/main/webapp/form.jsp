<%--
  Created by IntelliJ IDEA.
  User: Student
  Date: 9/7/2025
  Time: 1:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.time.LocalDate" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style.css">
    <script src="${pageContext.request.contextPath}/script.js"></script>
</head>
<body>
    <div class="form-container">
        <form action="registration-form" method="post">
            <div class="form-row">
                <label>First Name:</label>
                <input type="text" name="firstName">
                <span class="hint-text">(max 30 characters a-z and A-Z)</span>
            </div>

            <div class="form-row">
                <label>Last Name:</label>
                <input type="text" name="lastName">
                <span class="hint-text">(max 30 characters a-z and A-Z)</span>
            </div>

            <div class="form-row">
                <label>Date of Birth:</label>
                <div class="date-inputs">
                    <select name="day">
                        <option>Day</option>
                        <option value="1">1</option>
                        <option value="2">2</option>
                        <!-- Add more days as needed -->
                    </select>
                    <select name="month" onchange="dayProcess()">
                        <option>Month</option>
                        <c:set var="m" value="${['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December']}"/>
                        <c:forEach var="i" begin="1" end="12">
<%--                            <option value="${i}">${m[i]}</option>--%>
                            <option value="${i}">${m[i - 1]}</option>
                        </c:forEach>
                    </select>
                    <select name="year" onchange="dayProcess()">
                        <option>Year</option>
                        <c:forEach var="i" begin="0" end="${LocalDate.now().getYear() - 1900}">
                            <option value="${LocalDate.now().getYear() - i}">${LocalDate.now().getYear() - i}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>

            <div class="form-row">
                <label>Email:</label>
                <input type="email" name="email">
            </div>

            <div class="form-row">
                <label>Mobile Number:</label>
                <input type="text" name="mobile">
                <span class="hint-text">(10 digit number)</span>
            </div>

            <div class="form-row">
                <label>Gender:</label>
                <div class="radio-group">
                    <label><input type="radio" name="gender" value="male"> Male</label>
                    <label><input type="radio" name="gender" value="female"> Female</label>
                </div>
            </div>

            <div class="form-row">
                <label>Address:</label>
                <textarea name="address"></textarea>
            </div>

            <div class="form-row">
                <label>City:</label>
                <input type="text" name="city">
                <span class="hint-text">(max 30 characters a-z and A-Z)</span>
            </div>

            <div class="form-row">
                <label>Pin Code:</label>
                <input type="text" name="pincode">
                <span class="hint-text">(6 digit number)</span>
            </div>

            <div class="form-row">
                <label>State:</label>
                <input type="text" name="state">
                <span class="hint-text">(max 30 characters a-z and A-Z)</span>
            </div>

            <div class="form-row">
                <label>Country:</label>
                <input type="text" name="country" value="India">
            </div>

            <div class="form-row">
                <label>Hobbies:</label>
                <div class="checkbox-group">
                    <div class="checkbox-item">
                        <input type="checkbox" name="hobbies" value="drawing">
                        <label>Drawing</label>
                    </div>
                    <div class="checkbox-item">
                        <input type="checkbox" name="hobbies" value="singing">
                        <label>Singing</label>
                    </div>
                    <div class="checkbox-item">
                        <input type="checkbox" name="hobbies" value="dancing">
                        <label>Dancing</label>
                    </div>
                    <div class="checkbox-item">
                        <input type="checkbox" name="hobbies" value="sketching">
                        <label>Sketching</label>
                    </div>
                    <div class="checkbox-item">
                        <input type="checkbox" name="hobbies" value="others">
                        <label>Others</label>
                        <input type="text" name="otherHobbies" style="width: 100px; margin-left: 5px;">
                    </div>
                </div>
            </div>

            <div class="qualification-section">
                <div class="qualification-container">
                    <div class="qualification-label">Qualification</div>
                    <div class="qualifications-table">
                        <table>
                            <thead>
                            <tr>
                                <th>S.No.</th>
                                <th>Examination</th>
                                <th>Board</th>
                                <th>Percentage</th>
                                <th>Year of Passing</th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr>
                                <td>1</td>
                                <td>Class X</td>
                                <td><input type="text" name="class10Board"></td>
                                <td><input type="text" name="class10Percentage"></td>
                                <td><input type="text" name="class10Year"></td>
                            </tr>
                            <tr>
                                <td>2</td>
                                <td>Class XII</td>
                                <td><input type="text" name="class12Board"></td>
                                <td><input type="text" name="class12Percentage"></td>
                                <td><input type="text" name="class12Year"></td>
                            </tr>
                            <tr>
                                <td>3</td>
                                <td>Graduation</td>
                                <td><input type="text" name="graduationBoard"></td>
                                <td><input type="text" name="graduationPercentage"></td>
                                <td><input type="text" name="graduationYear"></td>
                            </tr>
                            <tr>
                                <td>4</td>
                                <td>Masters</td>
                                <td><input type="text" name="mastersBoard"></td>
                                <td><input type="text" name="mastersPercentage"></td>
                                <td><input type="text" name="mastersYear"></td>
                            </tr>
                            </tbody>
                        </table>
                        <div class="table-hints">
                            <span>(10 char max)</span>
                            <span style="margin-left: 200px;">(upto 2 decimal)</span>
                        </div>
                    </div>
                </div>
            </div>

            <div class="form-row">
                <label>Course applied for:</label>
                <div class="course-options">
                    <label><input type="radio" name="course" value="bca"> BCA</label>
                    <label><input type="radio" name="course" value="bcom"> B.Com</label>
                    <label><input type="radio" name="course" value="bsc"> B.Sc</label>
                    <label><input type="radio" name="course" value="ba"> BA</label>
                </div>
            </div>

            <div class="buttons">
                <button type="submit">Submit</button>
                <button type="reset">Reset</button>
            </div>
        </form>
    </div>
</body>
</html>
