package br.com.iftube.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.iftube.exception.service.ServiceException;
import br.com.iftube.model.entities.PalavraChave;
import br.com.iftube.service.PalavraChaveService;

@Controller
public class PalavraChaveController {
	
	
	@Autowired
	private PalavraChaveService palavraChaveService;

	@RequestMapping("addTag")
	@Transactional
	public String addTag(PalavraChave tag, Model model) {

		try {
			palavraChaveService.adicionar(tag);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			model.addAttribute("exception", e);
		}
		return "forward:exibirPaginaCadastrarDisciplina";
	}

}
