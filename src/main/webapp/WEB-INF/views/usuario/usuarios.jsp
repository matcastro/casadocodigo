<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>

<c:url value="/" var="contextPath" />

<tags:pageTemplate titulo="Lista de Usuários">

<jsp:body>
	<section class="container middle">
		<a href="${s:mvcUrl('UC#form').build() }"><fmt:message key="lista.usuarios.novo"/></a>
		<h2 id="cart-title"><fmt:message key="lista.usuarios"/></h2>
		<p>${message }</p>
		<table id="cart-table">
			<thead>
				<tr>
					<th><fmt:message key="cadastro.usuarios.nome"/></th>
					<th><fmt:message key="cadastro.usuarios.email"/></th>
					<th>Roles</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${usuarios}" var="usuario">
					<tr>
						<td>${usuario.nome}</td>
						<td>${usuario.email}</td>
						<td>${usuario.roles}</td>
						<td>
							<form:form action="${s:mvcUrl('UC#permissoes').arg(0, usuario.email).build() }">
								<input type="image" src="${contextPath }resources/imagens/adicionar.png" 
										alt="Adicionar" title="Adicionar" />
							</form:form>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</section>
</jsp:body>

</tags:pageTemplate>