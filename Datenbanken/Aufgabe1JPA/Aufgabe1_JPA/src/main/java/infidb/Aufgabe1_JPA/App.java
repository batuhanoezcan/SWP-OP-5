package infidb.Aufgabe1_JPA;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import infidb.Aufgabe1_JPA.Artikel;
import infidb.Aufgabe1_JPA.Bestellung_v3;
import infidb.Aufgabe1_JPA.Bestellung_Artikel;
import infidb.Aufgabe1_JPA.Kunde;
import infidb.Aufgabe1_JPA.Adresse;


public class App 
{
    public static void main(String[] args) throws SQLException
    {
        Scanner s = new Scanner(System.in);
    	boolean finished = false;
    	while(finished!=true) {
    	EntityManagerFactory f = Persistence.createEntityManagerFactory("MyUnit");
        EntityManager manager = f.createEntityManager();
        

		System.out.println("Type in your desired action:");
		System.out.println("C for CREATE, R for READ, U for UPDATE, D for DELETE");
		String input = s.nextLine();

		if(input.equalsIgnoreCase("C"))
		{
			System.out.println("What do you want to create?");
			System.out.println("B for Bestellung, BA for Bestellung_Artikel, K for Kunde, Ad for Adresse, Ar for Artikel");
			String create = s.nextLine();
			if(create.equalsIgnoreCase("B"))
			{
				System.out.print("Type in your Kunde_ID:");
				int kunde_id = s.nextInt();
				System.out.print("Type in your Rechnung_ID:");
				int rechnung_id = s.nextInt();
				System.out.print("Type in your Liefer_ID:");
				int liefer_id = s.nextInt();
				Bestellung_v3 a = new Bestellung_v3(kunde_id,rechnung_id,liefer_id);
				manager.getTransaction().begin();
				manager.persist(a);
				manager.getTransaction().commit();      
			}
			
			if(create.equalsIgnoreCase("BA"))
			{
				System.out.print("Type in your Bestell_ID:");
				int bestell_id = s.nextInt();
				System.out.print("Type in your Artikel_ID:");
				int artikel_id = s.nextInt();
				System.out.print("Type in your Menge:");
				int menge = s.nextInt();
				
				// Hat nicht funktioniert, habe stattdessen PreparedStatement verwendet.
				/*Embed_ID eid = new Embed_ID(bestell_id,artikel_id);
				
				Bestellung_Artikel a = new Bestellung_Artikel(eid,menge);
				manager.getTransaction().begin();
				manager.persist(a);
				manager.getTransaction().commit();
				*/
				
				String url = "jdbc:postgresql://localhost:5432/aufgabe1?user=postgres&password=a";
				Connection con = DriverManager.getConnection(url);
				
				String sql = "INSERT INTO Bestellung_Artikel(bestell_id, artikel_id, menge) values(?,?,?)";
				PreparedStatement sta;
				try {
					sta = con.prepareStatement(sql);
					sta.setInt(1, bestell_id);
					sta.setInt(2, artikel_id);
					sta.setInt(3, menge);
					sta.executeUpdate();
					sta.close();
					}
				
				catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if(create.equalsIgnoreCase("K"))
			{
				System.out.print("Type in your Titel vorgestellt:");
				String titelvor = s.nextLine();
				System.out.print("Type in your Vorname:");
				String vorname = s.nextLine();
				System.out.print("Type in your Nachname:");
				String nachname = s.nextLine();
				System.out.print("Type in your Titel nachgestellt:");
				String titelnach = s.nextLine();
				Kunde a = new Kunde(titelvor, vorname, nachname, titelnach);
				manager.getTransaction().begin();
				manager.persist(a);
				manager.getTransaction().commit();			
			}
			
			if(create.equalsIgnoreCase("Ad"))
			{
				System.out.print("Type in your Stadt:");
				String stadt = s.nextLine();
				System.out.print("Type in your Strasse:");
				String strasse = s.nextLine();
				System.out.print("Type in your PLZ:");
				int plz = s.nextInt();
				s.nextLine();
				System.out.print("Type in your Titel Hausnummer:");
				String hnr = s.nextLine();
				Adresse a = new Adresse(stadt, strasse, plz, hnr);
				manager.getTransaction().begin();
				manager.persist(a);
				manager.getTransaction().commit();			
			}
			
			if(create.equalsIgnoreCase("Ar"))
			{
				System.out.print("Type in your Artikelname:");
				String name = s.nextLine();
				System.out.print("Type in your Preis:");
				int preis = s.nextInt();
				Artikel a = new Artikel(name, preis);
				manager.getTransaction().begin();
				manager.persist(a);
				manager.getTransaction().commit();
			}
		}
		
		if(input.equalsIgnoreCase("R"))
		{
			System.out.println("What do you want to read?");
			System.out.println("B for Bestellung, BA for Bestellung_Artikel, K for Kunde, Ad for Adresse, Ar for Artikel");
			String read = s.nextLine();
			if (read.equalsIgnoreCase("B"))
			{
				System.out.print("Type in the ID of the object you want to read:");
				int id = s.nextInt();
		        Bestellung_v3 a = manager.find(Bestellung_v3.class, (long)id);
		        		        System.out.println(a.toString());
			}
			
			if (read.equalsIgnoreCase("BA"))
			{
				System.out.print("Type in the Bestell_ID of the object you want to read:");
				int b_id = s.nextInt();
				System.out.println();

				System.out.print("Type in the Artikel_ID of the object you want to read:");
				int a_id = s.nextInt();
				
				String url = "jdbc:postgresql://localhost:5432/aufgabe1?user=postgres&password=a";
				Connection con = DriverManager.getConnection(url);
			
		        System.out.println();		        

				String sql = "SELECT * from bestellung_artikel where bestell_id=? AND artikel_id=?";
				PreparedStatement sta;
				try {
					sta = con.prepareStatement(sql);
					sta.setInt(1, b_id);
					sta.setInt(2, a_id);
					ResultSet rs = sta.executeQuery();
					rs.next();
					System.out.println("Bestell ID: " + rs.getInt("bestell_id"));
					System.out.println("Artikel ID: " + rs.getInt("artikel_id"));
					System.out.println("Menge: " + rs.getInt("menge"));
					
					}
				catch (SQLException e) {
					e.printStackTrace();
				}
				 
		        System.out.println();

				/*
				Embed_ID eid = new Embed_ID(b_id,a_id);
				Bestellung_Artikel a = manager.find(Bestellung_Artikel.class, eid);
						        System.out.println(a.toString()); */
		    }
			
			if (read.equalsIgnoreCase("K"))
			{
				System.out.print("Type in the ID of the object you want to read:");
				int id = s.nextInt();
				Kunde a = manager.find(Kunde.class, (long)id);
		        		        System.out.println(a.toString());    
			}
			
			if (read.equalsIgnoreCase("Ad"))
			{
				System.out.print("Type in the ID of the object you want to read:");
				int id = s.nextInt();
				Adresse a = manager.find(Adresse.class, (long)id);
		        		        System.out.println(a.toString());
		    }
			
			if (read.equalsIgnoreCase("Ar"))
			{
				System.out.print("Type in the ID of the object you want to read:");
				int id = s.nextInt();
				Artikel a = manager.find(Artikel.class, (long)id);
		        		        System.out.println(a.toString());
		    }
			
		}
		
		if(input.equalsIgnoreCase("U"))
		{
			System.out.println("What do you want to update?");
			System.out.println("B for Bestellung, BA for Bestellung_Artikel, K for Kunde, Ad for Adresse, Ar for Artikel");
			String update = s.nextLine();

			if (update.equalsIgnoreCase("B"))
			{
				System.out.println("Type in the ID of the object you want to update:");
				int id = s.nextInt();
				System.out.println();
				
				Bestellung_v3 a = manager.find(Bestellung_v3.class, (long)id);
				
		        System.out.println("This is your selected Object: ");
		        		        System.out.println(a.toString());
		        System.out.println();
				
				System.out.print("Type in the updated Kunde ID:");
				int kunde_id = s.nextInt();
				System.out.println();
				
				System.out.print("Type in the updated Adresse Rechnung ID:");
				int ar_id = s.nextInt();
				System.out.println();
				
				System.out.print("Type in the updated Adresse Liefer ID:");
				int al_id = s.nextInt();
				System.out.println();
				
				manager.getTransaction().begin();
				a.setKunde_id(kunde_id);
				a.setAdresse_rechnung_id(ar_id);
				a.setAdresse_liefer_id(al_id);
				manager.getTransaction().commit();
			}
			
			if (update.equalsIgnoreCase("BA"))
			{
				System.out.print("Type in the Bestell_ID of the object you want to update:");
				int b_id = s.nextInt();
				System.out.println();
				
				System.out.print("Type in the Artikel_ID of the object you want to update:");
				int a_id = s.nextInt();
				
				
				String url = "jdbc:postgresql://localhost:5432/aufgabe1?user=postgres&password=a";
				Connection con = DriverManager.getConnection(url);
			
				
			    System.out.println("This is your selected Object: ");
		        System.out.println();
		        

				String sql = "SELECT * from bestellung_artikel where bestell_id=? AND artikel_id=?";
				PreparedStatement sta;
				try {
					sta = con.prepareStatement(sql);
					sta.setInt(1, b_id);
					sta.setInt(2, a_id);
					ResultSet rs = sta.executeQuery();
					rs.next();
					System.out.println("Bestell ID: " + rs.getInt("bestell_id"));
					System.out.println("Artikel ID: " + rs.getInt("artikel_id"));
					System.out.println("Menge: " + rs.getInt("menge"));
					
					}
				catch (SQLException e) {
					e.printStackTrace();
				}
				 
		        System.out.println();


		        System.out.print("Type in the updated Menge:");
		        int menge = s.nextInt();
		        System.out.println();
				
				sql = "UPDATE bestellung_artikel SET menge=? WHERE bestell_id=? AND artikel_id=?";
				try {
					sta = con.prepareStatement(sql);
					sta.setInt(2, b_id);
					sta.setInt(3, a_id);
					sta.setInt(1, menge);
					sta.executeUpdate();
					
					}
				catch (SQLException e) {
					e.printStackTrace();
				}
				
				/*
				Embed_ID eid = new Embed_ID(b_id,a_id);
				Bestellung_Artikel a = manager.find(Bestellung_Artikel.class, eid);
				
		        System.out.println("This is your selected Object: ");
		        		        System.out.println(a.toString());
		        System.out.println();

				
				System.out.print("Type in the updated Menge:");
				int menge = s.nextInt();
				System.out.println();
				
				manager.getTransaction().begin();
				a.setMenge(menge);
				manager.getTransaction().commit();
				*/
			}
			
			if (update.equalsIgnoreCase("K"))
			{
				System.out.print("Type in the ID of the object you want to update:");
				int id = s.nextInt();
				System.out.println();
				
				Kunde a = manager.find(Kunde.class, (long)id);
				
		        System.out.println("This is your selected Object: ");
		        		        System.out.println(a.toString());
		        System.out.println();
				
				System.out.print("Type in the updated Titel vorgestellt:");
				String titelv = s.nextLine();
				System.out.println();
				
				System.out.print("Type in the updated Vorname:");
				String vorname = s.nextLine();
				System.out.println();
				
				System.out.print("Type in the updated Nachname:");
				String nachname = s.nextLine();
				System.out.println();
				
				System.out.print("Type in the updated Titel nachgestellt:");
				String titeln = s.nextLine();
				System.out.println();
				
				manager.getTransaction().begin();
				a.setNachname(nachname);
				a.setTiteln(titeln);
				a.setTitelv(titelv);
				a.setVorname(vorname);
				manager.getTransaction().commit();
			}
			
			if (update.equalsIgnoreCase("Ad"))
			{
				System.out.print("Type in the ID of the object you want to update:");
				int id = s.nextInt();
				System.out.println();
				
				Adresse a = manager.find(Adresse.class, (long)id);
				
		        System.out.println("This is your selected Object: ");
		        		        System.out.println(a.toString());
		        System.out.println();
		        
				System.out.print("Type in the updated Stadt:");
				String stadt = s.nextLine();
				System.out.println();
				
				System.out.print("Type in the updated Strasse:");
				String strasse = s.nextLine();
				System.out.println();
				
				System.out.print("Type in the updated PLZ:");
				int plz = s.nextInt();
				System.out.println();
				
				System.out.print("Type in the updated Hausnummer:");
				String hnr= s.nextLine();
				System.out.println();
				
				manager.getTransaction().begin();
				a.setHnr(hnr);
				a.setPlz(plz);
				a.setStadt(stadt);
				a.setStrasse(strasse);
				manager.getTransaction().commit();
			}
			
			if (update.equalsIgnoreCase("Ar"))
			{
				System.out.print("Type in the ID of the object you want to update:");
				int id = s.nextInt();
				System.out.println();
				
				Artikel a = manager.find(Artikel.class, (long)id);
				
		        System.out.println("This is your selected Object: ");
		        		        System.out.println(a.toString());
		        System.out.println();
		        
				System.out.print("Type in the updated Name:");
				String name = s.nextLine();
				System.out.println();
				
				System.out.print("Type in the updated Preis:");
				int preis = s.nextInt();
				System.out.println();
				
				manager.getTransaction().begin();
				a.setName(name);
				a.setPreis(preis);
				manager.getTransaction().commit();
			}
		}
		
		if(input.equalsIgnoreCase("D"))
		{
			System.out.println("What do you want to delete?");
			System.out.println("B for Bestellung, BA for Bestellung_Artikel, K for Kunde, Ad for Adresse, Ar for Artikel");
			String delete = s.nextLine();
			if (delete.equalsIgnoreCase("B"))
			{
				System.out.print("Type in the ID of the object you want to delete:");
				int id = s.nextInt();

		        Bestellung_v3 a = manager.find(Bestellung_v3.class, (long)id);
		        manager.getTransaction().begin();
		        manager.remove(a);
		        manager.getTransaction().commit();		
			}
			
			if (delete.equalsIgnoreCase("BA"))
			{
				System.out.print("Type in the Bestell_ID of the object you want to delete:");
				int b_id = s.nextInt();
				System.out.println();

				System.out.print("Type in the Artikel_ID of the object you want to delete:");
				int a_id = s.nextInt();

				/*
				Embed_ID eid = new Embed_ID(b_id,a_id);
				Bestellung_Artikel a = manager.find(Bestellung_Artikel.class, eid);
				
				manager.getTransaction().begin();
		        manager.remove(a);
		        manager.getTransaction().commit();
		        */
				
		        String url = "jdbc:postgresql://localhost:5432/aufgabe1?user=postgres&password=a";
				Connection con = DriverManager.getConnection(url);
				
				String sql = "DELETE from bestellung_artikel where bestell_id=? AND artikel_id=?";
				PreparedStatement sta;
				try {
					sta = con.prepareStatement(sql);
					sta.setInt(1, b_id);
					sta.setInt(2, a_id);
					sta.executeUpdate();
					sta.close();
					}
				
				catch (SQLException e) {
					e.printStackTrace();
				}
		    }

			if (delete.equalsIgnoreCase("K"))
			{
				System.out.print("Type in the ID of the object you want to delete:");
				int id = s.nextInt();
				
				Kunde a = manager.find(Kunde.class, (long)id);
		        manager.getTransaction().begin();
		        manager.remove(a);
		        manager.getTransaction().commit();
			}
			
			if (delete.equalsIgnoreCase("Ad"))
			{
				System.out.print("Type in the ID of the object you want to delete:");
				int id = s.nextInt();
				
				Adresse a = manager.find(Adresse.class, (long)id);
		        manager.getTransaction().begin();
		        manager.remove(a);
		        manager.getTransaction().commit();
		    }
			
			if (delete.equalsIgnoreCase("Ar"))
			{
				System.out.print("Type in the ID of the object you want to delete:");
				int id = s.nextInt();
				
				Artikel a = manager.find(Artikel.class, (long)id);
		        manager.getTransaction().begin();
		        manager.remove(a);
		        manager.getTransaction().commit();
		    }
		}
		System.out.println("Finished? y/N");
		s.nextLine();
		String finish = s.nextLine();
		if(finish.equalsIgnoreCase("y"))
		{
			finished = true;
		}
		else {
			finished = false;
		}
		
    }
    	s.close();
    }
}