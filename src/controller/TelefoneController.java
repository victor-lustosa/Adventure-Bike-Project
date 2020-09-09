package controller;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import controller.listing.TelefoneListing;
import model.Telefone;


@Named
@ViewScoped
public class TelefoneController extends Controller<Telefone> {

	private static final long serialVersionUID = 8881610383057468107L;

	@Override
	public Telefone getEntity() {
		if (entity == null) {
			entity = new Telefone();
		}
		return entity;
	}
	
	public void abrirTelefoneListing() {
		TelefoneListing listing = new TelefoneListing();
		listing.open();
	}
	
	public void obterTelefoneListing(SelectEvent event) {
        Telefone entity = (Telefone) event.getObject();
        setEntity(entity);
    }

}
