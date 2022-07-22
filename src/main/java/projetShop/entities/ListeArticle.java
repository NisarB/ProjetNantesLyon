package projetShop.entities;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "liste_article")
public class ListeArticle {
	@EmbeddedId
	private ListeArticlekey id;
	@Column(name = "liste_article_quantite")
	private int quantite;

	public ListeArticle() {
	}

	public ListeArticle(ListeArticlekey id, int quantite) {
		this.id = id;
		this.quantite = quantite;
	}

	public ListeArticlekey getId() {
		return id;
	}

	public void setId(ListeArticlekey id) {
		this.id = id;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

}
