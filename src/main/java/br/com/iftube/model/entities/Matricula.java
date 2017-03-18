package br.com.iftube.model.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="matricula")
public class Matricula implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1377552746497960566L;
	
	
	@Id
	@Column(name="matricula_aluno",length=15)
	private String matriculaAluno;
	
	public Matricula() {
		// TODO Auto-generated constructor stub
	}
	
	public String getMatriculaAluno() {
		return matriculaAluno;
	}
	public void setMatriculaAluno(String matriculaAluno) {
		this.matriculaAluno = matriculaAluno;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((matriculaAluno == null) ? 0 : matriculaAluno.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Matricula other = (Matricula) obj;
		if (matriculaAluno == null) {
			if (other.matriculaAluno != null)
				return false;
		} else if (!matriculaAluno.equals(other.matriculaAluno))
			return false;
		return true;
	}
	
	
}