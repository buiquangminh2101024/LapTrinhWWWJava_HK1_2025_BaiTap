<%@ page import="iuh.fit.se.models.CartItem" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: QUANG MINH
  Date: 9/17/2025
  Time: 5:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <p><a href="<%= request.getContextPath()%>/product">Product List</a></p>
    <div>
        <c:if test="${not empty errors}">
            <div style="color: red">${errors}</div>
        </c:if>
    </div>
    <table style="width:100%; border: 1px solid black;">
        <tr style="background-color: #CCCCCC;">
            <td>Model Description</td> <td>Quantity</td>
            <td>Unit Price</td> <td>Total</td>
        </tr>
        <% request.setAttribute("size", ((List<CartItem>) session.getAttribute("cart")).size()); %>
        <c:if test="${size == 0}">
            <tr>
                <td colspan='4'>No items in Cart</td>
            </tr>
        </c:if>
        <c:set var="subtotal" value="0" />
        <c:forEach var="cartItem" items="${cart}" varStatus="counter">
            <form name="item" method="get" action="<%= request.getContextPath()%>/cart">
                <tr>
                    <td>
                        <c:out value="${cartItem.partNumber}" />
                        <c:out value="${cartItem.modelDescription}" />
                    </td>
                    <td>
                        <input type="hidden" name="id" value="${cartItem.partNumber}" />
                        <input type="text" name="quantity" value="${cartItem.quantity}" size="2" />
                        <input type="submit" name="action" value="update" />
                        <input type="submit" name="action" value="delete" />
                    </td>
                    <td>$<c:out value="${cartItem.unitCost}"/></td>
                    <td>$<c:out value="${cartItem.totalCost}"/></td>
                    <c:set var="subtotal" value="${subtotal + cartItem.quantity * cartItem.totalCost}" />
                </tr>
            </form>
        </c:forEach>
        <tr>
            <td colspan="2"></td>
            <td></td>
            <td>Subtotal: $<c:out value="${subtotal}"/></td>
        </tr>
    </table>
</body>
</html>
