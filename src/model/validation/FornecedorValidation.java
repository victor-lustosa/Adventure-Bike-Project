package model.validation;

import application.ValidationException;
import model.Fornecedor;
import repository.FornecedorRepository;

public class FornecedorValidation implements Validation<Fornecedor> {

	@Override
	public void validate(Fornecedor entity) throws ValidationException {

	}

	private void validaCnpj(Fornecedor entity) throws ValidationException {
		FornecedorRepository repo = new FornecedorRepository();
		if (repo.containsCnpj(entity.getId(), entity.getCnpj())) {
			throw new ValidationException("CNPJ Invalido . Este CNPJ ja esta sendo utilizado por outro fornecedor.");
		}

	}

}
