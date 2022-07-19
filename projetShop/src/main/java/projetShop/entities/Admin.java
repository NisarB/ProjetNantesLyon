package projetShop.entities;

import java.util.Objects;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Admin")
@SequenceGenerator(name ="seqUtilisateur", sequenceName = "seq_admin", initialValue = 100, allocationSize = 1)
public class Admin extends Utilisateur {
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqUtilisateur")
	
	@Embedded
	
	@AttributeOverrides({ @AttributeOverride(name = "id", column = @Column(name = "Admin_id")),
			@AttributeOverride(name = "nom", column = @Column(name = "Admin_nom")),
			@AttributeOverride(name = "prenom", column = @Column(name = "Admin_prenom"))})
	private Long id;
	private String nom;
	private String prenom;
	
	public Admin() {
		
	}

	protected Long getId() {
		return id;
	}

	protected void setId(Long id) {
		this.id = id;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(id);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Admin other = (Admin) obj;
		return Objects.equals(id, other.id);
	}
	
	

}
