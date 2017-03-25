<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>PagePro</title>
</head>
<body>

<h1>Récapitulatif de vos infos :</h1>
<p>idUser : ${sessionScope.user_identifie.idUser}</p>
<p>Login : ${sessionScope.user_identifie.login}</p>
<p>Pass : ${sessionScope.user_identifie.pass}</p>
<p>Nom : ${sessionScope.user_identifie.nom}</p>
<p>Prénom : ${sessionScope.user_identifie.prenom}</p>
<p>Adresse : ${sessionScope.user_identifie.adresse}</p>
<p>Age : ${sessionScope.user_identifie.age}</p>
<p>DateNaissance : ${sessionScope.user_identifie.dateNaissance}</p>
<p>Tel : ${sessionScope.user_identifie.telephone}</p>
<p>Mail : ${sessionScope.user_identifie.mail}</p>
<p>Statut : ${sessionScope.user_identifie.statut}</p>

<c:if test="${sessionScope.user_identifie.statut == 'professionel'}">
<p>IdPro : ${sessionScope.user_identifie.id}</p>
<p>NomMétier : ${sessionScope.user_identifie.nomMetier}</p>
<p>AdrTravail : ${sessionScope.user_identifie.adressePro}</p>
</c:if>

<c:if test="${sessionScope.user_identifie.statut == 'étudiant'}">
<p>IdEtu : ${sessionScope.user_identifie.idEtu}</p>
<p>Ecole : ${sessionScope.user_identifie.ecole}</p>
<p>DateDeb : ${sessionScope.user_identifie.datedeb}</p>
<p>DateFin : ${sessionScope.user_identifie.datefin}</p>
</c:if>

<form method="post" action="testServlet2"><input type="submit" name="Servlet2"/></form>
<form method="post" action="testServlet3"><input type="submit" name="Servlet2"/></form>
</body>
</html>