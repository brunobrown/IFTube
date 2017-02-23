package br.com.iftube.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.iftube.model.entities.Curso;
import br.com.iftube.model.entities.Disciplina;
import br.com.iftube.model.entities.PalavraChave;
import br.com.iftube.service.CursoService;
import br.com.iftube.service.DisciplinaService;
import br.com.iftube.service.PalavraChaveService;
import br.com.iftube.service.exception.ServiceException;

@Controller
@Transactional
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
		return "adm/disciplina/inicio-disciplinaTemp";
	}

	@RequestMapping("exibirPaginaCadastro")
	public String exibirForm() {
		return "adm/disciplina/add-disciplinaTemp";
	}
	
	@RequestMapping("exibirPaginaAlterar")
	public String exibirForm(int id, Model model) {
		model.addAttribute("c", cursoService.obterCursoPorId(id));
		model.addAttribute("d", disciplinaService.obterDisciplinaPorId(id));
		model.addAttribute("pc", palavraChaveService.obterPalavraChavePorId(id));
		return "adm/disciplina/edit-disciplinaTemp";
	}
	
	@RequestMapping("exibirPaginaVisualizar")
	public String visualizar(int id, Model model) {
		model.addAttribute("c", cursoService.obterCursoPorId(id));
		model.addAttribute("d", disciplinaService.obterDisciplinaPorId(id));
		model.addAttribute("pc", palavraChaveService.obterPalavraChavePorId(id));
		return "adm/disciplina/view-disciplinaTemp";
	}
	

	@RequestMapping("addDisciplina")
	public String cadastro(Curso curso, Disciplina disciplina, PalavraChave palavraChave) {
		try {
			cursoService.adicionar(curso);
		} catch (ServiceException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			disciplinaService.adicionar(disciplina);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		palavraChaveService.adicionar(palavraChave);

		return "forward:listar";
	}
	
	@RequestMapping("edit")
	public String alterar(Curso curso, Disciplina disciplina, PalavraChave palavraChave) {
		cursoService.editar(curso);
		disciplinaService.editar(disciplina);
		palavraChaveService.editar(palavraChave);
		return "forward:listar";
	}

	@RequestMapping("delete")
	public String remover(int id) {
		cursoService.deletar(id);
		disciplinaService.deletar(id);
		palavraChaveService.deletar(id);
		return "forward:listar";
	}

}
