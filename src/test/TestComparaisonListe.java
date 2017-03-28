package test;

import java.util.ArrayList;

import metier.TacheSimple;
import modele.GestionTache;

public class TestComparaisonListe {

	public static void main(String[] args) {
		
		GestionTache gt = new GestionTache();
		ArrayList<TacheSimple> a = gt.getMesTachesEnAttentePartage(2);
		
		for(TacheSimple ts : a) {
			System.out.println(ts.getTitre()+" "+ts.getIdUser());
		}

	}

}
