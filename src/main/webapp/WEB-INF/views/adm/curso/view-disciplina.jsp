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
	<h3>Visualizar - Disciplina</h3>
	<hr>

	ID:
	<input type="text" readonly="readonly" value="${disciplina.id}">
	<br /> 
	Curso:<input type="text" readonly="readonly"
		value="${disciplina.idCursoFk.nomeCurso}">
	<br />
	
	Status Curso: <input type="text" readonly="readonly" 
	style="color: ${disciplina.idCursoFk.estadoCurso eq 'ATIVO' ? 'green' : 'red' }"
	value="${disciplina.idCursoFk.estadoCurso}"><br/>
	
	Disciplina:<input type="text" readonly="readonly"
		value="${disciplina.nomeDisciplina}">
	<br />
	
	Status Disciplina:
	<input type="text" readonly="readonly"
		style="color: ${disciplina.estadoDisciplina eq 'ATIVO' ? 'green' : 'red' }"
		value="${disciplina.estadoDisciplina}" /><br/>
	
	Período:<input type="text" readonly="readonly" value="${disciplina.periodo}">
	<br />

	<br /> Tags:
	<br />
	<textarea rows="10" cols="20" readonly="readonly"><c:forEach
			var="objPalavraChave" items="${palavraChave}">
			<c:if test="${disciplina.id eq objPalavraChave.idDisciplinaFk.id}">
${objPalavraChave.tag}</c:if>
		</c:forEach></textarea>


	<br />
	<hr>
	<a href="home"><button>Voltar</button></a>
	
	<c:choose>
		<c:when test="${disciplina.estadoDisciplina != 'ATIVO'}">
			<a href="exibirPaginaAlterar?id=${disciplina.id}"><button>Alterar Disciplina</button></a>
		</c:when>
		<c:otherwise>
			<button>Ação Bloqueada</button>
		</c:otherwise>
	</c:choose>
	
	<table>
		<tr>
			<td><c:choose>
					<c:when test="${disciplina.idCursoFk.estadoCurso != 'INATIVO'}">
						<form:form action="desabilitarDisciplina" method="post">
							<input type="hidden" name="pagina" value="view"/>
							<input type="hidden" name="id" value="${disciplina.id}">
							<input type="hidden" name="estadoDisciplina"
								value="${disciplina.estadoDisciplina eq 'INATIVO' ? 'ATIVO' : 'INATIVO' }">
							<input type="submit"
								value="${disciplina.estadoDisciplina eq 'INATIVO' ? 'Habilitar Disciplina' : 'Desabilitar Disciplina' }">
						</form:form>
					</c:when>
					<c:otherwise>
						<button>Ação Bloqueada</button>
					</c:otherwise>
				</c:choose></td>
		</tr>
	</table>
	<hr>

</body>
</html>