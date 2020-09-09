package model;

import javax.persistence.Column;
import javax.persistence.Entity;

import model.validation.Validation;

@Entity
public class Telefone extends DefaultEntity<Telefone> {

	private static final long serialVersionUID = 4368844581125273114L;

	@Column(nullable = false)
	private String numero;

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	@Override
	public Validation<Telefone> getValidation() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toString() {
		super.toString();
		return "Telefone [ numero=" + numero + "]";
	}

}
