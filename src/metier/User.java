package metier;

import java.sql.Date;

public class User implements IUser {
	private int idUser;
	private String login;
	private String pass;
	private String Nom;
	private String Prenom;
	private String Adresse;
	private int age;
	private Date DateNaissance;
	private int telephone;
	private String mail;
	private String statut;
	private static int cpt = 11;
	
	public User(int idUser, String login, String pass, String nom, String prenom, String adresse, int age,
			Date dateNaissance, int telephone, String mail, String statut) {
		this.idUser = idUser;
		this.login = login;
		this.pass = pass;
		Nom = nom;
		Prenom = prenom;
		Adresse = adresse;
		this.age = age;
		DateNaissance = dateNaissance;
		this.telephone = telephone;
		this.mail = mail;
		this.statut = statut;
		cpt+=1;
	}
	public User(String login, String pass, String nom, String prenom, String adresse, int age,
			Date dateNaissance, int telephone, String mail, String statut) {
		this.idUser = cpt;
		this.login = login;
		this.pass = pass;
		Nom = nom;
		Prenom = prenom;
		Adresse = adresse;
		this.age = age;
		DateNaissance = dateNaissance;
		this.telephone = telephone;
		this.mail = mail;
		this.statut = statut;
		cpt+=1;
	}
	
	public User (String login, String pass) {
		this.login = login;
		this.pass = pass;
	}
	
	public User(int id, String login, String nom, String prenom) {
		this.idUser = id;
		this.login = login;
		this.Nom = nom;
		this.Prenom = prenom;
	}
	public User(int num) {
		this.idUser = num;
	}
	
	public User() {
	}
	
	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getNom() {
		return Nom;
	}

	public void setNom(String nom) {
		Nom = nom;
	}

	public String getPrenom() {
		return Prenom;
	}

	public void setPrenom(String prenom) {
		Prenom = prenom;
	}

	public String getAdresse() {
		return Adresse;
	}

	public void setAdresse(String adresse) {
		Adresse = adresse;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getDateNaissance() {
		return DateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		DateNaissance = dateNaissance;
	}

	public int getTelephone() {
		return telephone;
	}

	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public int getIdUser() {
		return idUser;
	}
	
	public int setIdUser(int id) {
		return this.idUser = id;
	}
	
	
	public String getLogin() {
		return login;
	}
	
}
