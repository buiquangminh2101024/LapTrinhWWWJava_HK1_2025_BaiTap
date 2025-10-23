<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/danhSachSanPham.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/quanLy.css">

<div class="danhsach_container">
    <div class="find">
        <form action="${pageContext.request.contextPath}/quanLy" method="get">
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
                            <form action="${pageContext.request.contextPath}/quanLy" method="post" class="form_button_edit">
                                <input type="hidden" name="id" value="${phone.maDT}">
                                <input type="hidden" name="type" value="edit">
                                <button class="button_edit" onclick="return confirm('Bạn có chắc là mình muốn sửa không?')">
                                    <img
                                            src="${pageContext.request.contextPath}/images/edit.png"
                                            alt="Lỗi icon"
                                            class="img_button_edit"
                                    >
                                </button>
                            </form>
                            <form action="${pageContext.request.contextPath}/quanLy" method="post" class="form_button_delete">
                                <input type="hidden" name="id" value="${phone.maDT}">
                                <input type="hidden" name="image" value="${phone.hinhAnh}">
                                <input type="hidden" name="type" value="delete">
                                <button class="button_delete" onclick="return confirm('Bạn có chắc là mình muốn xóa không?')">
                                    <img
                                            src="${pageContext.request.contextPath}/images/delete.png"
                                            alt="Lỗi icon"
                                            class="img_button_delete"
                                    >
                                </button>
                            </form>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </c:forEach>
    </div>
</div>