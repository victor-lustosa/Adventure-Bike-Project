package controller.listing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.PrimeFaces;

import model.ServicoPrestado;
import repository.ServicoPrestadoRepository;

@Named
@ViewScoped
public class ServicoPrestadoListing extends Listing<ServicoPrestado> {

	private static final long serialVersionUID = -2853437258107472756L;
	private List<ServicoPrestado> list;
	private String filtro;

	public ServicoPrestadoListing() {
		super(ServicoPrestado.class);
	}

	public void open() {
		Map<String, Object> options = new HashMap<String, Object>();
		options.put("resizable", true);
		options.put("draggable", true);
		options.put("modal", true);
		options.put("width", 800);
		options.put("height", 500);
		options.put("contentWidth", "100%");
		options.put("contentHeight", "100%");
		// ligacao com a pagina xhtml
		PrimeFaces.current().dialog().openDynamic("servicoprestadolisting", options, null);
	}

	public void pesquisar() {
		ServicoPrestadoRepository repo = new ServicoPrestadoRepository();
		setList(repo.findByNome(getFiltro()));
	}

	public List<ServicoPrestado> getList() {
		if (list == null)
			list = new ArrayList<ServicoPrestado>();
		return list;
	}

	public void setList(List<ServicoPrestado> list) {
		this.list = list;
	}

	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}

}
