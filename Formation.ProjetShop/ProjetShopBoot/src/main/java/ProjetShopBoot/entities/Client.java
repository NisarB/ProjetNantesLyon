package ProjetShopBoot.entities;

import java.util.Arrays;

import java.util.Collection;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonView;

@Entity

public class Client extends Utilisateur {
	@JsonView(JsonViews.Base.class)
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqClient")
	@Column(name = "client_id")
	private Long id;

	@JsonView(JsonViews.Base.class)
	@Column(name = "nom_client")
	private String nom;
	@JsonView(JsonViews.Base.class)
	@Column(name = "prenom_client")
	private String prenom;
	@JsonView(JsonViews.Base.class)
	@Column(name = "mail_client")
	private String mail;
	@JsonView(JsonViews.Base.class)
	@Column(name = "tel_client")
	private String tel;

	@AttributeOverrides({
			@AttributeOverride(name = "numero", column = @Column(name = "numero_client", length = 50)),
			@AttributeOverride(name = "rue", column = @Column(name = "rue_client", length = 255)),
			@AttributeOverride(name = "codePostal", column = @Column(name = "CP_client", length = 50)),
			@AttributeOverride(name = "ville", column = @Column(name = "ville_client", length = 255)) })
	@Embedded
	@JsonView(JsonViews.Base.class)
	private Adresse adresse;

	@OneToMany(mappedBy = "client")
	private Set<Commande> commandes;

	public Client() {

	}

	public Client(String nom, String prenom) {
		this.nom = nom;
		this.prenom = prenom;
	}

	public Set<Commande> getCommandes() {
		return commandes;
	}

	public void setCommandes(Set<Commande> commandes) {
		this.commandes = commandes;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

}
