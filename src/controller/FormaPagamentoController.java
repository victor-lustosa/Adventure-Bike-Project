package controller;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import application.Session;
import model.Bandeira;
import model.Boleto;
import model.CartaoCredito;
import model.FormaPagamento;
import model.TipoCartao;
import model.Usuario;

@Named
@ViewScoped
public class FormaPagamentoController extends Controller<FormaPagamento> {

	private static final long serialVersionUID = -3182998839416333203L;

//	@Override
//	public void salvar() {
////		PedidoController pedido = new PedidoController();
////		CarrinhoController carrinho = new CarrinhoController();
//		Usuario usuario = (Usuario) Session.getInstance().getAttribute("usuarioLogado");
//		if (getEntity() == null)
//			setEntity(new FormaPagamento());
//		getEntity().setNome(usuario.getNome());
////		carrinho.salvar();
////		pedido.salvar();
//		super.salvar();
//	}

	@Override
	public FormaPagamento getEntity() {
		if (entity == null) {
			entity = new FormaPagamento();
		}
		System.out.println(entity.toString());
		return entity;
	}
}