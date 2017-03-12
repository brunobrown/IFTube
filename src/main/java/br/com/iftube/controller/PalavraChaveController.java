package br.com.iftube.controller;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.iftube.exception.service.ServiceException;
import br.com.iftube.model.entities.Disciplina;
import br.com.iftube.model.entities.PalavraChave;
import br.com.iftube.service.DisciplinaService;
import br.com.iftube.service.PalavraChaveService;

@Controller
public class PalavraChaveController {
	
	
	@Autowired
	private PalavraChaveService palavraChaveService;
	
	@Autowired
	private DisciplinaService disciplinaService;
	
	@RequestMapping("addTag")
	@Transactional
	public String addTag(PalavraChave tag, Model model) {

		try {
			palavraChaveService.adicionar(tag);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "forward:exibirPaginaCadastrarDisciplina";
	}
	
	@RequestMapping("editTag")
	public String edit(PalavraChave tag, String id,  int disciplinaId, Model model){
		
		palavraChaveService.editar(tag, id);
		Disciplina disciplina = disciplinaService.obterDisciplinaPorId(disciplinaId);
		model.addAttribute("disciplina", disciplina);
		model.addAttribute("palavraChave", palavraChaveService.obterTodosTag());
		
		return "adm/curso/edit-disciplina";
	}

}
