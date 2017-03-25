package controle;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

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
		 HttpSession session = req.getSession();
		User u =(User) session.getAttribute("user_identifie");
		GestionTache gt = new GestionTache();
		String btn = req.getParameter("tachebtn");
		ArrayList<TacheSimple> listeTache = new ArrayList<TacheSimple>();
		
		if(btn.equals("tacheSimple")) {
		 String titre = req.getParameter("titre");
		 String date = req.getParameter("date");
		 String heuredeb =req.getParameter("heuredeb");
		 String heurefin =req.getParameter("heurefin");
		 String note =req.getParameter("note");
		 String objet =req.getParameter("objet");

		 TacheSimple ts = new TacheSimple(titre, Date.valueOf(date), heuredeb, heurefin, note, objet, u.getIdUser());
	
		 try {
			if(gt.verifTache(ts)){
					System.out.println("inseré !");
				}else{
					System.out.println("echec");
				}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
		else if(btn.equals("tacheRec")) {
			String titre = req.getParameter("titre");
			String mois = req.getParameter("mois");
			String jourDeb = req.getParameter("jour");
			String heuredeb =req.getParameter("heuredeb");
			String heurefin =req.getParameter("heurefin");
			String note =req.getParameter("note");
			String objet =req.getParameter("objet");
			System.out.println(objet);
			System.out.println(u.getIdUser());
			listeTache = RecupTacheRec.creerListTacheRec(Integer.parseInt(mois), jourDeb, titre, heuredeb, heurefin, note, objet, u.getIdUser());
			
			for(TacheSimple t : listeTache) {
				 try {
						if(gt.verifTache(t)){
								System.out.println("inseré !");
							}else{
								System.out.println("echec");
							}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
			
		}
		else if(btn.equals("tacheContinu")) {
			String titre = req.getParameter("titre");
			String date = req.getParameter("date");
			String freq = req.getParameter("freq");
			String heuredeb =req.getParameter("heuredeb");
			String heurefin =req.getParameter("heurefin");
			String note =req.getParameter("note");
			String objet =req.getParameter("objet");
			
			listeTache = RecupTacheRec.creerListTacheContinu(date, Integer.parseInt(freq), titre, heuredeb, heurefin, note, objet, u.getIdUser());
			
			for(TacheSimple t : listeTache) {
				 try {
						if(gt.verifTache(t)){
								System.out.println("inseré !");
							}else{
								System.out.println("echec");
							}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
			
		}	
		req.getRequestDispatcher("Calendar.jsp").forward(req, response);	 	
	}


}
