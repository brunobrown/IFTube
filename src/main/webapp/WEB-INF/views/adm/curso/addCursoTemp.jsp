<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<jsp:useBean id="curso" class="br.com.iftube.model.entities.Curso" />
	<jsp:useBean id="disciplina"
		class="br.com.iftube.model.entities.Disciplina" />
	<jsp:useBean id="palavraChave"
		class="br.com.iftube.model.entities.PalavraChave" />

	<h1>IFTube - Adm</h1>
	<hr>
	<h3>Curso</h3>
	<hr>
	${exception}

	<form action="addCurso" method="post">
		<input type="text" name="nomeCurso" />
		<input type="hidden" name="estadoCurso" value="ATIVO"/>
		<input type="submit" value="Cadastrar">
	</form>

	<a href="home"><button>Voltar</button></a>

	<hr />


	<form:form action="searchCurso" method="get">
		Curso:<input type="text" name="nomeCurso">
		<input type="submit" value="Pesquisar">
	</form:form>

	<hr />
	<table border=1>
		<tr>
			<th>ID</th>
			<th>CURSO</th>
			<th colspan="2">ACÃO</th>
			<th>STATUS</th>
		</tr>


		<c:choose>
			<c:when test="${cursoLocalizado != null}">

				<tr>
					<form:form action="editCurso" method="post">
						<td><input type="text" name="id"
							value="${cursoLocalizado.id}" readonly="readonly"></td>
						<td><input type="text" name="nomeCurso"
							value="${cursoLocalizado.nomeCurso}"></td>
						<input type="hidden" name="estadoCurso"
							value="${cursoLocalizado.estadoCurso}">
						<td><input type="submit" value="Alterar"></td>
						<br/>
					</form:form>
					
					<form:form action="desabilitarCurso" method="post">
						<input type="hidden" name="id" value="${cursoLocalizado.id}">
						<input type="hidden" name="nomeCurso" value="${cursoLocalizado.nomeCurso}" >
						<input type="hidden" name="estadoCurso" value="${cursoLocalizado.estadoCurso eq 'INATIVO' ? 'ATIVO' : 'INATIVO' }">	
						<td><input type="submit" value="${cursoLocalizado.estadoCurso eq 'INATIVO' ? 'Habilitar' : 'Desabilitar' }"></td>
						<td style="color: ${cursoLocalizado.estadoCurso eq 'ATIVO' ? 'green' : 'red' }">${cursoLocalizado.estadoCurso}</td>
					</form:form>
				</tr>

			</c:when>
			<c:otherwise>

				<c:forEach var="c" items="${listarCurso}">

					<tr>

						<form:form action="editCurso" method="post">
							<td><input type="text" name="id" value="${c.id}"
								readonly="readonly"></td>
							<td><input type="text" name="nomeCurso"
								value="${c.nomeCurso}"></td>
							<input type="hidden" name="estadoCurso"
								value="${c.estadoCurso}">	
							<td><input type="submit" value="Alterar"></td>
							<br/>
						</form:form>
						
						<form:form action="desabilitarCurso" method="post">
							<input type="hidden" name="id" value="${c.id}">
							<input type="hidden" name="nomeCurso" value="${c.nomeCurso}" >
							<input type="hidden" name="estadoCurso" value="${c.estadoCurso eq 'INATIVO' ? 'ATIVO' : 'INATIVO' }">	
							<td><input type="submit" value="${c.estadoCurso eq 'INATIVO' ? 'Habilitar' : 'Desabilitar' }"></td>
							<td style="color: ${c.estadoCurso eq 'ATIVO' ? 'green' : 'red' }">${c.estadoCurso}</td>
						</form:form>
					</tr>
				</c:forEach>

			</c:otherwise>
		</c:choose>

	</table>

</body>
</html>