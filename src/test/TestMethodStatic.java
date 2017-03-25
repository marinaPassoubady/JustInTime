package test;

import java.util.ArrayList;

import metier.TacheSimple;
import toolsTache.RecupTacheRec;

public class TestMethodStatic {
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
		ArrayList<TacheSimple> d =RecupTacheRec.creerListTacheRec(3, "WEDNESDAY", "Stage", "10:00:00", "20:00:00", "tessst", "caméra", 1);
		
		for(TacheSimple s : d) {
			System.out.println("Prevu le :"+s.getDate()+" nom de la tache "+s.getTitre()+"commence à : "+s.getHeuredeb()+" termine à : "+s.getHeurefin()
			+" start at : "+s.getStart()+" end at : "+s.getEnd()+" vos notes : "+s.getNote()+" vos objets : "+s.getObjet());
		}
	}
}
