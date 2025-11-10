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
                        ${ncc.tenNCC}
                    </div>
                </div>
                <div class="card_container">
                    <c:forEach var="phone" items="${ncc.dienThoais}">
                        <div class="card">
                            <div class="card_img_container">
                                <img src="${pageContext.request.contextPath}/images/${phone.hinhAnh}" alt="" class="card_img">
                            </div>
                            <div class="card_content_container">
                                <div class="card_phone_name">${phone.tenDT}</div>
                                <div style="margin-bottom: 10px;">
                                    <span style="font-weight: bold; color: #FC466B;">Tên nhà cung cấp: </span>
                                        ${phone.nhaCungCap.tenNCC}
                                </div>
                                <div>
                                    <span style="font-weight: bold; color: #3F5EFB;">Cấu hình: </span>
                                        ${phone.cauHinh}
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </c:forEach>
    </div>
</div>