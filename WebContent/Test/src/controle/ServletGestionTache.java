package controle;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Timer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import metier.IUser;
import metier.TacheSimple;
import metier.User;
import modele.GestionCompte;
import modele.GestionTache;
import modele.ProgContrainte;
import tools.TimerVerifTachePartagee;
import toolsTache.RecupTacheRec;

/**
 * Servlet implementation class ServletGestionTache
 */
@WebServlet("/ServletGestionTache")
public class ServletGestionTache extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletGestionTache() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		GestionCompte gc = new GestionCompte();
		HttpSession session = req.getSession();
		User u =(User) session.getAttribute("user_identifie");
		GestionTache gt = new GestionTache();
		String btn = req.getParameter("tachebtn");
		ArrayList<TacheSimple> listeTache = new ArrayList<TacheSimple>();
		String msgConfirm = "La t&acircche a bien &eacutet&eacute ajout&eacutee !";
		String msgError =  "Vous n'avez pas rempli tous les champs !";
		String msgErrorInsert = "Ce cr&eacuteneau horaire n'est pas disponible !";
		String msgErrorTache = "Cette tt&acircche n'existe pas !";
		String msgErrorAmi = "Votre liste d'amis n'est pas correcte !";
		String msgPartageError = "Certains amis ne sont pas disponibles !";
		
		if(btn.equals("tacheSimple")) {
			String titre = req.getParameter("titre");
			String date = req.getParameter("date");
			String heuredeb =req.getParameter("heuredeb");
			String heurefin =req.getParameter("heurefin");
			String note =req.getParameter("note");
			String objet =req.getParameter("objet");
			
			if(titre.equals("") || date.equals("") || heuredeb.equals("") || heurefin.equals("")) {
				req.setAttribute("erreur_saisietache",msgError );
				req.getRequestDispatcher("Calendar.jsp").forward(req, response);
			 } else {

			TacheSimple ts = new TacheSimple(titre, Date.valueOf(date), heuredeb, heurefin, note, objet, u.getIdUser());

			try {
				if(gt.verifTache(ts)){
					System.out.println("inseré !");
					req.setAttribute("msgConfirmTache", msgConfirm);
					req.getRequestDispatcher("Calendar.jsp").forward(req, response);
				}else{
					req.setAttribute("erreur_horaire", msgErrorInsert);
					System.out.println("echec");
				}
			} catch (Exception e) {
				req.setAttribute("erreur_horaire", msgErrorInsert);
				e.printStackTrace();
			}

		}
		} 
		if(btn.equals("tacheRec")) {
			String titre = req.getParameter("titre");
			String mois = req.getParameter("mois");
			String jourDeb = req.getParameter("jour");
			String heuredeb =req.getParameter("heuredeb");
			String heurefin =req.getParameter("heurefin");
			String note =req.getParameter("note");
			String objet =req.getParameter("objet");
			
			if(titre.equals("") || mois.equals("") || jourDeb.equals("") || heuredeb.equals("") || heurefin.equals("")) {
				req.setAttribute("erreur_saisietache",msgError );
				req.getRequestDispatcher("Calendar.jsp").forward(req, response);
			 }
			else {
				listeTache = RecupTacheRec.creerListTacheRec(Integer.parseInt(mois), jourDeb, titre, heuredeb, heurefin, note, objet, u.getIdUser());
	
				for(TacheSimple t : listeTache) {
					try {
						if(gt.verifTache(t)){
							req.setAttribute("msgConfirmTache", msgConfirm);
							System.out.println("inseré !");
						}else{
							req.setAttribute("erreur_horaire", msgErrorInsert);
							System.out.println("echec");
						}
					} catch (Exception e) {
						req.setAttribute("erreur_horaire", msgErrorInsert);
						e.printStackTrace();
					}
				}
			}
		}
		if(btn.equals("tacheContinue")) {
			String titre = req.getParameter("titre");
			String date = req.getParameter("date");
			String freq = req.getParameter("nbJour");
			String heuredeb =req.getParameter("heuredeb");
			String heurefin =req.getParameter("heurefin");
			String note =req.getParameter("note");
			String objet =req.getParameter("objet");
			
			if(titre.equals("") || date.equals("") || freq.equals("") || heuredeb.equals("") || heurefin.equals("")) {
				req.setAttribute("erreur_saisietache",msgError );
				req.getRequestDispatcher("Calendar.jsp").forward(req, response);
			 }
			else {
				listeTache = RecupTacheRec.creerListTacheContinu(date, Integer.parseInt(freq), titre, heuredeb, heurefin, note, objet, u.getIdUser());
	
				for(TacheSimple t : listeTache) {
					try {
						if(gt.verifTache(t)){
							req.setAttribute("msgConfirmTache", msgConfirm);
							System.out.println("inseré tache continu !");
						}else{
							req.setAttribute("erreur_horaire", msgErrorInsert);
							System.out.println("echec");
						}
					} catch (Exception e) {
						req.setAttribute("erreur_horaire", msgErrorInsert);
						e.printStackTrace();
					}
				}
			}
		}	

		if (btn.equals("tachePartageFixe")) { //avec une personne ou plusieurs personne
			String titre = req.getParameter("titre");
			String date = req.getParameter("date");
			String heuredeb =req.getParameter("heuredeb");
			String heurefin =req.getParameter("heurefin");
			String loginUserP = req.getParameter("friends");
			String[] listeAmiP = loginUserP.split(",");
			
			if(titre.equals("") || date.equals("") || heuredeb.equals("") || heurefin.equals("") || loginUserP.equals("")) {
				req.setAttribute("erreur_saisietache",msgError );
				req.getRequestDispatcher("Calendar.jsp").forward(req, response);
			 }
			else {
				for(int i = 0; i < listeAmiP.length; ++i) {
					User ami = gc.trouverUser(listeAmiP[i]);
					if(ami != null) {
					if(gc.findFriends(ami)) {
						TacheSimple ts = gt.findTache(titre, date, heuredeb, heurefin, u.getIdUser());
						if(ts != null) {
							ts.setIdUser(ami.getIdUser());
							try {
								if(gt.verifTache2(ts)) {
									req.setAttribute("msgConfirmTache", msgConfirm);
									Timer t = new Timer();
									gt.partagerTacheSolo(u.getIdUser(), ts.getIdTache(), ts.getIdUser());
									int idLastTacheP = gt.getLastTachePartagee();
									t.schedule(new TimerVerifTachePartagee(idLastTacheP,ts.getIdTache(),ami,t), 180000); //3 mins
								}
							} catch (Exception e) {
								req.setAttribute("erreur_horairePartage", msgPartageError);
								e.printStackTrace();
							}
						}
						else {
							//toast
							req.setAttribute("erreur_tacheBase", msgErrorTache);
							System.out.println("tache erronée");
						}
					}
					else {
						//toast
						req.setAttribute("erreur_AmiExiste", msgErrorAmi);
						System.out.println("ce n'est pas votre ami");
					}
				}
				else {
					req.setAttribute("erreur_AmiExiste", msgErrorAmi);
					}
				}
			}
		}
		
		if(btn.equals("tachePartageContrainteGrp")) {
			String titre = req.getParameter("titre");
			String date = req.getParameter("date");
			String duree =req.getParameter("duree");
			String loginUserP = req.getParameter("friends");
			String note =req.getParameter("note");
			String objet =req.getParameter("objet");
			ArrayList<IUser> arrayAmi = new ArrayList<IUser>();
			String[] listeAmiP = loginUserP.split(",");
			
			if(titre.equals("") || date.equals("") || duree.equals("") || loginUserP.equals("")) {
				req.setAttribute("erreur_saisietache",msgError );
				req.getRequestDispatcher("Calendar.jsp").forward(req, response);
			 }
			else {
				arrayAmi.add(u);
				for(int i = 0; i < listeAmiP.length; ++i) {
					User ami = gc.trouverUser(listeAmiP[i]);
					if(ami == null) {
						req.setAttribute("erreur_AmiExiste", msgErrorAmi);
					}
					else {
						
						if(gc.findFriends(ami)) {
							arrayAmi.add(ami);
						try {
							ProgContrainte.AjoutTacheCOntrainte(date, titre, note, objet, Integer.parseInt(duree), arrayAmi);
							req.setAttribute("msgConfirmTache", msgConfirm);
						} catch (NumberFormatException e) {
							req.setAttribute("erreur_horairePartage", msgPartageError);
							e.printStackTrace();
						} catch (Exception e) {
							req.setAttribute("erreur_horairePartage", msgPartageError);
							e.printStackTrace();
						}
					}
						else {
							req.setAttribute("erreur_AmiExiste", msgErrorAmi);
						}
					}
				}
			}
		}
		
		if(btn.equals("tachePartageContrainteMoi")) {
			String titre = req.getParameter("titre");
			String date = req.getParameter("date");
			String duree =req.getParameter("duree");
			String note =req.getParameter("note");
			String objet =req.getParameter("objet");
			ArrayList<IUser> arrayAmi = new ArrayList<IUser>();
			
			if(titre.equals("") || date.equals("") || duree.equals("")) {
				req.setAttribute("erreur_saisietache",msgError );
				req.getRequestDispatcher("Calendar.jsp").forward(req, response);
			 }
			else {
			arrayAmi.add(u);
			try {
				ProgContrainte.AjoutTacheCOntrainte(date, titre, note, objet, Integer.parseInt(duree), arrayAmi);
				req.setAttribute("msgConfirmTache", msgConfirm);
			} catch (NumberFormatException e) {
				req.setAttribute("erreur_horaire", msgErrorInsert);
				e.printStackTrace();
			} catch (Exception e) {
				req.setAttribute("erreur_horaire", msgErrorInsert);
				e.printStackTrace();
			}
			
			}
		}
		
		if(btn.equals("TacheSpec")){
			System.out.println("spécifique");
			String titre = req.getParameter("titre");
			String date = req.getParameter("date");
			String heuredeb =req.getParameter("heuredeb");
			String heurefin =req.getParameter("heurefin");
			String note =req.getParameter("note");
			String objet =req.getParameter("objet");
			String labelSpec1 = req.getParameter("labelSpec1");
			String labelSpec2 = req.getParameter("labelSpec2");

			
			if(titre.equals("") || date.equals("") || heuredeb.equals("") || heurefin.equals("") || labelSpec1.equals("") || labelSpec2.equals("")) {
				req.setAttribute("erreur_saisietache",msgError);
				req.getRequestDispatcher("Calendar.jsp").forward(req, response);
			 }
			
			else {
				String noteSpec = labelSpec1+" : "+note+"\n "+labelSpec2+" : "+objet;
				//System.out.println(labelSpec1 +""+labelSpec2);
				String obj="";
				TacheSimple tacheSpecifique = new TacheSimple(titre, Date.valueOf(date), heuredeb, heurefin, noteSpec, obj , u.getIdUser());
				try {
					if(gt.verifTache(tacheSpecifique)){
						req.setAttribute("msgConfirmTache", msgConfirm);
						System.out.println("inseré !");
					}else{
						req.setAttribute("erreur_horaire", msgErrorInsert);
						System.out.println("echec");
					}
				} catch (Exception e) {
					req.setAttribute("erreur_horaire", msgErrorInsert);
					e.printStackTrace();
				};
			}
		}

		req.getRequestDispatcher("Calendar.jsp").forward(req, response);
	 	
	}


}
