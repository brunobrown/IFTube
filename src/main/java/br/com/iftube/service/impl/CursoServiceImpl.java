package br.com.iftube.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.iftube.exception.service.ServiceException;
import br.com.iftube.model.daos.CursoDAO;
import br.com.iftube.model.entities.Curso;
import br.com.iftube.service.CursoService;

@Service
public class CursoServiceImpl implements CursoService, Converter<String, Curso>{

	@Autowired
	private CursoDAO cursoDao;
	
	
	@Transactional
	public Curso adicionar(Curso curso) throws ServiceException{
		Curso cursoEncontrado = cursoDao.obterCursoPorNome(curso.getNomeCurso());
		if(cursoEncontrado != null){
			throw new ServiceException("Curso já existe!");
		}
		
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
	
	@Transactional
	public Curso alterarEstadoCurso(int id, String estadoCurso) {
		Curso curso = obterCursoPorId(id);
		curso.setEstadoCurso(estadoCurso);
		editar(curso);
		return curso;
	}

	@SuppressWarnings("rawtypes")
	@Transactional
	public List obterTodosCurso() {
		return cursoDao.obterTodosCurso();
	}
	
	@Transactional
	public Curso convert(String id) {
		
		if (!id.equals("")) {
			return cursoDao.obterCursoPorId(Integer.valueOf(id));
		} else {
		    return null;
		}
	}
	
}
