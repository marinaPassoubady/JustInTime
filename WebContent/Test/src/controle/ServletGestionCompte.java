package controle;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import metier.Professionnel;
import metier.User;
import modele.GestionCompte;

/**
 * Servlet implementation class ServletGestionCompte
 */
@WebServlet("/ServletGestionCompte")
public class ServletGestionCompte extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletGestionCompte() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Gson gson = new Gson();
		System.out.println("je suis passer dans la servlet gestionCompte get");
		GestionCompte gc = new GestionCompte();
		HttpSession session = request.getSession();
		User u = (User) session.getAttribute("user_identifie");
		String ami = request.getParameter("amiSearch");
		
		
	    
		if(gc.ajoutAmiByLogin(ami, u.getIdUser())) {
				String json = new Gson().toJson("true");
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				response.getWriter().write(json);
		}
		else {
			
			String json = new Gson().toJson("false");
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(json);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GestionCompte gc = new GestionCompte();
		HttpSession session = request.getSession();
		User u = (User) session.getAttribute("user_identifie");
		String pass = request.getParameter("pass");
		String date = request.getParameter("DateNaissance");
		String adresse = request.getParameter("Adresse");
		String tel = request.getParameter("Telephone");
		String mail =request.getParameter("Mail");
		
		if(u.getStatut().equals("professionnel")){
			String nomMetier = request.getParameter("NomMetier");
			String adrTravail = request.getParameter("AdresseLieuTravail");
			User u1 = gc.updatePro(u.getIdUser(),pass,adresse,Date.valueOf(date),Integer.parseInt(tel),mail,nomMetier,adrTravail);
			session.setAttribute("user_identifie",u1 );		
		}else if(u.getStatut().equals("autre")){
			String situationSociale = request.getParameter("situationSocial");
			User u2 = gc.updateAutre(u.getIdUser(), pass, adresse, Date.valueOf(date),Integer.parseInt(tel),mail, situationSociale);
			session.setAttribute("user_identifie",u2 );
		}else{
			String ecole = request.getParameter("ecole");
	 		String DateEntre = request.getParameter("dateDeb");
	 		String DateFin = request.getParameter("dateFin");
	 		User u3 = gc.updateEtudiant(u.getIdUser(), pass, adresse, Date.valueOf(date),Integer.parseInt(tel), mail, Date.valueOf(DateEntre),Date.valueOf(DateFin), ecole);
	 		session.setAttribute("user_identifie",u3 );
		}
		request.getRequestDispatcher("profile.jsp").forward(request, response);
	}

}
