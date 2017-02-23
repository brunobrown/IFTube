package br.com.iftube.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.iftube.model.daos.CursoDAO;
import br.com.iftube.model.entities.Curso;
import br.com.iftube.service.CursoService;

@Service
public class CursoServiceImpl implements CursoService{

	@Autowired
	private CursoDAO cursoDao;
	
	
	@Transactional
	public Curso adicionar(Curso curso){
		return cursoDao.adicionar(curso);
	}

	@Transactional
	public void editar(Curso curso) {
		cursoDao.editar(curso);
	}

	@Transactional
	public void deletar(int cursoId) {
		cursoDao.deletar(cursoId);
	}

	@Transactional
	public Curso obterCursoPorId(int cursoId) {
		return cursoDao.obterCursoPorId(cursoId);
	}

	@SuppressWarnings("rawtypes")
	@Transactional
	public List obterTodosCurso() {
		return cursoDao.obterTodosCurso();
	}

}
