package controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.PrimeFaces;

import model.ItemPedido;
import model.Produto;
import model.Usuario;
import repository.ProdutoRepository;

@Named
@ViewScoped
public class VendaProdutoController implements Serializable {

	private static final long serialVersionUID = 2230641043240396866L;
	private String nome;
	private List<Produto> listaProduto = null;
	private Usuario usuario;
	private Produto produto;
	int quant;
	Double valorCarrinho = 0.00;

	private ItemPedido itemPedido;

	public ItemPedido getItemPedido() {
		return itemPedido;
	}

	public void setItemPedido(ItemPedido itemPedido) {
		this.itemPedido = itemPedido;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public void pesquisar() {
		ProdutoRepository repo = new ProdutoRepository();
		setListaProduto(repo.findByNome(getNome()));
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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setListaProduto(List<Produto> listaProduto) {
		this.listaProduto = listaProduto;
	}

	public String descricao(int idproduto) {
		ProdutoRepository repo = new ProdutoRepository();
		produto = repo.findById(idproduto);
		Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
		flash.put("produtoFlash", produto);

		return "descricao.xhtml?faces-redirect=true";
	}

	public void clearMultiViewState() {
		FacesContext context = FacesContext.getCurrentInstance();
		String viewId = context.getViewRoot().getViewId();
		PrimeFaces.current().multiViewState().clearAll(viewId, true, (clientId) -> {
			showMessage(clientId);
		});
	}

	private void showMessage(String clientId) {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, clientId + " multiview state has been cleared out", null));
	}
}
