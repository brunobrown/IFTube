package br.com.iftube.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.iftube.exception.service.ServiceException;
import br.com.iftube.model.daos.UsuarioDAO;
import br.com.iftube.model.entities.Usuario;
import br.com.iftube.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService, Converter<String, Usuario>{

	@Autowired
	private UsuarioDAO usuarioDao;
	
	@SuppressWarnings("unchecked")
	public Usuario adicionar(Usuario usuario, String confirmaSenha) throws ServiceException{
		
		List<Usuario> todosUsuario = usuarioDao.obterTodosUsuario();
		
		boolean loginExiste = false;
		boolean emailExiste = false;
		boolean senhaNaoConfere = false;
		
		for (Usuario u : todosUsuario) {
			if(u.getEmail().equals(usuario.getEmail())){
				loginExiste = true;
				break;
			}else if(u.getLogin().equals(usuario.getLogin())){
				emailExiste = true;
				break;
			}else if(!u.getSenha().equals(confirmaSenha)){
				senhaNaoConfere = true;
				break;
			}
		
		}
		
		if(loginExiste){
			throw new ServiceException("Este Login já Existe!");
		}else if(emailExiste){
			throw new ServiceException("Este Email já Existe!");
		}else if(senhaNaoConfere){
			throw new ServiceException("Senhas não conferem!");
		}
		
		return usuarioDao.adicionar(usuario);
	}
	
	@Transactional
	public void editar(Usuario usuario){

		usuarioDao.editar(usuario);
	}
	
	@Transactional
	public Usuario alterarStatusUsuario(Usuario usuario){
		
		if(usuario.isAtivo() != true){
			usuario.setAtivo(true);
			editar(usuario);
			return usuario;
		}
			usuario.setAtivo(false);
			editar(usuario);
			return usuario;
	}
	
	@Transactional
	public void deletar(int usuarioId) {
		usuarioDao.deletar(usuarioId);
	}

	@Transactional
	public Usuario obterUsuarioPorId(int usuarioId) {
		return usuarioDao.obterUsuarioPorId(usuarioId);
	}
	
	@Transactional
	public Usuario validarUsuario(Usuario usuario){
		
		return usuario = usuarioDao.obterUsuario(usuario.getLogin(), usuario.getSenha());
		
	}
	
	@Transactional
	public boolean verificarPerfilUsuario(Usuario usuario){
		
		if(usuario.getPerfil().toString().equals("ADMINISTRADOR") || usuario.getPerfil().toString().equals("COORDENADOR")){
			return true;
		}else{
			return false;
		}
	}
	
	@Transactional
	public Usuario obterUsuarioPorNome(String nome) {
		return usuarioDao.obterUsuarioPorNome(nome);
	}
	
	@Transactional
	public Usuario obterUsuarioPorLogin(String login) {
		return usuarioDao.obterUsuarioPorLogin(login);
	}
	
	@Transactional
	public Usuario obterUsuarioPorMatricula(String idMatriculaAlunoFk) {
		return usuarioDao.obterUsuarioPorNome(idMatriculaAlunoFk);
	}
	
	@SuppressWarnings("rawtypes")
	@Transactional
	public List obterTodosUsuario() {
		return usuarioDao.obterTodosUsuario();
	}
	

	@Transactional
	public Usuario convert(String id) {
			
		if (id != null && !id.equals("")) {
			return usuarioDao.obterUsuarioPorId(Integer.valueOf(id));
		} else {
			return null;
		}
	}

}
