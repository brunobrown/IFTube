package br.com.iftube.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.iftube.model.entities.Links;
import br.com.iftube.service.DisciplinaService;
import br.com.iftube.service.LinksService;
import br.com.iftube.service.PalavraChaveService;

@Controller
public class LinkController {
	
	@Autowired
	private LinksService linkService;
	
	@Autowired
	private DisciplinaService disciplinaService;
	
	@Autowired
	private PalavraChaveService palavraChaveService;
	
	@RequestMapping("homeLink")
	public String exibirHomeLink(Model model){
		model.addAttribute("link", linkService.obterTodosLinks());
		return "adm/link/homeLink";
	}
	
	@RequestMapping("exibirPaginaCadastrarLink")
	public String exibirPaginaCadastarLink(Model model){
		model.addAttribute("disciplina", disciplinaService.obterTodosDisciplina());
		model.addAttribute("palavraChave", palavraChaveService.obterTodosTag());
		
		return "adm/link/addLink";
	}
	
	@RequestMapping("cadastrarLink")
	public String cadastarLink(Links link, Model model){
		linkService.adicionar(link);
		model.addAttribute("link", linkService.obterTodosLinks());
		return "forward:exibirPaginaCadastarLink";
	}
	
	@RequestMapping("exibirPaginaVisualizarLink")
	public String exibirPaginaVisualizarLink(Model model){
		model.addAttribute("link", linkService.obterTodosLinks());
		return "viewLink";
	}
	
	@RequestMapping("exibirPaginaEditarLink")
	public String exibirPaginaEditarLink(int idLink, Model model){
		model.addAttribute("link", linkService.obterTodosLinks());
		return "editLink";
	}
	
	@RequestMapping("editLink")
	public String alterarLink(Links link, Model model){
		linkService.editar(link);
		model.addAttribute("link", linkService.obterTodosLinks());
		return "forward:exibirPaginaCadastarLink";
	}

}
