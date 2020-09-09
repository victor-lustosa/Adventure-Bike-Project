package model;

import javax.persistence.Column;
import javax.persistence.Entity;

import model.validation.Validation;

@Entity
public class Endereco extends DefaultEntity<Endereco> {

	private static final long serialVersionUID = -4624192438309428426L;
	@Column(nullable = false)
	private String cep;
	@Column(nullable = false)
	private String numero;
	@Column(nullable = false)
	private String rua;
	@Column(nullable = true)
	private String complemento;
	@Column(nullable = true)
	private String pontoReferencia;

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getPontoReferencia() {
		return pontoReferencia;
	}

	public void setPontoReferencia(String pontoReferencia) {
		this.pontoReferencia = pontoReferencia;
	}

	@Override
	public Validation<Endereco> getValidation() {
		return null;
	}

	@Override
	public String toString() {
		super.toString();
		return "Endereco [cep=" + cep + ", numero=" + numero + ", rua=" + rua + ", complemento=" + complemento
				+ ", pontoReferencia=" + pontoReferencia + "]";
		
	}
	
	
}
