package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import model.validation.Validation;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Produto extends DefaultEntity<Produto> {

	private static final long serialVersionUID = -8579376882467070134L;

	@ManyToOne()
	@JoinColumn(name = "idmarca", nullable = false)
	private Marca marca;

	@ManyToOne()
	@JoinColumn(name = "idtipoproduto", nullable = false)
	private TipoProduto tipoProduto;

	@Column(length = 120, nullable = false)
	private String material;

	@Column(length = 400)
	private String descricao;

	@Column(length = 100, nullable = false)
	private String nome;

	@Column(length = 100, nullable = false)
	private String modelo;

	@Column(nullable = false)
	private Double valor;

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public TipoProduto getTipoProduto() {
		return tipoProduto;
	}

	public void setTipoProduto(TipoProduto tipoProduto) {
		this.tipoProduto = tipoProduto;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		super.toString();
		return "Produto [marca=" + marca + ", tipoProduto=" + tipoProduto + ", material=" + material + ", descricao="
				+ descricao + ", nome=" + nome + ", modelo=" + modelo + ", valor=" + valor + ", getId()=" + getId()
				+ "]";
	}

	@Override
	public Validation<Produto> getValidation() {
		return null;
	}
}