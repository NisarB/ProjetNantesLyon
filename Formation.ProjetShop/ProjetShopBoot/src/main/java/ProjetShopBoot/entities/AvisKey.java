package ProjetShopBoot.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonView;

@Embeddable
public class AvisKey implements Serializable {

	@JsonView(JsonViews.Avis.class)
	@ManyToOne
	@JoinColumn(name = "avis_client_id", foreignKey = @ForeignKey(name = "avis_client_id_fk"))
	private Client client;
	@JsonView(JsonViews.Avis.class)
	@ManyToOne
	@JoinColumn(name = "avis_article_id", foreignKey = @ForeignKey(name = "avis_Article_id_fk"))
	private Article article;

	public AvisKey() {
	}

	public AvisKey(AvisKey ak) {
		this.client = ak.client;
		this.article = ak.article;
	}

	public AvisKey(Client client, Article article) {
		this.client = client;
		this.article = article;
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

	@Override
	public int hashCode() {
		return Objects.hash(article, client);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AvisKey other = (AvisKey) obj;
		return Objects.equals(article, other.article) && Objects.equals(client, other.client);
	}

}
