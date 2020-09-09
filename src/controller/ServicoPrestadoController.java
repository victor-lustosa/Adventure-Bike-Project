package controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import controller.listing.ServicoPrestadoListing;
import model.ServicoPrestado;

@Named
@ViewScoped
public class ServicoPrestadoController extends Controller<ServicoPrestado> {
	private String filtro;
	private List<ServicoPrestado> listaServicoPrestado;

	private static final long serialVersionUID = -3111377090925332626L;

	@Override
	public ServicoPrestado getEntity() {
		if (entity == null) {
			entity = new ServicoPrestado();
		}
		return entity;
	}

	public List<ServicoPrestado> getListaServicoPrestado() {
		if (listaServicoPrestado == null)
			listaServicoPrestado = new ArrayList<ServicoPrestado>();
		return listaServicoPrestado;
	}

	public void abrirServicoPrestadoListing() {
		ServicoPrestadoListing listing = new ServicoPrestadoListing();
		listing.open();
	}

	public void obterServicoPrestadoListing(SelectEvent event) {
		ServicoPrestado entity = (ServicoPrestado) event.getObject();
		setEntity(entity);
	}

	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}

}
