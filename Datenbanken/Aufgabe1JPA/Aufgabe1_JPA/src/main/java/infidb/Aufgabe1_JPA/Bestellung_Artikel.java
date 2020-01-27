package infidb.Aufgabe1_JPA;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
public class Bestellung_Artikel {
	@EmbeddedId
	@Setter
	@Getter
	private Embed_ID id;
	@Setter
	@Getter
	private int menge;
	
	public Bestellung_Artikel() {
		super();

	}

	public Bestellung_Artikel(Embed_ID id,int menge) {
		super();
		this.id = id;
		this.menge = menge;
	}


	@Override
	public String toString() {
		return "Bestellung_Artikel [id=" + id + ", menge=" + menge + "]";
	}

	public int getMenge() {
		return menge;
	}

	public void setMenge(int menge) {
		this.menge = menge;
	}

	
}
