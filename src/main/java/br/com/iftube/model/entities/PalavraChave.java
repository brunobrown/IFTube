package br.com.iftube.model.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="palavra_chave")
public class PalavraChave implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7868269123208270826L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@Lob
	@Column(nullable=false)
	private String tag;
	
	@ManyToOne
	@JoinColumn(name = "id_disciplina_fk")
	private Disciplina idDisciplinaFk;
	
	public PalavraChave() {
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public Disciplina getIdDisciplinaFk() {
		return idDisciplinaFk;
	}

	public void setIdDisciplinaFk(Disciplina idDisciplinaFk) {
		this.idDisciplinaFk = idDisciplinaFk;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((idDisciplinaFk == null) ? 0 : idDisciplinaFk.hashCode());
		result = prime * result + ((tag == null) ? 0 : tag.hashCode());
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
		PalavraChave other = (PalavraChave) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (idDisciplinaFk == null) {
			if (other.idDisciplinaFk != null)
				return false;
		} else if (!idDisciplinaFk.equals(other.idDisciplinaFk))
			return false;
		if (tag == null) {
			if (other.tag != null)
				return false;
		} else if (!tag.equals(other.tag))
			return false;
		return true;
	}

}
