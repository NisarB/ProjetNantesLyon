package ProjetShopBoot.entities;

import javax.persistence.Embeddable;

import com.fasterxml.jackson.annotation.JsonView;

@Embeddable
public class Facture {

	@JsonView(JsonViews.Commande.class)
	private double tva;

	@JsonView(JsonViews.Commande.class)
	private TypePaiment typePaiement;

	@JsonView(JsonViews.Commande.class)
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
