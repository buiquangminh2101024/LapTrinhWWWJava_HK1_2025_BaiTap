<%@ page import="java.util.List" %>
<%@ page import="iuh.fit.se.models.CartItem" %><%--
  Created by IntelliJ IDEA.
  User: QUANG MINH
  Date: 9/17/2025
  Time: 5:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
  <style>
    .a {
      width: 160px; height: 200px; border: 1px solid black;
      padding: 5px; margin: 10px;
      float: left; text-align: center;
    }
    .hinh {
      width: 80px; height: 100px;
    }
  </style>
</head>
<body>
  <p><a href="<%= request.getContextPath()%>/cart">View Cart</a></p>
  <div>
    <c:if test="${not empty errors}">
      <div style="color: red">${errors}</div>
    </c:if>
  </div>
  <c:forEach items="${products}" var="p">
    <div class="a">
      <form name="modelDetail" method="get" action="cart">
        ${p.model} <br/>
        <img src="<%= request.getContextPath()%>/${p.imgURL}" class="hinh"/> <br/>
        Price: ${p.price} <br/>
        <input type="text" name="quantity" value="1" size="2"/>
        <input type="hidden" name="id" value="${p.id}"/>
        <input type="hidden" name="action" value="add"/>
        <input type="submit" name="addToCart" value="Add to Cart"/>
      </form>
    </div>
  </c:forEach>
</body>
</html>
