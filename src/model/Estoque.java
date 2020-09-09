package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import model.validation.Validation;

@Entity
public class Estoque extends DefaultEntity<Estoque> {

	private static final long serialVersionUID = 268507942847684339L;
	@Column(nullable = false)
	private Integer quantidade;

	@Column(nullable = false)
	private Double precoCompra;
	@ManyToOne()
	@JoinColumn(name = "idfornecedor", nullable = false)
	private Fornecedor fornecedor;
	@ManyToOne()
	@JoinColumn(name = "idproduto", nullable = false)
	private Produto produto;
	@Column(nullable = false)
	private String notaFiscal;

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPrecoCompra() {
		return precoCompra;
	}

	public void setPrecoCompra(Double precoCompra) {
		this.precoCompra = precoCompra;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public String getNotaFiscal() {
		return notaFiscal;
	}

	public void setNotaFiscal(String notaFiscal) {
		this.notaFiscal = notaFiscal;
	}

	@Override
	public Validation<Estoque> getValidation() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toString() {
		return "Estoque [quantidade=" + quantidade + ", valorTotal=" + ", precoCompra=" + precoCompra + ", fornecedor="
				+ fornecedor + ", produto=" + produto + ", notaFiscal=" + notaFiscal + "]";
	}

}
