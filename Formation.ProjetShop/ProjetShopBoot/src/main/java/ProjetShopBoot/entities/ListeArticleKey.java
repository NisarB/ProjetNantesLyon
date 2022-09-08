package ProjetShopBoot.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonView;

@Embeddable
public class ListeArticleKey implements Serializable {
	@JsonView(JsonViews.ListeArticle.class)
	@ManyToOne
	@JoinColumn(name = "liste_article_commande_id", foreignKey = @ForeignKey(name = "liste_article_commande_id_fk"))
	private Commande commande;
	@JsonView(JsonViews.ListeArticle.class)
	@ManyToOne
	@JoinColumn(name = "liste_article_article_id", foreignKey = @ForeignKey(name = "liste_article_article_id_fk"))
	private Article article;

	public ListeArticleKey() {
	}

	public ListeArticleKey(Commande commande, Article article) {
		this.commande = commande;
		this.article = article;
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

	@Override
	public int hashCode() {
		return Objects.hash(article, commande);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ListeArticleKey other = (ListeArticleKey) obj;
		return Objects.equals(article, other.article) && Objects.equals(commande, other.commande);
	}

}
