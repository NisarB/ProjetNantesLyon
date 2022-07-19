package projetShop.entities;

import java.util.Objects;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Client")
@SequenceGenerator(name = "seqUtilisateur", sequenceName = "seq_client", initialValue = 100, allocationSize = 1)

@AttributeOverrides({ @AttributeOverride(name = "id", column = @Column(name = "client_id", length = 55)),
	@AttributeOverride(name = "password", column = @Column(name = "client_password", length = 255))})
		
public class Client extends Utilisateur{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqClient")
	@Column(name="nom")
	private String nom;
	@Column(name="prenom")
	private String prenom;
	@Column(name="mail")
	private String mail;
	@Column(name="Tel")
	private String tel;
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "numero", column = @Column(name = "client_numero", length = 50)),
			@AttributeOverride(name = "rue", column = @Column(name = "client_rue", length = 60)),
			@AttributeOverride(name = "codePostal", column = @Column(name = "client_cp", length = 50)),
			@AttributeOverride(name = "ville", column = @Column(name = "client_ville", length = 60))})
	private Adresse adresse;
	
	public Client() {
		
	}

	public Client(Long id,String nom, String prenom, String mail, String tel, Adresse adresse) {
		super(id);
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.tel = tel;
		this.adresse = adresse;
	}

	
	protected String getNom() {
		return nom;
	}

	protected void setNom(String nom) {
		this.nom = nom;
	}

	protected String getPrenom() {
		return prenom;
	}

	protected void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	protected String getMail() {
		return mail;
	}

	protected void setMail(String mail) {
		this.mail = mail;
	}

	protected String getTel() {
		return tel;
	}

	protected void setTel(String tel) {
		this.tel = tel;
	}

	protected Adresse getAdresse() {
		return adresse;
	}

	protected void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	

	
	
	
	
}
