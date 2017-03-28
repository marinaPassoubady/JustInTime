<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html >
<head>
  <meta charset="UTF-8">
  <title>Just in Time</title>
  <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=yes">
  
  <link rel='stylesheet prefetch' href='http://fonts.googleapis.com/css?family=Open+Sans'>
<script type="text/javascript" src="./js/script.js"></script>
      <link rel="stylesheet" href="css/styleInscription.css">
      <link rel="stylesheet" href="styleInscription.css">
      
<%String msgErrorSaisie = (String) request.getAttribute("msgErrorIns"); %>      
</head>
<style>
h2#erreur {
font-size: 30px;
color : white;
background-color : #ff000080;
padding-left: 150px;
padding-right : 150px;
font-weight: initial;
padding-top: 12px;
text-align: center;
font-family: 'Cookie-Regular';
    /* font-family: "Open Sans", Helvetica, Arial, sans-serif; */
}</style>
<body>
  <div class="cont">
  	   <%if (msgErrorSaisie != null) { %>
	<h2 id="erreur"><%=msgErrorSaisie %></h2>
  <% } %>
  <div class="demo">
    <div class="login">
    <form method="post" action="inscription">
	<h1>Just in Time</h1>
      
      <div class="login__form" style="top:15%;">
        <div class="login__row">
          <input type="text" name="nom" pattern="[a-zA-Z]*"  id="nom"  class="login__input name" placeholder="Nom" onblur="verifPseudo(this)"/>
           <input type="text" name="Adresse" pattern="([a-zA-Z0-9]| |/|\|@|#|$|%|&)+"  id="Adresse" class="login__input name" placeholder="Adresse"/>
        </div>
        <div class="login__row">
          <input id="prenom" type="text" name="prenom" pattern="[A-Za-z]*" class="login__input name" placeholder="Prénom" onblur="verifPseudo(this)"/>
           <input id="age" type="text" name="age" pattern="[0-9]{2}" class="login__input name" placeholder="Age"/>
        </div>
        <div class="login__row">
          <input type="text" name="login" id="login" class="login__input name" placeholder="Login"/>
             <input id="dateNaiss" type="text" name="dateNaiss" class="login__input name" placeholder="Date de naissance"/>
        </div>
        <div class="login__row">
          <input id="pass" type="password" name="pass" class="login__input pass" placeholder="Mot de passe"/>
           <input type="tel" pattern="^((\+\d{1,3}(-| )?\(?\d\)?(-| )?\d{1,5})|(\(?\d{2,6}\)?))(-| )?(\d{3,4})(-| )?(\d{4})(( x| ext)\d{1,5}){0,1}$" name="tel" 
			id="Telephone" class="login__input name" placeholder="Téléphone"/>
        </div>
      	<div class="login__row">
		<input name="mail" id="mail" type="email" class="login__input name" placeholder="Mail" style="margin-left: -10%;" type="text">
		
			<select class="txtfield"  name="statut" size="1" id="select" value="1" onchange="hideThis();">
				<option value="1" selected="selected">Votre statut</option>
  				<option value="2" >Professionnel</option>
  				<option value="3">Etudiant</option>
 				<option value="4">Autre</option>
				</select>
			
			</div>
			<div style="display:none;"class="login__row" id = "form1">
				<input type="text" name="nomMetier"  pattern="[A-Za-z]*" id="nomMetier" class="login__input name" placeholder="Nom de votre metier"/>
				<input type="text" name="adrTravail"  pattern="[A-Za-z]*" id="adrTravail" class="login__input name" placeholder="Adresse de travail"/>
			</div>

			<div style="display:none;"  id = "form2">
			<div class="login__row">
				<input type="text" name="nomEtablissement"  pattern="[A-Za-z]*" id="nomEtablissement" class="login__input name" placeholder="Nom de votre etablissement"/>
				<input type="text" name="dateDeb" id="dateDeb" class="login__input name" placeholder="Date de début"/>
				</div>
				<div class="login__row">
			<input name="dateFin" id="dateFin" class="login__input name" placeholder="Date de fin" style="margin-left: -32%;" type="text">	
			</div>
			</div>
			

			<div style="display:none;"class="login__row" id = "form3">
				<input name="situationSoc"  pattern="[A-Za-z]*" id="situationSoc" class="login__input name" placeholder="Situation sociale" style="margin-left: -31%;" type="text">
			</div>

        <!--<a href="inscp.html">-->
		<button type="submit" class="login__submit">Sign in</button>
		<p class="login__signup">Vous êtes déjà inscrit ? &nbsp;<a href="index.jsp">Se connecter</a></p>

      </div>
      </form>
    </div>
 
      <div class="app__logout">
        <svg class="app__logout-icon svg-icon" viewBox="0 0 20 20">
          <path d="M6,3 a8,8 0 1,0 8,0 M10,0 10,12"/>
        </svg>
      </div>
    </div>
  </div>
</div>
  <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

    <script src="js/index.js"></script>

</body>
</html>
