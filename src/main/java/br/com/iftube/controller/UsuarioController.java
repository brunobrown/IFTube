package br.com.iftube.controller;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.iftube.model.entities.Usuario;
import br.com.iftube.service.UsuarioService;


@Controller
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@RequestMapping("homeUser")
	public String exibirInicio(Model model, Usuario usuario) {
		model.addAttribute("curso", usuarioService.obterTodosUsuario());
		return "adm/user/homeUser";
	}
	
	@RequestMapping("exibirPaginaCadastrarUsuario")
	public String exibirPaginaCadastrarUsuario(Model model) {
		model.addAttribute("listarUsuario", usuarioService.obterTodosUsuario());
		return "adm/user/addUsuario";
	}
	
	@RequestMapping("addUsuario")
	@Transactional
	public String cadastrarUsuario(Usuario curso, Model model) {
		
				usuarioService.adicionar(curso);
		
		return "forward:exibirPaginaCadastrarUsuario";
	}

	@RequestMapping("editUsuario")
	@Transactional
	public String alterarUsuario(int id, Usuario curso, Model model){
			usuarioService.editar(curso);
		return "forward:exibirPaginaCadastrarUsuario";
	}
	
	@RequestMapping("searchUsuario")
	@Transactional
	public String searchUsuario(String nomeUsuario, Model model){
		Usuario cursoLocalizado = usuarioService.obterUsuarioPorNome(nomeUsuario);
		model.addAttribute("cursoLocalizado", cursoLocalizado);
		return "forward:exibirPaginaCadastrarUsuario";
	}

}
