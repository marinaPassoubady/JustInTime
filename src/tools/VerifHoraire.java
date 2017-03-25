package tools;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class VerifHoraire {
	
	
	public static boolean verifHeureDebut(String argStartTime,
            String argEndTime, String heureDebutTacheInsere) throws ParseException {
        String reg = "^([0-1][0-9]|2[0-3]):([0-5][0-9]):([0-5][0-9])$";
        //
        if (argStartTime.matches(reg) && argEndTime.matches(reg)
                && heureDebutTacheInsere.matches(reg)) {
            boolean valid = false;
            // Start Time
            java.util.Date startTime = new SimpleDateFormat("HH:mm:ss")
                    .parse(argStartTime);
            Calendar startCalendar = Calendar.getInstance();
            startCalendar.setTime(startTime);

            // Current Time
            java.util.Date currentTime = new SimpleDateFormat("HH:mm:ss")
                    .parse(heureDebutTacheInsere);
            Calendar currentCalendar = Calendar.getInstance();
            currentCalendar.setTime(currentTime);

            // End Time
            java.util.Date endTime = new SimpleDateFormat("HH:mm:ss")
                    .parse(argEndTime);
            Calendar endCalendar = Calendar.getInstance();
            endCalendar.setTime(endTime);

            //
            if (currentTime.compareTo(endTime) < 0) {

                currentCalendar.add(Calendar.DATE, 1);
                currentTime = currentCalendar.getTime();

            }

            if (startTime.compareTo(endTime) < 0) {
                startCalendar.add(Calendar.DATE, 1);
                startTime = startCalendar.getTime();

            }
            
            if (currentTime.before(startTime)) {

                System.out.println(" Time is Lesser ");

                valid = false;
            } else {

                if (currentTime.after(endTime)) {
                    endCalendar.add(Calendar.DATE, 1);
                    endTime = endCalendar.getTime();

                }

                //System.out.println("Comparing , Start Time /n " + startTime);
               // System.out.println("Comparing , End Time /n " + endTime);
              //  System.out
              //.println("Comparing , Current Time /n " + currentTime);

                if (currentTime.before(endTime)) {
                    System.out.println("RESULT, Time lies b/w");
                    valid = true;
                } else {
                    valid = false;
                    System.out.println("RESULT, Time does not lies b/w");
                }

            }
            return valid;

        } else {
            throw new IllegalArgumentException(
                    "Not a valid time, expecting HH:MM:SS format");
        }

    }
	
	public static boolean verifHeureFin(String argStartTime,
            String argEndTime, String heureFinTacheInsere) throws ParseException {
        String reg = "^([0-1][0-9]|2[0-3]):([0-5][0-9]):([0-5][0-9])$";
        //
        if (argStartTime.matches(reg) && argEndTime.matches(reg)
                && heureFinTacheInsere.matches(reg)) {
            boolean valid = false;
            // Start Time
            
            java.util.Date startTime = new SimpleDateFormat("HH:mm:ss")
                    .parse(argStartTime);
            Calendar startCalendar = Calendar.getInstance();
            startCalendar.setTime(startTime);
            
            

            // Current Time
            java.util.Date currentTime = new SimpleDateFormat("HH:mm:ss")
                    .parse(heureFinTacheInsere);
            Calendar currentCalendar = Calendar.getInstance();
            currentCalendar.setTime(currentTime);

            // End Time
            java.util.Date endTime = new SimpleDateFormat("HH:mm:ss")
                    .parse(argEndTime);
            Calendar endCalendar = Calendar.getInstance();
            endCalendar.setTime(endTime);

            //
            if (currentTime.compareTo(endTime) < 0) {
            	System.out.println();
                //currentCalendar.add(Calendar.DATE, 1);
                currentTime = currentCalendar.getTime();

            }

            if (startTime.compareTo(endTime) < 0) {

               // startCalendar.add(Calendar.DATE, 1);
                startTime = startCalendar.getTime();

            }
            
            if (currentTime.before(startTime) || currentTime.equals(startTime)) {

                System.out.println(" Time is Lesser ");

                valid = false;
            } else {

                if (currentTime.after(endTime)) {
                   // endCalendar.add(Calendar.DATE, 1);
                    endTime = endCalendar.getTime();

                }

                System.out.println("Comparing , Start Time /n " + startTime);
                System.out.println("Comparing , End Time /n " + endTime);
                System.out
                        .println("Comparing , Current Time /n " + currentTime);

                if (currentTime.before(endTime)) {
                    System.out.println("RESULT, Time lies b/w");
                    valid = true;
                } else {
                    valid = false;
                    System.out.println("RESULT, Time does not lies b/w");
                }

            }
            return valid;

        } else {
            throw new IllegalArgumentException(
                    "Not a valid time, expecting HH:MM:SS format");
        }

    }
	
	public static boolean verifHeureEnglobe(String argStartTime,
			String argEndTime, String heureDebutTacheInsere , String heureFinTacheInsere) throws ParseException {
		String reg = "^([0-1][0-9]|2[0-3]):([0-5][0-9]):([0-5][0-9])$";
		//
		if (argStartTime.matches(reg) && argEndTime.matches(reg)
				&& heureDebutTacheInsere.matches(reg) && heureFinTacheInsere.matches(reg)) {
			boolean valid = false;
		}
		// Start Time
		java.util.Date startTime = new SimpleDateFormat("HH:mm:ss")
				.parse(argStartTime);
		Calendar startCalendar = Calendar.getInstance();
		startCalendar.setTime(startTime);

		// Current Time start
		java.util.Date currentTimeDeb = new SimpleDateFormat("HH:mm:ss")
				.parse(heureDebutTacheInsere);
		Calendar currentCalendarDeb = Calendar.getInstance();
		currentCalendarDeb.setTime(currentTimeDeb);

		// Current Time end
		java.util.Date currentTimeFin = new SimpleDateFormat("HH:mm:ss")
				.parse(heureFinTacheInsere);
		Calendar currentCalendarFin = Calendar.getInstance();
		currentCalendarFin.setTime(currentTimeFin);

		// End Time
		java.util.Date endTime = new SimpleDateFormat("HH:mm:ss")
				.parse(argEndTime);
		Calendar endCalendar = Calendar.getInstance();
		endCalendar.setTime(endTime);

		//
		if (currentTimeDeb.compareTo(startTime) < 0 && currentTimeFin.compareTo(endTime) > 0) {
			System.out.println("heure pb");
			return false;

		}
		System.out.println("heure no pb");
		return true;
	}
}
