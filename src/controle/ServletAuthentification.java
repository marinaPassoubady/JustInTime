package controle;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import metier.IUser;
import modele.GestionCompte;
import modele.GestionTache;
import metier.User;

/**
 * Servlet implementation class ServletAuthentification
 */
@WebServlet("/ServletAuthentification")
public class ServletAuthentification extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HttpSession session;
       
    /**
     * @throws ServletException 
     * @see HttpServlet#HttpServlet()
     */
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
 
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		authentification(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("login");
		String pass = request.getParameter("mdp");
		GestionCompte gp = new GestionCompte();
		GestionTache gt = new GestionTache();
		//on disait que connexn renvoyait l'user qui s'est connecté 
		User u = new User();
		if(gp.connexion(login, pass) == true) {
		u = gp.verifStatut(login);
		createSession(request,u);
		System.out.println("user connecte"+u.getIdUser());
		 try {
				gt.recupererTache(u);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		request.getRequestDispatcher("Calendar.jsp").forward(request, response);
			System.out.println("co");
		}else{
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}
	
	public void authentification(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("index.jsp").forward(req, resp);
		
	}
	
	public void createSession(HttpServletRequest req, IUser u) {
		session = req.getSession(true);
		session.setAttribute("user_identifie", u); 
	}

}
