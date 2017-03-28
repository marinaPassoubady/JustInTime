package tools;

import java.util.Timer;
import java.util.TimerTask;

import metier.User;
import modele.GestionTache;

public class TimerVerifTachePartagee extends TimerTask {
	
	private int idTachePrim;
	private int idTacheP;
	GestionTache t = new GestionTache();
	private Timer timer;
	private User UserAmi;
	public TimerVerifTachePartagee(int idTachePrim, int idTacheP, User UserAmi, Timer timer) {
		super();
		this.idTachePrim = idTachePrim;
		this.idTacheP = idTacheP;
		this.timer = timer;
		this.UserAmi = UserAmi;
		System.out.println("user ami timer"+UserAmi.getIdUser());
		
	}
	

	
	@Override
	public void run() {
		if(t.verifEtatTacheP(idTachePrim,UserAmi)) {
			System.out.println("je suis passe dans la verif du timer");
			t.updateEtatTachePFalse(idTacheP,UserAmi);
			System.out.println("jai modifié en false la tache");
			timer.cancel();
		}
		else {
			System.out.println("je suis passe dans le else du timer");
			timer.cancel();
		}
	}

}
