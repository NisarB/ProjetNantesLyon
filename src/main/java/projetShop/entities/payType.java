package projetShop.entities;

public enum payType {

	CB("Carte bleue"), PayPal("PayPal"), OTHER("Autre");

	private String type;

	private payType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}
}
	