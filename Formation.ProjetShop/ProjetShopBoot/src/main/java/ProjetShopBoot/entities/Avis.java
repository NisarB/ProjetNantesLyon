package ProjetShopBoot.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "avis")
public class Avis {
	
	@JsonView(JsonViews.Avis.class)
	@EmbeddedId
	private AvisKey id;
	
	@JsonView(JsonViews.Avis.class)
	@Column(name = "avis_article")
	private String avis;
	
	@JsonView(JsonViews.Avis.class)
	@Column(name = "note_article")
	private double note;

	public Avis() {
	}

	public Avis(AvisKey id, String avis, double note) {
		this.id = id;
		this.avis = avis;
		this.note = note;
	}

	public AvisKey getId() {
		return id;
	}

	public void setId(AvisKey id) {
		this.id = id;
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
