package tools;

public class SyntaxHoraire {
	
	public static String createSyntax(String date, String horaire) {
		String horaireF = date+"T"+horaire+"-05:00";
		return horaireF;
	}
}
