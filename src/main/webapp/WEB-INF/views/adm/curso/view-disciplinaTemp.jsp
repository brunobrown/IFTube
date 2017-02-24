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
	<h3>Visualizar - Disciplina</h3>
	<hr>

	Curso:
	<input type="text" readonly="readonly" value="${c.nomeCurso}">
	<br /> Disciplina:
	<input type="text" readonly="readonly" value="${d.nomeDisciplina}">
	<br /> Período:
	<input type="text" readonly="readonly" value="${d.periodo}">
	<br /> Tags:
	<input type="text" readonly="readonly" value="${pc.tag}">
	<br />
	<hr>
	<a href="listar"><button>Voltar</button></a>
	<a href="exibirPaginaAlterar?id=${c.id}"><button>Alterar</button></a>
	<a href="delete?id=${c.id}"><button>Remover</button></a>
	<hr>
	
</body>
</html>