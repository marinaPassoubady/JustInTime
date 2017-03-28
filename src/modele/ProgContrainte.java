package modele;

import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import metier.IUser;
import metier.TacheSimple;

public class ProgContrainte {
	private static Connection co =  SingletonConnect.getConnect();
	
	 public static void AjoutTacheCOntrainte(String datejour, String NomTache,String note, String objet,int DureeTache,ArrayList<IUser> amis ) throws Exception {
		 Date d = new Date();
		 GestionTache gt = new GestionTache();
		 
		 // Attribue la date du jour à un type Date
		 String[] tab = datejour.split("-");
		 d.setYear(Integer.valueOf(tab[0])-1900);
		 d.setMonth(Integer.valueOf(tab[1])-1);
		 d.setDate(Integer.valueOf(tab[2]));
		 
		// System.out.println(d.toString());	
		 
		 //Instancie une tache de base commencant à 8h00 et d'une durée passé en paramètre
		 //Calcule de l'ehure Début et l'Heure de Fin
		 String HeureDebut = "08:00:00";
		 String[] tab1 = HeureDebut.split(":");
		 int Heure = Integer.valueOf(tab1[0]);
		 Heure += DureeTache;
		 String Heure2 = String.valueOf(Heure);
		 
		 if(Heure2.length() == 1) {
			 Heure2= "0"+Heure2;
		 }
		 
		 String HeureFin = Heure2+":"+tab1[1]+":"+tab1[2];
		 
		//Formate la Date en un string prédéfinis 
        String currentDate= new SimpleDateFormat("yyyy-MM-dd").format(d);
		System.out.println(currentDate);	
		
		 TacheSimple t = new TacheSimple(NomTache,java.sql.Date.valueOf(currentDate),HeureDebut,HeureFin,note,objet,1);
		 
		 
		 
		 //Maintenant que la tache est crée, on cherche à verifier pour chacun des amis sil ils sont disponible ou pas pour cette tranche d'horaire
		 //Petite liste de boolean qui va recuperer un boolean pour chaque amis
		 ArrayList<Boolean> listbool = new ArrayList<Boolean>();
		 
		while(true) {
			listbool.clear();
			System.out.println("Affichage HeureTache teste "+t.getHeuredeb()+" "+t.getHeurefin());
			
		 for(IUser u : amis) {
			 t.setIdUser(u.getIdUser());
			 
			 // Si l'ami en question a des dispnobilités 
			 if(gt.verifTache2(t)){
				 listbool.add(true);
			 } else {
				 listbool.add(false);
			 }
		 }
		 
		
		//Dans tous les cas si dans la liste Un utilisateur ne peut pas, on decide de changer les horraires de la tache en avançant de 15 min
		 //Dans le cas contraire on peut attribuer les taches a chaque utilisateur et on quitte la boucle
		 if(!listbool.contains(false)) {
			 for(IUser u : amis) {
				 t.setIdUser(u.getIdUser());
				gt.insererTache(t);
				 System.out.println(t.getIdUser()+" "+t.getTitre()+" "+t.getDate()+" "+ t.getHeuredeb()+" "+t.getHeurefin()+
						 t.getNote()+" "+t.getObjet()+" "+ t.getIdUser());
			 }
			 break; 
		 }
		
		 //Changement d'horaire on avance de 15 min
			 HeureDebut = t.getHeuredeb();
			 HeureFin = t.getHeurefin();
			 String HeureDebut2 = "";
			 String HeureFin2 = "";
			 String MinuteDebut = "";
			 String MinuteFin = "";
			 
			 String HeureEntierD ="";
			 String HeureEntierF ="";
			 
			 String[] tab3 = HeureDebut.split(":");
			 String[] tab4 = HeureFin.split(":");
			 
			 int MinuteD = Integer.valueOf(tab3[1]);
			 int MinuteF = Integer.valueOf(tab4[1]);
			 int HeureD = Integer.valueOf(tab3[0]);
			 int HeureF = Integer.valueOf(tab4[0]);
			 
			 
			 
			 if(MinuteD == 45) {
				 MinuteD = 0;
				 HeureD+=1;
			 } else {
				 MinuteD +=15;
			 }
					 
			 if(MinuteF == 45) {
				 MinuteF = 0;
				 HeureF+=1;
				 
			 } else {
				 MinuteF +=15;
			 }
			 
			 if(HeureD == 24) {
				HeureD = 0;
			 } 
				 
			if(HeureF == 24) {
				HeureF = 0;
			} 
					 
			 HeureDebut2 = String.valueOf(HeureD);
			 HeureFin2 = String.valueOf(HeureF);
			 MinuteDebut = String.valueOf(MinuteD);
			 MinuteFin = String.valueOf(MinuteF);
			 
			 if(HeureDebut2.length() == 1) {
				 HeureDebut2= "0"+HeureD;
			 }
			 
			 if (HeureFin2.length() == 1) {
				 HeureFin2 = "0"+HeureF;
			 } 
			 
			 if (MinuteDebut.length() == 1)  {
				 MinuteDebut = "0"+MinuteDebut;
			 }

			if (MinuteFin.length() == 1){
				 MinuteFin = "0"+MinuteFin;
			 }
			 
			 if(Integer.valueOf(HeureF) > 23 || Integer.valueOf(HeureF) == 0 ) {
				 break;
			 }
			 
			 HeureEntierD = HeureDebut2+":"+MinuteDebut+":"+tab3[2];
			 HeureEntierF = HeureFin2+":"+MinuteFin+":"+tab4[2];
			 
			 
			 t.setHeuredeb(HeureEntierD);
			 t.setHeurefin(HeureEntierF);
			 
		  
		}
	 }
}
