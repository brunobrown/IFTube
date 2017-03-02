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
<hr>


	<form action="edit" method="get">
		
		Curso:<select name="curso">
			<option>Selecione um Curso:</option>
			<c:forEach var="c" items="${listarCurso}">
				<option value="${c.id}" <c:if test="${c.id eq curso.id}">selected="selected"</c:if> >${c.nomeCurso}</option>
			</c:forEach>
		</select> <br />
		
		<input type="hidden" name="id" value="${disciplina.id}">
		Disciplina:<input type="text" name="nomeDisciplina" value="<c:out value='${disciplina.nomeDisciplina}'/>"> <br /> 
		
		Período:<select name="periodo">
		<c:forEach begin="1" end="3" var="i">
			<option value="${i}" <c:if test="${i eq disciplina.periodo}">selected="selected"</c:if> >${i}</option>
		</c:forEach>
		</select><br /> 
		
		<input type="hidden" name="id" value="${palavraChave.id}">
		Tags:<input type="text" name="tag" value="${palavraChave.tag}"><br /> 
		<input type="submit" value="Alterar">
	</form>
	<a href="home"><button>Cancelar</button></a>
</body>
</html>