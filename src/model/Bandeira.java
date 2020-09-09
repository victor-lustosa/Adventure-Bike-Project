package model;

public enum Bandeira {

	VISA(0, "visa"), MASTER_CARD(1, "mastercard"), ELO(2, "elo");

	private int id;
	private String label;

	private Bandeira(int id, String label) {
		this.id = id;
		this.label = label;
	}

	public int getId() {
		return id;
	}

	public String getLabel() {
		return label;
	}

	public static Bandeira valueOf(int valor) {
		for (Bandeira bandeira : Bandeira.values()) {
			if (valor == bandeira.getId())
				return bandeira;
		}
		return null;
	}

}
