package test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.stream.IntStream;

public class TestRec {

	public static void main(String[] args) {
		
		/*//POUR AJOUTER DES TACHES SUR DES JOURS A LA SUITE
		int freq = 41;
		String dt1 = "2017-03-23";  // Start date
		for(int i = 1; i <= freq; ++i) {
			String dt = dt1;  // Start date
			int cpt;
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			try {
				c.setTime(sdf.parse(dt));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			cpt=i;
			c.add(Calendar.DATE, cpt);  // number of days to add
			dt = sdf.format(c.getTime());
			System.out.println(dt.toString()); //creer la tache simple
			cpt+=i;
		}*/
		
		//AJOUTER TOUS LES LUNDIS
		
		//définir les varialbes année et jur que l'on recuperera à partir du formulaire ! faire un split
		 String year = "2017";
		 String jour = "MONDAY";
		 int y = Integer.parseInt(year);
		 int te = y;
	     String month = "03";
	     int m = Integer.parseInt(month);
	     int temp = m;
	     ArrayList<String> dateMensuelNonFormatee = new ArrayList<String>(); 
	        IntStream.rangeClosed(1,YearMonth.of(te, temp).lengthOfMonth())
            .mapToObj(day -> LocalDate.of(te, temp, day))
            .filter(date -> date.getDayOfWeek() == DayOfWeek.valueOf(jour))
            .forEach(date -> dateMensuelNonFormatee.add(""+date.getDayOfMonth()));
	        
	        
	        ArrayList<String> dateMensuelFormatee = new ArrayList<String>();
	        
	        ArrayList<String> dateMensuelFormateeT = new ArrayList<String>();
	        ArrayList<Date> dateFormatee = new ArrayList<Date>();
	        for(int i = 0; i < dateMensuelNonFormatee.size(); ++i) {
	        	if(dateMensuelNonFormatee.get(i).length() == 1) {
	        		String tempo = "0"+dateMensuelNonFormatee.get(i);
	        		dateMensuelFormatee.add(year+":"+month+":"+tempo);
	        	}
	        	else {
	        	dateMensuelFormatee.add(year+":"+month+":"+dateMensuelNonFormatee.get(i));
	        	}
	        	//System.out.println(dateMensuelFormatee.get(i));
	        }
	        
	        
	        /**************** TEST 2 COMPARAISON DATE **************/
	     // Start Time
            java.util.Date startTime = null;
			try {
				startTime = new SimpleDateFormat("yyyy:mm:dd")
				        .parse("2017:03:20");
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            java.util.Date endTime = null;
			try {
				endTime = new SimpleDateFormat("yyyy:mm:dd")
				        .parse("2017:03:20");
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            Date endCalendar = endTime;
            Date startCalendar = startTime;
            boolean b = startCalendar.before(endCalendar);
   
            
          /****************** COMPARER LES DATES *************/  
           for(String e : dateMensuelFormatee) {
        	  
        	   java.util.Date d = null;
			try {
				d = new SimpleDateFormat("yyyy:mm:dd")
					        .parse(e);
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
			//start calendar corresond à la date d'aujourd'hui (date à laquelle il va ajouter une tache reccurrente 
			if(startCalendar.before(d)) {
				dateMensuelFormateeT.add(e);
			}
		
     
 
	}
        Date ds = new Date();
   		
        String modifiedDate= new SimpleDateFormat("yyyy-MM-dd").format(ds);
        
        System.out.println(modifiedDate);
        
        
   		
	}
}
