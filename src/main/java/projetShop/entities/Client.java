package projetShop.entities;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "client")
@SequenceGenerator(name = "seqUtilisateur", sequenceName = "seq_client", initialValue = 100, allocationSize = 1)

public class Client extends Utilisateur {
	
	@Column(name = "nom_client")
	private String nom;

	@Column(name = "prenom_client")
	private String prenom;

	@Column(name = "mail_client")
	private String mail;

	@Column(name = "tel_client")
	private String tel;
	
	@AttributeOverrides({
		@AttributeOverride(name = "numero", column = @Column(name = "numero_client", length = 50)),
		@AttributeOverride(name = "rue", column = @Column(name = "rue_client", length = 255)),
		@AttributeOverride(name = "codePostal", column = @Column(name = "CP_client", length = 50)),
		@AttributeOverride(name = "ville", column = @Column(name = "ville_client", length = 255)) })
	@Embedded
	private Adresse adresse;
	
	@Version
	private long version;

	public Client() {

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
