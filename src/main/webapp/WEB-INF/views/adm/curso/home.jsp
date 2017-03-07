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
			<th colspan="3">AÇÕES</th>
			<th>STATUS CURSO</th>
			<th>STATUS DISCIPLINA</th>
		</tr>

		<c:forEach var="objDisciplina" items="${disciplina}" varStatus="i">
			<tr bgcolor="#${ i.count % 2 == 0 ? 'ffffff' : 'bdc3c7' }" >
				<td>${objDisciplina.id}</td>
				<td>${objDisciplina.idCursoFk.nomeCurso}</td>
				<td>${objDisciplina.nomeDisciplina}</td>
				<td>${objDisciplina.periodo}</td>
				<td>
					<c:forEach var="objPalavraChave" items="${palavraChave}">
						<c:if test="${objDisciplina.id eq objPalavraChave.idDisciplinaFk.id}">${objPalavraChave.tag}</c:if>
					</c:forEach>
					
				</td>
				<td><a href="exibirPaginaVisualizar?id=${objDisciplina.id}"><button>Visualizar Disciplina</button></a></td>
				<td><a href="exibirPaginaAlterar?id=${objDisciplina.id}"><button>Alterar Disciplina</button></a></td>
				<td>
				
					<c:if test="${objDisciplina.idCursoFk.estadoCurso != 'INATIVO'}">
						<form:form action="desabilitarDisciplina" method="post">
							<input type="hidden" name="id" value="${objDisciplina.id}">
							<input type="hidden" name="estadoDisciplina" value="${objDisciplina.estadoDisciplina eq 'INATIVO' ? 'ATIVO' : 'INATIVO' }">	
							<input type="submit" value="${objDisciplina.estadoDisciplina eq 'INATIVO' ? 'Habilitar Disciplina' : 'Desabilitar Disciplina' }">
						</form:form>
					</c:if>
					${objDisciplina.idCursoFk.estadoCurso != 'ATIVO' ? '<button>Ação Bloqueada</button>' : '' }
				</td>
				<td style="color: ${objDisciplina.idCursoFk.estadoCurso eq 'ATIVO' ? 'green' : 'red' }">${objDisciplina.idCursoFk.estadoCurso}</td>
				<td style="color: ${objDisciplina.estadoDisciplina eq 'ATIVO' ? 'green' : 'red' }">${objDisciplina.estadoDisciplina}</td>
			</tr>
		</c:forEach>
	</table>



</body>
</html>