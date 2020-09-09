package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import model.validation.Validation;

@Entity
public class Carrinho extends DefaultEntity<Carrinho> {

	private static final long serialVersionUID = 131791403543271208L;
	@ManyToOne(optional = true, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "idusuario")
	private Usuario usuario;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idpedido")
	private Pedido pedido;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "iditempedido")
	@JoinTable(name = "carrinho_itempedido", joinColumns = {
			@JoinColumn(name = "idcarrinho", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "iditempedido", referencedColumnName = "id") })
	private List<ItemPedido> listaItem;

	private Double valorCarrinho;

	public Double getValorCarrinho() {
		return valorCarrinho;
	}

	public void setValorCarrinho(Double valorCarrinho) {
		this.valorCarrinho = valorCarrinho;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<ItemPedido> getListaItem() {
		return listaItem;
	}

	public void setListaItem(List<ItemPedido> listaItem) {
		this.listaItem = listaItem;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	@Override
	public Validation<Carrinho> getValidation() {
		return null;
	}

	@Override
	public String toString() {
		return "Carrinho [usuario=" + usuario + ", pedido=" + pedido + ", listaItem=" + listaItem + ", valorCarrinho="
				+ valorCarrinho + "]";
	}

}
