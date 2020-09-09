package model;

import java.util.ArrayList;
import java.util.List;

public enum Perfil {

	FUNCIONARIO(0, "Funcionario"), CLIENTE(1, "Cliente");

	private int id;
	private String label;
	private List<String> paginasAcesso = null;

	private Perfil(int id, String label) {
		this.id = id;
		this.label = label;
		paginasAcesso = new ArrayList<String>();
		if (id == 0) {
			paginasAcesso.add("pages/usuario.xhtml");
			paginasAcesso.add("pages/usuariolisting.xhtml");
			paginasAcesso.add("pages/fornecedor.xhtml");
			paginasAcesso.add("pages/fornecedorlisting.xhtml");
			paginasAcesso.add("pages/marca.xhtml");
			paginasAcesso.add("pages/marcalisting.xhtml");
			paginasAcesso.add("pages/tiporevisao.xhtml");
			paginasAcesso.add("pages/tipoprodutolisting.xhtml");
			paginasAcesso.add("pages/tipoproduto.xhtml");
			paginasAcesso.add("pages/produto.xhtml");
			paginasAcesso.add("pages/tipoprodutolisting.xhtml");
			paginasAcesso.add("pages/bicicleta.xhtml");
			paginasAcesso.add("pages/bicicletalisting.xhtml");
			paginasAcesso.add("pages/estoque.xhtml");
			paginasAcesso.add("pages/entradaestoque.xhtml");

		} else {
			paginasAcesso.add("pages/vendaproduto.xhtml");
			paginasAcesso.add("pages/descricao.xhtml");
			paginasAcesso.add("pages/formapagamento.xhtml");
			paginasAcesso.add("pages/cartaocredito.xhtml");
			paginasAcesso.add("pages/carrinho.xhtml");
			paginasAcesso.add("pages/boleto.xhtml");

		}

	}

	public List<String> getPaginasAcesso() {
		return paginasAcesso;
	}

	public int getId() {
		return id;
	}

	public String getLabel() {
		return label;
	}

	public static Perfil valueOf(int valor) {
		for (Perfil perfil : Perfil.values()) {
			if (valor == perfil.getId())
				return perfil;
		}
		return null;
	}

}
