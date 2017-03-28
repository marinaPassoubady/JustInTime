package metier;

import java.sql.Date;

public class Professionnel extends User{
	//param pro
			private int id;
			private String nomMetier;
			private String adrTravail;
			private static int cpt = 5;
			

		public Professionnel(int idUser, String login, String pass, String nom, String prenom,
				String adresse, int age, Date dateNaissance, int telephone, String mail, String statut,
				int id, String nomMetier, String adrTravail) {
			
			super(idUser, login, pass, nom, prenom, adresse, age, dateNaissance, telephone, mail, statut);
			this.id = cpt;
			this.nomMetier = nomMetier;
			this.adrTravail = adrTravail;
			cpt+=1;
		}
		public Professionnel(int idUser, String login, String pass, String nom, String prenom,
				String adresse, int age, Date dateNaissance, int telephone, String mail, String statut,
				 String nomMetier, String adrTravail) {
			
			super(idUser, login, pass, nom, prenom, adresse, age, dateNaissance, telephone, mail, statut);
			this.nomMetier = nomMetier;
			this.adrTravail = adrTravail;
			
		}
		//constructeur avec que les attributs de la classe Pro
		
		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getNomMetier() {
			return nomMetier;
		}

		public void setNomMetier(String nomMetier) {
			this.nomMetier = nomMetier;
		}

		public String getAdressePro() {
			return adrTravail;
		}

		public void setAdressePro(String adrTravail) {
			this.adrTravail = adrTravail;
		}
		
		
}
