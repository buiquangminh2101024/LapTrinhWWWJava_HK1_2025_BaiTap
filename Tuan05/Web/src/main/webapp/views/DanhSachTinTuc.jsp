<%--
  Created by IntelliJ IDEA.
  User: QUANG MINH
  Date: 9/18/2025
  Time: 4:52 PM
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
         <form action="${pageContext.servletContext.contextPath}/danhSachTinTuc" method="get" style="width: 100%;">
             <div class="label-container">
                 <c:forEach var="d" items="${danhMuc}">
                     <label>
                         <input type="checkbox" name="danhMuc" value="${d.maDM}">${d.tenDanhMuc}
                     </label>
                 </c:forEach>
             </div>
             <div class="label-submit-container">
                 <input type="submit" value="Tìm">
             </div>
         </form>
     </div>
     <hr/>
     <div class="card-container">
         <c:forEach var="t" items="${tinTuc}">
             <div class="card">
                 <h2>${t.tieuDe}</h2>
                 <span>Liên kết: <a href="${t.lienKet}">${t.lienKet}</a></span>
                 <p>${t.noiDungTT}</p>
             </div>
         </c:forEach>
     </div>
 </div>
</body>
</html>
