package controller.listing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.PrimeFaces;

import model.Produto;
import repository.ProdutoRepository;

@Named
@ViewScoped
public class ProdutoListing extends Listing<Produto> {

	private static final long serialVersionUID = 2921753168434872389L;
	private List<Produto> list;
	private String filtro;
	

	public ProdutoListing() {
		super(Produto.class);
	}
	
	public void open() {
		Map<String,Object> options = new HashMap<String, Object>();
        options.put("resizable", true);
        options.put("draggable", true);
        options.put("modal", true);
        options.put("width", 800);
        options.put("height", 500);
        options.put("contentWidth", "100%");
        options.put("contentHeight", "100%");  
        // ligacao com a pagina xhtml
        PrimeFaces.current().dialog().openDynamic("produtolisting", options, null);
	}

	public void pesquisar() {
		ProdutoRepository repo = new ProdutoRepository();
		setList(repo.findByNome(getFiltro()));
	}
	

	public List<Produto> getList() {
		if (list == null)
			list = new ArrayList<Produto>();
		return list;
	}

	public void setList(List<Produto> list) {
		this.list = list;
	}

	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}

}
