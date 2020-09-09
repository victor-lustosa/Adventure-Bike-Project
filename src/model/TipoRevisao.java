package model;

import javax.persistence.Column;
import javax.persistence.Entity;

import model.validation.Validation;

@Entity
public class TipoRevisao extends DefaultEntity<TipoRevisao> {

	private static final long serialVersionUID = 2594497148902596670L;
	@Column(nullable = false)
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public Validation<TipoRevisao> getValidation() {
		return null;
	}
}
