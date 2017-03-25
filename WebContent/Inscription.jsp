<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <link rel="stylesheet" type="text/css" href="./styleCSS/style1.css">
 <script type="text/javascript" src="./js/script.js"></script>
<title>Inscription</title>
</head>
<body>

<form method="post" action="inscription">
			<p>
			<label for="nom">Nom :</label>
			<input type="text" name="nom" id="nom" onblur="verifPseudo(this)"/></p>
			
			<p><label for="prenom">Prenom :</label> 
			<input type="text" name="prenom" id="prenom" onblur="verifPseudo(this)"/></p>
			
			<p><label for="prenom">Login :</label> 
			<input type="text" name="login" id="login" onblur="verifPseudo(this)"/></p>
			
			<p><label for="prenom">Password :</label> 
			<input type="password" name="pass" id="pass" onblur="verifPseudo(this)"/></p>
			
			<p><label for="adresse">Adresse :</label>
			<input type="text" name="adresse" id="adresse" onblur="verifAdresse(this)"/></p>
			
			<p><label for="age">Age :</label>
			<input type="text" name="age" id="age" size="2" onblur="verifAge(this)"/></p>

			<p><label for="dateNaiss">Date naissance :</label> 
			<input type="text" name="dateNaiss" id="dateNaiss"/></p>
			
			<p><label for="tel">Telephone :</label> 
			<input type="tel" pattern="^((\+\d{1,3}(-| )?\(?\d\)?(-| )?\d{1,5})|(\(?\d{2,6}\)?))(-| )?(\d{3,4})(-| )?(\d{4})(( x| ext)\d{1,5}){0,1}$" name="tel" 
			id="Telephone"/></p>
			
			<p><label for="mail">Mail :</label>
			 <input type="text" name="mail" id="mail"/></p>

			<p><label for="statut">Statut :</label> <select name="statut" size="1" id="select" value="1" onchange="hideThis();">
				<option value="1"  selected="selected">Choisissez votre statut</option>
  				<option value="2">Professionnel</option>
  				<option value="3">Etudiant</option>
 				<option value="4">Autre</option>
				</select></p>

			<div id = "form1">
			<p><label for="nomMetier">Votre metier :</label>
				<input type="text" name="nomMetier" id="nomMetier"/></p>
			<p><label for="adrTravail">Votre adresse de travail :</label>
				<input type="text" name="adrTravail" id="adrTravail"/></p>
			</div>

			<div id = "form2">
			<p><label for="nomMetier">Votre nom d'établissement :</label>
				<input type="text" name="nomEtablissement" id="nomEtablissement"/></p>
			<p><label for="dateDeb">Date d'entrée :</label>
				<input type="text" name="dateDeb" id="dateDeb"/></p>
			<p><label for="dateFin">Date de fin :</label>
				<input type="text" name="dateFin" id="dateFin"/></p>	
			</div>

			<div id = "form3">
			<label for="situationSoc">Situation sociale :</label>
				<input type="text" name="situationSoc" id="situationSoc"/>
			</div>
			<input type="submit" name="inscription" value="s'inscrire">
</form>	
</body>
</html>