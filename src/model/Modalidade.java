package model;

public enum Modalidade {

	URBANA(0, "Urbana"), BMX(1, "BMX"), ESTRADA(2, "Estrada"), DOWNHILL(3, "Downhill");

	private int id;
	private String label;

	private Modalidade(int id, String label) {
		this.id = id;
		this.label = label;

	}

	public int getId() {
		return id;
	}

	public String getLabel() {
		return label;
	}

	public static Modalidade valueOf(int valor) {
		for (Modalidade bicicleta : Modalidade.values()) {
			if (valor == bicicleta.getId())
				return bicicleta;
		}
		return null;
	}

}