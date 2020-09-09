package controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import application.Session;
import application.Util;
import model.Carrinho;
import model.ItemPedido;
import model.Usuario;

@Named
@ViewScoped
public class CarrinhoController extends Controller<Carrinho> {

	private static final long serialVersionUID = -7303558665258909306L;
		private Double valorCarrinho = 0.00;

	public Double getValorCarrinho() {
		return valorCarrinho;
	}

	public void setValorCarrinho(Double valorCarrinho) {
		this.valorCarrinho = valorCarrinho;
	}

	int i = 0;

//	@Override
//	public void salvar() {
////		
////		List<ItemPedido> carrinhoSalvar = (ArrayList<ItemPedido>) Session.getInstance().getAttribute("carrinho");
////		for (ItemPedido itemPedido : carrinhoSalvar) {
////			System.out.println(itemPedido.getProduto().toString());
////			valorCarrinho = valorCarrinho + carrinhoSalvar.get(i).getValor();
////			i = i + 1;
////			System.out.println("carrinho:" + carrinhoSalvar.toString());
////			System.out.println("quant: " + i);
////			System.out.println("valor do carrinho: " + valorCarrinho);
////		}
////		if(entity == null)
////			entity = new Carrinho();
////		Usuario usuario1 = (Usuario) Session.getInstance().getAttribute("usuarioLogado");
////		entity.setUsuario(usuario1);
////		entity.setValorCarrinho(valorCarrinho);
////		super.salvar();
//	}

	@Override
	public Carrinho getEntity() {
		if (entity == null) {
			entity = new Carrinho();
			entity.setUsuario(new Usuario());
		}
		List<ItemPedido> carrinhoPedido = (ArrayList<ItemPedido>) Session.getInstance().getAttribute("carrinho");

		if (carrinhoPedido == null)
			carrinhoPedido = new ArrayList<ItemPedido>();
		entity.setListaItem(carrinhoPedido);
		return entity;
	}

	public void remover(Integer idProduto) {
		Usuario usuario = (Usuario) Session.getInstance().getAttribute("usuarioLogado");
		if (usuario == null)
			Util.addMessageWarn("Eh preciso estar logado para realizar uma pedido. Faca o Login!!");
		else {
			List<ItemPedido> carrinho = (List<ItemPedido>) Session.getInstance().getAttribute("carrinho");

			for (ItemPedido itemPedido : carrinho) {
				System.out.println(itemPedido.getProduto().toString());
				System.out.println(idProduto);
				if (itemPedido.getProduto().getId().equals(idProduto)) {
					carrinho.remove(itemPedido);
					return;
				}
			}

		}
	}

	public String pedido(List<ItemPedido> carrinho) {
		Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
		flash.put("carrinhoFlash", carrinho);

		return "pedido.xhtml?faces-redirect=true";
	}

}