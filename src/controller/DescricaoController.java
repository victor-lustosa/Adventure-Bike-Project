package controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import application.Session;
import application.Util;
import model.ItemPedido;
import model.Produto;
import repository.ProdutoRepository;

@Named
@ViewScoped
public class DescricaoController implements Serializable {

	private static final long serialVersionUID = 6787464323324498154L;
	private Produto produto;
	private List<Produto> listaProduto = null;
	private String nome;
	int quant;
	Double valorCarrinho = 0.00;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setListaProduto(List<Produto> listaProduto) {
		this.listaProduto = listaProduto;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public void pesquisar() {
		ProdutoRepository repo = new ProdutoRepository();
		setListaProduto(repo.findByNome(getNome()));
	}

	public DescricaoController() {
		Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
		flash.keep("pacienteFlash");
		setProduto((Produto) flash.get("produtoFlash"));
	}

	public Double comprar(int idProduto) {
		ProdutoRepository repo = new ProdutoRepository();
		Produto produto = repo.findById(idProduto);
		if (Session.getInstance().getAttribute("carrinho") == null) {
			Session.getInstance().setAttribute("carrinho", new ArrayList<ItemPedido>());
		}

		List<ItemPedido> carrinho = (ArrayList<ItemPedido>) Session.getInstance().getAttribute("carrinho");

		ItemPedido item = new ItemPedido();
		item.setProduto(produto);
		item.setValor(produto.getValor());
		carrinho.add(item);
		int i = 0;
		for (ItemPedido itemPedido : carrinho) {
			System.out.println(itemPedido.getProduto().toString());

			valorCarrinho = valorCarrinho + carrinho.get(i).getValor();
			quant = quant + carrinho.get(i).getQuantidade();
			i = i + 1;
			System.out.println("carrinho:" + carrinho.toString());
			System.out.println("quant: " + quant);
			System.out.println("valor do carrinho: " + valorCarrinho);

		}
		Session.getInstance().setAttribute("carrinho", carrinho);
		System.out.println(item.toString());
		Util.addMessageInfo("Produto adicionado no carrinho. " + "Quantidade de Itens: " + carrinho.size());
		return valorCarrinho;

	}

	public List<Produto> getListaProduto() {
		ProdutoRepository repo = new ProdutoRepository();
		if (listaProduto == null) {
			listaProduto = new ArrayList<Produto>();
			listaProduto = repo.findByAll();
			return listaProduto;
		} else {
			listaProduto = repo.findByNome(getNome());
			return listaProduto;
		}
	}
}
