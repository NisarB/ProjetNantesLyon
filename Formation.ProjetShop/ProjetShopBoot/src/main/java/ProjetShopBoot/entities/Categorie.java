package ProjetShopBoot.entities;

public enum Categorie {

	 C1("Categorie 1"), C2("Categorie 2"), CX("Autres");

	private String categorie;
	 
	
	 Categorie(String categorie) {
	}


	public String getCategorie() {
		return categorie;
	}


	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	
	
}
