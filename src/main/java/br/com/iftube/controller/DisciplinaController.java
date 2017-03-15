package br.com.iftube.controller;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.iftube.exception.service.ServiceException;
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
			model.addAttribute("exception", "Disciplina cadastrada com sucesso!");
		} catch (ServiceException e) {
			model.addAttribute("exception", "Esta Disciplina já existe neste Curso!");
			e.printStackTrace();
		}
		
		model.addAttribute("curso", cursoService.obterCursoPorId(disciplina.getIdCursoFk().getId()));
		model.addAttribute("disciplina", disciplina);
		
		return "forward:exibirPaginaCadastrarDisciplina";
	}
	
	@RequestMapping("exibirPaginaVisualizar")
	public String exibirPaginaVisualizar(Model model, Integer id){
		
		Disciplina disciplina = disciplinaService.obterDisciplinaPorId(id);
		model.addAttribute("disciplina", disciplina);
		model.addAttribute("palavraChave", palavraChaveService.obterTodosTag());
		
		return "adm/curso/view-disciplina";
	}
	
	@RequestMapping("exibirPaginaAlterar")
	public String exibirPaginaAlterar(Model model, int id, PalavraChave p){
		
		Disciplina disciplina = disciplinaService.obterDisciplinaPorId(id);
		model.addAttribute("disciplina", disciplina);
		model.addAttribute("palavraChave", palavraChaveService.obterTodosTag());
		
		return "adm/curso/edit-disciplina";
	}
	
	@RequestMapping("editDisciplina")
	public String edit(Disciplina disciplina, Model model){
		
		try {
			disciplinaService.editar(disciplina);
			model.addAttribute("exception", "Disciplina alterada com sucesso!");
		} catch (ServiceException e) {
			model.addAttribute("exception", "Esta Disciplina já existe neste Curso!");
			e.printStackTrace();
		}
		
		return "forward:exibirPaginaAlterar";
	}
	
	@RequestMapping(value = "desabilitarDisciplina", method = RequestMethod.POST)
	@Transactional
	public String desabilitarDisciplina(Disciplina disciplina, String pagina){
		
		disciplinaService.alterarEstadoDisciplina(disciplina.getId(), disciplina.getEstadoDisciplina());
		
		if(pagina.equals("view")){
			return "forward:exibirPaginaVisualizar";
		}
		
		return "forward:home";
		
	}
	
}
