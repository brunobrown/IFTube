package br.com.iftube.controller;


import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
	public String exibirForm(Usuario usuario, Model model) {
		
		model.addAttribute("estadoUsuario", estadoUsuario);
		model.addAttribute("perfil", perfil);
		return "adm/user/addUsuario";
	}
	
	@RequestMapping("addUsuario")
	@Transactional
	public String cadastrarUsuario(Usuario usuario, Model model) {
		
		usuarioService.adicionar(usuario);
		
		return "forward:exibirPaginaCadastrarUsuario";
	}
	
	
//	@RequestMapping("exibirPaginaVisualiza")
//	public String exibirPaginaVisualizar(Model model, Integer id){
//		
//		Usuario usuario = usuarioService.obterUsuarioPorId(id);
//		model.addAttribute("usuario", usuario);
//		//model.addAttribute("palavraChave", palavraChaveService.obterTodosTag());
//		
//		return "adm/curso/view-usuario";
//	}
//	
//	@RequestMapping("exibirPaginaAlterar")
//	public String exibirPaginaAlterar(Model model, int id, PalavraChave p){
//		
//		Usuario usuario = usuarioService.obterUsuarioPorId(id);
//		model.addAttribute("usuario", usuario);
//		//model.addAttribute("palavraChave", palavraChaveService.obterTodosTag());
//		
//		return "adm/curso/edit-usuario";
//	}
//	
//	@RequestMapping("editUsuario")
//	public String edit(Usuario usuario, Model model){
//		
//		usuarioService.editar(usuario);
//		
//		return "forward:exibirPaginaAlterar";
//	}
//	
//	@RequestMapping(value = "desabilitarUsuario", method = RequestMethod.POST)
//	@Transactional
//	public String desabilitarUsuario(Usuario usuario, String pagina){
//		
//		//usuarioService.alterarEstadoUsuario(usuario.getId(), usuario.getEstadoUsuario());
//		
//		return "forward:home";
//		
//	}
	
}
