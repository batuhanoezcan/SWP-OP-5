package infidb.Aufgabe1_JPA;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Artikel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Setter
	@Getter
	private long id;
	@Setter
	@Getter
	private String name;
	@Setter
	@Getter
	private double preis;
	
	public Artikel() {
		super();
	}

	public Artikel(String name, double preis) {
		super();
		this.name = name;
		this.preis = preis;
	}

	@Override
	public String toString() {
		return "Artikel [id=" + id + ", name=" + name + ", preis=" + preis + "]";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPreis() {
		return preis;
	}

	public void setPreis(double preis) {
		this.preis = preis;
	}
	
	
	
}
