package projetShop.entities;

import javax.persistence.Embeddable;

@Embeddable
public class Facture {
	private double tva ;
	private TypePaiment typePaiement;
	private double remise;
}
