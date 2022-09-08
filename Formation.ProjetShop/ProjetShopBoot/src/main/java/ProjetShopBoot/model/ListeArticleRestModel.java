package ProjetShopBoot.model;

import ProjetShopBoot.entities.Article;
import ProjetShopBoot.entities.Commande;

public class ListeArticleRestModel {
	private Commande commande;
	private Article article;
	private int quantite;
	
	public ListeArticleRestModel() {
	}
	
	public Commande getCommande() {
		return commande;
	}
	public void setCommande(Commande commande) {
		this.commande = commande;
	}
	public Article getArticle() {
		return article;
	}
	public void setArticle(Article article) {
		this.article = article;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	
	
}
