package br.com.iftube.test.model.daos;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import br.com.iftube.model.daos.CursoDAO;
import br.com.iftube.model.entities.Curso;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/applicationContext.xml"})
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
@Transactional
public class TestCursoDAO {

	@Autowired
	private CursoDAO cursoDao;
	
	
	@Test
	public void testAdicionar(){
		Curso curso = new Curso();
		curso.setNomeCurso("testAdicionarCurso");
		cursoDao.adicionar(curso);

	
		Assert.assertNotNull(curso.getId());
	}
	
}
