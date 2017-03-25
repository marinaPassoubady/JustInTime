package metier;

import java.sql.Date;

public class TacheSimple extends ATache{	

	public TacheSimple(String title, Date date,String heuredebut,  String heurefin, String note, String objet, int idUser){
		super(title,date,heuredebut,heurefin,note,objet,idUser);
		}
	

	public TacheSimple(int idTache,String title,  Date date, String heuredebut, String heurefin, String note, String objet, int idUser){
		super(idTache,title,date,heuredebut,heurefin,note,objet,idUser);
		}
	
	public TacheSimple(){
		;
	}



	

}
