package controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import controller.listing.TipoRevisaoListing;
import model.TipoRevisao;

@Named
@ViewScoped
public class TipoRevisaoController extends Controller<TipoRevisao> {
	private String filtro;
	private List<TipoRevisao> listaTipoRevisao;

	private static final long serialVersionUID = -3111377090925332626L;

	@Override
	public TipoRevisao getEntity() {
		if (entity == null) {
			entity = new TipoRevisao();
		}
		return entity;
	}

	public List<TipoRevisao> getListaTipoRevisao() {
		if (listaTipoRevisao == null)
			listaTipoRevisao = new ArrayList<TipoRevisao>();
		return listaTipoRevisao;
	}

	public void abrirTipoRevisaoListing() {
		TipoRevisaoListing listing = new TipoRevisaoListing();
		listing.open();
	}

	public void obterTipoRevisaoListing(SelectEvent event) {
		TipoRevisao entity = (TipoRevisao) event.getObject();
		setEntity(entity);
	}

	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}

}
