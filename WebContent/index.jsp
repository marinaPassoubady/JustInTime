<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html >
<head>
  <meta charset="UTF-8">
  <title>Just in Time</title>
  <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=yes">
  
  <link rel='stylesheet prefetch' href='http://fonts.googleapis.com/css?family=Open+Sans'>

      <link rel="stylesheet" href="css/style.css">
<%String msgErrorSaisie = (String) request.getAttribute("error_saisie"); %>  
  
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
    <form method="post" action="verification">
	<h1>Just in Time</h1>
      <div class="login__check"></div>
      <div class="login__form">
        <div class="login__row">
          <svg class="login__icon name svg-icon" viewBox="0 0 20 20">
            <path d="M0,20 a10,8 0 0,1 20,0z M10,0 a4,4 0 0,1 0,8 a4,4 0 0,1 0,-8" />
          </svg>
          <input type="text" name="login" id="login" class="login__input name" placeholder="Login"/>
        </div>
        <div class="login__row">
          <svg class="login__icon pass svg-icon" viewBox="0 0 20 20">
            <path d="M0,20 20,20 20,8 0,8z M10,13 10,16z M4,8 a6,8 0 0,1 12,0" />
          </svg>
          <input id="mdp" type="password" name="mdp" class="login__input pass" placeholder="Mot de passe"/>
        </div>
        
		<button type="submit" class="login__submit">Se connecter</button>
        <p class="login__signup">Vous n'êtes pas encore inscrit? &nbsp;<a href="inscp.jsp">S'inscrire</a></p>
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
