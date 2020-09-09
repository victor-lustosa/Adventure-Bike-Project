package controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import controller.listing.TipoProdutoListing;
import model.TipoProduto;

@Named
@ViewScoped
public class TipoProdutoController extends Controller<TipoProduto> {
	private String filtro;
	private List<TipoProduto> listaTipoProduto;

	private static final long serialVersionUID = -3111377090925332626L;

	@Override
	public TipoProduto getEntity() {
		if (entity == null) {
			entity = new TipoProduto();
		}
		return entity;
	}

	public List<TipoProduto> getListaTipoProduto() {
		if (listaTipoProduto == null)
			listaTipoProduto = new ArrayList<TipoProduto>();
		return listaTipoProduto;
	}

	public void abrirTipoProdutoListing() {
		TipoProdutoListing listing = new TipoProdutoListing();
		listing.open();
	}

	public void obterTipoProdutoListing(SelectEvent event) {
		TipoProduto entity = (TipoProduto) event.getObject();
		setEntity(entity);
	}

	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}

}
