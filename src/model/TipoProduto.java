package model;

import javax.persistence.Column;
import javax.persistence.Entity;

import model.validation.Validation;

@Entity
public class TipoProduto extends DefaultEntity<TipoProduto> {

	private static final long serialVersionUID = -2359731594073401155L;

	@Column(nullable = false)
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public Validation<TipoProduto> getValidation() {
		return null;
	}

	@Override
	public String toString() {
		return "TipoProduto [nome=" + nome + "]";
	}

}
