package ProjetShopBoot.entities;

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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "commande")
@SequenceGenerator(name = "seqCommande", sequenceName = "seq_commande", initialValue = 100, allocationSize = 1)

public class Commande {

	@JsonView({ JsonViews.ListeArticle.class, JsonViews.Base.class, JsonViews.Commande.class })
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqCommande")
	@Column(name = "id_commande")
	private Long id;

	@JsonView(JsonViews.Commande.class)
	@Column(name = "date_commande")
	private LocalDate date;

	@JsonView(JsonViews.Commande.class)
	@ManyToOne
	@JoinColumn(name = "commande_id_client", foreignKey = @ForeignKey(name = "commande_id_client_fk"))
	private Client client;

	@JsonView(JsonViews.Commande.class)
	@OneToMany(mappedBy = "id.commande")
	private Set<ListeArticle> articles;

	@JsonView(JsonViews.Commande.class)
	@Embedded
	private Facture facture;

	@Version
	private long version;

	public Commande() {

	}

	public Commande(Long id, LocalDate date, Client client, Set<ListeArticle> articles, Facture facture, long version) {
		this.id = id;
		this.date = date;
		this.client = client;
		this.articles = articles;
		this.facture = facture;
		this.version = version;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
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

	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
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
		return Objects.equals(id, other.id);
	}

}
