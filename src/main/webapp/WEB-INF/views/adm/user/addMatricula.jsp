<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>IFTube - Adm</h1>
	<hr>
	<h3>Matrícula</h3>
	
	<a href="homeUser"><button>Usuários</button></a>
	<a href="exibirPaginaCadastrarUsuario?holeUser=<sec:authentication property="authorities"/>"><button>Cadastrar
			Usuário</button></a>
	<hr>
	${exception}
	
	<c:url var="addMatricula" value="/addMatricula"/>
	<form:form action="addMatricula" method="post">
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		Cadastrar Usuário<input type="text" name="matriculaAluno" />
		<input type="submit" value="Cadastrar">
	</form:form>

	<hr />

	<form:form action="searchMatricula" method="get">
		Matrícula:<input type="text" name="matriculaAluno">
		<input type="submit" value="Pesquisar">
	</form:form>

	<hr />
	<table border=1>
		<tr>
			<th>MATRÍCULA</th>
			<th>ACÃO</th>
			<th>STATUS</th>
		</tr>


		<c:choose>
			<c:when test="${matriculaLocalizado != null}">

				<tr>
					<c:url var="editMatricula" value="/editMatricula"/>
					<form:form action="editMatricula" method="post">
						<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
						<input type="hidden" name="matriculaAtual" value="${matriculaLocalizado.matriculaAluno}">
							
							<c:forEach var="objUsuario" items="${listarUsuario}">
								<c:if test="${objUsuario.idMatriculaAlunoFk.matriculaAluno eq matriculaLocalizado.matriculaAluno}">
									<input type="hidden" name="idUsuario" value="${objUsuario.id}">
								</c:if>
							</c:forEach>
							
						<td><input type="text" name="matriculaAluno" value="${matriculaLocalizado.matriculaAluno}"></td>
						<td><input type="submit" value="Alterar"></td>
						<br/>
					</form:form>
				</tr>

			</c:when>
			<c:otherwise>

				<c:forEach var="c" items="${listarMatricula}">

					<tr>
						<c:url var="editMatricula" value="/editMatricula"/>
						<form:form action="editMatricula" method="post">
							<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
							<input type="hidden" name="matriculaAtual" value="${c.matriculaAluno}">
							
							<c:forEach var="objUsuario" items="${listarUsuario}">
								<c:if test="${objUsuario.idMatriculaAlunoFk.matriculaAluno eq c.matriculaAluno}">
									<input type="hidden" name="idUsuario" value="${objUsuario.id}">
								</c:if>
							</c:forEach>
							
							<td><input type="text" name="matriculaAluno" value="${c.matriculaAluno}"></td>
							<td><input type="submit" value="Alterar"></td>
						
						</form:form>
					</tr>
				</c:forEach>

			</c:otherwise>
		</c:choose>

	</table>

</body>
</html>