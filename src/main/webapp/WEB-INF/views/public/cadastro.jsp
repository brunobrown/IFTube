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

	<h1>IFTube - Cadastro</h1>
	<hr>
	<h3>Aluno</h3>
	<hr>

${exception}<br/>

	<form:form action="validarMatricula" method="post">
		<input type="hidden" name="holeUser" value="<sec:authentication property="authorities"/>">
		Informe sua Matrícula:
		<input type="text" name="matricula" placeholder="Ex.: 20151JBTI000"/>
		<input type="submit" value="Enviar"/> 
	</form:form>
	<br/><hr>
	
	${exceptionEmailLoginSenha}
	<br/>

	<c:if test="${matriculaExiste}">
	
	<c:url var="novoAluno" value="/novoAluno"/>
	<form action="novoAluno" method="post">
		<input type="hidden" name="holeUser" value="<sec:authentication property="authorities"/>">
		Matrícula<input type="text" name="idMatriculaAlunoFk" value="${matricula.matriculaAluno}" readonly="readonly"/><br/>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		Nome:<input type="text" name="nome"/><br/>
		Email<input type="text" name="email"/><br/>
		Login:<input type="text" name="login"/><br/>
		Senha:<input type="password" name="senha"/><br/>
		Confirme a Senha:<input type="password" name="confirmaSenha"/><br/>
		<input type="hidden" name="perfil" value="ALUNO"/><br/>
		<input type="submit" value="Cadastrar"/>
	</form>
	
	</c:if>
	<hr/>
	<a href="login"><button>Cancelar</button></a>

</body>
</html>