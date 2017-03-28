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
	<h1>IFTube - Aluno</h1>
	<hr>
	
	<sec:authorize access="hasAuthority('ADMINISTRADOR') or hasAuthority('COORDENADOR')">
	
		Bem vindo, <sec:authentication property="name"/> |
	 
	<c:url var="logout" value="/logout"/>
	<form:form action="${logout}" method="post">
    	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    	<input type="submit" value="Logout" />
	</form:form>
	
    | <a href="home">ADM</a>
	
	
	
	</sec:authorize>
	
	<sec:authorize access="hasAuthority('ALUNO')">
	
	Bem vindo, <sec:authentication property="name"/> |
	
	<c:url var="logout" value="/logout"/>
	<form:form action="${logout}" method="post">
    	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    	<input type="submit" value="Logout" />
	</form:form>
	
	</sec:authorize>
	
	<hr>
	<c:url var="login" value="/login"/>
	<form:form action="${login}" method="post">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		Login:<input type="text" name="login"/><br/>
		Senha:<input type="password" name="senha"/><br/>
		<input type="submit" value="logar">
		<!-- Mantenha-me conectado: <input type="checkbox" name="_spring_security_remember_me" />  -->
	</form:form>
	<a href="cadastroAluno"><button>Quero me cadastrar</button></a>
	
	<br/>
	<font color="red">
		<span>${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}</span>
	</font>
</body>
</html>