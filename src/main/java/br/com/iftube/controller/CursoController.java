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
import br.com.iftube.service.CursoService;
import br.com.iftube.service.DisciplinaService;
import br.com.iftube.service.PalavraChaveService;


@Controller
public class CursoController {

	@Autowired
	private CursoService cursoService;
	
	@Autowired
	private DisciplinaService disciplinaService;
	
	@Autowired
	private PalavraChaveService palavraChaveService;

	@RequestMapping("home")
	@Transactional
	public String exibirInicio(Model model, Disciplina disciplina) {
		model.addAttribute("curso", cursoService.obterTodosCurso());
		model.addAttribute("disciplina", disciplinaService.obterTodosDisciplina());
		model.addAttribute("palavraChave", palavraChaveService.obterTodosTag());

		return "adm/curso/home";
	}
	
	@RequestMapping("exibirPaginaCadastrarCurso")
	public String exibirPaginaCadastrarCurso(Model model) {
		model.addAttribute("listarCurso", cursoService.obterTodosCurso());
		return "adm/curso/addCurso";
	}
	
	@RequestMapping("addCurso")
	@Transactional
	public String cadastrarCurso(Curso curso, Model model) {
		
			try {
				cursoService.adicionar(curso);
			} catch (ServiceException e) {
				// TODO Auto-generated catch block
				model.addAttribute("exception", e);
			}
		
		
		return "forward:exibirPaginaCadastrarCurso";
	}

	@RequestMapping("editCurso")
	@Transactional
	public String alterarCurso(int id, Curso curso){
		cursoService.editar(curso);
		return "forward:exibirPaginaCadastrarCurso";
	}
	
	@RequestMapping(value = "desabilitarCurso", method = RequestMethod.POST)
	@Transactional
	public String desabilitarCurso(Curso curso, String pagina){
		
		cursoService.alterarEstadoCurso(curso.getId(), curso.getEstadoCurso());
		
		try {
			disciplinaService.alterarTodosEstadoDisciplina(curso.getId(), curso.getEstadoCurso());
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(pagina.equals("home")){
			return "forward:home";
		}
		
		return "forward:exibirPaginaCadastrarCurso";
		
	}
	
	@RequestMapping("searchCurso")
	@Transactional
	public String searchCurso(String nomeCurso, Model model){
		Curso cursoLocalizado = cursoService.obterCursoPorNome(nomeCurso);
		model.addAttribute("cursoLocalizado", cursoLocalizado);
		return "forward:exibirPaginaCadastrarCurso";
	}

}
