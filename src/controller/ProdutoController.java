package controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.file.UploadedFile;

import application.Util;
import controller.listing.MarcaListing;
import controller.listing.ProdutoListing;
import controller.listing.TipoProdutoListing;
import model.Produto;
import model.TipoProduto;
import model.Marca;
import repository.MarcaRepository;

@Named
@ViewScoped
public class ProdutoController extends Controller<Produto> {

	private static final long serialVersionUID = 6787464323324498154L;
	private String filtro;
	private InputStream fotoInputStream = null;
	private String nomeFoto = null;
	
	public void upload(FileUploadEvent event) {
		
		UploadedFile uploadFile =  event.getFile();
		System.out.println("nome arquivo: "+ uploadFile.getFileName());
		System.out.println("tipo: "+ uploadFile.getContentType());
		System.out.println("tamanho: "+ uploadFile.getSize());
		
		if (uploadFile.getContentType().equals("image/png")) {
			try {
				fotoInputStream = uploadFile.getInputStream();
				nomeFoto = uploadFile.getFileName();
				System.out.println("inputStream: "+ uploadFile.getInputStream().toString());
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
		if (salvarEspecial()) {
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
		return "Arquivo: "+ nomeFoto + " (Clique para alterar a foto...)";
	}
	
	@Override
	public Produto getEntity() {
		if (entity == null) {
			entity = new Produto();
			entity.setMarca(new Marca());
		}
		return entity;
	}

	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}

	public void abrirProdutoListing() {
		ProdutoListing listing = new ProdutoListing();
		listing.open();
	}

	public void obterProdutoListing(SelectEvent event) {
		Produto entity = (Produto) event.getObject();
		setEntity(entity);
		if (getEntity().getMarca() == null) {
			getEntity().setMarca(new Marca());
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

}
