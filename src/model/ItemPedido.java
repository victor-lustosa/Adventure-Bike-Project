package model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;

import model.validation.Validation;

@Entity
public class ItemPedido extends DefaultEntity<ItemPedido> {

	private static final long serialVersionUID = 885652744452932617L;
	private Double valor;
	private int quantidade = 0;
	@ManyToOne
	@JoinColumn(name = "idproduto")
	private Produto produto;
	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	@Override
	public Validation getValidation() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toString() {
		super.toString();
		return "ItemPedido [valor=" + valor + ", quantidade=" + quantidade + ", produto=" + produto + "]";
	}
	

}
