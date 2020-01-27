package infidb.Aufgabe1_JPA;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class App 
{
    public static void main(String[] args)
    {
    	EntityManagerFactory f = Persistence.createEntityManagerFactory("MyUnit");
        EntityManager manager = f.createEntityManager();
        
        Scanner s = new Scanner(System.in);

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
				Embed_ID eid = new Embed_ID(bestell_id,artikel_id);
				
				Bestellung_Artikel a = new Bestellung_Artikel(eid,menge);
				manager.getTransaction().begin();
				manager.persist(a);
				manager.getTransaction().commit();
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
				
				Embed_ID eid = new Embed_ID(b_id,a_id);
				Bestellung_Artikel a = manager.find(Bestellung_Artikel.class, eid);
						        System.out.println(a.toString());
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
			System.out.print("What do you want to update?");
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
				
				a.setKunde_id(kunde_id);
				a.setAdresse_rechnung_id(ar_id);
				a.setAdresse_liefer_id(al_id);
			}
			
			if (update.equalsIgnoreCase("BA"))
			{
				System.out.print("Type in the Bestell_ID of the object you want to update:");
				int b_id = s.nextInt();
				System.out.println();
				
				System.out.print("Type in the Artikel_ID of the object you want to update:");
				int a_id = s.nextInt();
				
				Embed_ID eid = new Embed_ID(b_id,a_id);
				Bestellung_Artikel a = manager.find(Bestellung_Artikel.class, eid);
				
		        System.out.println("This is your selected Object: ");
		        		        System.out.println(a.toString());
		        System.out.println();

				
				System.out.print("Type in the updated Menge:");
				int menge = s.nextInt();
				System.out.println();
				
				a.setMenge(menge);
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
				
				a.setNachname(nachname);
				a.setTiteln(titeln);
				a.setTitelv(titelv);
				a.setVorname(vorname);
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
				
				a.setHnr(hnr);
				a.setPlz(plz);
				a.setStadt(stadt);
				a.setStrasse(strasse);
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
				
				a.setName(name);
				a.setPreis(preis);
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

				Embed_ID eid = new Embed_ID(b_id,a_id);
				Bestellung_Artikel a = manager.find(Bestellung_Artikel.class, eid);
				
				manager.getTransaction().begin();
		        manager.remove(a);
		        manager.getTransaction().commit();
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
		
	s.close();
    }
}