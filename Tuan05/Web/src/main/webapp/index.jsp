<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <style>
        body{
            margin: 0;
        }
        .container, .header, .content {
            width: 100%;
        }
        .header {
            height: 200px;
            overflow: hidden;
            position: relative;
        }
        .img-header {
            width: 100%;
            position: absolute;
            left: 0;
            top: -100px;
        }
        .navigate {
            height: 40px;
            display: flex;
            align-items: center;
            justify-content: center;
            gap: 10px;
        }
        .navigate {
            width: 100%;
            box-shadow: 0 0 5px #000;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="header">
            <img class="img-header" src="images/header.jpg" alt="Lỗi hình ảnh">
        </div>
        <div class="navigate">
            <a href="danhSachTinTuc">Danh sách tin tức</a>
            <span>|</span>
            <a href="themTinTuc">Thêm tin tức mới</a>
            <span>|</span>
            <a href="quanLy">Chức năng quản lý</a>
        </div>
        <div class="content">
            <c:choose>
                <c:when test="${'DanhSachTinTucServlet'.equals(pageToInclude)}">
                    <jsp:include page="views/DanhSachTinTuc.jsp"/>
                </c:when>
                <c:when test="${'ThemTinTucServlet'.equals(pageToInclude)}">
                    <jsp:include page="views/TinTucForm.jsp"/>
                </c:when>
                <c:when test="${'QuanLyServlet'.equals(pageToInclude)}">
                    <jsp:include page="views/QuanLyForm.jsp"/>
                </c:when>
            </c:choose>
        </div>
    </div>
</body>
</html>