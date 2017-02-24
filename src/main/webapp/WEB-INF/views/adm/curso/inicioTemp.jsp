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
<a href="exibirPaginaCadastrarCurso"><button>Cadastrar Curso</button></a> |
<a href="exibirPaginaCadastrarDisciplina"><button>Cadastrar Disciplina</button></a>
<hr>


	<table>
		<tr>
			<th>ID</th>
			<th>CURSO</th>
			<th>DISCIPLINA</th>
			<th>PERIODO</th>
			<th>TAGS</th>
			<th>AÇÕES</th>
		</tr>

		<c:forEach var="c" items="${listarCurso}">
					<tr>
						<td>${c.id}</td>
						<td>${c.nomeCurso}</td>
						<td></td>
						<td></td>
						<td></td>
						<td><a href="exibirPaginaVisualizar?id=${c.id}"><button>Vilualizar</button></a></td>
						<td><a href="exibirPaginaAlterar?id=${c.id}"><button>Alterar</button></a></td>
						<td><a href="delete?id=${c.id}"><button>Remover</button></a></td>
					</tr>
				</c:forEach>
	</table>



</body>
</html>