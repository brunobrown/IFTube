package br.com.iftube.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.iftube.exception.service.ServiceException;
import br.com.iftube.model.daos.CursoDAO;
import br.com.iftube.model.entities.Curso;
import br.com.iftube.service.CursoService;

@Service
public class CursoServiceImpl implements CursoService{

	@Autowired
	private CursoDAO cursoDao;
	
	
	@Transactional
	public Curso adicionar(Curso curso) throws ServiceException{
		return cursoDao.adicionar(curso);
	}

	@Transactional
	public Curso editar(Curso curso) {
		return cursoDao.editar(curso);
	}

	@Transactional
	public void deletar(Curso curso) {
		cursoDao.deletar(curso);
	}

	@Transactional
	public Curso obterCursoPorId(int cursoId) {
		return cursoDao.obterCursoPorId(cursoId);
	}
	
	@Transactional
	public Curso obterCursoPorNome(String nomeCurso) {
		return cursoDao.obterCursoPorNome(nomeCurso);
	}

	@SuppressWarnings("rawtypes")
	@Transactional
	public List obterTodosCurso() {
		return cursoDao.obterTodosCurso();
	}

}
