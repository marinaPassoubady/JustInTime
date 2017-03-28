package modele;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Timer;


import metier.Tache;
import metier.TacheSimple;
import metier.User;
import tools.SyntaxHoraire;
import tools.VerifHoraire;



public class GestionTache {
	private Connection co =  SingletonConnect.getConnect();
	public GestionTache(){

	}

	public void insererTache(TacheSimple t){
		String reqPro = "INSERT INTO `tachesimple`( `NomTache`, `HeureDebut`, `HeureFin`, `JourTache`,`note`,`objets`, `idUser`) VALUES (?,?,?,?,?,?,?)";

		try {
			PreparedStatement ps = co.prepareStatement(reqPro); 

			ps.setString(1,t.getTitre());
			ps.setString(2,t.getHeuredeb());
			ps.setString(3,  t.getHeurefin());
			ps.setDate(4, t.getDate());
			ps.setString(5, t.getNote());
			ps.setString(6, t.getObjet());
			ps.setInt(7, t.getIdUser());
			ps.execute();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean verifTache(TacheSimple t) throws Exception {
		String reqTache ="SELECT * FROM `tachesimple` WHERE `idUser`=?";
		PreparedStatement ps = co.prepareStatement(reqTache); 
		ps.setInt(1,t.getIdUser());
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			if(rs.getDate("JourTache").compareTo(t.getDate())==0){
				System.out.println("meme date");
				//comparer les heures
				if(comparerHoraire(t,rs.getString("HeureDebut"),rs.getString("HeureFin"))==false){
					return false;
				}else if(VerifHoraire.verifHeureEnglobe(rs.getString("HeureDebut"),rs.getString("HeureFin"),t.getHeuredeb(), t.getHeurefin())==false){
					return false;
				}
				else if(t.getHeuredeb().equals(rs.getString("HeureDebut")) && t.getHeurefin().equals(rs.getString("HeureFin"))){
				     return false;
				}
			}
		}
		insererTache(t);
		return true;
	}
	
	public boolean verifTache2(TacheSimple t) throws Exception{
		String reqTache ="SELECT * FROM `tachesimple` WHERE `idUser`=?";
		PreparedStatement ps = co.prepareStatement(reqTache); 
		ps.setInt(1,t.getIdUser());
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			if(rs.getDate("JourTache").compareTo(t.getDate())==0){
				//comparer les heures
				if(comparerHoraire(t,rs.getString("HeureDebut"),rs.getString("HeureFin"))==false){
					return false;
				}else if(VerifHoraire.verifHeureEnglobe(rs.getString("HeureDebut"),rs.getString("HeureFin"),t.getHeuredeb(), t.getHeurefin())==false){
					return false;
				}
				else if(t.getHeuredeb().equals(rs.getString("HeureDebut")) && t.getHeurefin().equals(rs.getString("HeureFin"))){
				     return false;
				}
			}
		}
		return true;
	}

	public boolean comparerHoraire(TacheSimple t, String heureDeb, String heureFin) throws Exception{
		if(VerifHoraire.verifHeureDebut(heureDeb, heureFin, t.getHeuredeb())==false && VerifHoraire.verifHeureFin(heureDeb, heureFin,t.getHeurefin())==true){
			return false;
		}
		
		if(VerifHoraire.verifHeureDebut(heureDeb, heureFin, t.getHeuredeb())==true && VerifHoraire.verifHeureFin(heureDeb, heureFin,t.getHeurefin())==false){
			return false;
		}
		if(VerifHoraire.verifHeureDebut(heureDeb, heureFin, t.getHeuredeb())==true && VerifHoraire.verifHeureFin(heureDeb, heureFin,t.getHeurefin())==true){
			return false;
		}
		if(VerifHoraire.verifHeureDebut(heureDeb, heureFin, t.getHeuredeb())==false ){
			return true;
		}
		if(VerifHoraire.verifHeureFin(heureDeb, heureFin,t.getHeurefin())==false){
			return true;

		}
		
		return false;
	}
	public ArrayList<TacheSimple> recupererTache (User u) throws Exception{
		String reqAuth =" SELECT * FROM tachesimple WHERE idUser=?";
		PreparedStatement ps = co.prepareStatement(reqAuth);
		ps.setInt(1, u.getIdUser());
		ResultSet rs = ps.executeQuery();
		TacheSimple t = new TacheSimple();
		ArrayList<TacheSimple> taches = new ArrayList<TacheSimple>();
		while(rs.next()){
			t = new TacheSimple(rs.getInt("IdTacheS"),rs.getString("NomTache"),Date.valueOf(rs.getString("JourTache")),rs.getString("HeureDebut"),
					rs.getString("HeureFin"),rs.getString("note"),rs.getString("objets"),rs.getInt("idUser"));
			taches.add(t);

		}
		return taches;
	}

	public int getLastTache(String typeTache) throws SQLException {

		if(typeTache.equals("TacheRecurrente")) {
			String reqId = "SELECT MAX(IdTacheRecurrente) as lastId FROM tacherecurrente";
			PreparedStatement ps = co.prepareStatement(reqId);
			ResultSet rs = ps.executeQuery();
			int lastId = 0;

			while(rs.next()) {
				lastId = rs.getInt("lastId");
			}
			return lastId;

		}else if(typeTache.equals("TacheSimple")) {
			String reqId = "SELECT MAX(IdTacheS) as lastId FROM tachesimple";
			PreparedStatement ps = co.prepareStatement(reqId);
			ResultSet rs = ps.executeQuery();
			int lastId = 0;

			while(rs.next()) {
				lastId = rs.getInt("lastId");
			}
			return lastId;
		}
		System.out.println("Erreur récupération dernière ID dans la table Tache");
		return 0;
	}

	public void suppressionTacheSimple(TacheSimple ts) throws SQLException {
		String reqPro = "DELETE FROM `tachesimple` WHERE IdTacheS=?";
		PreparedStatement ps = co.prepareStatement(reqPro); 

		ps.setInt(1, ts.getIdTache());
		ps.execute();	

	}
	
	public TacheSimple getTachebyId(int idTache) {
		String req = "SELECT * from TacheSimple where idTacheS=?";
		TacheSimple ts = null;
		try {
			PreparedStatement ps = co.prepareStatement(req);
			ps.setInt(1, idTache);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				ts = new TacheSimple(rs.getInt("IdTacheS"),rs.getString("NomTache"),Date.valueOf(rs.getString("JourTache")),rs.getString("HeureDebut"),
						rs.getString("HeureFin"),rs.getString("note"),rs.getString("objets"),rs.getInt("idUser"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return ts;
	}
	
	
	//INSERER DANS LA TABLE TACHEPARTAGEES
	public void partagerTacheSolo(int UserId, int tache, int idAmi) {
		String req = "INSERT INTO Tachepartagees (IdTacheP,IdUserOrigine,IdUserPartageAvec,estPartagee) VALUES (?,?,?,null)";
		try {
			PreparedStatement ps = co.prepareStatement(req);
			ps.setInt(1, tache);
			ps.setInt(2, UserId);
			ps.setInt(3, idAmi);
			ps.execute();  //	A NE PAS OUBLIER PLUS JAMAIS TAS COMPRIS SAL BOUFFON 
			System.out.println("tache partagee a ete inseré dans la table ");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	//RETROUVER UNE TACHE SELON LES 4 PARAMS
	public TacheSimple findTache(String nom, String date, String heureDeb, String heureFin, int UserId) {
		String req = "SELECT * FROM TACHESIMPLE WHERE NomTache=? AND HeureDebut=? AND HeureFin=? AND JourTache=? AND idUser=?";
		try {
			PreparedStatement ps = co.prepareStatement(req);
			ps.setString(1, nom);
			ps.setString(2, heureDeb);
			ps.setString(3, heureFin);
			ps.setDate(4, java.sql.Date.valueOf(date));
			ps.setInt(5, UserId);
			ResultSet rs = ps.executeQuery();
			System.out.println("je suis passé par là");
			if(rs.next()) {
				TacheSimple t=  new TacheSimple(rs.getInt("IdTacheS"),rs.getString("NomTache"),Date.valueOf(rs.getString("JourTache")),rs.getString("HeureDebut"),
						rs.getString("HeureFin"),rs.getString("note"),rs.getString("objets"),rs.getInt("idUser"));
				System.out.println("la tache a été trouvée");	
				return t;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public int getLastTachePartagee() {
		String reqId = "SELECT MAX(IdTachePartagee) as lastTachePartagee FROM TACHEPARTAGEES";
		PreparedStatement ps;
		try {
			ps = co.prepareStatement(reqId);
			ResultSet rs = ps.executeQuery();
			int lastId = 0;
			if(rs.next()) {
				lastId = rs.getInt("lastTachePartagee");
			}
			return lastId;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public boolean verifEtatTacheP(int tachP, User u) {
		String reqId = "SELECT * FROM TACHEPARTAGEES WHERE IdTachePartagee=? AND IdUserPartageAvec=? AND estPartagee IS NULL";
		PreparedStatement ps;
		try {
			System.out.println("tache partage dans etat "+tachP);
			System.out.println("user partage verif :"+u.getIdUser());
			ps = co.prepareStatement(reqId);
			ps.setInt(1, tachP);
			ps.setInt(2, u.getIdUser());
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;	
	}
	
	public void updateEtatTachePFalse(int tachP, User u) {
		String reqId = "UPDATE TACHEPARTAGEES SET estPartagee= 0 WHERE IdTacheP=? AND IdUserPartageAvec=?";
		PreparedStatement ps;
		try {
			ps = co.prepareStatement(reqId);
			ps.setInt(1, tachP);
			ps.setInt(2, u.getIdUser());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<TacheSimple> getMesTachesEnAttentePartage(int Userid) {
		String reqId = "SELECT idTacheP FROM TACHEPARTAGEES WHERE IdUserPartageAvec=? AND estPartagee IS NULL";
		
		ArrayList<Integer> listTacheId = new ArrayList<Integer>();
		PreparedStatement ps;
		try {
			ps = co.prepareStatement(reqId);
			ps.setInt(1, Userid);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				listTacheId.add(rs.getInt("IdTacheP"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		ArrayList<TacheSimple> tacheAttente = new ArrayList<TacheSimple>();
		
		ArrayList<TacheSimple> cv = new ArrayList<TacheSimple>();
		
		for(int e : listTacheId) {
			tacheAttente.add(getTachebyId(e));
		}
		

		//int userOrigine = tacheAttente.get(0).getIdUser();
		
		for(TacheSimple t : tacheAttente) {
			//System.out.println(t.getTitre());
			int userOrigine = t.getIdUser();
			t.setIdUser(Userid);
			System.out.println(t.getIdUser());
			try {
				if(verifTache2(t)) {
					t.setIdUser(userOrigine);
					System.out.println(t.getIdUser());
					cv.add(t);
					}
					
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		
		
		return cv;
	}
	
	/******************** VALIDER OU REFUSER UNE PROPOSITION DE SHARING TASK ***********/
	
	public void updateTachePTrue(int tacheP, User u) {
		String reqId = "UPDATE TACHEPARTAGEES SET estPartagee = 1 WHERE IdTacheP=? AND IdUserPartageAvec=?";
		PreparedStatement ps;
		try {
			ps = co.prepareStatement(reqId);
			ps.setInt(1, tacheP);
			ps.setInt(2, u.getIdUser());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
