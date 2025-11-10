<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/themMoiSanPham.css">

<div class="themmoi_container">
    <div class="form_container">
        <c:if test="${dienThoai.maDT == 0}">
            <h1 style="text-align: center; margin-bottom: 30px;">Thêm điện thoại mới</h1>
        </c:if>
        <c:if test="${dienThoai.maDT != 0}">
            <h1 style="text-align: center; margin-bottom: 30px;">Sửa điện thoại</h1>
        </c:if>
        <%--@elvariable id="dienThoai" type="iuh.fit.se.entities.DienThoai"--%>
        <form:form
                method="POST"
                action="${pageContext.request.contextPath}/themMoiSanPham"
                modelAttribute="dienThoai"
                cssClass="form"
                enctype="multipart/form-data"
        >
            <form:hidden path="maDT"/>
            <form:hidden path="hinhAnh"/>
            <div class="attribute">
                <div style="margin-bottom: 10px;">
                    <form:label path="tenDT" cssClass="attribute_title">Tên điện thoại</form:label>
                </div>
                <div><form:input path="tenDT" cssClass="input"/></div>
                <div><form:errors path="tenDT" cssClass="error"/></div>
            </div>
            <div class="attribute">
                <div style="margin-bottom: 10px;">
                    <form:label path="namSanXuat" cssClass="attribute_title">Năm sản xuất</form:label>
                </div>
                <div><form:input path="namSanXuat" cssClass="input" type="number"/></div>
                <div><form:errors path="namSanXuat"  cssClass="error"/></div>
            </div>
            <div class="attribute">
                <div style="margin-bottom: 10px;">
                    <form:label path="cauHinh" cssClass="attribute_title">Cấu hình</form:label>
                </div>
                <div><form:input path="cauHinh" cssClass="input"/></div>
                <div><form:errors path="cauHinh"  cssClass="error"/></div>
            </div>
            <div class="attribute">
                <div style="margin-bottom: 10px;">
                    <form:label path="nhaCungCap" cssClass="attribute_title">Nhà cung cấp</form:label>
                </div>
                <div>
                    <form:select path="nhaCungCap" cssClass="input">
                        <c:forEach var="ncc" items="${nccs}">
                            <form:option value="${ncc.maNCC}">${ncc.tenNCC}</form:option>
                        </c:forEach>
                    </form:select>
                </div>
                <div></div>
            </div>
            <div class="attribute">
                <div style="margin-bottom: 10px;">
                    <form:label path="hinhAnh" cssClass="attribute_title">Hình ảnh</form:label>
                </div>
                <div><input name="hinhAnhFile" class="input" type="file" accept="image/png,image/jpg,image/jpeg"/></div>
                <div></div>
            </div>
            <div class="submit_container">
                <input type="submit" value="${dienThoai.maDT != 0? "Sửa": "Thêm"}" class="button-light_blue" />
            </div>
        </form:form>
    </div>
</div>