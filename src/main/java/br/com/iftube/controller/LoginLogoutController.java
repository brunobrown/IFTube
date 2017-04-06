package br.com.iftube.controller;

import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.transaction.annotation.Transactional;

import br.com.iftube.exception.service.ServiceException;
import br.com.iftube.model.entities.EstadoUsuario;
import br.com.iftube.model.entities.Perfil;
import br.com.iftube.model.entities.Usuario;
import br.com.iftube.service.DisciplinaService;
import br.com.iftube.service.LinksService;
import br.com.iftube.service.PalavraChaveService;
import br.com.iftube.service.UsuarioService;

@Controller
public class LoginLogoutController {

	List<EstadoUsuario> estadoUsuario;
	List<Perfil> perfil;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private LinksService linkService;
	
	@Autowired
	private DisciplinaService disciplinaService;
	
	@Autowired
	private PalavraChaveService palavraChaveService;
	
	@PostConstruct
	private void init() {
		this.estadoUsuario = Arrays.asList(EstadoUsuario.values());
		this.perfil = Arrays.asList(Perfil.values());
	}
	
	
	@RequestMapping("index")
	public String exibirLogin(boolean loginSenhaInvalido, Model model) {
		model.addAttribute("erro", loginSenhaInvalido);
		model.addAttribute("link", linkService.obterTodosLinks());
		return "index";
	}
		
	//@RequestMapping(value = "efetuarLogin", method = RequestMethod.POST)
	@RequestMapping("efetuarLogin")
	@Transactional
	public String efetuarLogin(Usuario usuario, String userLogin, HttpSession session, Model model) {
		
		Usuario usuarioLogado = new Usuario();
		
		usuarioLogado = usuarioService.validarUsuario(usuario);
			
			if(usuarioLogado != null){
				session.setAttribute("usuarioLogado", usuarioLogado);
				if(usuarioService.verificarPerfilUsuario(usuarioLogado)){
					return "forward:home";
				}else{
					return "public/home";
				}
			}

			return "forward:index";
	}
	
	@RequestMapping("acessoNegado")
	public String acessoNegado() {
		return "acessoNegado";
	}
	
	@RequestMapping("cadastroAluno")
	public String cadastroAluno() {
		return "public/cadastro";
	}
	
	@Transactional
	@RequestMapping("novoAluno")
	public String cadastrarUsuario(Usuario usuario, String confirmaSenha, Model model) {
		
		try {
			usuarioService.adicionar(usuario, confirmaSenha);
		} catch (ServiceException e) {
			model.addAttribute("exceptionEmailLoginSenha", e);
			e.printStackTrace();
		}
		
		return "public/cadastro";
	}
	
}
