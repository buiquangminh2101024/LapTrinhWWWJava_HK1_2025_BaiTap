<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/danhSachSanPham.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/quanLy.css">

<div class="card">
    <div class="card_img_container">
        <img src="${applicationScope.API_BASE_URL}images/${param.hinhAnh}" alt="" class="card_img">
    </div>
    <div class="card_content_container">
        <div class="card_phone_name">${param.tenDT}</div>
        <div style="margin-bottom: 10px;">
            <span style="font-weight: bold; color: #FC466B;">Tên nhà cung cấp: </span>
            ${param.tenNCC}
        </div>
        <div>
            <span style="font-weight: bold; color: #3F5EFB;">Cấu hình: </span>
            ${param.cauHinh}
        </div>
    </div>
    <c:if test="${direction == 'QuanLy'}">
        <form action="${pageContext.request.contextPath}/quanLy" method="post" class="form_button_edit">
            <input type="hidden" name="id" value="${param.maDT}">
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
            <input type="hidden" name="id" value="${param.maDT}">
            <input type="hidden" name="image" value="${param.hinhAnh}">
            <input type="hidden" name="type" value="delete">
            <button class="button_delete" onclick="return confirm('Bạn có chắc là mình muốn xóa không?')">
                <img
                        src="${pageContext.request.contextPath}/images/delete.png"
                        alt="Lỗi icon"
                        class="img_button_delete"
                >
            </button>
        </form>
    </c:if>
</div>