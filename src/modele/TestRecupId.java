package modele;

import java.sql.Connection;
import java.sql.Date;
//import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

import metier.IUser;
import metier.User;

public class TestRecupId {
private static Connection co =  SingletonConnect.getConnect();
	
	 static int getLastUser() throws SQLException {
		String reqId = "SELECT MAX(IdUser) as lastId FROM USER";
		PreparedStatement ps = co.prepareStatement(reqId);
		ResultSet rs = ps.executeQuery();
		int lastId = 0;
		while(rs.next()) {
			lastId = rs.getInt("lastId");
		}
		return lastId;	
	}
	public static void main(String[] args) throws SQLException {
		GestionCompte cp = new GestionCompte();
		cp.inscriptionEtu("autreTesccccct", "Atest", "amoi", "blabla", "66, rue des Autres", 14,Date.valueOf("1977-04-12"), Integer.parseInt("0134828645"), "mail@m.fr", "etudiant","archi", Date.valueOf("1977-04-12"),Date.valueOf("1977-04-12"));
				
	}
	
}
