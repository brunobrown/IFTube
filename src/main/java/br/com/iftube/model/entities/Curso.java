package br.com.iftube.model.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table(name="curso")
public class Curso implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = 689773374265672630L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	/*##############################
	Validacao adicionada abaixo*/
	@NotEmpty(message="Este campo deve ser preenchido!")
	@Size(min = 5, max = 15, message="O Nome do Curso deve deve ter um tamanho de 15 caracteres")
	//##############################
	
	@Column(name = "nome_curso",unique=true, nullable=false, length=100)
	private String nomeCurso;
	
	@Column(name = "estado_curso", nullable=false, length=10)
	private String estadoCurso;
	
	public Curso() {
		// TODO Auto-generated constructor stub
	}
	
	public String getEstadoCurso() {
		return estadoCurso;
	}

	public void setEstadoCurso(String estadoCurso) {
		this.estadoCurso = estadoCurso;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeCurso() {
		return nomeCurso;
	}

	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nomeCurso == null) ? 0 : nomeCurso.hashCode());
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
		Curso other = (Curso) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nomeCurso == null) {
			if (other.nomeCurso != null)
				return false;
		} else if (!nomeCurso.equals(other.nomeCurso))
			return false;
		return true;
	}
	
}
