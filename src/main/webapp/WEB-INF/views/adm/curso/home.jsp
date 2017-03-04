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
	<a href="exibirPaginaCadastrarCurso"><button>Cadastrar
			Curso</button></a> |
	<a href="exibirPaginaCadastrarDisciplina"><button>Cadastrar
			Disciplina</button></a>
	<hr>


	<table border='1' style='width: 50%'>
		<tr>
			<th>ID</th>
			<th>CURSO</th>
			<th>DISCIPLINA</th>
			<th>PERIODO</th>
			<th>TAGS</th>
			<th>AÇÕES</th>
		</tr>

		<c:forEach var="obj" items="${listar}" varStatus="i">
			<tr bgcolor="#${ i.count % 2 == 0 ? 'ffffff' : 'bdc3c7' }" >
				<td>${obj.idCursoFk.id}</td>
				<td>${obj.idCursoFk.nomeCurso}</td>
				<td>${obj.nomeDisciplina}</td>
				<td>${obj.periodo}</td>
				<td></td>
				<td><a href="exibirPaginaVisualizar?id=${obj.id}"><button>Vilualizar</button></a></td>
				<td><a href="exibirPaginaAlterar?id=${obj.id}"><button>Alterar</button></a></td>
				<td><a href="delete?id=${obj.id}"><button>Remover</button></a></td>
			</tr>
		</c:forEach>
	</table>



</body>
</html>