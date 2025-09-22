<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%--
  Created by IntelliJ IDEA.
  User: QUANG MINH
  Date: 9/18/2025
  Time: 4:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        body {
            width:100%;
        }
        .content-container {
            width:100%;
            margin-top: 50px;
            display: flex;
            flex-direction: column;
            align-items: center;
        }
        .card {
            width: 300px;
            border: 1px solid black;
            border-radius: 10px;
        }
        form {
            width: 100%;
            padding-bottom: 20px;
            display: flex;
            flex-direction: column;
            align-items: center;
            gap: 20px;
        }
        h1 {
            width: 100%;
        }
        input, select {
            width: 70%;
        }
    </style>
</head>
<body>
    <div class="content-container">
        <c:if test="${not empty errors}">
            <ul style="color: red;">
                <c:forEach var="error" items="${errors}">
                    <li>${error.propertyPath}: ${error.message}</li>
                </c:forEach>
            </ul>
        </c:if>
        <div class="card">
            <form action="${pageContext.servletContext.contextPath}/themTinTuc" method="post">
                <h1 style="text-align: center">Thêm tin tức</h1>
                <input type="text" name="tieuDe" placeholder="Nhập Tiêu Đề ">
                <input type="text" name="noiDung" placeholder="Nhập Nội Dung">
                <input type="text" name="lienKet" placeholder="Nhập Liên Kết">
                <select name="maDanhMuc">
                    <c:forEach var="i" items="${danhMuc}">
                        <option value="${i.maDM}">${i.tenDanhMuc}</option>
                    </c:forEach>
                </select>
                <input type="submit" value="Thêm">
            </form>
        </div>
    </div>
</body>
</html>
