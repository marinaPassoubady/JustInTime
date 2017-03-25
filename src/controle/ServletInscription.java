package controle;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modele.GestionCompte;

/**
 * Servlet implementation class ServletInscription
 */
@WebServlet("/ServletInscription")
public class ServletInscription extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletInscription() {
        super();
        // TODO Auto-generated constructor stub
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
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		GestionCompte gc = new GestionCompte();
		 String nom = req.getParameter("nom");
		 System.out.println(nom);
		 String prenom = req.getParameter("prenom");
		 String login = req.getParameter("login");
		 String pass = req.getParameter("pass");
		 String adresse = req.getParameter("adresse");
		 String age = req.getParameter("age");
		 System.out.println(age);
		 String dateNaiss = req.getParameter("dateNaiss");
		 System.out.println(dateNaiss);
		 String tel = req.getParameter("tel");
		 String mail = req.getParameter("mail");
		 String statut = req.getParameter("statut");
		 System.out.println(statut);
		 switch(statut) {
		 	case "2" :
		 		
				  String nomMetier = req.getParameter("nomMetier");
				  String adrTravail = req.getParameter("adrTravail");
			try {
				gc.inscriptionPro(login, pass, nom, prenom, adresse, Integer.parseInt(age), Date.valueOf(dateNaiss), Integer.parseInt(tel), mail,"professionnel", nomMetier, adrTravail);
			} catch (NumberFormatException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
			  
		 	case "3" : 
		 		
		 		String ecole = req.getParameter("nomEtablissement");
		 		String DateEntre = req.getParameter("dateDeb");
		 		System.out.println(DateEntre);
		 		String DateFin = req.getParameter("dateFin");
		 		System.out.println(DateFin);
			try {
				gc.inscriptionEtu(login, pass,nom, prenom, adresse, Integer.parseInt(age), Date.valueOf(dateNaiss), Integer.parseInt(tel), mail,"etudiant", ecole, Date.valueOf(DateEntre), Date.valueOf(DateFin));
			} catch (NumberFormatException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 	break;
		  case "4" : 
			  
		  String situationSociale = req.getParameter("situationSoc");
		  try {
	  		gc.inscriptionAutre(login, pass, nom, prenom, adresse, Integer.parseInt(age), Date.valueOf(dateNaiss), Integer.parseInt(tel), mail,"autre", situationSociale);
	  		}catch(NumberFormatException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  break;	
		  
		  }
		 req.getRequestDispatcher("Accueil.jsp").forward(req, response);
	}
	
	

}
