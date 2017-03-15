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

	<jsp:useBean id="palavraChave"
		class="br.com.iftube.model.entities.PalavraChave" />


	<h1>IFTube - Adm</h1>
	<hr>
	<h3>Disciplina</h3>
	<hr>

${exception}<br/>

	<c:choose>
		<c:when test="${disciplina.id == null}">
			<form action="addDisciplina" method="post">

				<select name="idCursoFk">
					<option>Selecione um Curso:</option>
					<c:forEach var="c" items="${listarCurso}">
						<c:if test="${c.estadoCurso != 'INATIVO'}"><option value="${c.id}" >${c.nomeCurso}</option></c:if>
					</c:forEach>
				</select> <br /> Disciplina:<input type="text" name="nomeDisciplina" /><br />

				Período:<select name="periodo">
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
				</select><br /> <input type="submit" value="Enviar">

				<input type="hidden" name="estadoDisciplina" value="ATIVO"/>

			</form>
		</c:when>

		<c:otherwise>
			
	Curso:<input value="${curso.nomeCurso}" readonly />
			<br />
	Disciplina:<input value="${disciplina.nomeDisciplina}" readonly />
			<br />	
	Período:<input value="${disciplina.periodo}ª" readonly />
			<br />
			<input type="hidden" name="estadoDisciplina" value="${disciplina.estadoDisciplina}"/>
			
		</c:otherwise>
	</c:choose>

	<c:if test="${disciplina.id != null}">

		<hr>

		<form action="addTag" method="get">

			<input type="hidden" name="idDisciplinaFk" value="${disciplina.id}"><br />

				Tags:<br/>
				<br/><textarea name="tag" rows="10" cols="20" placeholder="Informe uma Tag aqui! Aperte Enter ao final de cada Tag! Não Repetita Tags!"></textarea><br /> 
			
				<input type="submit" value="Cadastrar">

		</form>

	</c:if>


	<hr>

	<a href="home"><button>Voltar</button></a>

</body>
</html>