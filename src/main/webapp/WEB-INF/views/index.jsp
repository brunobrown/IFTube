<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<html lang="en">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>IFTube</title>

    <meta name="description" content="">
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0" />
    <meta http-equiv="content-type" content="text/html; charset=utf-8" />
   

    <!-- CHARTBEAT -->
    <script type="text/javascript">var _sf_startpt=(new Date()).getTime()</script>

    <!-- WEBFONTS -->
    
    
    <script type="text/javascript" src="resources/js/webfonts.min.js?1481298570"></script>

    <!-- CSS -->
    <!-- FONTS -->
    
    <link rel="stylesheet" type="text/css" href="resources/css/rendered/fonts.min.css?1481298571" />
    
    
    <link rel="stylesheet" type="text/css" href="resources/css/app.min.css?1481298571" />

       
</head>


<body>

<!-- Modal -->
            <div class="modal fade" id="login-senha-invalido" tabindex="-1" role="dialog" aria-labelledby="modalLabel">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Fechar"><span aria-hidden="true">&times;</span></button>
                            <h4 class="modal-title" id="modalLabel">IFTube</h4>
                       		</div>
                        		<div class="modal-body">
                      	 			${sessionScope['SPRING_SECURITY_LAST_EXCEPTION'].message != 'User is disabled' ? 'Login ou Senha Inválidos!' : 'Este Usuário esta desabilitado! Por favor comunique isto a: contato@iftube.com.br'}
                        		</div>
                        	<div class="modal-footer">
                            <button type="button" class="btn btn-success" data-dismiss="modal">OK</button>
                        </div>
                    </div>
                </div>
            </div>
 <sec:authentication var="user" property="name"/>
 
<a class="sr-only" href="#content">Skip To Content</a>



<!-- Navigation -->
    <nav class="navbar navbar-inverse navbar-fixed-top">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#">IFTube</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav navbar-right">
        <li class="active">
        
        
        <sec:authorize access="hasAuthority('ADMINISTRADOR') or hasAuthority('COORDENADOR') or hasAuthority('ALUNO')">
        <a>Bem Vindo <sec:authentication property="name"/><span class="sr-only">(current)</span></a>
        </sec:authorize>
        </li>
        <sec:authorize access="hasAuthority('ADMINISTRADOR') or hasAuthority('COORDENADOR')">
        <li><a href="home">ADM</a><p class="sr-only"></p></li>
         </sec:authorize>
         <c:if test="${user != 'anonymousUser'}">
         <li><a href="#">Perfil</a></li>
        <li><a href="#">Postar Links</a></li>
        </c:if>
        <li class="dropdown">
          
            	<c:choose>
			<c:when test="${user eq 'anonymousUser'}">
			<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Entrar <span class="caret"></span></a>
          <ul class="dropdown-menu" role="menu">
			
 				<li>
				<c:url var="login" value="/login"/>
            	 <form:form role="form" class="form-inline" action="${login}" method="post">
            	 	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            	 	<div class="form-group">
            	 		<label class="sr-only" for="exampleInputEmail2">Login</label>
						<input type="text" class="form-control" id="exampleInputEmail2" placeholder="Login" name="login">
	            	</div>
	            	<div class="form-group">
            	 		<label class="sr-only" for="exampleInputPassword2">Senha</label>
						<input type="password" class="form-control" id="exampleInputPassword2" placeholder="Senha" name="senha">
	            	</div>
	            	<div class="checkbox">
	            		<label>
	            			<input type="checkbox">Lembrar-me
	            		</label>
	            	</div>
	            	<button type="submit" class="btn btn-default">Logar</button>
            	</form:form>
				</li>
					<li><a class="btn grey-cascade btn-block" href="cadastroAluno">Cadastre-se.</a></li>
	                <li><a class="btn grey-cascade btn-block" href="#">Esqueci minha senha :(</a></li>
				 </ul>
			</c:when>
			<c:otherwise>

				<a class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Sair <span class="caret"></span></a>
          <ul class="dropdown-menu" role="menu">
			
 				<li>
					<c:url var="logout" value="/logout"/>
					<form:form role="form" class="form-horizontal" action="${logout}" method="post">
				    	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
				    	<button type="submit" class="btn btn-default">Logout</button>
					</form:form>
				</li>
				 </ul>

			</c:otherwise>
		</c:choose>
         
        </li>
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
        <!-- /.container -->
</nav>



    

    
<header id="top">
    <div class="header-wrapper">
        <a class="iftube" href="#"><img src="resources/assets/logo_IFTube.png" alt="IFTube" /></a>
        <h1>O temor do Senhor é o princípio da sabedoria; bom entendimento têm todos os que lhe obedecem; o seu louvor permanece para sempre. Salmos 111:10</h1>
        <h2>Os Melhores Links Estão Aqui!</h2>
        <p class="byline">Não desperdice seu tempo estudando através de vídeos que não tem nada a ver com as disciplinas.<br/>Utilize os melhores!</p>
    </div>




</header>

    <section id="content">
      <div class="btn" id="back-to-top">
          <p id="back-to-top-text">voltar ao topo&nbsp;&nbsp;<strong>&uarr;</strong></p>
          <p id="back-to-top-no-text"><i class="icon-up-hand"></i></p>
      </div>
        <div class="container">
            <div class="row">
                <div id="main-content" class="col-md-12">
                    
    <div class="book-container">

        <!-- <div class="top-row"> -->
            <div class="spacer">
                <h4 class="hidden-xs">O que você<br> Gostaria de assistir?</h4>
            </div>

            <div class="title-area">
                <div class="current-tag-wrapper">
               		<h3 class="current-tag"><span>Mostrando todos os links</span></h3>
                </div>



                <div class="btn-group btn-group-lg toggle-text grid-active">


                   <button class="grid btn btn-default">Capas</button>
                   <button class="list btn btn-default">Lista</button>


                </div>

            </div>
        <!-- </div> -->

        <div class="grid-row">
            <div class="tags-wrapper">


                <div class="chatter"><br/><p>Use os filtros abaixo para explorar diversos vídeos. (Há, você também pode combinar filtros!)
                    <!-- <a href="#" target="_blank">teste</a> -->
                    </p>
                </div>
                <button id="mobile-filters" class="visible-xs btn btn-primary btn-block">Filtrar por tags</button>
                <button id="clear-mobile-filters" class="visible-xs btn btn-large btn-info clear-tags hide" data-filter-value="*"><i class="icon-cancel-circled2">&nbsp;&nbsp;</i>Limpar Filtro</button>




                <!-- All Tags List -->
                <ul class="filter tags option-set list-unstyled hidden-xs" data-filter-group="category">

                    <li class="visible-xs mobile-label">Filtrar por: <span class="close visible-xs close-modal" aria-hidden="true">&times;</span></li>

                    <li class="hidden-xs">
                        <button class="btn btn-large btn-info clear-tags hide" data-filter-value="*"><i class="icon-cancel-circled2">&nbsp;&nbsp;</i>Limpar Filtro</button>
                    </li>
                    
                     <li>
                         <button
                         class="btn btn-large btn-info tag ingles"
                         data-filter-value=".tag-ingles" data-tag-slug="ingles">Matemática</button>
                     </li>
                     
                     <li>
                         <button
                         class="btn btn-large btn-info tag ingles"
                         data-filter-value=".tag-ingles" data-tag-slug="ingles">inglês</button>
                     </li>
                     
                      <li>
                         <button
                         class="btn btn-large btn-info tag ingles"
                         data-filter-value=".tag-ingles" data-tag-slug="ingles">Português</button>
                     </li>
                     
                      <li>
                         <button
                         class="btn btn-large btn-info tag ingles"
                         data-filter-value=".tag-ingles" data-tag-slug="ingles">Segurança do Trabalho</button>
                     </li>
                     
                     <li>
                         <button
                         class="btn btn-large btn-info tag ingles"
                         data-filter-value=".tag-ingles" data-tag-slug="ingles">Lógica de Programação</button>
                     </li>
                     
                      <li>
                         <button
                         class="btn btn-large btn-info tag ingles"
                         data-filter-value=".tag-ingles" data-tag-slug="ingles">Redes</button>
                     </li>
                    
                    

                </ul>
            </div>
            <!-- Book Cards Grid -->

            <div class="books-grid-wrapper">

                <div class="filter-inactive">
					<c:forEach var="objLink" items="${link}">
						<iframe width="300" height="150" src="https://www.${objLink.link}" frameborder="0" allowfullscreen></iframe>
					</c:forEach>
				
                </div>

                <ul id="books-list">

                </ul>
            </div>
        </div>
    </div>




                </div>
            </div>
        </div>
    </section>

    <footer id="footer">
        <div class="primary">
            <ul>
               <li><a href="https://www.facebook.com/bruno.brown.75" >facebook</a></li>
            </ul>
        </div>
        <div class="secondary">
            <p>&copy;2017 IFTube</p>
        </div>
    </footer>
    

    <div class="modal fade" id="share-modal" tabindex="-1" role="dialog">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-body share clearfix">
                <button type="button" class="share-close" data-dismiss="modal" aria-hidden="true">&times; <em>Close</em></button>
                <div class="story-summary">
                    <h4>Share this App</h4>

                    <p>
                    <textarea class="summary-text" id="summary-text" type="text" readonly>Visit the #bookconcierge, NPR's guide to 2016's great reads. http://apps.npr.org/best-books-2016/</textarea><a class="clippy" data-toggle="tooltip" data-trigger="manual" data-placement="right" title="Copied!" data-clipboard-target="#summary-text"><i class="icon icon-clipboard share-icon"></i> Copy</a></p>

                </div><!-- / story-summary -->

                <div class="email-friend">
                        <h4><a href="mailto:?body=Explore more than 300 books NPR staff and critics loved this year. 
http://apps.npr.org/best-books-2016/ &amp;subject=NPR's best books of 2016" onclick="_gaq.push(['_trackEvent', 'best-books-2016', 'email', 'share-discuss']);"><i class="icon icon-mail share-icon"></i> <b>Email to a friend</b></a></h4>
                    </div><!-- / email-friend -->

                <div class="facebook-share share-section">

                    <h4>On Facebook</h4>
                    <ul class="featured-facebook-posts">
                        
                    </ul><!-- / featured-tweets -->
                    <p class="share-story"><a href="https://www.facebook.com/dialog/feed?app_id=138837436154588&amp;link=http%3A%2F%2Fapps.npr.org%2Fbest-books-2016%2F&amp;name=NPR%27s+Book+Concierge&amp;picture=http%3A%2F%2Fapps.npr.org%2Fbest-books-2016%2Fassets%2Fimg%2Fcovers.jpg&amp;redirect_uri=http%3A%2F%2Fapps.npr.org%2Fbest-books-2016%2F" target="_blank" onclick="_gaq.push(['_trackEvent', 'best-books-2016', 'facebook', 'share-discuss']);"><i class="icon icon-facebook share-icon"></i> <b>Share on Facebook</b></a></p>
                </div><!-- / facebook-share -->

                <div class="twitter-share share-section">


                    <h4>On Twitter</h4>

                    <ul class="featured-tweets">
                        
                    </ul><!-- / featured-tweets -->

                    <p class="share-story">
                        <a href="http://twitter.com/share?text=Visit+the+%23bookconcierge%2C+%40NPRBooks%27+guide+to+2016%27s+great+reads.&amp;url=http%3A%2F%2Fapps.npr.org%2Fbest-books-2016%2F" target="_blank" onclick="_gaq.push(['_trackEvent', 'best-books-2016', 'tweet', 'share-discuss']);"><i class="icon icon-twitter share-icon"></i> <b>Share on Twitter</b></a>
                    </p>
                </div><!-- / twitter-share -->
            </div><!-- / modal-body -->
        </div><!-- / modal-content -->
    </div>
</div><!-- / #share-modal -->

    <!-- JS -->
    <script src="resources/js/lib/clipboard.min.js"></script>
    
    
    <script type="text/javascript" src="resources/js/app-footer.min.js?1481298572"></script>

    
<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" data-keyboard="true">
  <div class="modal-dialog">
    <div class="modal-content">
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->


<c:if test="${erro}">
    <script>
	    $(document).ready(function(){
	        $("#login-senha-invalido").modal();
	    });
	</script>
</c:if>

</body>
</html>