package infidb.Aufgabe1_JPA;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Bestellung_v3 {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Setter
	@Getter
	private long id;
	@Setter
	@Getter
	private int kunde_id;
	@Setter
	@Getter
	private int adresse_rechnung_id;
	@Setter
	@Getter
	private int adresse_liefer_id;
	
	public Bestellung_v3() {
		super();

	}

	public Bestellung_v3(int kunde_id, int adresse_rechnung_id, int adresse_liefer_id) {
		super();
		this.kunde_id = kunde_id;
		this.adresse_rechnung_id = adresse_rechnung_id;
		this.adresse_liefer_id = adresse_liefer_id;
	}

	@Override
	public String toString() {
		return "Bestellung_v3 [id=" + id + ", kunde_id=" + kunde_id + ", adresse_rechnung_id=" + adresse_rechnung_id
				+ ", adresse_liefer_id=" + adresse_liefer_id + "]";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getKunde_id() {
		return kunde_id;
	}

	public void setKunde_id(int kunde_id) {
		this.kunde_id = kunde_id;
	}

	public int getAdresse_rechnung_id() {
		return adresse_rechnung_id;
	}

	public void setAdresse_rechnung_id(int adresse_rechnung_id) {
		this.adresse_rechnung_id = adresse_rechnung_id;
	}

	public int getAdresse_liefer_id() {
		return adresse_liefer_id;
	}

	public void setAdresse_liefer_id(int adresse_liefer_id) {
		this.adresse_liefer_id = adresse_liefer_id;
	}
	
	
	
}
