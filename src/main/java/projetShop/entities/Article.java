package projetShop.entities;

import java.util.List;

public class Article {

	private Integer id_prod;
	private String nom;
	private String description;
	private double prix;
	private double note;
	private Integer quantite;
	private Categorie categorie;
	private List<Avis> avis;

	public Article() {
	}

	public void ajouterAvis() {
	}

	public void supprimerAvis() {
	}

	public Integer getId_prod() {
		return id_prod;
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
		return quantite;
	}

	public void setQuantite(Integer quantite) {
		this.quantite = quantite;
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

}
