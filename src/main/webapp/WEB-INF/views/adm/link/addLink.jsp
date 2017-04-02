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
	<h3>Matrícula</h3>
	
	<a href="homeUser"><button>Usuários</button></a>
	<a href="exibirPaginaCadastrarUsuario?holeUser=<sec:authentication property="authorities"/>"><button>Cadastrar
			Usuário</button></a>
	<hr>
	${exception}
	
	<c:url var="addLink" value="/addLink"/>
	<form:form action="exibirPaginaCadastrarLink" method="get">
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	
	

		<select name="idDisciplinaFk">
			<option>Selecione uma Disciplina</option>
				<c:forEach var="objDisciplina" items="${disciplina}">
				<option value="${objDisciplina.id}">${objDisciplina.nomeDisciplina}</option>
			</c:forEach>
		</select> <br />

<!-- ########################################################### -->
		
			<!-- jQuery -->
    	<script src="resources/js/jquery.js"></script>
		
		<script>

        $(document).ready(function(e) {
            $("body").delegate("#test", "change", function(data){

                //Pegando o valor do select
                var valor = $(this).val();
                //Enviando o valor do meu select para ser processado e
                //retornar as informações que eu preciso
                $("#conteudo").load("exibirPaginaCadastrarLink?parametro="+ valor);

            });
        });
        </script>

		
		<select name="idPalavraChaveFk" id="test">
			<option>Selecione no minimo uma Tag</option>
				<c:forEach var="objPalavraChave" items="${palavraChave}">
					<option value="${objPalavraChave.id}">${objPalavraChave.tag}</option>
			</c:forEach>
		</select> <br />
		
		
<div id="conteudo"></div>
<!-- ############################################################ -->

		Descrição:<br/>
		<br/><textarea name="descricao" rows="10" cols="20" placeholder="Dê um resumo sobre o que se trata o vídeo!"></textarea><br /> 
		
		<input type="submit" value="Cadastrar">
	</form:form>

	<hr />

	<form:form action="searchMatricula" method="get">
		Matrícula:<input type="text" name="matriculaAluno">
		<input type="submit" value="Pesquisar">
	</form:form>

	<hr />
	<table border=1>
		<tr>
			<th>ID</th>
			<th>LINK</th>
			<th>DESCRIÇÃO</th>
		</tr>

				<tr>
					<c:url var="editMatricula" value="/editMatricula"/>
					<form:form action="editMatricula" method="post">
						<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
						<input type="hidden" name="matriculaAtual" value="${matriculaLocalizado.matriculaAluno}">
							
							<c:forEach var="objUsuario" items="${listarUsuario}">
								<c:if test="${objUsuario.idMatriculaAlunoFk.matriculaAluno eq matriculaLocalizado.matriculaAluno}">
									<input type="hidden" name="idUsuario" value="${objUsuario.id}">
								</c:if>
							</c:forEach>
							
						<td><input type="text" name="matriculaAluno" value="${matriculaLocalizado.matriculaAluno}"></td>
						<td><input type="submit" value="Alterar"></td>
						<br/>
					</form:form>
				</tr>

	</table>


</body>
</html>