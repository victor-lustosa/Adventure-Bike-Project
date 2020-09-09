package model;

import javax.persistence.Column;
import javax.persistence.Entity;

import model.validation.Validation;

@Entity
public class ServicoPrestado extends DefaultEntity<ServicoPrestado> {

	private static final long serialVersionUID = -8714927029426168522L;
	@Column(nullable = false)
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public Validation<ServicoPrestado> getValidation() {
		return null;
	}
}
