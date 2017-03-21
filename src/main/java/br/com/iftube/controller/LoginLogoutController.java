package br.com.iftube.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.iftube.model.entities.Usuario;
import br.com.iftube.service.UsuarioService;

@Controller
public class LoginLogoutController {

	@Autowired
	private UsuarioService usuarioService;
	
	
	@RequestMapping("login")
	public String exibirLogin() {
		
		return "index";
	}
	
	@RequestMapping("efetuarLogin")
	public String efetuarLogin(Usuario usuario, HttpSession session, Model model) {
		
		Usuario usuarioLogado = new Usuario();
		
		usuarioLogado = usuarioService.validarUsuario(usuario);
			
			if(usuarioLogado != null){
				session.setAttribute("usuarioLogado", usuarioLogado);
				if(usuarioService.verificarPerfilUsuario(usuarioLogado)){
					return "forward:home";
				}else{
					return "home";
				}
			}

			return "forward:login";
	}
	
	@RequestMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "forward:login";
	}
}
