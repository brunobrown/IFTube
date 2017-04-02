<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>IFTube - Adm</h1>
	<hr>
	Bem vindo <sec:authentication property="name"/> |
	<c:url var="logout" value="/logout"/>
	<form:form action="${logout}" method="post">
    	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    	<input type="submit" value="Logout" />
	</form:form>
	
	 <sec:authentication property="authorities"/>
	
	<hr>
	
	
	<a href="home"><button>Home</button></a> | 
	<a href="homeUser"><button>Usuarios</button></a>
	<hr>
	<a href="exibirPaginaCadastrarLink"><button>Cadastrar Link</button></a>
	<hr>


	<table border='1' style='width: 50%'>
		<tr>
			<th>ID</th>
			<th>LINK</th>
			<th>DESCRIÇÃO</th>
			<th>DISCIPLINA</th>
			<th>TAGS</th>
			<th>VISUALIZAR</th>
			<th>ALTERAR</th>
		</tr>

		<c:forEach var="objLink" items="${link}" varStatus="i">
			<tr bgcolor="#${ i.count % 2 == 0 ? 'ffffff' : 'bdc3c7' }" >
				<td>${objLink.id}</td>
				<td>${objLink.link}</td>
				<td>${objLink.idDisciplinaFk.nomeDisciplina}</td>
				<td>
					<c:forEach var="objLink" items="${link}">
						${objLink.idPalavraChaveFk.tag}
					</c:forEach>
				</td>
				<td><a href="exibirPaginaVisualizar?id=${objLink.id}"><button>Visualizar Link</button></a></td>
				<td><a href="exibirPaginaEditar?id=${objLink.id}"><button>Editar Link</button></a></td>
				<td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>