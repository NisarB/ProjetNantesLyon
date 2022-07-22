package projetShop.entities;

public enum TypePaiment {

	CB("Carte bleue"), PayPal("PayPal"), OTHER("Autre");

	private String type;

	private TypePaiment(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}
}
	