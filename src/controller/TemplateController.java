package controller;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import application.Session;
import application.Util;
import model.Usuario;

@Named
@ViewScoped
public class TemplateController implements Serializable {

	private static final long serialVersionUID = -1555344601461039458L;
	private Usuario usuarioLogado = null;

	public Usuario getUsuarioLogado() {
		if (usuarioLogado == null) // buscando o usuario da sessao
			usuarioLogado = (Usuario) Session.getInstance().getAttribute("usuarioLogado");
		return usuarioLogado;
	}

	public void encerrarSessao() {
		// encerrando a sessao
		Session.getInstance().invalidateSession();
		Util.redirect("/faces/login.xhtml");
		// return "login.xhtml?faces-redirect=true";
	}

}
