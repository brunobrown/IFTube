package br.com.iftube.controller;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.iftube.exception.service.ServiceException;
import br.com.iftube.model.entities.Curso;
import br.com.iftube.model.entities.Disciplina;
import br.com.iftube.model.entities.PalavraChave;
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

	@RequestMapping("exibirPaginaCadastrarDisciplina")
	@Transactional
	public String exibirForm(Model model) {
		
		model.addAttribute("listarCurso", cursoService.obterTodosCurso());
		
		
		return "adm/curso/addDisciplinaTag";
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
		
		model.addAttribute("curso", cursoService.obterCursoPorId(disciplina.getIdCursoFk().getId()));
		model.addAttribute("disciplina", disciplina);
		
		return "forward:exibirPaginaCadastrarDisciplina";
	}
	
	@RequestMapping("exibirPaginaVisualizar")
	public String exibirPaginaVisualizar(Model model, Integer id){
		
		
		Disciplina disciplina = disciplinaService.obterDisciplinaPorId(id);
		
		//Curso curso = cursoService.obterCursoPorId(disciplina.getIdCursoFk().getId());
		
		//PalavraChave palavraChave = palavraChaveService.obterTagPorId(id);
		//palavraChaveService.obterTagPorId(palavraChave.getIdDisciplinaFk().getId());
		
		//model.addAttribute("curso", curso);
		model.addAttribute("disciplina", disciplina);
		//model.addAttribute("palavraChave", palavraChave);
		
		return "adm/curso/view-disciplina";
	}
	
	@RequestMapping("exibirPaginaAlterar")
	public String exibirPaginaAlterar(Model model, Integer id){
		
		Disciplina disciplina = disciplinaService.obterDisciplinaPorId(id);
		Curso curso = cursoService.obterCursoPorId(disciplina.getIdCursoFk().getId());
		
		PalavraChave palavraChave = palavraChaveService.obterTagPorId(id);
		palavraChaveService.obterTagPorId(palavraChave.getIdDisciplinaFk().getId());
		
		model.addAttribute("listarCurso", cursoService.obterTodosCurso());
		model.addAttribute("curso", curso);
		model.addAttribute("disciplina", disciplina);
		model.addAttribute("palavraChave", palavraChave);
		
		return "adm/curso/edit-disciplina";
	}
	
	@RequestMapping("edit")
	public String edit(Curso curso, Disciplina disciplina, PalavraChave tag){
		
	
		palavraChaveService.editar(tag);
		disciplinaService.editar(disciplina);
		cursoService.editar(curso);
		
		return "forward:home";
	}
	
	@RequestMapping(value = "desabilitarDisciplina", method = RequestMethod.POST)
	@Transactional
	public String desabilitarDisciplina(Disciplina disciplina){
		
		disciplinaService.alterarEstadoDisciplina(disciplina.getId(), disciplina.getEstadoDisciplina());
		
		return "forward:home";
		
	}
	
}
