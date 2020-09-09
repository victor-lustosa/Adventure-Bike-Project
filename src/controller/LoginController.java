package controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import application.Session;
import application.Util;
import model.Usuario;
import repository.UsuarioRepository;

@Named
@RequestScoped
public class LoginController {

	private Usuario usuario;

	public String logar() {
		UsuarioRepository repo = new UsuarioRepository();
		String hashSenha = Util.hashSHA256(getUsuario().getSenha());
		Usuario usuario = repo.verificarLoginSenha(getUsuario().getEmail(), hashSenha);

		if (usuario != null) {
			Session.getInstance().setAttribute("usuarioLogado", usuario);
			if (usuario.getPerfil().getId() == 0)
				return "pages/produto.xhtml?faces-redirect=true";
			else
				return "pages/vendaproduto.xhtml?faces-redirect=true";

		}
		Util.addMessageError("Login ou Senha invalido.");
		return "";
	}

	public String cadastrar() {
		return "cadastrarcliente.xhtml?faces-redirect=true";
	}

	

	public void limpar() {
		usuario = new Usuario();
	}

	public Usuario getUsuario() {
		if (usuario == null)
			usuario = new Usuario();
		return usuario;
	}
}
