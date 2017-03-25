package modele;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingletonConnect {
	private static Connection connect;
	
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/base_pjs4", "root", "");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnect() {
		return connect;
	}
}
