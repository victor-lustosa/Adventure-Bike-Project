package controller.listing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.PrimeFaces;

import model.Cidade;
import repository.CidadeRepository;

@Named
@ViewScoped
public class CidadeListing extends Listing<Cidade> {

	private static final long serialVersionUID = 2921753168434872389L;
	private List<Cidade> list;
	private String filtro;
	private Integer filtroIdEstado = null;
	
	public CidadeListing() {
		super(Cidade.class);
		// obtendo a informacao da sessao e remover o objeto da sessao
		//filtroIdEstado = (Integer) Session.getInstance().getAttributeAndRemove("idEstado");
		filtroIdEstado = (Integer) getObjectSession("idEstado");
	}
	
	public void open() {
		open(null);
	}
	
	public void open(Integer idEstado) {
		if (idEstado != null) {
			// adicionando o idEstado na sessao
//			Session.getInstance().setAttribute("idEstado", idEstado);
			addObjectSession("idEstado", idEstado);
		}
		
		Map<String,Object> options = new HashMap<String, Object>();
        options.put("resizable", true);
        options.put("draggable", true);
        options.put("modal", true);
        options.put("width", 800);
        options.put("height", 500);
        options.put("contentWidth", "100%");
        options.put("contentHeight", "100%");

        // ligacao com a pagina xhtml
        PrimeFaces.current().dialog().openDynamic("cidadelisting", options, null);
        
	}

	public void pesquisar() {
		
		CidadeRepository repo = new CidadeRepository();
		if (getFiltroIdEstado() == null)
			setList(repo.findByNome(getFiltro()));
		else
			setList(repo.findByNome(getFiltro(), getFiltroIdEstado()));
	}
	
	
	public List<Cidade> getList() {
		if (list == null)
			list = new ArrayList<Cidade>();
		return list;
	}

	public void setList(List<Cidade> list) {
		this.list = list;
	}

	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}

	public Integer getFiltroIdEstado() {
		return filtroIdEstado;
	}

	public void setFiltroIdEstado(Integer filtroIdEstado) {
		this.filtroIdEstado = filtroIdEstado;
	}

}
