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

<jsp:useBean id="curso"
		class="br.com.iftube.model.entities.Curso" />
	<jsp:useBean id="disciplina"
		class="br.com.iftube.model.entities.Disciplina" />
	<jsp:useBean id="palavraChave"
		class="br.com.iftube.model.entities.PalavraChave" />

<h1>IFTube - Adm</h1>		
<hr>
<h3>Disciplina</h3>
<hr>
	<form action="addDisciplina" method="post">
	
		Curso:<select name="nomeCurso">
			<option value="Informática Para Internet">Informática Para Internet</option>
			<option value="Qualidade">Qualidade</option>
		</select><br />
		Disciplina:<input type="text" name="nomeDisciplina"> <br /> 
		Período:<select name="periodo">
			<option value="1">1</option>
			<option value="2">2</option>
			<option value="3">3</option>
		</select><br /> 
		Tags:<input type="text" name="tag"><br /> 
		<input type="submit" value="Cadastrar">
	</form>
	<a href="listar"><button>Voltar</button></a>

</body>
</html>