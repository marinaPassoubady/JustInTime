package modele;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import metier.Autre;
import metier.Etudiant;
import metier.IUser;
import metier.Professionnel;
import metier.User;

public class GestionCompte {
	private Connection co =  SingletonConnect.getConnect();
	private static final String tableUser = "User";
	private static final String tablePro = "Professionnel";
	private static final String tableEtu = "Etudiant";
	private static final String tableAutre = "Autre";

	public boolean connexion(String login, String mdp) {
		String reqAuth =" SELECT * FROM USER WHERE login=? and pass=?";
		
		try {
			PreparedStatement ps = co.prepareStatement(reqAuth);
			ps.setString(1, login);
			ps.setString(2, mdp);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				return true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	

	public User verifStatut(String login) {
		String reqVerif =" SELECT * FROM USER WHERE login=?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		User u = null;
		
		try {
			ps = co.prepareStatement(reqVerif);
			ps.setString(1, login);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				String statut = rs.getString("statut");
				switch(statut) {
				case "professionnel" :
					ResultSet rst = null;
					String reqProf =" SELECT p.idProfessionnel, p.NomMetier, p.AdresseLieuTravail FROM PROFESSIONNEL p, USER u WHERE u.IdProfessionnel=p.IdProfessionnel and "
							+ "u.IdProfessionnel = ?";
					ps = co.prepareStatement(reqProf);
					ps.setInt(1, rs.getInt("IdProfessionnel"));
					rst = ps.executeQuery();
					while(rst.next()) {
					u = new Professionnel (rs.getInt("idUser"),rs.getString("login"),rs.getString("pass"),rs.getString("nom"),rs.getString("prenom"),
							rs.getString("adresse"),rs.getInt("age"),Date.valueOf(rs.getString("dateNaissance")), rs.getInt("telephone"), rs.getString("mail"), 
							rs.getString("statut"),rst.getInt("idProfessionnel"), rst.getString("NomMetier"),rst.getString("AdresseLieuTravail"));
					}
					break;
				case "étudiant" : 
					ResultSet rst1 = null;
					String reqEtu =" SELECT p.idEtudiant, p.Ecole, p.DateEntre, p.DateFinEtude FROM ETUDIANT p, USER u WHERE u.IdEtudiant=p.IdEtudiant and "
							+ "u.IdEtudiant = ?";
					ps = co.prepareStatement(reqEtu);
					ps.setInt(1, rs.getInt("IdEtudiant"));
					rst1 = ps.executeQuery();
					while(rst1.next()) {
					u = new Etudiant (rs.getInt("idUser"),rs.getString("login"),rs.getString("pass"),rs.getString("nom"),rs.getString("prenom"),
							rs.getString("adresse"),rs.getInt("age"),Date.valueOf(rs.getString("dateNaissance")), rs.getInt("telephone"), rs.getString("mail"), 
							rs.getString("statut"),rst1.getInt("idEtudiant"), rst1.getString("Ecole"),Date.valueOf(rst1.getString("DateEntre")),Date.valueOf(rst1.getString("DateFinEtude")));
					}
					break;
				case "autre" : 
					ResultSet rst2 = null;
					String reqAutre =" SELECT * FROM Autre a, USER u WHERE a.IdAutre= u.IdAutre and "
							+ "u.IdAutre = ?";
					ps = co.prepareStatement(reqAutre);
					ps.setInt(1, rs.getInt("IdAutre"));
					rst2 = ps.executeQuery();
					while(rst2.next()) {
					u = new Autre (rs.getInt("idUser"),rs.getString("login"),rs.getString("pass"),rs.getString("nom"),rs.getString("prenom"),
							rs.getString("adresse"),rs.getInt("age"),Date.valueOf(rs.getString("dateNaissance")), rs.getInt("telephone"), rs.getString("mail"), 
							rs.getString("statut"),rst2.getInt("idAutre"), rst2.getString("SituationSociale"));
					}
					break;
					default : 
						System.out.println("Statut non reconnu");
					
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return u;
	}
	
	/*public int getLastUser() throws SQLException {
		String reqId = "SELECT MAX(IdUser) as lastId FROM USER";
		PreparedStatement ps = co.prepareStatement(reqId);
		ResultSet rs = ps.executeQuery();
		int lastId = 0;
		while(rs.next()) {
			lastId = rs.getInt("lastId");
		}
		return lastId;	
	}*/
	
	public int getLastId(String s) throws SQLException {
		String reqId = "SELECT MAX(Id"+s+") as lastId FROM "+s;
		PreparedStatement ps = co.prepareStatement(reqId);
		ResultSet rs = ps.executeQuery();
		int lastId = 0;
		while(rs.next()) {
			lastId = rs.getInt("lastId");
		}
		return lastId;	
	}
	
	/*public int getLastUserEtu() throws SQLException {
		String reqId = "SELECT MAX(IdEtudiant) as lastId FROM ETUDIANT";
		PreparedStatement ps = co.prepareStatement(reqId);
		ResultSet rs = ps.executeQuery();
		int lastId = 0;
		while(rs.next()) {
			lastId = rs.getInt("lastId");
		}
		return lastId;	
	}
	
	public int getLastUserAutre() throws SQLException {
		String reqId = "SELECT MAX(IdAutre) as lastId FROM AUTRE";
		PreparedStatement ps = co.prepareStatement(reqId);
		ResultSet rs = ps.executeQuery();
		int lastId = 0;
		while(rs.next()) {
			lastId = rs.getInt("lastId");
		}
		return lastId;	
	}*/
	
	public void inscriptionPro(String login, String pass, String nom, String prenom, String adresse, int age, Date dateNaissance,
			int telephone, String mail, String statut, String nomMetier, String adrTravail) throws SQLException {
		
		String reqPro = "INSERT INTO PROFESSIONNEL (NomMetier, AdresseLieuTravail) VALUES (?,?)";
		PreparedStatement ps = co.prepareStatement(reqPro); 
		
		//ps.setInt(1, (getLastUserPro()+1));
		ps.setString(1,nomMetier);
		ps.setString(2, adrTravail);
		
		ps.execute();
		System.out.println("pro insere ok !");
		String reqUser = "INSERT INTO USER (login, pass, Nom, Prenom, Adresse, Age, DateNaissance, Telephone, Mail, Statut, IdProfessionnel) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
		ps = co.prepareStatement(reqUser);
		
		ps.setString(1,login);
		ps.setString(2,pass);
		ps.setString(3,nom);
		ps.setString(4,prenom);
		ps.setString(5,adresse);
		ps.setInt(6, age);
		ps.setString(7, dateNaissance.toString());
		ps.setInt(8, telephone);
		ps.setString(9, mail);
		ps.setString(10, statut);
		ps.setInt(11, getLastId(tablePro));
		ps.execute();
		System.out.println("fini");
	}
		
	
	public void inscriptionEtu(String login, String pass, String nom, String prenom, String adresse, int age, Date dateNaissance,
			int telephone, String mail, String statut, String etablissement, Date dateDeb, Date dateFin) throws SQLException {
		
		String reqPro = "INSERT INTO ETUDIANT (Ecole, DateEntre, DateFinEtude) VALUES (?,?,?)";
		PreparedStatement ps = co.prepareStatement(reqPro); 
		
		//ps.setInt(1, (getLastUserPro()+1));
		ps.setString(1,etablissement);
		ps.setString(2, dateDeb.toString());
		ps.setString(3, dateFin.toString());
		
		
		ps.execute();
		
		String reqUser = "INSERT INTO USER (login, pass, Nom, Prenom, Adresse, Age, DateNaissance, Telephone, Mail, Statut, IdEtudiant"
				+ ") VALUES (?,?,?,?,?,?,?,?,?,?,?)";
		ps = co.prepareStatement(reqUser);
		
		ps.setString(1,login);
		ps.setString(2,pass);
		ps.setString(3,nom);
		ps.setString(4,prenom);
		ps.setString(5,adresse);
		ps.setInt(6, age);
		ps.setString(7, dateNaissance.toString());
		ps.setInt(8, telephone);
		ps.setString(9, mail);
		ps.setString(10, statut);
		ps.setInt(11, getLastId(tableEtu));
		ps.execute();
	}
	
	public void inscriptionAutre(String login, String pass, String nom, String prenom, String adresse, int age, Date dateNaissance,
			int telephone, String mail, String statut, String situation) throws SQLException {
		
		String reqPro = "INSERT INTO AUTRE (situationSociale) VALUES (?)";
		PreparedStatement ps = co.prepareStatement(reqPro); 
		
		//ps.setInt(1, (getLastUserPro()+1));
		ps.setString(1,situation);
		ps.execute();
		
		String reqUser = "INSERT INTO USER (login, pass, Nom, Prenom, Adresse, Age, DateNaissance, Telephone, Mail, Statut, "
				+ " IdAutre) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
		ps = co.prepareStatement(reqUser);
		
		ps.setString(1,login);
		ps.setString(2,pass);
		ps.setString(3,nom);
		ps.setString(4,prenom);
		ps.setString(5,adresse);
		ps.setInt(6, age);
		ps.setString(7, dateNaissance.toString());
		ps.setInt(8, telephone);
		ps.setString(9, mail);
		ps.setString(10, statut);
		ps.setInt(11, getLastId(tableAutre));
		ps.execute();
	}
	
	
	/**************** GESTION DES AMIS (AJOUTER SUPPRIMER PARTAGER ET CONSULTER ) **************/
	
	public User trouverUser(String login) {
			String reqAuth =" SELECT idUser FROM USER WHERE login=?";
		
		try {
			PreparedStatement ps = co.prepareStatement(reqAuth);
			ps.setString(1, login);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				User u = new User(rs.getInt("idUser"));
				return u;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public void ajoutAmiByLogin(String login, int userOrigine) {
		if(!(trouverUser(login) == null)) {
			String req = "INSERT INTO LISTEAMIS (IdUserOrigine,IdUserAmi) VALUES(?,?)";
			try {
				PreparedStatement ps = co.prepareStatement(req);
				ps.setInt(1, userOrigine);
				ps.setInt(2, trouverUser(login).getIdUser());
				ps.execute();
			}
			 catch (SQLException e) {
					e.printStackTrace();
				}
		}
		else {
			System.out.println("user n'existe pas dans la base");
		}
	}
	
	public ArrayList<User> getMyFriends(User uOrigine) {
		
		String req = "SELECT IdUserAmi FROM LISTEAMIS WHERE IdUserOrigine=?";
		ArrayList<Integer> idListAmis = new ArrayList<Integer>();
		
		try {
			PreparedStatement ps = co.prepareStatement(req);
			ps.setInt(1, uOrigine.getIdUser());
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				idListAmis.add(rs.getInt(1));
			}
		}
		 catch (SQLException e) {
				e.printStackTrace();
			}
		
		String req2 = "SELECT IdUser, login, Nom, Prenom FROM USER WHERE IdUser=?";
		ArrayList<User> listeAmi = new ArrayList<User>();
		
		try {
			PreparedStatement ps = co.prepareStatement(req2);
			for(int d : idListAmis) {
				ps.setInt(1, d);
				ResultSet rs = ps.executeQuery();
				if(rs.next()) {
					listeAmi.add(new User(rs.getInt("IdUser"),rs.getString("login"),rs.getString("Nom"),rs.getString("Prenom")));
				}
			}
			
			
		} catch (SQLException e){
			e.printStackTrace();
		}
		return listeAmi;
	}
	

	
}
