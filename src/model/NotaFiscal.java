package model;

import javax.persistence.Column;
import javax.persistence.Entity;

import model.validation.Validation;

@Entity
public class NotaFiscal extends DefaultEntity<NotaFiscal> {

	private static final long serialVersionUID = -7607211676214204484L;
	@Column(nullable = false)
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public Validation<NotaFiscal> getValidation() {
		return null;
	}
}
