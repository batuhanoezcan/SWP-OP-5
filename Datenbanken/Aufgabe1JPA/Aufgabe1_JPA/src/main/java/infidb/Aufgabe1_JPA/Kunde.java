package infidb.Aufgabe1_JPA;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Kunde {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Setter
	@Getter
	private long id;
	@Setter
	@Getter
	private String titelv;
	@Setter
	@Getter
	private String vorname;
	@Setter
	@Getter
	private String nachname;
	@Setter
	@Getter
	private String titeln;
	
	public Kunde() {
		super();
	}

	public Kunde(String titelv, String vorname, String nachname, String titeln) {
		super();
		this.titelv = titelv;
		this.vorname = vorname;
		this.nachname = nachname;
		this.titeln = titeln;
	}

	@Override
	public String toString() {
		return "Kunde [id=" + id + ", titelv=" + titelv + ", vorname=" + vorname + ", nachname=" + nachname
				+ ", titeln=" + titeln + "]";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitelv() {
		return titelv;
	}

	public void setTitelv(String titelv) {
		this.titelv = titelv;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public String getNachname() {
		return nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	public String getTiteln() {
		return titeln;
	}

	public void setTiteln(String titeln) {
		this.titeln = titeln;
	}
	
	

}
