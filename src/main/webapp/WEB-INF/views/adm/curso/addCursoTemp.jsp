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

		<div>
			<label for="title">Curso</label> <input type="text" name="nomeCurso" />
		</div>

		<div>
			<input type="submit" value="Cadastrar">
		</div>
	</form>

	<a href="listar"><button>Voltar</button></a>

	<hr />


	<form:form action="searchCurso" method="get">
		Curso:<input type="text" name="nomeCurso">
		<input type="submit" value="Pesquisar">
	</form:form>

	<hr />
	<table style='width: 30%'>
		<tr>
			<th>ID</th>
			<th>CURSO</th>
			<th>AÇÕES</th>
		</tr>


		<c:choose>
			<c:when test="${cursoLocalizado != null}">

				<tr>
					<form:form action="editCurso" method="get">
						<td><input type="text" name="id"
							value="${cursoLocalizado.id}" readonly="readonly"></td>
						<td><input type="text" name="nomeCurso"
							value="${cursoLocalizado.nomeCurso}"></td>
						<td><input type="submit" value="Alterar"></td>
					</form:form>
					<td><a href="deleteCurso?id=${cursoLocalizado.id}"><button>Remover</button></a></td>
				</tr>

			</c:when>
			<c:otherwise>

				<c:forEach var="c" items="${listarCurso}">

					<tr>

						<form:form action="editCurso" method="get">
							<td><input type="text" name="id" value="${c.id}"
								readonly="readonly"></td>
							<td><input type="text" name="nomeCurso"
								value="${c.nomeCurso}"></td>
							<td><input type="submit" value="Alterar"></td>
						</form:form>
						<td><a href="deleteCurso?id=${c.id}"><button>Remover</button></a></td>
					</tr>
				</c:forEach>

			</c:otherwise>
		</c:choose>

	</table>

</body>
</html>