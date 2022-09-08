package ProjetShopBoot.entities;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "liste_article")
public class ListeArticle {
	@JsonView(JsonViews.ListeArticle.class)
	@EmbeddedId
	private ListeArticleKey id;
	
	@JsonView(JsonViews.ListeArticle.class)
	@Column(name = "liste_article_quantite")
	private int quantite;

	public ListeArticle() {
	}

	public ListeArticle(ListeArticleKey id, int quantite) {
		this.id = id;
		this.quantite = quantite;
	}

	public ListeArticleKey getId() {
		return id;
	}

	public void setId(ListeArticleKey id) {
		this.id = id;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

}
