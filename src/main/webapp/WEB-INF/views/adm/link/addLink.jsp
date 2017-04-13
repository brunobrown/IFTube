<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script src="resources/js/jquery.js"></script>

<script>
	$(document).ready(
			function(e) {
				$("body").delegate(
						"#selectDisciplina",
						"change",
						function(data) {

							//Pegando o valor do select
							var valor = $(this).val();
							//Enviando o valor do meu select para ser processado e
							//retornar as informações que eu preciso
							$("#conteudo").load(
									"exibirPaginaCadastrarLink?idDisciplinaSelecionada="
											+ valor);

						});
			});
</script>

<link rel="stylesheet" type="text/css"
	href="resources/css/rendered/fonts.min.css" />


<link rel="stylesheet" type="text/css"
	href="resources/css/bootstrap.min.css" />

</head>
<body id='conteudo'>

	<h1>IFTube - Adm</h1>
	<hr>
	<h3>Matrícula</h3>

	<a href="homeUser"><button>Usuários</button></a>
	<a
		href="exibirPaginaCadastrarUsuario?holeUser=<sec:authentication property="authorities"/>"><button>Cadastrar
			Usuário</button></a>
	<hr>
	${exception}

	<c:url var="cadastrarLink" value="/cadastrarLink" />
	<form:form action="cadastrarLink" method="get">
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />

<input type="hidden" name="idDisciplinaFk" value="${idDisciplinaSelecionada}"/>

<input type="hidden" name="userLogin" value="<sec:authentication property="name"/>"/>

		<select id="selectDisciplina">
			<option>Selecione uma Disciplina</option>
			<c:forEach var="objDisciplina" items="${disciplina}">
				<option value="${objDisciplina.id}">${objDisciplina.nomeDisciplina}</option>
			</c:forEach>
		</select>
		<br />

<c:if test="${idDisciplinaSelecionada != null}">Remova as Tags não desejadas</c:if>

<br/>

		<c:forEach var="objPalavraChave" items="${palavraChave}" varStatus="i">
			<c:if test="${objPalavraChave.idDisciplinaFk.id eq idDisciplinaSelecionada}">

				<a id="${objPalavraChave.tag}" class="${objPalavraChave.tag}"> <span
					class="btn btn-success"><span class="close" data-dismiss="alert" aria-hiden="true">&nbsp;&times;</span>
					<strong>#${objPalavraChave.tag}</strong>
				</span>
				</a>
								
				<input type="hidden" id="${objPalavraChave.tag}"
					class="${objPalavraChave.tag}" name="palavraChaveId"
					value="${objPalavraChave.tag}" />
	
				<script>
					$(document).ready(function() {
						$("#${objPalavraChave.tag}").click(function() {
							$("a").remove(".${objPalavraChave.tag}");
							$("input").remove(".${objPalavraChave.tag}");
						});
					});
				</script>

			</c:if>
		</c:forEach>

 
<br/>
Link:<input type="text" name="link" placeholder="Cole ou digite o Link aqui! Ex.: www.youtube.com/watch?ajdg=sedAfs"/>
<br/>
Descrição:<br />
		<textarea name="descricao" rows="10" cols="20"
			placeholder="Dê um resumo sobre o que se trata o vídeo!"></textarea>
		<br />

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

	
			<c:forEach var="objLinksTags" items="${linksTags}">
				${objLinksTags.id}
			</c:forEach>
			
			<!-- 
			<c:forEach var="objTagsLinks" items="${tagsLinks}">
				${objTagsLinks.id}
			</c:forEach>
			-->

		<tr>
			<c:url var="editLink" value="/editLink" />
			<form:form action="editLink" method="post">
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
			
				<input type="hidden" name="matriculaAtual"
					value="${matriculaLocalizado.matriculaAluno}">

				<c:forEach var="objUsuario" items="${listarUsuario}">
					<c:if
						test="${objUsuario.idMatriculaAlunoFk.matriculaAluno eq matriculaLocalizado.matriculaAluno}">
						<input type="hidden" name="idUsuario" value="${objUsuario.id}">
					</c:if>
				</c:forEach>

				<td><input type="text" name="matriculaAluno"
					value="${matriculaLocalizado.matriculaAluno}"></td>
				<td><input type="submit" value="Alterar"></td>
				<br />
			</form:form>
		</tr>

	</table>
 <!-- JavaScript -->
    <script src="resources/js/jquery.js"></script>
    <script src="resources/js/bootstrap.min.js"></script>
    <script src="resources/js/modern-business.js"></script>
</body>
</html>