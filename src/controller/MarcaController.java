package controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import controller.listing.MarcaListing;
import model.Marca;

@Named
@ViewScoped
public class MarcaController extends Controller<Marca> {
	private String filtro;
	private List<Marca> listaMarca;

	private static final long serialVersionUID = -3111377090925332626L;

	@Override
	public Marca getEntity() {
		if (entity == null) {
			entity = new Marca();
		}
		System.out.println(entity.toString());
		return entity;
	}

	public List<Marca> getListaMarca() {
		if (listaMarca == null)
			listaMarca = new ArrayList<Marca>();
		return listaMarca;
	}

	public void abrirMarcaListing() {
		MarcaListing listing = new MarcaListing();
		listing.open();
	}

	public void obterMarcaListing(SelectEvent event) {
		Marca entity = (Marca) event.getObject();
		setEntity(entity);
	}

	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}

}
