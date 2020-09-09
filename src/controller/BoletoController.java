package controller;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import model.Boleto;

@Named
@ViewScoped
public class BoletoController extends Controller<Boleto> {

	private static final long serialVersionUID = -7207688643567623410L;

	@Override
	public void salvar() {
		PedidoController pedido = new PedidoController();
//		CarrinhoController carrinho = new CarrinhoController();
		pedido.salvar();
//		carrinho.salvar();
		super.salvar();
	}

	@Override
	public Boleto getEntity() {
		if (entity == null) {
			entity = new Boleto();
		}
		System.out.println(entity.toString());
		return entity;
	}
}