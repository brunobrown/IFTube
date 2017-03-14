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

	<h1>IFTube - Adm</h1>
	<hr>
	<h3>Alterar - Disciplina</h3>
	<hr />

	${exception}

	<c:choose>
		<c:when test="${disciplina.idCursoFk.estadoCurso != 'INATIVO'}">

			<form action="editDisciplina" method="get">

				<input type="hidden" name="idCursoFk"
					value="${disciplina.idCursoFk.id}"> <input type="hidden"
					name="idDisciplinaFk" value="${disciplina.id}"> <input
					type="hidden" name="id" value="${disciplina.id}"> Curso:<input
					type="text" readonly="readonly"
					value="${disciplina.idCursoFk.nomeCurso}"><br /> Status
				Curso: <input type="text" readonly="readonly"
					style="color: ${disciplina.idCursoFk.estadoCurso eq 'ATIVO' ? 'green' : 'red' }"
					value="${disciplina.idCursoFk.estadoCurso}"><br />

				Disciplina:<input type="text" name="nomeDisciplina"
					value="${disciplina.nomeDisciplina}"/> <br />

				Status Disciplina: <input type="text" name="estadoDisciplina" readonly="readonly"
					style="color: ${disciplina.estadoDisciplina eq 'ATIVO' ? 'green' : 'red' }"
					value="${disciplina.estadoDisciplina}" /><br /> Período: <select
					name="periodo">
					<c:forEach begin="1" end="3" var="i">
						<option value="${i}"
							<c:if test="${i eq disciplina.periodo}">selected="selected"</c:if>>${i}</option>
					</c:forEach>
				</select><br /> <br />
				<input type="submit" value="Alterar Disciplina">
				<hr />
			</form>
		</c:when>
		<c:otherwise>

			<input type="hidden" name="id" value="${disciplina.id}">
				
				Curso:<input type="text" readonly="readonly"
				value="${disciplina.idCursoFk.nomeCurso}">
			<br />
				Status Curso: <input type="text" readonly="readonly"
					style="color: ${disciplina.idCursoFk.estadoCurso eq 'ATIVO' ? 'green' : 'red' }"
					value="${disciplina.idCursoFk.estadoCurso}"><br />
				Disciplina:<input type="text" readonly="readonly"
				name="nomeDisciplina"
				value="${disciplina.nomeDisciplina}"/>
			<br /> 
				Status Disciplina: <input type="text" readonly="readonly"
					style="color: ${disciplina.estadoDisciplina eq 'ATIVO' ? 'green' : 'red' }"
					value="${disciplina.estadoDisciplina}" /><br />
				Período:<input type="text" readonly="readonly"
				value="${disciplina.periodo}">
			<br />
		</c:otherwise>
	</c:choose>

	<form action="editTag" method="get">

		<c:forEach var="objPalavraChave" items="${palavraChave}">
			<c:if test="${disciplina.id eq objPalavraChave.idDisciplinaFk.id}">

				<input type="hidden" name="id" value="${objPalavraChave.id}">

			</c:if>
		</c:forEach>
		<input type="hidden" name="idDisciplinaFk" value="${disciplina.id}">
		<input type="hidden" name="disciplinaId" value="${disciplina.id}">
		Tags: <br />
<textarea name="tag" rows="10" cols="20"placeholder="Informe uma Tag aqui! Aperte Enter ao final de cada Tag! Não Repetita Tags!"><c:forEach var="objPalavraChave" items="${palavraChave}"><c:if test="${disciplina.id eq objPalavraChave.idDisciplinaFk.id}">
${objPalavraChave.tag}</c:if></c:forEach></textarea>

		<br />
		<input type="submit" value="Adicionar / Alterar / Remover Tag">
	</form>
	<a href="home"><button>Cancelar</button></a>
	<hr />


</body>
</html>