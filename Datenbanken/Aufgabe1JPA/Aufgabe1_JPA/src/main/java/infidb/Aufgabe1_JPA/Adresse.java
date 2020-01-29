package infidb.Aufgabe1_JPA;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Adresse {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Setter
	@Getter
	private long id;
	@Setter
	@Getter
	private String stadt;
	@Setter
	@Getter
	private String strasse;
	@Setter
	@Getter
	private int plz;
	@Setter
	@Getter
	private String hnr;
	
	public Adresse() {
		super();
	}

	public Adresse(String stadt, String strasse, int plz, String hnr) {
		super();
		this.stadt = stadt;
		this.strasse = strasse;
		this.plz = plz;
		this.hnr = hnr;
	}

	@Override
	public String toString() {
		return "Adresse [id=" + id + ", stadt=" + stadt + ", strasse=" + strasse + ", plz=" + plz + ", hnr=" + hnr
				+ "]";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getStadt() {
		return stadt;
	}

	public void setStadt(String stadt) {
		this.stadt = stadt;
	}

	public String getStrasse() {
		return strasse;
	}

	public void setStrasse(String strasse) {
		this.strasse = strasse;
	}

	public int getPlz() {
		return plz;
	}

	public void setPlz(int plz) {
		this.plz = plz;
	}

	public String getHnr() {
		return hnr;
	}

	public void setHnr(String hnr) {
		this.hnr = hnr;
	}
	
	

}
