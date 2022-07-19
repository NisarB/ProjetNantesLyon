package projetShop.entities;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Admin")
@SequenceGenerator(name ="seqUtilisateur", sequenceName = "seq_admin", initialValue = 100, allocationSize = 1)
public class Admin extends Utilisateur {
	

}
