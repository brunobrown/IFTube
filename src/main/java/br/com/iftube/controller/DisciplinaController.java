package br.com.iftube.controller;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.iftube.exception.service.ServiceException;
import br.com.iftube.model.entities.Disciplina;
import br.com.iftube.service.CursoService;
import br.com.iftube.service.DisciplinaService;

@Controller
public class DisciplinaController {

	@Autowired
	private CursoService cursoService;
	
	@Autowired
	private DisciplinaService disciplinaService;

	

	@RequestMapping("home")
	@Transactional
	public String exibirInico(Model model) {
		model.addAttribute("listar", disciplinaService.obterTodosDisciplina());
		return "adm/curso/inicioTemp";
	}

	@RequestMapping("exibirPaginaCadastrarDisciplina")
	@Transactional
	public String exibirForm(Model model) {
		
		model.addAttribute("listarCurso", cursoService.obterTodosCurso());
		
		return "adm/curso/addDisciplinaTagTemp";
	}
	
	
	@RequestMapping("addDisciplina")
	@Transactional
	public String cadastrarDisciplina(Disciplina disciplina, Model model) {
		
		try {
			disciplinaService.adicionar(disciplina);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			model.addAttribute("exception", e);
		}
		
		model.addAttribute("disciplina", disciplina);
		
		return "forward:exibirPaginaCadastrarDisciplina";
	}
	
}
