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
	<jsp:useBean id="palavraChave"
		class="br.com.iftube.model.entities.PalavraChave" />

	<h1>IFTube - Adm</h1>
	<hr>
	<h3>Disciplina</h3>
	<hr>
	<form action="addDisciplina" method="post">

<c:choose>
			<c:when test="${disciplina.id == null}">

		<select name="curso">
			<option>Selecione um Curso:</option>
			<c:forEach var="c" items="${listarCurso}">
				<option value="${c.id}">${c.nomeCurso}</option>
			</c:forEach>
		</select> <br />
			</c:when>
			<c:otherwise>

			

				<table border='1' style='width: 50%'>
				<tr><td>${c.nomeCurso}</td></tr>
				</table>



			</c:otherwise>
		</c:choose>






		 Disciplina:<input type="text" name="nomeDisciplina" value="${disciplina.nomeDisciplina}" <c:if test="${disciplina.id != null}">readonly</c:if>>

		<br /> Período:<select name="periodo">
			<option value="1">1</option>
			<option value="2">2</option>
			<option value="3">3</option>
		</select><br />

	<c:if test="${disciplina.id == null}">
		<input type="submit" value="Enviar">
	</c:if>

	</form>

	


<c:if test="${disciplina.id != null}">

<hr>

		<form action="addTag" method="get">
		
		<input type="hidden" name="idDisciplinaFk" value="${disciplina.id}"><br />
		
	<label for="tags">Informe as Tags utilizando (#) + (nome) separados por espaço</label><br/>
			Tags:<input type="text" name="tag" placeholder="#matrizes #spring #mvc #substantivo"><br /> 
			
			<input type="submit" value="Cadastrar">

		</form>
</c:if>


	<hr>

	<a href="home"><button>Voltar</button></a>

</body>
</html>