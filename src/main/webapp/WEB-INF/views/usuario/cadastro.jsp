<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>

<c:url value="/" var="contextPath" />

<tags:pageTemplate titulo="Cadastro de usuários">

<jsp:body>
	<section class="container middle">
		<h2 id="cart-title"><fmt:message key="cadastro.usuarios"/></h2>
		<form:form action="${s:mvcUrl('UC#cadastra').build() }" method="post" modelAttribute="usuario">
			<div class="form-group">
				<label><fmt:message key="cadastro.usuarios.nome"/></label>
				<form:input path="nome" cssClass="form-control"/>
				<form:errors path="nome" />
			</div>
			<div class="form-group">
				<label><fmt:message key="cadastro.usuarios.email"/></label>
				<form:input path="email" cssClass="form-control"/>
				<form:errors path="email" />
			</div>
			<div class="form-group">
				<label><fmt:message key="cadastro.usuarios.senha"/></label>
				<form:input path="senha" cssClass="form-control"/>
				<form:errors path="senha" />
			</div>
			<div class="form-group">
				<label><fmt:message key="cadastro.usuarios.senha.repetida"/></label>
				<form:input path="senhaRepetida" cssClass="form-control"/>
				<form:errors path="senhaRepetida" />
			</div>
			<button type="submit" class="btn btn-primary"><fmt:message key="cadastro.usuarios.cadastrar"/></button>
		</form:form>
	</section>
</jsp:body>

</tags:pageTemplate>