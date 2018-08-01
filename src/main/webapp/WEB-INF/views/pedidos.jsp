<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>

<c:url value="/" var="contextPath" />

<tags:pageTemplate titulo="Lista de Pedidos">

<jsp:body>
	<section class="container middle">
		<h2 id="cart-title">Lista de Pedidos Atuais</h2>
		<table id="cart-table">
			<colgroup>
				<col class="item-col" />
				<col class="item-price-col" />
				<col class="item-quantity-col" />
				<col class="line-price-col" />
				<col class="delete-col" />
			</colgroup>
			<thead>
				<tr>
					<td>ID</th>
					<th>Valor</th>
					<th>Data Pedido</th>
					<th>Títulos</th>
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

		<h2>Você já conhece os outros livros da Casa do Código?</h2>
		<ul id="collection" class="related-books">
			<li class="col-left"><a href="/products/livro-plsql" class="block clearfix book-suggest"
				data-book="PL/SQL: Domine a linguagem do banco de dados Oracle"> <img width="113px" height="160px"
					src="http:////cdn.shopify.com/s/files/1/0155/7645/products/plsql-featured_compact.png?v=1434740236"
					alt="PL/SQL: Domine a linguagem do banco de dados Oracle" />
			</a></li>
		</ul>

		<h2>
			<a href="${s:mvcUrl('HC#index').build() }">Veja todos os livros que publicamos!</a>
		</h2>
	</section>
</jsp:body>

</tags:pageTemplate>