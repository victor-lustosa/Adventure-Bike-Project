package model;

public enum QuantMarcha {

	VINTE_QUATRO(0, "Vinte quatro"), VINTE_SEIS(1, "Vinte seis"), TRINTA_E_DUAS(2, "Trinta e Duas");

	private int id;
	private String quantidade;

	private QuantMarcha(int id, String quantidade) {
		this.id = id;
		this.quantidade = quantidade;
	}

	public int getId() {
		return id;
	}

	public String getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
	}

	public static QuantMarcha valueOf(int valor) {
		for (QuantMarcha quanMarcha : QuantMarcha.values()) {
			if (valor == quanMarcha.getId())
				return quanMarcha;
		}
		return null;
	}

}