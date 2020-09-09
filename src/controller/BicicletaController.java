package controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.file.UploadedFile;

import application.Util;
import controller.listing.BicicletaListing;
import controller.listing.MarcaListing;
import controller.listing.TipoProdutoListing;
import model.Bicicleta;
import model.Marca;
import model.Modalidade;
import model.QuantMarcha;
import model.TipoProduto;
import repository.TipoProdutoRepository;

@Named
@ViewScoped
public class BicicletaController extends Controller<Bicicleta> {

	private static final long serialVersionUID = -5541416711085840273L;
	private static final String Bicicleta = null;
	private String filtro;
	private InputStream fotoInputStream = null;
	private String nomeFoto = null;
	private List<TipoProduto> listaTipoProduto = null;

	public void upload(FileUploadEvent event) {

		UploadedFile uploadFile = event.getFile();
		System.out.println("nome arquivo: " + uploadFile.getFileName());
		System.out.println("tipo: " + uploadFile.getContentType());
		System.out.println("tamanho: " + uploadFile.getSize());

		if (uploadFile.getContentType().equals("image/png")) {
			try {
				fotoInputStream = uploadFile.getInputStream();
				nomeFoto = uploadFile.getFileName();
				System.out.println("inputStream: " + uploadFile.getInputStream().toString());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Util.addMessageInfo("Upload realizado com sucesso.");
		} else {
			Util.addMessageError("O tipo da image deve ser png.");
		}

	}

	@Override
	public void salvar() {
		TipoProdutoRepository repo = new TipoProdutoRepository();
		entity.setTipoProduto(repo.retornaTipo("Bicicleta"));
		

		// salvando no banco de dados
		if (salvarEspecial()) {
			// caso nao tenha selecionado a imagem sair do metodo
			if (fotoInputStream == null) {
				limpar();
				Util.addMessageInfo("Cadastro realizado com sucesso");
				return;
			}
			if (Util.saveImageProduto(fotoInputStream, "png", getEntity().getId())) {
				limpar();
				Util.addMessageInfo("Cadastro realizado com sucesso");
				return;
			} else {
				limpar();
				Util.addMessageWarn("O Cadastro foi realizado com sucesso, porem a foto nao foi salva.");
				return;
			}
		}
		Util.addMessageError("Erro ao efetuar o cadastro do professor.");
	}

	public String getNomeFoto() {
		if (nomeFoto == null)
			return "Selecione uma foto ...";
		return "Arquivo: " + nomeFoto + " (Clique para alterar a foto...)";
	}

	@Override
	public Bicicleta getEntity() {
		if (entity == null) {
			entity = new Bicicleta();
			entity.setMarca(new Marca());
			entity.setTipoProduto(new TipoProduto());
		}
		return entity;
	}

	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}

	public void abrirBicicletaListing() {
		BicicletaListing listing = new BicicletaListing();
		listing.open();
	}

	public void obterBicicletaListing(SelectEvent event) {
		Bicicleta entity = (Bicicleta) event.getObject();
		setEntity(entity);
		if (getEntity().getMarca() == null) {
			getEntity().setMarca(new Marca());
		}
		if (getEntity().getTipoProduto() == null) {
			getEntity().setTipoProduto(new TipoProduto());
		}
	}

	public void abrirMarcaListing() {
		MarcaListing listing = new MarcaListing();
		listing.open();
	}

	public void obterMarcaListing(SelectEvent event) {
		Marca entity = (Marca) event.getObject();
		getEntity().setMarca(entity);
	}

	public void abrirTipoProdutoListing() {
		TipoProdutoListing listing = new TipoProdutoListing();
		listing.open();
	}

	public void obterTipoProdutoListing(SelectEvent event) {
		TipoProduto entity = (TipoProduto) event.getObject();
		getEntity().setTipoProduto(entity);
	}

	public Modalidade[] getListaModalidade() {
		return Modalidade.values();
	}

	public QuantMarcha[] getListaQuantMarcha() {
		return QuantMarcha.values();
	}

}