package controle;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONException;

import com.google.gson.Gson;

import metier.TacheSimple;
import metier.User;
import modele.GestionTache;
import tools.VerifHoraire;
import toolsTache.RecupTacheRec;

/**
 * Servlet implementation class ServletCalendar
 */
@WebServlet("/ServletCalendar")
public class ServletCalendar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletCalendar() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//conversion du temps 
		PrintWriter out = response.getWriter();
		GestionTache gt = new GestionTache ();
		HttpSession session = request.getSession();
		User u = (User) session.getAttribute("user_identifie");
		ArrayList<TacheSimple> listTache = new ArrayList<TacheSimple>();
		try {
			listTache = gt.recupererTache(u);
			System.out.println("récupération des taches");
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		try {
			session.setAttribute("listeTaches",gt.recupererTache(u));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Gson gson = new Gson();

		JSONArray company = null;
		try {
			company = new JSONArray(gson.toJson(listTache));
			out.println(company);
			out.close();
			//
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
