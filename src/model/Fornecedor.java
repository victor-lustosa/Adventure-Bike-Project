package model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import model.validation.Validation;

@Entity
public class Fornecedor extends DefaultEntity<Fornecedor> {

	private static final long serialVersionUID = -3722588257509847716L;

	@Column(nullable = false)
	private String cnpj;

	@Column(nullable = false)
	private String razaoSocial;

	@Column(nullable = false)
	private String nome;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idtelefone", unique = true)
	private Telefone telefone;

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Telefone getTelefone() {
		return telefone;
	}

	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}

	@Override
	public Validation<Fornecedor> getValidation() {
		// TODO Auto-generated method stub
		return null;
	}

}
