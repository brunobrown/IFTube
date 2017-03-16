package br.com.iftube.controller;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.iftube.model.entities.Perfil;
import br.com.iftube.service.PerfilService;


@Controller
public class PerfilController {

	@Autowired
	private PerfilService perfilService;

	
	@RequestMapping("exibirPaginaCadastrarPerfil")
	public String exibirPaginaCadastrarPerfil(Model model) {
		model.addAttribute("listarPerfil", perfilService.obterTodosPerfil());
		return "adm/user/addPerfil";
	}
	
	@RequestMapping("addPerfil")
	@Transactional
	public String cadastrarPerfil(Perfil curso, Model model) {
		
				perfilService.adicionar(curso);
		
		return "forward:exibirPaginaCadastrarPerfil";
	}

	@RequestMapping("editPerfil")
	@Transactional
	public String alterarPerfil(int id, Perfil curso, Model model){
			perfilService.editar(curso);
		return "forward:exibirPaginaCadastrarPerfil";
	}
	
	@RequestMapping("searchPerfil")
	@Transactional
	public String searchPerfil(String nomePerfil, Model model){
		Perfil cursoLocalizado = perfilService.obterPerfilPorNome(nomePerfil);
		model.addAttribute("cursoLocalizado", cursoLocalizado);
		return "forward:exibirPaginaCadastrarPerfil";
	}

}
