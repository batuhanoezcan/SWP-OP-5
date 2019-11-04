import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;


public class main {
	
	public void addBestellung(int kunde, int rechnung, int liefer) throws SQLException {
		String url = "jdbc:postgresql://localhost:5432/aufgabe1?user=postgres&password=a";
		Connection con = DriverManager.getConnection(url);
		
		String sql = "INSERT INTO bestellung_v3(kunde_id, adresse_rechnung_id, adresse_liefer_id) values(?,?,?)";
		PreparedStatement sta;
		try {
			sta = con.prepareStatement(sql);
			sta.setInt(1, kunde);
			sta.setInt(2, rechnung);
			sta.setInt(3, liefer);
			sta.executeUpdate();
			sta.close();
			}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void addBestellungArtikel(int Bestell_id, int Artikel_id, int Menge) throws SQLException {
		String url = "jdbc:postgresql://localhost:5432/aufgabe1?user=postgres&password=a";
		Connection con = DriverManager.getConnection(url);
		
		String sql = "INSERT INTO Bestellung_Artikel(bestell_id, artikel_id, menge) values(?,?,?)";
		PreparedStatement sta;
		try {
			sta = con.prepareStatement(sql);
			sta.setInt(1, Bestell_id);
			sta.setInt(2, Artikel_id);
			sta.setInt(3, Menge);
			sta.executeUpdate();
			sta.close();
			}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void addKunde(String titelV, String Vorname, String Nachname, String titelN) throws SQLException {
		
		String url = "jdbc:postgresql://localhost:5432/aufgabe1?user=postgres&password=a";
		Connection con = DriverManager.getConnection(url);
		
		String sql = "INSERT INTO Kunde(titelv, vorname, nachname, titeln) values(?,?,?,?)";
		PreparedStatement sta;
		try {
			sta = con.prepareStatement(sql);
			sta.setString(1, titelV);
			sta.setString(2, Vorname);
			sta.setString(3, Nachname);
			sta.setString(4, titelN);
			sta.executeUpdate();
			sta.close();
			}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void addAdresse(String Stadt, String Adresse, int PLZ, String Hausnummer) throws SQLException {
		
		String url = "jdbc:postgresql://localhost:5432/aufgabe1?user=postgres&password=a";
		Connection con = DriverManager.getConnection(url);
		
		String sql = "INSERT INTO adresse(stadt, strasse, plz, hnr) values(?,?,?,?)";
		PreparedStatement sta;
		try {
			sta = con.prepareStatement(sql);
			sta.setString(1, Stadt);
			sta.setString(2, Adresse);
			sta.setInt(3, PLZ);
			sta.setString(4, Hausnummer);
			sta.executeUpdate();
			sta.close();
			}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void addArtikel(String Name, double Preis) throws SQLException {
		String url = "jdbc:postgresql://localhost:5432/aufgabe1?user=postgres&password=a";
		Connection con = DriverManager.getConnection(url);
		
		String sql = "INSERT INTO artikel(name, preis) values(?,?)";
		PreparedStatement sta;
		try {
			sta = con.prepareStatement(sql);
			sta.setString(1, Name);
			sta.setDouble(2, Preis);
			sta.executeUpdate();
			sta.close();
			}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void deleteBestellung(int ID) throws SQLException {
		
		String url = "jdbc:postgresql://localhost:5432/aufgabe1?user=postgres&password=a";
		Connection con = DriverManager.getConnection(url);
		
		String sql = "DELETE from bestellung_v3 where id=?";
		PreparedStatement sta;
		try {
			sta = con.prepareStatement(sql);
			sta.setInt(1, ID);
			sta.executeUpdate();
			sta.close();
			}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteBestellungArtikel(int ID) throws SQLException {
		
		String url = "jdbc:postgresql://localhost:5432/aufgabe1?user=postgres&password=a";
		Connection con = DriverManager.getConnection(url);
		
		String sql = "DELETE from bestellung_artikel where bestell_id=?";
		PreparedStatement sta;
		try {
			sta = con.prepareStatement(sql);
			sta.setInt(1, ID);
			sta.executeUpdate();
			sta.close();
			}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteKunde(int ID) throws SQLException {
		
		String url = "jdbc:postgresql://localhost:5432/aufgabe1?user=postgres&password=a";
		Connection con = DriverManager.getConnection(url);
		
		String sql = "DELETE from Kunde where id=?";
		PreparedStatement sta;
		try {
			sta = con.prepareStatement(sql);
			sta.setInt(1, ID);
			sta.executeUpdate();
			sta.close();
			}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteAdresse(int ID) throws SQLException {
		
		String url = "jdbc:postgresql://localhost:5432/aufgabe1?user=postgres&password=a";
		Connection con = DriverManager.getConnection(url);
		
		String sql = "DELETE from Adresse where id=?";
		PreparedStatement sta;
		try {
			sta = con.prepareStatement(sql);
			sta.setInt(1, ID);
			sta.executeUpdate();
			sta.close();
			}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteArtikel(int ID) throws SQLException {
		
		String url = "jdbc:postgresql://localhost:5432/aufgabe1?user=postgres&password=a";
		Connection con = DriverManager.getConnection(url);
		
		String sql = "DELETE from artikel where id=?";
		PreparedStatement sta;
		try {
			sta = con.prepareStatement(sql);
			sta.setInt(1, ID);
			sta.executeUpdate();
			sta.close();
			}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void readBestellung(int ID) throws SQLException {
		String url = "jdbc:postgresql://localhost:5432/aufgabe1?user=postgres&password=a";
		Connection con = DriverManager.getConnection(url);
		
		String sql = "SELECT * from bestellung_v3 where id=?";
		PreparedStatement sta;
		try {
			sta = con.prepareStatement(sql);
			sta.setInt(1, ID);
			ResultSet rs = sta.executeQuery();
			rs.next();
			System.out.println("Kunde ID:" + rs.getInt("kunde_id"));
			System.out.println("Adresse Rechnung ID:" + rs.getInt("adresse_rechnung_id"));
			System.out.println("Adresse Liefer ID:" + rs.getInt("adresse_liefer_id"));
			
			}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void readBestellungArtikel(int ID) throws SQLException {
		String url = "jdbc:postgresql://localhost:5432/aufgabe1?user=postgres&password=a";
		Connection con = DriverManager.getConnection(url);
		
		String sql = "SELECT * from bestellung_artikel where bestell_id=?";
		PreparedStatement sta;
		try {
			sta = con.prepareStatement(sql);
			sta.setInt(1, ID);
			ResultSet rs = sta.executeQuery();
			rs.next();
			System.out.println("Bestell ID: " + rs.getInt("bestell_id"));
			System.out.println("Artikel ID: " + rs.getInt("artikel_id"));
			System.out.println("Menge: " + rs.getInt("menge"));
			
			}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void readArtikel(int ID) throws SQLException {
		String url = "jdbc:postgresql://localhost:5432/aufgabe1?user=postgres&password=a";
		Connection con = DriverManager.getConnection(url);
		
		String sql = "SELECT * from artikel where id=?";
		PreparedStatement sta;
		try {
			sta = con.prepareStatement(sql);
			sta.setInt(1, ID);
			ResultSet rs = sta.executeQuery();
			rs.next();
			System.out.println("Name: " + rs.getString("name"));
			System.out.println("Preis: " + rs.getDouble("preis"));
			
			}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void readKunde(int ID) throws SQLException {
		String url = "jdbc:postgresql://localhost:5432/aufgabe1?user=postgres&password=a";
		Connection con = DriverManager.getConnection(url);
		
		String sql = "SELECT * from kunde where id=?";
		PreparedStatement sta;
		try {
			sta = con.prepareStatement(sql);
			sta.setInt(1, ID);
			ResultSet rs = sta.executeQuery();
			rs.next();
			System.out.println("Titel vorgestellt: " + rs.getString("titelv"));
			System.out.println("Vorname: " + rs.getString("vorname"));
			System.out.println("Nachname: " + rs.getString("nachname"));
			System.out.println("Titel nachgestellt: " + rs.getString("titeln"));
			
			}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void readAdresse(int ID) throws SQLException {
		String url = "jdbc:postgresql://localhost:5432/aufgabe1?user=postgres&password=a";
		Connection con = DriverManager.getConnection(url);
		
		String sql = "SELECT * from adresse where id=?";
		PreparedStatement sta;
		try {
			sta = con.prepareStatement(sql);
			sta.setInt(1, ID);
			ResultSet rs = sta.executeQuery();
			rs.next();
			System.out.println("Stadt: " + rs.getString("stadt"));
			System.out.println("Strasse: " + rs.getString("strasse"));
			System.out.println("PLZ: " + rs.getInt("plz"));
			System.out.println("Hausnummer: " + rs.getString("hnr"));
			
			}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void updateBestellung(int Kunde_id, int Adresse_rechnung_id, int Adresse_liefer_id, int Id) throws SQLException {
		String url = "jdbc:postgresql://localhost:5432/aufgabe1?user=postgres&password=a";
		Connection con = DriverManager.getConnection(url);
	
		String sql = "UPDATE bestellung_v3 SET kunde_id=?, adresse_rechnung_id=?, adresse_liefer_id=? WHERE ID=?";
		PreparedStatement sta;
		try {
			sta = con.prepareStatement(sql);
			sta.setInt(1, Kunde_id);
			sta.setInt(2, Adresse_rechnung_id);
			sta.setInt(3, Adresse_liefer_id);
			sta.setInt(4, Id);
			sta.executeUpdate();
			
			}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void updateBestellungArtikel(int Bestell_id, int artikel_id, int Menge) throws SQLException {
		String url = "jdbc:postgresql://localhost:5432/aufgabe1?user=postgres&password=a";
		Connection con = DriverManager.getConnection(url);
	
		String sql = "UPDATE bestellung_artikel SET artikel_id=?, menge=?, WHERE bestell_id=?";
		PreparedStatement sta;
		try {
			sta = con.prepareStatement(sql);
			sta.setInt(3, Bestell_id);
			sta.setInt(1, artikel_id);
			sta.setInt(2, Menge);
			sta.executeUpdate();
			
			}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void updateArtikel(String Name, double Preis, int Id) throws SQLException {
		String url = "jdbc:postgresql://localhost:5432/aufgabe1?user=postgres&password=a";
		Connection con = DriverManager.getConnection(url);
	
		String sql = "UPDATE artikel SET name=?, preis=?, WHERE ID=?";
		PreparedStatement sta;
		try {
			sta = con.prepareStatement(sql);
			sta.setString(1, Name);
			sta.setDouble(2, Preis);
			sta.setInt(3, Id);
			sta.executeUpdate();
			
			}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void updateKunde(String titelV, String Vorname, String Nachname, String titelN, int Id) throws SQLException {
		String url = "jdbc:postgresql://localhost:5432/aufgabe1?user=postgres&password=a";
		Connection con = DriverManager.getConnection(url);
	
		String sql = "UPDATE kunde SET titelv=?, vorname=?, nachname=?, titeln=? WHERE ID=?";
		PreparedStatement sta;
		try {
			sta = con.prepareStatement(sql);
			sta.setString(1, titelV);
			sta.setString(2, Vorname);
			sta.setString(3, Nachname);
			sta.setString(4, titelN);
			sta.setInt(5, Id);
			sta.executeUpdate();
			
			}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void updateAdresse(String Stadt, String Adresse, int PLZ, String Hausnummer, int Id) throws SQLException {
		String url = "jdbc:postgresql://localhost:5432/aufgabe1?user=postgres&password=a";
		Connection con = DriverManager.getConnection(url);
	
		String sql = "UPDATE adresse SET stadt=?, strasse=?, plz=?, hnr=? WHERE ID=?";
		PreparedStatement sta;
		try {
			sta = con.prepareStatement(sql);
			sta.setString(1, Stadt);
			sta.setString(2, Adresse);
			sta.setInt(3, PLZ);
			sta.setString(4, Hausnummer);
			sta.setInt(5, Id);
			sta.executeUpdate();
			
			}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Class.forName("org.postgresql.Driver");
		Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/aufgabe1?user=postgres&password=a");
		
		main database = new main();
	//	database.addKunde("Herr","Max","Mustermann","N");
	//	database.addAdresse("Vomp", "Mooswinkl", 6134, "71a");
	//	database.addArtikel("Artikel1", 17.24);
	//	database.deleteKunde(2);
	//	database.deleteAdresse(2);
	//	database.deleteArtikel(2);
	
		Scanner s = new Scanner(System.in);

			System.out.println("Type in your desired action:");
			System.out.println("C for CREATE, R for READ, U for UPDATE, D for DELETE");
			String input = s.nextLine();

			if(input.equals("C"))
			{
				System.out.println("What do you want to create?");
				System.out.println("B for Bestellung, BA for Bestellung_Artikel, K for Kunde, Ad for Adresse, Ar for Artikel");
				String create = s.nextLine();
				if(create.equals("B"))
				{
					System.out.print("Type in your Kunde_ID:");
					int kunde_id = s.nextInt();
					System.out.print("Type in your Rechnung_ID:");
					int rechnung_id = s.nextInt();
					System.out.print("Type in your Liefer_ID:");
					int liefer_id = s.nextInt();
					database.addBestellung(kunde_id, rechnung_id, liefer_id);
				}
				
				if(create.equals("BA"))
				{
					System.out.print("Type in your Bestell_ID:");
					int bestell_id = s.nextInt();
					System.out.print("Type in your Artikel_ID:");
					int artikel_id = s.nextInt();
					System.out.print("Type in your Menge:");
					int menge = s.nextInt();
					database.addBestellungArtikel(bestell_id, artikel_id, menge);
				}
				
				if(create.equals("K"))
				{
					System.out.print("Type in your Titel vorgestellt:");
					String titelvor = s.nextLine();
					System.out.print("Type in your Vorname:");
					String vorname = s.nextLine();
					System.out.print("Type in your Nachname:");
					String nachname = s.nextLine();
					System.out.print("Type in your Titel nachgestellt:");
					String titelnach = s.nextLine();
					database.addKunde(titelvor,vorname,nachname,titelnach);
				}
				
				if(create.equals("Ad"))
				{
					System.out.print("Type in your Stadt:");
					String stadt = s.nextLine();
					System.out.print("Type in your Strasse:");
					String strasse = s.nextLine();
					System.out.print("Type in your PLZ:");
					int plz = s.nextInt();
					System.out.print("Type in your Titel Hausnummer:");
					String hnr = s.nextLine();
					database.addAdresse(stadt,strasse,plz,hnr);
				}
				
				if(create.equals("Ar"))
				{
					System.out.print("Type in your Artikelname:");
					String name = s.nextLine();
					System.out.print("Type in your Preis:");
					int preis = s.nextInt();
					database.addArtikel(name,preis);
				}
			}
			
			if(input.equals("R"))
			{
				System.out.println("What do you want to read?");
				System.out.println("B for Bestellung, BA for Bestellung_Artikel, K for Kunde, Ad for Adresse, Ar for Artikel");
				String read = s.nextLine();
				if (read.equals("B"))
				{
					System.out.print("Type in the ID of the object you want to read:");
					int id = s.nextInt();
					database.readBestellung(id);
				}
				
				if (read.equals("BA"))
				{
					System.out.print("Type in the ID of the object you want to read:");
					int id = s.nextInt();
					database.readBestellungArtikel(id);
				}
				
				if (read.equals("K"))
				{
					System.out.print("Type in the ID of the object you want to read:");
					int id = s.nextInt();
					database.readKunde(id);
				}
				
				if (read.equals("Ad"))
				{
					System.out.print("Type in the ID of the object you want to read:");
					int id = s.nextInt();
					database.readAdresse(id);
				}
				
				if (read.equals("Ar"))
				{
					System.out.print("Type in the ID of the object you want to read:");
					int id = s.nextInt();
					database.readArtikel(id);
				}
				
			}
			
			if(input.equals("U"))
			{
				System.out.print("What do you want to update?");
				System.out.println("B for Bestellung, BA for Bestellung_Artikel, K for Kunde, Ad for Adresse, Ar for Artikel");
				String update = s.nextLine();

				if (update.equals("B"))
				{
					System.out.print("Type in the ID of the object you want to update:");
					int id = s.nextInt();
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
					
					database.updateBestellung(kunde_id, ar_id, al_id, id);
				}
				
				if (update.equals("BA"))
				{
					System.out.print("Type in the ID of the object you want to update:");
					int id = s.nextInt();
					System.out.println();
					
					System.out.print("Type in the updated Artikel ID:");
					int artikel_id = s.nextInt();
					System.out.println();
					
					System.out.print("Type in the updated Menge:");
					int menge = s.nextInt();
					System.out.println();
					
					database.updateBestellungArtikel(artikel_id, menge, id);
				}
				
				if (update.equals("K"))
				{
					System.out.print("Type in the ID of the object you want to update:");
					int id = s.nextInt();
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
					
					database.updateKunde(titelv, vorname, nachname, titeln, id);
				}
				
				if (update.equals("Ad"))
				{
					System.out.print("Type in the ID of the object you want to update:");
					int id = s.nextInt();
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
					
					database.updateAdresse(stadt, strasse, plz, hnr, id);
				}
				
				if (update.equals("Ar"))
				{
					System.out.print("Type in the ID of the object you want to update:");
					int id = s.nextInt();
					System.out.println();
					
					System.out.print("Type in the updated Name:");
					String name = s.nextLine();
					System.out.println();
					
					System.out.print("Type in the updated Preis:");
					int preis = s.nextInt();
					System.out.println();
					
					database.updateArtikel(name, preis, id);
				}
			}
			
			if(input.equals("D"))
			{
				System.out.print("What do you want to delete?");
				System.out.println("B for Bestellung, BA for Bestellung_Artikel, K for Kunde, Ad for Adresse, Ar for Artikel");
				String delete = s.nextLine();
				if (delete.equals("B"))
				{
					System.out.print("Type in the ID of the object you want to delete:");
					int id = s.nextInt();
					database.deleteBestellung(id);
				}
				
				if (delete.equals("BA"))
				{
					System.out.print("Type in the ID of the object you want to delete:");
					int id = s.nextInt();
					database.deleteBestellungArtikel(id);
				}

				if (delete.equals("K"))
				{
					System.out.print("Type in the ID of the object you want to delete:");
					int id = s.nextInt();
					database.deleteKunde(id);
				}
				
				if (delete.equals("Ad"))
				{
					System.out.print("Type in the ID of the object you want to delete:");
					int id = s.nextInt();
					database.deleteAdresse(id);
				}
				
				if (delete.equals("Ar"))
				{
					System.out.print("Type in the ID of the object you want to delete:");
					int id = s.nextInt();
					database.deleteArtikel(id);
				}
			}
			
		s.close();

	}

}
