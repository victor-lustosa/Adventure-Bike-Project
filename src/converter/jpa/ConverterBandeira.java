package converter.jpa;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import model.Bandeira;

@Converter(autoApply = true)
public class ConverterBandeira implements AttributeConverter<Bandeira, Integer> {

	@Override
	public Integer convertToDatabaseColumn(Bandeira bandeira) {
		return bandeira.getId();
	}

	@Override
	public Bandeira convertToEntityAttribute(Integer value) {
		if (value == null) 
			return null;
		return Bandeira.valueOf(value);
	}
}
