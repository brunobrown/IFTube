package br.com.iftube.test.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import br.com.iftube.model.daos.DisciplinaDAO;
import br.com.iftube.model.entities.Disciplina;
import br.com.iftube.service.DisciplinaService;
import br.com.iftube.service.exception.ServiceException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/applicationContext.xml"})
//atraves do parametro (defaultRollback = true) os dados nao sao adicionados e o banco nao e poluido
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
@Transactional
public class TestDisciplinaService {

	@Autowired
	private DisciplinaService disciplinaService;
	
	@Autowired
	private DisciplinaDAO disciplinaDao;
	
	@Test
	public void testNaoAdicionarDisciplina(){
		//criando um objeto Disciplina
		Disciplina disciplina = new Disciplina();
		
		//setando o um nome no objeto
		disciplina.setNomeDisciplina("testNomeDisciplina");
		
		//adicionando o objeto atraves do dao
		disciplinaDao.adicionar(disciplina);
		
		//adicionando o objeto atraves do service
		try {
			disciplinaService.adicionar(disciplina);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	

	}
	@Test
	public void testAdicionarDisciplina(){
		
		//criando um objeto Disciplina
				Disciplina disciplina = new Disciplina();
				
				//setando o um nome no objeto
				disciplina.setNomeDisciplina("testNomeDisciplina");
				
				//adicionando o objeto atraves do dao
				disciplinaDao.adicionar(disciplina);
				
				//adicionando o objeto atraves do service

				try {
					disciplinaService.adicionar(disciplina);
				} catch (ServiceException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
	}
}
