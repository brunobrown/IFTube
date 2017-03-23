package br.com.iftube.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AutorizadorInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object controller) throws Exception {
		
		String uri = request.getRequestURI();
		
		if (uri.contains("bootstrap") 
				|| uri.contains("css") 
				|| uri.contains("js") 
				|| uri.contains("img")
				|| uri.endsWith("iftube/")
				|| uri.endsWith("/iftube/login") 
				|| uri.endsWith("/iftube/efetuarLogin")
				|| uri.endsWith("/iftube/efetuarLogin")){

			return true;
		}

		if (request.getSession().getAttribute("usuarioLogado") != null) {

			return true;
		}

		response.sendRedirect("forward:login");
		return false;
	}
	
}