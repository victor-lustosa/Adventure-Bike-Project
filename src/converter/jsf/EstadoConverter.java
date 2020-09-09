package converter.jsf;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import model.Estado;
import repository.EstadoRepository;

@FacesConverter(forClass = Estado.class)
public class EstadoConverter implements Converter<Estado>{

	@Override
	public Estado getAsObject(FacesContext context, UIComponent component, String value) {
		if (value == null || value.trim().isEmpty())
			return null;
		EstadoRepository repo = new EstadoRepository();
		return repo.findById(Integer.valueOf(value));
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Estado value) {
		if (value == null || value.getId() == null)
			return null;
		
		return value.getId().toString();
	}

}
