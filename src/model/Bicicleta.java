package model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Bicicleta extends Produto {

	private static final long serialVersionUID = -6720114476341967519L;
	@Column(nullable = false)
	private Modalidade modalidade;
	@Column(nullable = false)
	private QuantMarcha quantMarcha;

	public Modalidade getModalidade() {
		return modalidade;
	}

	public void setModalidade(Modalidade modalidade) {
		this.modalidade = modalidade;
	}

	public QuantMarcha getQuantMarcha() {
		return quantMarcha;
	}

	public void setQuantMarcha(QuantMarcha quantMarcha) {
		this.quantMarcha = quantMarcha;
	}

	@Override
	public String toString() {
		;
		return super.toString() + "Bicicleta [modalidade=" + modalidade + ", quantMarcha=" + quantMarcha + "]";
	}

}