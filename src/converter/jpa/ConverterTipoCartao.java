package converter.jpa;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import model.TipoCartao;

@Converter(autoApply = true)
public class ConverterTipoCartao implements AttributeConverter<TipoCartao, Integer> {

	@Override
	public Integer convertToDatabaseColumn(TipoCartao tipoCartao) {
		return tipoCartao.getId();
	}

	@Override
	public TipoCartao convertToEntityAttribute(Integer value) {
		if (value == null) 
			return null;
		return TipoCartao.valueOf(value);
	}
}
