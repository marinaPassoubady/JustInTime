package toolsTache;

import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.stream.IntStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;

import metier.TacheSimple;

public class RecupTacheRec {
	
	public static ArrayList<TacheSimple> creerListTacheRec(int mois,String jourRec, String nomTache, String heureDeb, String heureFin,
			String note, String objet, int idUser) {
		
		Date d = new Date();
        String currentDate= new SimpleDateFormat("yyyy-MM-dd").format(d);
		String moisString = "";
		if(mois <= 9) 
			moisString = "0"+mois;
		else
			moisString = ""+mois;
	    ArrayList<String> dateMensuelNonFormatee = new ArrayList<String>(); 
	    ArrayList<TacheSimple> listTache = new ArrayList<>();
	     
	      IntStream.rangeClosed(1,YearMonth.of((d.getYear()+1900), mois).lengthOfMonth())
          	.mapToObj(day -> LocalDate.of((d.getYear()+1900), mois, day))
            .filter(date -> date.getDayOfWeek() == DayOfWeek.valueOf(jourRec))
            .forEach(date -> dateMensuelNonFormatee.add(""+date.getDayOfMonth()));
	        
	        
	        ArrayList<String> dateMensuelFormatee = new ArrayList<String>();
	        
	        for(int i = 0; i < dateMensuelNonFormatee.size(); ++i) {
	        	if(dateMensuelNonFormatee.get(i).length() == 1) {
	        		String tempo = "0"+dateMensuelNonFormatee.get(i);
	        		dateMensuelFormatee.add((d.getYear()+1900)+"-"+moisString+"-"+tempo);
	        	}
	        	else if(dateMensuelNonFormatee.get(i).length() > 1) {
	        	dateMensuelFormatee.add((d.getYear()+1900)+"-"+moisString+"-"+dateMensuelNonFormatee.get(i));
	        	}
	        	//System.out.println(dateMensuelFormatee.get(i));
	        }
	        
	        for(String e: dateMensuelFormatee) {
	        	//System.out.println(e);
	        }
	        /****************** COMPARER LES DATES *************/
	       
	        //definir la date du jour
	        java.util.Date startTime = null;
			try {
				startTime = new SimpleDateFormat("yyyy-MM-dd")
				        .parse(currentDate);
				System.out.println(startTime);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//comparer avec la date du jour
	           for(String e : dateMensuelFormatee) {
	        	  
	        	   java.util.Date ds = null;
				try {
					ds = new SimpleDateFormat("yyyy-MM-dd")
						        .parse(e);
					System.out.println(ds);
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				//start calendar corresond à la date d'aujourd'hui (date à laquelle il va ajouter une tache reccurrente 
				if(ds.after(startTime)) {
					//System.out.println(e.toString());
					//System.out.println(ds);
					listTache.add(new TacheSimple(nomTache,java.sql.Date.valueOf(e),heureDeb,heureFin,note,objet,idUser));
				}
				else
					System.out.println(ds);
					
	           }
		return listTache;
	}
	
	public static ArrayList<TacheSimple> creerListTacheContinu(String dateDebTache, int freq, String nomTache, String heureDeb, String heureFin,
			   String note, String objet, int idUser) {
			  ArrayList<TacheSimple> listTache = new ArrayList<>();
			  System.out.println(dateDebTache +" Tache de base à de base");
			  for(int i = 0; i < freq; ++i) {
			   String dt = dateDebTache;  // Start date

			   SimpleDateFormat sdf = new SimpleDateFormat("yyyy:MM:dd");
			   Date d = new Date();
			   String tab[] = dt.split("-");
			   int Jour = Integer.valueOf(tab[2])+i;
			   d.setYear(Integer.valueOf(tab[0]));
			   d.setMonth(Integer.valueOf(tab[1]));
			   d.setDate(Jour);
			   
			   
			   String annee = String.valueOf(d.getYear());
			   String mois =  String.valueOf(d.getMonth());
			   String Jour2 = String.valueOf(d.getDate());
			   
			   if(mois.length() == 1) {
			    mois = "0"+mois;
			   }
			   
			   if(Jour2.length() == 1) {
			    Jour2 ="0"+Jour2;
			   }
			 
			   String dateparam =annee+"-"+mois+"-"+Jour2;
			   listTache.add(new TacheSimple(nomTache,java.sql.Date.valueOf(dateparam),heureDeb,heureFin,note,objet,idUser));
			   System.out.println(dateparam +" Tache de dateParam");
			   
			     
			  }
			  return listTache;
	}
}
