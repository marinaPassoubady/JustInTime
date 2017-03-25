package metier;

import java.sql.Date;

public class Etudiant extends User{
	private int IdEtu;
	private String ecole;
	private Date Datedeb;
	private Date Datefin;
	
	public Etudiant(int idUser, String login, String pass, String nom, String prenom,
			String adresse, int age, Date dateNaissance, int telephone, String mail, String statut, int idE, 
			String ecole, Date dateD, Date dateF) {
		
		super(idUser, login, pass, nom, prenom, adresse, age, dateNaissance, telephone, mail, statut);
		this.IdEtu = idE;
		this.ecole = ecole;
		this.Datedeb = dateD;
		this.Datefin = dateF;
	}

	public String getEcole() {
		return ecole;
	}

	public void setEcole(String ecole) {
		this.ecole = ecole;
	}

	public Date getDatedeb() {
		return Datedeb;
	}

	public void setDatedeb(Date datedeb) {
		Datedeb = datedeb;
	}

	public Date getDatefin() {
		return Datefin;
	}

	public void setDatefin(Date datefin) {
		Datefin = datefin;
	}

	public int getIdEtu() {
		return IdEtu;
	}
}
