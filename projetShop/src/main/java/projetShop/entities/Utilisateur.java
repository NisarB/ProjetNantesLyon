package projetShop.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@MappedSuperclass

@Entity
@Table(name = "Utilisateur")
@SequenceGenerator(name = "seqUtilisateur", 
					sequenceName = "seq_utilisateur",
					allocationSize = 1, initialValue = 100)
public abstract class Utilisateur {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqPersonne")
	private Long id;
	@Column(name = "password")
	private String password;
	@Column(name="Username")
	private String Username;
	
	public Utilisateur() {
		
	}
	public Utilisateur(Long id) {
		this.id = id;
		
	}
	
	public Utilisateur(String password,String Username) {
		this.password = password;
		this.Username=Username;
	}
	protected Long getId() {
		return id;
	}
	protected void setId(Long id) {
		this.id = id;
	}
	protected String getUsername() {
		return Username;
	}
	protected void setUsername(String username) {
		Username = username;
	}
	protected String getPassword() {
		return password;
	}
	protected void setPassword(String password) {
		this.password = password;
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
		Utilisateur other = (Utilisateur) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
