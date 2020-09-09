package controller;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import model.Bandeira;
import model.CartaoCredito;
import model.TipoCartao;

@Named
@ViewScoped
public class CartaoCreditoController extends Controller<CartaoCredito> {

	private static final long serialVersionUID = -6808058965760290520L;

	@Override
	public void salvar() {
		PedidoController pedido = new PedidoController();
//		CarrinhoController carrinho = new CarrinhoController();
		pedido.salvar();
//		carrinho.salvar();
		super.salvar();
	}

	@Override
	public CartaoCredito getEntity() {
		if (entity == null) {
			entity = new CartaoCredito();
		}
		return entity;
	}

	public Bandeira[] getListaBandeira() {
		return Bandeira.values();
	}

	public TipoCartao[] getListaTipoCartao() {
		return TipoCartao.values();
	}
}