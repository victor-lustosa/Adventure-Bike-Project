package converter.jsf;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import model.Cidade;
import repository.CidadeRepository;

@FacesConverter(forClass = Cidade.class)
public class CidadeConverter implements Converter<Cidade>{

	@Override
	public Cidade getAsObject(FacesContext context, UIComponent component, String value) {
		if (value == null || value.trim().isEmpty())
			return null;
		CidadeRepository repo = new CidadeRepository();
		return repo.findById(Integer.valueOf(value));
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Cidade value) {
		if (value == null || value.getId() == null)
			return null;
		
		return value.getId().toString();
	}

}
