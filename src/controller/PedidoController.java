package controller;

import java.util.List;
import java.util.Random;

import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import application.Session;
import application.Util;
import model.Carrinho;
import model.ItemPedido;
import model.Pedido;
import model.Usuario;

@Named
@ViewScoped
public class PedidoController extends Controller<Pedido> {
	Random random = new Random();
	private static final long serialVersionUID = 8702988121934899052L;
	private Carrinho carrinho;

	public Carrinho getCarrinho() {
		if (carrinho == null) {
			carrinho = new Carrinho();
		}
		return carrinho;
	}

	public void setCarrinho(Carrinho carrinho) {
		this.carrinho = carrinho;
	}

	@Override
	public void salvar() {
		getEntity().setCarrinho(getCarrinho());
		entity.setValorTotal(getCarrinho().getValorCarrinho());
		Double numeroPedido = random.nextDouble() * 10;
		String stringNumeroPedido = Double.toString(numeroPedido);
		entity.setNumeroPedido(stringNumeroPedido);
		super.salvar();
	}

	public PedidoController() {
		Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
		flash.keep("carrinhoFlash");
		getCarrinho().setListaItem((List<ItemPedido>) flash.get("carrinhoFlash"));
		getCarrinho().setUsuario((Usuario) Session.getInstance().getAttribute("usuarioLogado"));
		System.out.println("entreiii");
		System.out.println(getCarrinho().toString());
	}

	@Override
	public Pedido getEntity() {
		if (entity == null) {
			setEntity(new Pedido());
		}
		return entity;
	}

	public void boleto() {
		Util.redirect("/faces/pages/boleto.xhtml?faces-redirect=true");
	}

	public void cartaoCredito() {
		Util.redirect("/faces/pages/cartaocredito.xhtml?faces-redirect=true");
	}
}