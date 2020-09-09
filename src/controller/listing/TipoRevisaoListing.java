package controller.listing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.PrimeFaces;

import model.TipoRevisao;
import repository.TipoRevisaoRepository;

@Named
@ViewScoped
public class TipoRevisaoListing extends Listing<TipoRevisao> {

	private static final long serialVersionUID = -2853437258107472756L;
	private List<TipoRevisao> list;
	private String filtro;

	public TipoRevisaoListing() {
		super(TipoRevisao.class);
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
		PrimeFaces.current().dialog().openDynamic("tiporevisaolisting", options, null);
	}

	public void pesquisar() {
		TipoRevisaoRepository repo = new TipoRevisaoRepository();
		setList(repo.findByNome(getFiltro()));
	}

	public List<TipoRevisao> getList() {
		if (list == null)
			list = new ArrayList<TipoRevisao>();
		return list;
	}

	public void setList(List<TipoRevisao> list) {
		this.list = list;
	}

	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}

}
