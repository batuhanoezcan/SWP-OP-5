package infidb.Aufgabe1_JPA;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class Embed_ID implements Serializable {
	private int bestell_id;
	private int artikel_id;
	
	public Embed_ID()
	{
		super();
	}
	
	public Embed_ID(int bestellung_id, int artikel_id)
	{
		this.bestell_id = bestell_id;
		this.artikel_id = artikel_id;
	}
	
	
	public int getBestell_id() {
		return bestell_id;
	}

	public void setBestell_id(int bestell_id) {
		this.bestell_id = bestell_id;
	}

	public int getArtikel_id() {
		return artikel_id;
	}

	public void setArtikel_id(int artikel_id) {
		this.artikel_id = artikel_id;
	}

	
	
	@Override
	public String toString() {
		return "Embed_ID [bestell_id=" + bestell_id + ", artikel_id=" + artikel_id + "]";
	}

	@Override
	public int hashCode() {
		return 0;
	}
 
	@Override
	public boolean equals(Object obj) {
		return true;
	}
}
