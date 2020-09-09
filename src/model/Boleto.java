package model;

import javax.persistence.Entity;

import model.validation.Validation;

@Entity
public class Boleto extends FormaPagamento {

	private static final long serialVersionUID = 1698379199713882961L;
	private String codigoBoleto;


	public String getCodigoBoleto() {
		return codigoBoleto;
	}

	public void setCodigoBoleto(String codigoBoleto) {
		this.codigoBoleto = codigoBoleto;
	}

}
