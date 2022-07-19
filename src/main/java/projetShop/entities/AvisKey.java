package projetShop.entities;

import java.io.Serializable;
import java.util.Objects;

public class AvisKey implements Serializable {
	private Client client;
	private Article article;
	
	public AvisKey() {
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
