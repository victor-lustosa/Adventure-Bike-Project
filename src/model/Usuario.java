package model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import model.validation.Validation;

@Entity
public class Usuario extends DefaultEntity<Usuario> {

	private static final long serialVersionUID = -3976906777918886470L;

	@Column(length = 100, nullable = false)
	private String nome;

	@Column(length = 100, nullable = false)
	private String email;

	@Column(length = 70, nullable = false)
	private String senha;

	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dataAniversario;
	@Column(nullable = false)
	private String cpf;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idendereco")
	private Endereco endereco;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idtelefone", nullable = true)
	private Telefone telefone;
   
	private Perfil perfil;
	


	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public Telefone getTelefone() {
		return telefone;
	}

	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Date getDataAniversario() {
		return dataAniversario;
	}

	public void setDataAniversario(Date dataAniversario) {
		this.dataAniversario = dataAniversario;
	}

	
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@Override
	public Validation<Usuario> getValidation() {
		return null;
	}

//	@Override
//	public String toString() {
//		return "Usuario [nome=" + nome + ", email=" + email + ", senha=" + senha + ", dataAniversario="
//				+ dataAniversario + ", cpf=" + cpf + ", endereco=" + endereco + ", telefone=" + telefone + ", perfil="
//				+ perfil + "]";
//	}
	
	

}
