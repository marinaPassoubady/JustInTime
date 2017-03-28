package metier;

import java.sql.Date;

public class TacheRecurrente extends ATache{
	private int recurrence;
	
	public TacheRecurrente(String title, Date date, int freq, String heuredebut,  String heurefin, String note, String objet, int idUser){
		super(title,date,heuredebut,heurefin,note,objet,idUser);
		this.recurrence = freq;
	}
	

	public TacheRecurrente(int idTache,String title, Date date, int freq, String heuredebut, String heurefin, String note, String objet, int idUser){
		super(idTache,title,date,heuredebut,heurefin,note,objet,idUser);
		this.recurrence = freq;
	}
	
	public TacheRecurrente(){
		;
	}


	public int getRecurrence() {
		return recurrence;
	}


	public void setRecurrence(int recurrence) {
		this.recurrence = recurrence;
	}
}
