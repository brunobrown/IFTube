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
			<th>ID</th>
			<th>PERFIL</th>
			<th>MATRICULA</th>
			<th>NOME</th>
			<th>EMAIL</th>
			<th>LOGIN</th>
			<th>SENHA</th>
		</tr>

			<tr bgcolor="#${ i.count % 2 == 0 ? 'ffffff' : 'bdc3c7' }" >
				<td>${objUsuario.id}</td>
				<td>${objUsuario.idPerfilFk.nome}</td>
				<td>${objUsuario.matricula}</td>
				<td>${objUsuario.nome}</td>
				<td>${objUsuario.email}</td>
				<td>${objUsuario.login}</td>
				<td>${objUsuario.senha}</td>
				
	</table>
</body>
</html>