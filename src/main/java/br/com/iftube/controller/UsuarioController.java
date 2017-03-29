package br.com.iftube.controller;


import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.iftube.exception.service.ServiceException;
import br.com.iftube.model.entities.EstadoUsuario;
import br.com.iftube.model.entities.Perfil;
import br.com.iftube.model.entities.Usuario;
import br.com.iftube.service.UsuarioService;

@Controller
public class UsuarioController {

	List<EstadoUsuario> estadoUsuario;
	List<Perfil> perfil;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@PostConstruct
	private void init() {
		this.estadoUsuario = Arrays.asList(EstadoUsuario.values());
		this.perfil = Arrays.asList(Perfil.values());
	}
	
	@RequestMapping("exibirPaginaCadastrarUsuario")
	@Transactional
	public String exibirForm(Usuario usuario, String holeUser, Model model) {
		model.addAttribute("estadoUsuario", estadoUsuario);
		model.addAttribute("perfil", perfil);
		
		if(holeUser.equals("[ROLE_ANONYMOUS]") || holeUser.equals("[ALUNO]")){
			return "public/cadastro";
		}
		
		return "adm/user/addUsuario";
	}
	
	@RequestMapping("addUsuario")
	@Transactional
	public String cadastrarUsuario(Usuario usuario, String confirmaSenha, Model model) {
		
		try {
			usuarioService.adicionar(usuario, confirmaSenha);
		} catch (ServiceException e) {
			model.addAttribute("exceptionEmailLoginSenha", e);
			e.printStackTrace();
		}
		
		return "forward:exibirPaginaCadastrarUsuario";
	}
	
	@RequestMapping("alterarStatusUsuario")
	@Transactional
	public String alterarStatusUsuario(Usuario usuario, Model model) {
		
		model.addAttribute("usuario", usuarioService.alterarStatusUsuario(usuario));
		
		return "forward:homeUser";
	}
	
}
