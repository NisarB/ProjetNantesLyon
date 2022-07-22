package projetShop.entities;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "commande")
@SequenceGenerator(name = "seqCommande", sequenceName = "seq_commande", initialValue = 100, allocationSize = 1)
@NamedQueries({})

public class Commande {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqCommande")
	@Column(name = "id_commande")
	private Long id_com;
	@Column(name = "date_commande")
	private LocalDate date_com;
	@ManyToOne
	@JoinColumn(name = "commande_id_client", foreignKey = @ForeignKey(name = "commande_id_client_fk"))
	private Client client;
	@OneToMany(mappedBy = "id.commande")
	private Set<ListeArticle> articles;
	@Embedded
	private Facture facture;

	public Commande() {
	}

	public Commande(LocalDate date_com, Client client, Set<ListeArticle> articles, Facture facture) {
		this.date_com = date_com;
		this.client = client;
		this.articles = articles;
		this.facture = facture;
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
