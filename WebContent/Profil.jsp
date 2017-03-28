<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.ArrayList" import="metier.TacheSimple" import="modele.GestionCompte"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% 
session = request.getSession();
ArrayList<TacheSimple> listeTache = (ArrayList<TacheSimple>) session.getAttribute("mes_taches_en_attente"); 
GestionCompte gc = new GestionCompte();

%>


    
</body>
</html>	

<%for(TacheSimple t : listeTache) { %>
	<div id="<%=t.getIdTache()%>">
			<label>Nom tache : <%=t.getTitre() %></label>
			<label>Date tache : <%=t.getDate() %></label>
			<label>Heure deb : <%=t.getHeuredeb() %></label>
			<label>Heure fin : <%=t.getHeurefin() %></label>
			<label>User origine : <%=gc.getLoginById(t.getIdUser()) %></label>
	</div>
<% } %>


<form method="post" action="servletTacheP">
<select name="tacheSelec">
	<option value="">Choisissez votre tache</option>
      <%for (TacheSimple ts : listeTache) { %>
      <option value="<%=ts.getIdTache()%>"><%=ts.getTitre()%></option>
      <% } %>
	 </select>
	<button type="submit" name="valider">Valider</button>
	<button type="submit" name="refuser">Refuser</button>
</form>