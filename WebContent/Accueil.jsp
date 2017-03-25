<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="./styleCSS/style.css">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="verif">
		<fieldset>
			<legend>Connexion Utilisateur :</legend>
			<p>
				<label for="id">Login : </label> <input type="text" name="login"
					id="login" value="" />
			</p>
			<p>
				<label for="mdp">Mot de passe : </label> <input type="text"
					name="mdp" id="mdp" value="" />
			</p>
		</fieldset>
		<input type="submit" value="valider" />
	</form>
</body>
</html>