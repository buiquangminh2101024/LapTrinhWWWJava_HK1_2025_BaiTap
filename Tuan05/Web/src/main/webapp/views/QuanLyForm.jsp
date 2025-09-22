<%--
  Created by IntelliJ IDEA.
  User: QUANG MINH
  Date: 9/18/2025
  Time: 4:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/DanhSachTinTuc.css">
</head>
<body>
<div class="content-container">
    <div class="danhmuc-container">
        <form action="${pageContext.servletContext.contextPath}/quanLy" method="get" style="width: 100%;">
            <div class="label-container">
                <c:set var="i" value="0" />
                <c:forEach var="d" items="${danhMuc}">
                    <label>
                        <input type="checkbox" name="danhMuc" value="${d.maDM}"
                            <c:if test="${not empty optionDanhMuc and optionDanhMuc[i] == d.maDM}">
                                <c:if test="${optionDanhMuc.length > i}">
                                    <c:set var="i" value="${i + 1}" />
                                </c:if>
                               checked
                            </c:if>
                        >${d.tenDanhMuc}
                    </label>
                </c:forEach>
            </div>
            <div class="order-container">
                <label>
                    <input type="radio" name="order" value="desc"
                        <c:choose>
                           <c:when test="${empty optionOrder}">checked</c:when>
                           <c:when test="${optionOrder == 'desc'}">checked</c:when>
                        </c:choose>
                    >desc
                </label>
                <label>
                    <input type="radio" name="order" value="asc"
                        <c:if test="${not empty optionOrder and optionOrder == 'asc'}">
                           checked
                        </c:if>
                    >asc
                </label>
            </div>
            <div class="title-container">
                <input type="text" name="tieuDe" placeholder="Nhập tiêu đề nếu nhớ"
                    <c:if test="${not empty optionTieuDe}">
                        value="${optionTieuDe}"
                    </c:if>
                >
            </div>
            <div class="label-submit-container">
                <input type="submit" value="Tìm">
                <button>
                    <a href="${pageContext.servletContext.contextPath}/quanLy"
                       style="text-decoration: none; color: black;"
                    >Reset tìm kiếm</a>
                </button>
            </div>
        </form>
    </div>
    <hr/>
    <div class="card-container">
        <c:forEach var="t" items="${tinTuc}">
            <form action="${pageContext.servletContext.contextPath}/quanLy" method="post">
                <div class="card">
                    <input hidden type="hidden" name="maTT" value="${t.maTT}">
                    <c:if test="${not empty optionDanhMuc}">
                        <input hidden type="hidden" name="danhMuc" value="${optionDanhMuc}">
                    </c:if>
                    <input hidden type="hidden" name="order" value="${optionOrder}">
                    <input hidden type="hidden" name="tieuDe" value="${optionTieuDe}">
                    <h2>${t.tieuDe}</h2>
                    <span>Liên kết: <a href="${t.lienKet}">${t.lienKet}</a></span>
                    <input type="submit" value="Xóa tin tức" onclick="return confirm('Bạn có chắc muốn xóa không?')">
                </div>
            </form>
        </c:forEach>
    </div>
</div>
</body>
</html>
