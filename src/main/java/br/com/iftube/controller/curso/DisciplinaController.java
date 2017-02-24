package br.com.iftube.controller.curso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import br.com.iftube.service.CursoService;
import br.com.iftube.service.DisciplinaService;
import br.com.iftube.service.PalavraChaveService;

@Controller
public class DisciplinaController {

	@Autowired
	private CursoService cursoService;
	@Autowired
	private DisciplinaService disciplinaService;
	@Autowired
	private PalavraChaveService palavraChaveService;

	@RequestMapping("listar")
	public String exibirInico(Model model) {
		model.addAttribute("listarCurso", cursoService.obterTodosCurso());
		model.addAttribute("listarDisciplina", disciplinaService.obterTodosDisciplina());
		model.addAttribute("listarTag", palavraChaveService.obterTodosPalavraChave());
		return "adm/curso/inicioTemp";
	}

	@RequestMapping("exibirPaginaCadastrarDisciplina")
	public String exibirForm() {
		return "adm/curso/addDisciplinaTagTemp";
	}
	
}
