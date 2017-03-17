package br.com.iftube.controller;


import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
	
	/*
	###########################
	No parametro do metodo (cadastarCurso) eu aviso ao Spring MVC que quero executar a
	validação utilizando a anotação (@Valid)
	
	Ainda no parametro do metodo (cadastarCurso) aviso ao Spring MVC para guardar a exception e o 
	resultado dos erros de validação em um objeto do tipo (BindingResult)
	###########################
	*/
	public String cadastrarCurso(@Valid Curso curso, BindingResult result, Model model) {
		
			/*
			 ###################################
			 Aqui verifico se a variavel (result) contem erro de validação,
			 se existir erro, o sistema retorna ao formulário. 
			 */
			if (result.hasErrors()) {
				return "forward:exibirPaginaCadastrarCurso";
			}
			//###############################
			try {
				cursoService.adicionar(curso);
				model.addAttribute("exception", "Curso cadastrado com sucesso!");
			} catch (ServiceException e) {
				model.addAttribute("exception", "Este Curso já existe!");
				e.printStackTrace();
			}
		
		
		return "forward:exibirPaginaCadastrarCurso";
	}

	@RequestMapping("editCurso")
	@Transactional
	public String alterarCurso(int id, Curso curso, Model model){
		try {
			cursoService.editar(curso);
			model.addAttribute("exception", "Curso alterado com sucesso!");
		} catch (ServiceException e) {
			model.addAttribute("exception", "Este Curso não pode ser alterado, ele já existe!");
			e.printStackTrace();
		}
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
