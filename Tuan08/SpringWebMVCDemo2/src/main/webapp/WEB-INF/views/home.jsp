<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/home.css">
    <title>Shining The Way</title>
</head>
<body>
    <div class="header">
        <span class="header_font">Shining</span>
        <img src="${pageContext.request.contextPath}/images/header.png" alt="Lỗi server" style="width: 10%;">
        <span class="header_font">The Way</span>
    </div>
    <div class="navigate">
        <a href="danhSachSanPham">Danh sách sản phẩm</a>
        <span>|</span>
        <a href="themMoiSanPham">Thêm mới sản phẩm</a>
        <span>|</span>
        <a href="quanLy">Chức năng quản lý</a>
    </div>
    <div class="content">
        <c:choose>
            <c:when test="${direction == 'DanhSachSanPham'}">
                <%@ include file="danhSachSanPham.jsp"%>
            </c:when>
            <c:when test="${direction == 'ThemMoiSanPham'}">
                <%@ include file="themMoiSanPham.jsp"%>
            </c:when>
            <c:when test="${direction == 'QuanLy'}">
                <%@ include file="quanLy.jsp"%>
            </c:when>
        </c:choose>
    </div>
    <div class="footer">Bùi Quang Minh - 22664411 - DHKTMP18B</div>
</body>
</html>