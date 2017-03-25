package metier;

import java.sql.Date;

public class Autre extends User{
	private int idAutre;
	private String SocialStatus;
	
	
	public Autre (int idUser, String login, String pass, String nom, String prenom,
				String adresse, int age, Date dateNaissance, int telephone, String mail,
				String statut, int idAutre, String situationSociale) {
		
		super(idUser, login, pass, nom, prenom, adresse, age, dateNaissance, telephone, mail, statut);
		this.idAutre = idAutre;
		this.SocialStatus = situationSociale;
	}
	
	public String getSocialStatus() {
		return SocialStatus;
	}
	public void setSocialStatus(String socialStatus) {
		SocialStatus = socialStatus;
	}
	
	
}
