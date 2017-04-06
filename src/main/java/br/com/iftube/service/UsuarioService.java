package br.com.iftube.service;

import java.util.List;

import br.com.iftube.exception.service.ServiceException;
import br.com.iftube.model.entities.Usuario;

public interface UsuarioService {

	public Usuario adicionar(Usuario usuario, String confirmaSenha) throws ServiceException;
	public void editar(Usuario usuario);
	public Usuario alterarStatusUsuario(Usuario usuario);
	public void deletar(int usuarioId);
	public Usuario obterUsuarioPorId(int usuarioId);
	public Usuario validarUsuario(Usuario usuario);
	public boolean verificarPerfilUsuario(Usuario usuario);
	public Usuario obterUsuarioPorNome(String nome);
	public Usuario obterUsuarioPorLogin(String login);
	public Usuario obterUsuarioPorMatricula(String idMatriculaAlunoFk);
	@SuppressWarnings("rawtypes")
	public List obterTodosUsuario();
	
}
