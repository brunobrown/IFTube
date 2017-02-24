package br.com.iftube.controller.curso;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.iftube.model.entities.Curso;
import br.com.iftube.service.CursoService;
import br.com.iftube.service.exception.ServiceException;


@Controller
@Transactional
public class CursoController {

	@Autowired
	private CursoService cursoService;


	@RequestMapping("exibirPaginaCadastrarCurso")
	public String exibirForm() {
		return "adm/curso/addCursoTemp";
	}
	
	@RequestMapping("addCurso")
	public String cadastrarCurso(Curso curso) {
		try {
			cursoService.adicionar(curso);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "forward:exibirPaginaCadastrarCurso";
	}


}
