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

	public boolean verifTache(TacheSimple t) throws Exception{
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

	public boolean comparerHoraire(TacheSimple t, String heureDeb, String heureFin) throws Exception{
		if(VerifHoraire.verifHeureDebut(heureDeb, heureFin, t.getHeuredeb())==false && VerifHoraire.verifHeureFin(heureDeb, heureFin,t.getHeurefin())==false){
			System.out.println("heure different");
			return true;
		}
		if(VerifHoraire.verifHeureDebut(heureDeb, heureFin, t.getHeuredeb())==false ){
			System.out.println("heure deb no pb");
			return true;
		}
		if(VerifHoraire.verifHeureFin(heureDeb, heureFin,t.getHeurefin())==false){
			System.out.println("heure fin no pb");
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
		for(TacheSimple ta : taches){
			System.out.println(ta.getTitre());
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
	public void partagerTache(int UserId, int tache, int idAmi) {
		String req = "INSERT INTO Tachepartagees (IdTacheP,IdUserOrigine,IdUserPartageAvec,estPartagee) VALUES (?,?,?,?)";
		try {
			PreparedStatement ps = co.prepareStatement(req);
			ps.setInt(parameterIndex, x);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
