package controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import application.Util;
import controller.listing.FornecedorListing;
import controller.listing.ProdutoListing;
import model.Estoque;
import model.Fornecedor;
import model.Produto;
import model.Telefone;
import repository.EstoqueRepository;

@Named
@ViewScoped
public class EstoqueController extends Controller<Estoque> {

	private static final long serialVersionUID = -6051599150675827361L;
	private List<Estoque> listaEstoque = null;

	@Override
	public Estoque getEntity() {
		if (entity == null) {
			entity = new Estoque();
			entity.setFornecedor(new Fornecedor());
			entity.getFornecedor().setTelefone(new Telefone());
		}
		return entity;
	}

	public List<Estoque> getListaEstoque() {
		if (listaEstoque == null) {
			listaEstoque = new ArrayList<Estoque>();
			EstoqueRepository repo = new EstoqueRepository();
			listaEstoque = repo.findAll();
		}
		return listaEstoque;
	}

	public void setListaEstoque(List<Estoque> listaEstoque) {
		this.listaEstoque = listaEstoque;
	}

	public void abrirFornecedorListing() {
		FornecedorListing listing = new FornecedorListing();
		listing.open();
	}

	public void obterFornecedorListing(SelectEvent event) {
		Fornecedor entity = (Fornecedor) event.getObject();
		getEntity().setFornecedor(entity);
	}

	public void abrirProdutoListing() {
		ProdutoListing listing = new ProdutoListing();
		listing.open();
	}

	public void obterProdutoListing(SelectEvent event) {
		Produto entity = (Produto) event.getObject();
		getEntity().setProduto(entity);
	}

	public void redireciona() {
		Util.redirect("/faces/pages/entradaestoque.xhtml");
	}
	public void redireciona1() {
		Util.redirect("/faces/pages/estoque.xhtml");
	}

}
