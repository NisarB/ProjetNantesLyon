package projetShop.entities;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

public class Commande {
	private Long id_com;
	private LocalDate date_com;
	private Client client;
	private Set<ListeArticle> articles;
	private Facture facture;

	public Commande() {
	}

	public void passerCommande() {
	}

	public void annulerCommande() {
	}

	public Long getId_com() {
		return id_com;
	}

	public void setId_com(Long id_com) {
		this.id_com = id_com;
	}

	public LocalDate getDate_com() {
		return date_com;
	}

	public void setDate_com(LocalDate date_com) {
		this.date_com = date_com;
	}

	public Set<ListeArticle> getArticles() {
		return articles;
	}

	public void setArticles(Set<ListeArticle> articles) {
		this.articles = articles;
	}

	public Facture getFacture() {
		return facture;
	}

	public void setFacture(Facture facture) {
		this.facture = facture;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id_com);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Commande other = (Commande) obj;
		return Objects.equals(id_com, other.id_com);
	}

}
