<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="includes/header.jsp" %>
<h3>Sipariş Detayı #${order.id}</h3><p>Durum: <b>${order.status}</b> - Toplam: <fmt:formatNumber value="${order.totalAmount}" type="currency" currencySymbol="₺"/></p><table class="table bg-white"><tr><th>Ürün</th><th>Adet</th><th>Birim Fiyat</th><th>Ara Toplam</th></tr><c:forEach var="i" items="${order.items}"><tr><td>${i.productName}</td><td>${i.quantity}</td><td><fmt:formatNumber value="${i.unitPrice}" type="currency" currencySymbol="₺"/></td><td><fmt:formatNumber value="${i.subtotal}" type="currency" currencySymbol="₺"/></td></tr></c:forEach></table>
<%@ include file="includes/footer.jsp" %>
