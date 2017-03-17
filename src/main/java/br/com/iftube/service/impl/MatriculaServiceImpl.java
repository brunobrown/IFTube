package br.com.iftube.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.iftube.exception.service.ServiceException;
import br.com.iftube.model.daos.MatriculaDAO;
import br.com.iftube.model.entities.Matricula;
import br.com.iftube.service.MatriculaService;

@Service
public class MatriculaServiceImpl implements MatriculaService, Converter<String, Matricula>{

	@Autowired
	private MatriculaDAO matriculaDao;
	
	
	@Transactional
	public Matricula adicionar(Matricula matricula) throws ServiceException{
		Matricula matriculaEncontrado = matriculaDao.obterMatriculaPorNome(matricula.getMatricula());
		if(matriculaEncontrado != null){
			throw new ServiceException("Matricula já existe!");
		}

		return matriculaDao.adicionar(matricula);
	}

	@Transactional
	public Matricula editar(Matricula matricula) throws ServiceException {
		Matricula matriculaEncontrado = matriculaDao.obterMatriculaPorNome(matricula.getMatricula());
		if(matriculaEncontrado != null){
			throw new ServiceException("Matricula já existe!");
		}
		
		return matriculaDao.editar(matricula);
	}

	@Transactional
	public void deletar(Matricula matricula) {
		matriculaDao.deletar(matricula);
	}

	@Transactional
	public Matricula obterMatriculaPorId(int matriculaId) {
		return matriculaDao.obterMatriculaPorId(matriculaId);
	}
	
	@Transactional
	public Matricula obterMatriculaPorNome(String matricula) {
		return matriculaDao.obterMatriculaPorNome(matricula);
	}

	@SuppressWarnings("rawtypes")
	@Transactional
	public List obterTodosMatricula() {
		return matriculaDao.obterTodosMatricula();
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public boolean validarMatricula(String matriculaStr) throws ServiceException {
		
		List<Matricula> todosMatriculas = matriculaDao.obterTodosMatricula();
		boolean matriculaExiste = false;
		
		for (Matricula m : todosMatriculas) {
			if(m.getMatricula().equals(matriculaStr)){
				matriculaExiste = true;
				break;
			}
		}
		
		if(!matriculaExiste){
			throw new ServiceException("Essa Matrícula Não Existe!");
		}
		
		return matriculaExiste;
	}
	
	
	@Transactional
	public Matricula convert(String id) {
		
		if (!id.equals("")) {
			return matriculaDao.obterMatriculaPorId(Integer.valueOf(id));
		} else {
		    return null;
		}
	}

	
}
