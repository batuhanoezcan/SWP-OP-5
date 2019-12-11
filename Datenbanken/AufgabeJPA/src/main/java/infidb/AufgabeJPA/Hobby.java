package infidb.AufgabeJPA;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Hobby {
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
	private int hoursperweek;
	@Setter
	@Getter
	private double expenses;
	
	public Hobby() {
		super();
	}

	public Hobby(String name, int hoursperweek, double expenses) {
		super();
		this.name = name;
		this.hoursperweek = hoursperweek;
		this.expenses = expenses;
	}

	@Override
	public String toString() {
		return "Hobby [id=" + id + ", name=" + name + ", hoursperweek=" + hoursperweek + ", expenses=" + expenses + "]";
	}
	
	
	
}
