package ProjetShopBoot.model;

import ProjetShopBoot.entities.Article;
import ProjetShopBoot.entities.Client;

public class AvisRestModel {
	
	private Client client;
	private Article article;
	
	private String avis;
	private double note;
	
	public AvisRestModel() {
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public String getAvis() {
		return avis;
	}

	public void setAvis(String avis) {
		this.avis = avis;
	}

	public double getNote() {
		return note;
	}

	public void setNote(double note) {
		this.note = note;
	}
	
	
	
	
}
