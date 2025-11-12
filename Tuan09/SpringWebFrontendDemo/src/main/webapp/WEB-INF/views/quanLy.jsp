<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/danhSachSanPham.css">

<div class="danhsach_container">
    <div class="find">
        <form action="${pageContext.request.contextPath}/danhSachSanPham" method="get">
            <input name="find" class="input">
            <button class="button-light_blue">Find</button>
        </form>
    </div>
    <div class="dienthoai_containers">
        <c:forEach var="ncc" items="${nccs}">
            <div class="dienthoai_container">
                <div class="nhacungcap_name">
                    <div class="category_text">
                            ${ncc.key}
                    </div>
                </div>
                <div class="card_container">
                    <c:forEach var="phone" items="${ncc.value}">
                        <jsp:include page="card.jsp">
                            <jsp:param name="maDT" value="${phone.maDT}"/>
                            <jsp:param name="hinhAnh" value="${phone.hinhAnh}"/>
                            <jsp:param name="tenDT" value="${phone.tenDT}"/>
                            <jsp:param name="tenNCC" value="${ncc.key}"/>
                            <jsp:param name="cauHinh" value="${phone.cauHinh}"/>
                        </jsp:include>
                    </c:forEach>
                </div>
            </div>
        </c:forEach>
    </div>
</div>