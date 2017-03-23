package br.com.iftube.controller;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.iftube.exception.service.ServiceException;
import br.com.iftube.model.entities.Matricula;
import br.com.iftube.model.entities.Disciplina;
import br.com.iftube.service.MatriculaService;
import br.com.iftube.service.UsuarioService;
//import br.com.iftube.service.DisciplinaService;
//import br.com.iftube.service.PalavraChaveService;


@Controller
public class MatriculaController {

	@Autowired
	private MatriculaService matriculaService;
	
	@Autowired
	private UsuarioService usuarioService;
//	
//	@Autowired
//	private PalavraChaveService palavraChaveService;

	@RequestMapping("homeUser")
	@Transactional
	public String exibirInicio(Model model, Disciplina disciplina) {
		model.addAttribute("matricula", matriculaService.obterTodosMatricula());
		model.addAttribute("usuario", usuarioService.obterTodosUsuario());

		return "adm/user/homeUser";
	}
	
	@RequestMapping("exibirPaginaCadastrarMatricula")
	public String exibirPaginaCadastrarMatricula(Model model) {
		model.addAttribute("listarMatricula", matriculaService.obterTodosMatricula());
		return "adm/user/addMatricula";
	}
	
	@RequestMapping("addMatricula")
	@Transactional
	public String cadastrarMatricula(Matricula matricula, Model model) {
		
			try {
				matriculaService.adicionar(matricula);
				model.addAttribute("exception", "Matrícula cadastrada com sucesso!");
			} catch (ServiceException e) {
				model.addAttribute("exception", "Esta Matrícula já existe!");
				e.printStackTrace();
			}
		
		
		return "forward:exibirPaginaCadastrarMatricula";
	}

	@RequestMapping("editMatricula")
	@Transactional
	public String alterarMatricula(int id, Matricula matricula, Model model){
		try {
			matriculaService.editar(matricula);
			model.addAttribute("exception", "Matrícula alterada com sucesso!");
		} catch (ServiceException e) {
			model.addAttribute("exception", "Esta Matrícula não pode ser alterada, ela já existe!");
			e.printStackTrace();
		}
		return "forward:exibirPaginaCadastrarMatricula";
	}
	
	
	@RequestMapping("searchMatricula")
	@Transactional
	public String searchMatricula(String nomeMatricula, Model model){
		Matricula matriculaLocalizado = matriculaService.obterMatriculaPorNome(nomeMatricula);
		model.addAttribute("matriculaLocalizado", matriculaLocalizado);
		return "forward:exibirPaginaCadastrarMatricula";
	}
	
	@RequestMapping("validarMatricula")
	@Transactional
	public String validarMatricula(String matricula, Model model){
		
		try {
			model.addAttribute("matriculaExiste", matriculaService.validarMatricula(matricula));
			model.addAttribute("matricula", matriculaService.obterMatriculaPorNome(matricula));
		} catch (ServiceException e) {
			model.addAttribute("exception", e);
			e.printStackTrace();
		}
		
		return "forward:exibirPaginaCadastrarUsuario";
	}

}
