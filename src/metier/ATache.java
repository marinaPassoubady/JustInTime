package metier;

import java.sql.Date;
import java.util.ArrayList;

import tools.SyntaxHoraire;

public abstract class ATache {
	private int IdTache;
	private String title;
	private Date date;
	private String heuredeb;
	private String heurefin;
	private boolean estPartagee;
	private String note;
	private String objet;
	private int idUser;
	private String start;
	private String end;
	
	public ATache(int idTache, String nomTache, Date date, String heureDebut, String heureDeFin, String note, String objet, int idUser) {
		IdTache = idTache;
		title = nomTache;
		this.date = date;
		heuredeb = heureDebut;
		heurefin = heureDeFin;
		this.setNote(note);
		this.estPartagee = false;
		setObjet(objet);
		this.setStart(SyntaxHoraire.createSyntax(String.valueOf(date), heureDebut));
		this.setEnd(SyntaxHoraire.createSyntax(String.valueOf(date), heureDeFin));
	}
	
	public ATache(String nomTache, Date date, String heureDebut, String heureDeFin, String note, String objet, int idUser) {
		title = nomTache;
		this.heuredeb = heureDebut;
		this.heurefin = heureDeFin;
		this.date = date;
		this.estPartagee = false;
		this.note = note;
		this.objet = objet;
		this.setStart(SyntaxHoraire.createSyntax(String.valueOf(date), heureDebut));
		this.setEnd(SyntaxHoraire.createSyntax(String.valueOf(date), heureDeFin));
		this.idUser = idUser;
	}
	
	public ATache() {
		;
	}
	
	public int getIdTache() {
		return IdTache;
	}
	public void setIdTache(int idTache) {
		IdTache = idTache;
	}
	public String getTitre() {
		return title;
	}
	public void setTitre(String nomTache) {
		title = nomTache;
	}
	
	public Date getDate() {
		return date;
	}
	
	public String getHeuredeb() {
		return heuredeb;
	}
	public void setHeuredeb(String heureDebut) {
		heuredeb = heureDebut;
	}
	public String getHeurefin() {
		return heurefin;
	}
	public void setHeurefin(String heureDeFin) {
		heurefin = heureDeFin;
	}
	public boolean isEstPartagee() {
		return estPartagee;
	}
	public void setEstPartagee(boolean estPartagee) {
		this.estPartagee = estPartagee;
	}
	
	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getObjet() {
		return objet;
	}

	public void setObjet(String objet) {
		this.objet = objet;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}
	
	/*
	public void ajouterObjet(IObjet obj) {
		this.listeObjet.add(obj);
	}
	
	public void supprmierObjet(IObjet obj) {
		this.listeObjet.remove(obj);
	}
	
	public ArrayList<IObjet> getListObjet() {
		return this.listeObjet;
	}
	*/
	
	

}
