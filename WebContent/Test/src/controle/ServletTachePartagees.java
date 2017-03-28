package controle;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import metier.TacheSimple;
import metier.User;
import modele.GestionCompte;
import modele.GestionTache;

/**
 * Servlet implementation class ServletTachePartagees
 */
@WebServlet("/ServletTachePartagees")
public class ServletTachePartagees extends HttpServlet {
	private static final long serialVersionUID = 1L;
    GestionTache gt;  
    GestionCompte gc;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletTachePartagees() {
        super();
        this.gt = new GestionTache();
        this.gc = new GestionCompte();
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User u = (User) session.getAttribute("user_identifie");
		session.setAttribute("mesAmis", gc.getMyFriends(u));
		session.setAttribute("mes_taches_en_attente", gt.getMesTachesEnAttentePartage(u.getIdUser()));
		System.out.println("je suis passé par la");
		request.getRequestDispatcher("profile.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String valider = request.getParameter("valider");
		String refuser = request.getParameter("refuser");
		String tacheChoisi = request.getParameter("tacheSelec");
		int idTacheChoisi = Integer.parseInt(tacheChoisi);
		User u = (User) session.getAttribute("user_identifie");
		ArrayList<TacheSimple> maListeTacheAttente = (ArrayList<TacheSimple>) session.getAttribute("mes_taches_en_attente");
		
		if(valider != null) {
			gt.updateTachePTrue(Integer.parseInt(tacheChoisi),u);
			for(TacheSimple t : maListeTacheAttente) {
				if(t.getIdTache() == idTacheChoisi) {
					t.setIdUser(u.getIdUser());
					gt.insererTache(t);
					System.out.println("tache partagée insérée "+t.getIdUser());
				}
			}		
		}
		else
			gt.updateEtatTachePFalse(Integer.parseInt(tacheChoisi),u);
		
		doGet(request,response);
	}
	
	

}
