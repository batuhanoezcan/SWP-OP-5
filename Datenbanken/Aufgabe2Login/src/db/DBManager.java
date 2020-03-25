package db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.persistence.EntityManager;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class DBManager {
	public static void addUser(EntityManager manager, String email, String password) throws SQLException {
		User user = new User(email, BCrypt.hashpw(password, BCrypt.gensalt()));
		manager.getTransaction();
		manager.persist(user);
		manager.getTransaction().commit();
	}

	public static boolean userexists(EntityManager manager, String email, String password) {
		User user = manager.find(User.class, email);
		return BCrypt.checkpw(password, user.getPassword());
	}
	
}
