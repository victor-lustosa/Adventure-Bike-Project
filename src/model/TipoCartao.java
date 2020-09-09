package model;

public enum TipoCartao {

	DEBITO(0, "debito"), CLIENTE(1, "credito");

	private int id;
	private String label;

	private TipoCartao(int id, String label) {
		this.id = id;
		this.label = label;
		}

	public int getId() {
		return id;
	}

	public String getLabel() {
		return label;
	}

	public static TipoCartao valueOf(int valor) {
		for (TipoCartao cartao : TipoCartao.values()) {
			if (valor == cartao.getId())
				return cartao;
		}
		return null;
	}

}
