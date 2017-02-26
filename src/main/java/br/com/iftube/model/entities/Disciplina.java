package br.com.iftube.model.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="disciplina")
public class Disciplina implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5312804025362449060L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "nome_disciplina", unique=true, nullable=false, length=100)
	private String nomeDisciplina;
	
	@Column(nullable=false, length=10)
	private Integer periodo;
	
	@ManyToOne
	@JoinColumn(name = "id_curso_fk")
	private Curso curso;
	
	
	public Disciplina() {
		// TODO Auto-generated constructor stub
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNomeDisciplina() {
		return nomeDisciplina;
	}


	public void setNomeDisciplina(String nome) {
		this.nomeDisciplina = nome;
	}


	public Integer getPeriodo() {
		return periodo;
	}


	public void setPeriodo(Integer periodo) {
		this.periodo = periodo;
	}


	public Curso getCurso() {
		return curso;
	}


	public void setCurso(Curso curso) {
		this.curso = curso;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((curso == null) ? 0 : curso.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nomeDisciplina == null) ? 0 : nomeDisciplina.hashCode());
		result = prime * result + ((periodo == null) ? 0 : periodo.hashCode());
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
		Disciplina other = (Disciplina) obj;
		if (curso == null) {
			if (other.curso != null)
				return false;
		} else if (!curso.equals(other.curso))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nomeDisciplina == null) {
			if (other.nomeDisciplina != null)
				return false;
		} else if (!nomeDisciplina.equals(other.nomeDisciplina))
			return false;
		if (periodo == null) {
			if (other.periodo != null)
				return false;
		} else if (!periodo.equals(other.periodo))
			return false;
		return true;
	}

}
