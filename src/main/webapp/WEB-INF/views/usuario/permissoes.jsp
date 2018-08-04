<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>

<c:url value="/" var="contextPath" />

<tags:pageTemplate titulo="Permissões de Usuários">

<jsp:body>
	<section class="container middle">
		<h2 id="cart-title">
			<fmt:message key="lista.permissoes">
				<fmt:param value="${command.nome }"/>
			</fmt:message>
		</h2>
		<form:form action="${s:mvcUrl('UC#atualiza').build() }" method="POST">
			<form:checkboxes items="${rolesList }" path="roles"/>
			<form:hidden path="email"/>
			<form:hidden path="nome"/>
			<form:hidden path="senha"/>
			<form:hidden path="senhaRepetida"/>
			<button type="submit" class="btn btn-primary">Atualizar</button>
		</form:form>	
	</section>
</jsp:body>

</tags:pageTemplate>