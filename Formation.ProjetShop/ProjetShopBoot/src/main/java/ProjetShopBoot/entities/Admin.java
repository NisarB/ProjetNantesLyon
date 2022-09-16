package ProjetShopBoot.entities;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "admin")
@SequenceGenerator(name = "seqUtilisateur", sequenceName = "seq_admin", initialValue = 100, allocationSize = 1)

public class Admin extends Utilisateur {

	public Admin() {
	}

}
