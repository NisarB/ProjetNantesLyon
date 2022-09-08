package ProjetShopBoot.entities;

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
import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "article")
@SequenceGenerator(name = "seqArticle", sequenceName = "seq_article", initialValue = 100, allocationSize = 1)
@NamedQueries({})
public class Article {

	@JsonView({ JsonViews.Avis.class, JsonViews.ListeArticle.class, JsonViews.Article.class })
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqArticle")
	@Column(name = "id_article")
	private Long id;

	@JsonView({ JsonViews.Avis.class, JsonViews.ListeArticle.class, JsonViews.Article.class })
	@Column(name = "nom_article", length = 150)
	private String nom;

	@JsonView({ JsonViews.Avis.class, JsonViews.Article.class })
	@Column(name = "description_article", columnDefinition = "TEXT")
	private String description;

	@JsonView({ JsonViews.Avis.class, JsonViews.ListeArticle.class, JsonViews.Article.class })
	@Column(name = "prix_article")
	private double prix;

	@JsonView({ JsonViews.Avis.class, JsonViews.Article.class })
	@Column(name = "note_article")
	private double note;

	@JsonView({ JsonViews.Article.class })
	@Column(name = "stock_article")
	private Integer stock;

	@JsonView({ JsonViews.Article.class })
	@Enumerated(EnumType.STRING)
	private Categorie categorie;

	@JsonView({ JsonViews.Avis.class, JsonViews.Article.class })
	@OneToMany(mappedBy = "id.article")
	private List<Avis> avis;

	public Article() {
	}

	public Article(String nom, double prix, Categorie categorie) {
		this.nom = nom;
		this.prix = prix;
		this.categorie = categorie;
	}

	public void ajouterAvis(Avis avis) {
		this.avis.add(avis);
	}

	public void supprimerAvis() {

	}
	
	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
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
