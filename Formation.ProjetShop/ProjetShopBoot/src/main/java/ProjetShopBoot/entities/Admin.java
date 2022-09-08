package ProjetShopBoot.entities;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "admin")
@SequenceGenerator(name = "seqUtilisateur", sequenceName = "seq_admin", initialValue = 100, allocationSize = 1)

public class Admin extends Utilisateur {
	
	@Version
	private long version;
	
	public Admin() {
	}

//	public void ajouterArticle(Article article) {
//	}
//
//	public void supprimerArticle(Article article) {
//	}
//
//	public void modifierArticle(Article article) {
//	}
//
//	public void Inventaire(Article article) {
//	}

}
