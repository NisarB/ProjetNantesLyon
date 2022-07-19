package projetShop.entities;

import java.util.Objects;

public class Avis {

	private AvisKey id;
	private String avis;
	private double note;
	
	public Avis() {
	}
	

	public AvisKey getId() {
		return id;
	}


	public String getAvis() {
		return avis;
	}

	public void setAvis(String avis) {
		this.avis = avis;
	}

	public double getNote() {
		return note;
	}

	public void setNote(double note) {
		this.note = note;
	}

	@Override
	public int hashCode() {
		return Objects.hash(avis);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Avis other = (Avis) obj;
		return Objects.equals(avis, other.avis);
	}
	
	
	
}
