package ProjetShopBoot.entities;

import javax.persistence.Embeddable;

@Embeddable
public class Facture {
	private double tva ;
	private TypePaiment typePaiement;
	private double remise;
	
	public Facture() {
		
	}
	
	public Facture(double tva, TypePaiment typePaiement, double remise) {
		this.tva = tva;
		this.typePaiement = typePaiement;
		this.remise = remise;
	}
	public double getTva() {
		return tva;
	}
	public void setTva(double tva) {
		this.tva = tva;
	}
	public TypePaiment getTypePaiement() {
		return typePaiement;
	}
	public void setTypePaiement(TypePaiment typePaiement) {
		this.typePaiement = typePaiement;
	}
	public double getRemise() {
		return remise;
	}
	public void setRemise(double remise) {
		this.remise = remise;
	}	
}
