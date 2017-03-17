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

	<jsp:useBean id="palavraChave"
		class="br.com.iftube.model.entities.PalavraChave" />


	<h1>IFTube - Adm</h1>
	<hr>
	<h3>Usuario</h3>
	<hr>

${exception}<br/>

	<form action="validarMatricula" method="post">
		Informe uma Matrícula:
		<input type="text" name="matricula" placeholder="Ex.: 20151JBTI000"/>
		<input type="submit" value="Enviar"/> 
	</form>

	<c:if test="${matriculaExiste}">
	
	<form action="addUsuario" Method="get">
		Matŕcula<input type="text" name="idMatriculaFk" value="${matricula.matricula}" readonly="readonly"/><br/>
		Nome:<input type="text" name="nome"/><br/>
		Email<input type="text" name="email"/><br/>
		Login:<input type="text" name="login"/><br/>
		Senha:<input type="text" name="senha"/><br/>
		<!-- Confirme a Senha:<input type="text" name="senha"/><br/> -->
		
		<c:forEach var="estadoUsuario" items="${estadoUsuario}">
			
			<c:if test="${estadoUsuario eq 'ATIVO'}">
			<input type="hidden" name="estadoUsuario" value="${estadoUsuario}"/>
			</c:if>
			
		</c:forEach><br/>
		Perfil:
		<select name="perfil">
			<c:forEach var="perfil" items="${perfil}">
			<option value="${perfil}">${perfil}</option>
			</c:forEach>
		</select><br/>
		<input type="submit" value="Cadastrar"/>
		
	</form>
	
	</c:if>


<!--
	<c:choose>
		<c:when test="${usuario.id == null}">
			<form action="addUsuario" method="post">

				<select name="idCursoFk">
					<option>Selecione um Curso:</option>
					<c:forEach var="c" items="${listarCurso}">
						<c:if test="${c.estadoCurso != 'INATIVO'}"><option value="${c.id}" >${c.nomeCurso}</option></c:if>
					</c:forEach>
				</select> <br /> Usuario:<input type="text" name="nomeUsuario" /><br />

				Período:<select name="periodo">
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
				</select><br /> <input type="submit" value="Enviar">

				<input type="hidden" name="estadoUsuario" value="ATIVO"/>

			</form>
		</c:when>

		<c:otherwise>
			
	Curso:<input value="${curso.nomeCurso}" readonly />
			<br />
	Usuario:<input value="${usuario.nomeUsuario}" readonly />
			<br />	
	Período:<input value="${usuario.periodo}ª" readonly />
			<br />
			<input type="hidden" name="estadoUsuario" value="${usuario.estadoUsuario}"/>
			
		</c:otherwise>
	</c:choose>

	<hr>
-->


	<a href="home"><button>Voltar</button></a>

</body>
</html>