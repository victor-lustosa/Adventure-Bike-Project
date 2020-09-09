package model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import model.validation.Validation;

@Entity
public class Cidade extends DefaultEntity<Cidade> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8967240851927495370L;
	private String nome;
	private String sigla;
	
	@ManyToOne()
	@JoinColumn(name = "idestado")
	private Estado estado;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	
	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	@Override
	public Validation<Cidade> getValidation() {
		return null;
	}



}
