<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:url value="/" var="contextPath" />

<tags:pageTemplate titulo="Lista de Pedidos">

<jsp:body>
	<section class="container middle">
		<h2 id="cart-title"><fmt:message key="pedidos.lista"/></h2>
		<table id="cart-table">
			<thead>
				<tr>
					<th><fmt:message key="pedidos.id"/></th>
					<th><fmt:message key="pedidos.valor"/></th>
					<th><fmt:message key="pedidos.data.pedido"/></th>
					<th><fmt:message key="pedidos.titulos"/></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${pedidos }" var="pedido">
					<tr>
						<td>${pedido.id }</td>
						<td>${pedido.valor }</td>
						<td>${pedido.data }</td>
						<td>
							<c:forEach items="${pedido.produtos}" var="produto" varStatus="iteration">
								${produto.titulo}<c:if test="${!iteration.last }">,</c:if>
							</c:forEach>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</section>
</jsp:body>

</tags:pageTemplate>