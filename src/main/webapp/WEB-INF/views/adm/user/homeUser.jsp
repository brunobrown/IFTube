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
	<a href="home"><button>Disciplinas</button></a>
	<hr>
	<a href="exibirPaginaCadastrarMatricula"><button>Cadastrar
			Matricula</button></a> |
	<a href="exibirPaginaCadastrarUsuario"><button>Cadastrar
			Usuário</button></a>
	<hr>


	<table border='1' style='width: 50%'>
		<tr>
			<th>MATRICULA</th>
			<th>PERFIL</th>
			<th>NOME</th>
			<th colspan="2">AÇÃO</th>
			<th>STATUS</th>

		</tr>
	<c:forEach var="objUsuario" items="${usuario}" varStatus="i">
			<tr bgcolor="#${ i.count % 2 == 0 ? 'ffffff' : 'bdc3c7' }" >
				<td>${objUsuario.idMatriculaAlunoFk.matriculaAluno}</td>
				<td>${objUsuario.perfil}</td>
				<td>${objUsuario.nome}</td>
				<td><a href="exibirPaginaVisualizarUsuario?id=${objUsuario.id}"><button>Visualizar</button></a></td>
				<td>
					<c:choose>
						<c:when test="${objUsuario.ativo != 'true'}">
							<a href="exibirPaginaAlterarUsuario?id=${objUsuario.id}"><button>Alterar</button></a>
						</c:when>
						<c:otherwise>
							<button>Ação Bloqueada</button>
						</c:otherwise>
					</c:choose>
				</td>
				<td>
				
				<a href="alterarStatusUsuario?usuario=${objUsuario.id}"><button>${objUsuario.ativo != true ? 'INATIVO' : 'ATIVO' }</button></a></td>
	</c:forEach>
	</table>
</body>
</html>