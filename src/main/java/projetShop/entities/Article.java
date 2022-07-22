package projetShop.entities;

import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "article")
@SequenceGenerator(name = "seqArticle", sequenceName = "seq_article", initialValue = 100, allocationSize = 1)
@NamedQueries({})
public class Article {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqArticle")
	@Column(name = "id_article")
	private Long id;
	@Column(name = "nom_article", length = 150)
	private String nom;
	@Column(name = "description_article", columnDefinition = "TEXT")
	private String description;
	@Column(name = "prix_article")
	private double prix;
	@Column(name = "note_article")
	private double note;
	@Column(name = "stock_article")
	private Integer stock;
	@Enumerated(EnumType.STRING)
	private Categorie categorie;
	@OneToMany(mappedBy = "id.article")
	private List<Avis> avis;

	public Article() {
	}

	public void ajouterAvis() {
	}

	public void supprimerAvis() {
	}

	public Long getId_prod() {
		return id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public double getNote() {
		return note;
	}

	public void setNote(double note) {
		this.note = note;
	}

	public Integer getQuantite() {
		return stock;
	}

	public void setQuantite(Integer stock) {
		this.stock = stock;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public List<Avis> getAvis() {
		return avis;
	}

	public void setAvis(List<Avis> avis) {
		this.avis = avis;
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
		Article other = (Article) obj;
		return Objects.equals(id, other.id);
	}

}
