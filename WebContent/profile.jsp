<!doctype html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="metier.User"
    import="metier.Etudiant"
    import="metier.Autre"
    import="metier.Professionnel"
    import="metier.TacheSimple"
    import="java.util.ArrayList"
    import="java.util.Date" 
    import="modele.GestionCompte"
    %>
<html lang="en-US">
<head>
  <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
  <title>Just in Time</title>
   <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>JustInTime | Starter</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <!-- Bootstrap 3.3.6 -->
  <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">

  <!-- Theme style -->
 

    <link rel="stylesheet" href="css/profil.css">
  <link rel="stylesheet" href="dist/css/skinProfil/skins/skin-blue.min.css">
  <link rel="shortcut icon" href="http://designshack.net/favicon.ico">
  <link rel="icon" href="http://designshack.net/favicon.ico">
  <link rel="stylesheet"  href="dist/css/skinProfil/skins/styleProfil.css">
  <script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
  <script type="text/javascript" charset="utf-8" src="js/jquery.leanModal.min.js"></script>
  <!-- jQuery plugin leanModal under MIT License http://leanmodal.finelysliced.com.au/ -->

</head>
<%
session = request.getSession();
User u = (User) session.getAttribute("user_identifie");
GestionCompte gc = new GestionCompte();
ArrayList<TacheSimple> listeTache = (ArrayList<TacheSimple>) session.getAttribute("mes_taches_en_attente"); 
ArrayList<User> amis = (ArrayList<User>) session.getAttribute("mesAmis");

%>


<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">

  <!-- Main Header -->
  <header class="main-header">

    <!-- Logo -->
    <a href="Calendar.jsp" class="logo">
      <!-- mini logo for sidebar mini 50x50 pixels -->
      <span class="logo-mini"><b>A</b>LT</span>
      <!-- logo for regular state and mobile devices -->
     <span class="logo-lg">Just in<b style="font-weight:bold;">TIME</b></span>
    </a>

    <!-- Header Navbar -->
    <nav class="navbar navbar-static-top" role="navigation">
      <!-- Sidebar toggle button-->
      
      <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
        <span class="sr-only">Toggle navigation</span>
      </a>

      <!-- Navbar Right Menu -->
      <div class="navbar-custom-menu">
        <ul class="nav navbar-nav">
          <!-- User Account Menu -->
          <li class="dropdown user user-menu">
            <!-- Menu Toggle Button -->
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
            
              <!-- hidden-xs hides the username on small devices so only the image appears. -->
              
            </a>
         <ul class="dropdown-menu">
              <!-- The user image in the menu -->
              <li class="user-header">
               <%if(u.getStatut().equals("professionnel")){ %>
              <img src="images/pro.jpg" class="img-circle" alt="User Image">
              <%} else if(u.getStatut().equals("autre")){ %>
              <img src="images/autre.jpg" class="img-circle" alt="User Image">
              <%} else {%>
              <img src="images/etudiant.jpg" class="img-circle" alt="User Image">
              <%} %>
      

                <p>
                  <%=u.getNom()%> <%=u.getPrenom() %> (<%=u.getStatut()%>)
                </p>
              </li>
              <!-- Menu Body -->
         
              <!-- Menu Footer-->
              <li class="user-footer">
                <div class="pull-left">
                  <a href="Calendar.jsp" class="btn btn-default btn-flat">Calendar</a>
                </div>
                <div class="pull-right">
                  <a href="ServletDeco" class="btn btn-default btn-flat">D&eacute;connexion</a>
                </div>
              </li>
            </ul>
      </div>
    </nav>
  </header>
  <!-- Left side column. contains the logo and sidebar -->

<div class='titrePro'> <p5> Mon compte </p5> </div>
  <!-- Content Wrapper. Contains page content -->
  <div class="content" style="min-height: 1px;">
    <!-- Content Header (Page header) -->
  

    <!-- Main content -->
 <section class="content2">
      <div class="row">
       <div class="col-md-3">
        <div class="box box-primary">
            <div class="box-body no-padding">
             <h1 class="profil">Mes amis</h1>
		  	  <img src="images/amiList.png" class="imgAmi" class="img-circle" alt="User Image" >
		  	   		<%for(User ami : amis) { %>
				<p><label class="LabelTache"><%= ami.getLogin() %> ~</label>
			<%=ami.getPrenom() %> <%=ami.getNom()%></p>
			<%} %>
	
        </div>
        </div>
        </div>
        
         <div class="col-md-6">
             <div class="row">
          <div class="box box-primary">
            <div class="box-body no-padding">
            <h1 class="profil">Profil</h1>
          	 <%if(u.getStatut().equals("professionnel")){ %>
              <img src="images/pro.jpg" class="img-circle" alt="User Image" style="width: 100px;height: 100px;">
              <%} else if(u.getStatut().equals("autre")){ %>
              <img src="images/autre.jpg" class="img-circle" alt="User Image" style="width: 100px;height: 100px;">
              <%} else {%>
             <img src="images/etudiant.jpg" class="img-circle" alt="User Image" style="width: 100px;height: 100px;">
              <%} %>
              <div class="divProfil1">
		     
		       <p style="margin-bottom: 12px;"><%=u.getNom()%> <%=u.getPrenom() %>  </p>
		       <p style="margin-bottom: 12px;"> <%=u.getAge() %> ans</p>
		       <p><%=u.getStatut() %></p>
		        </div>
		       
		       <div class="divProfil2">
		       <p><label class="LabelProfil">Date de naissance :</label><%=u.getDateNaissance() %></p>
		      
		       <p><label class="LabelProfil">Adresse :</label> <%=u.getAdresse() %></p>
		       <p><label class="LabelProfil">Téléphone :</label> <%=u.getTelephone() %></p>
		       <p><label class="LabelProfil">Mail :</label> <%=u.getMail() %></p> 
		        <%if(u.getStatut().equals("professionnel")){
		        	Professionnel p = (Professionnel) session.getAttribute("user_identifie");%>
              <p> <label class="LabelProfil">Nom Métier :</label> <%=p.getNomMetier() %></p>
              <p> <label class="LabelProfil">Adresse du lieu de travail :</label> <%=p.getAdressePro() %></p>
            
              <%} else if(u.getStatut().equals("autre")){
            	   Autre a = (Autre) session.getAttribute("user_identifie");%>
             
              <p><label class="LabelProfil">Situation sociale :</label> <%=a.getSocialStatus() %></p>
             
              <%} else {
            	  Etudiant e = (Etudiant) session.getAttribute("user_identifie");
              %>
             
             <p><label class="LabelProfil">Nom de l'établissement:</label> <%=e.getEcole() %></p>
            <p> <label class="LabelProfil">Date d'entrée :</label> <%=e.getDatedeb() %></p>
            <p> <label class="LabelProfil">Date de fin d'étude :</label> <%=e.getDatefin()%></p>
           
              <%} %>
              </div>	
               <a href="#loginmodal"  id="modaltrigger" ><button  class="btnmodif"  type="submit" name="modifier">Modifier</button></a>
               		   
            </div>         
        <!-- /.col -->
         </div>
         </div>
         </div>
        <div class="col-md-9">
        <div class="box box-primary">
            <div class="box-body no-padding">
             <h1 class="profil">Tâches partagées</h1>
				<%for(TacheSimple t : listeTache) { %>
	<div class="tachePartage"id="<%=t.getIdTache()%>">
			<h2 class="tacheTitre"> <%= t.getTitre() %></h2>
			<div class="tacheDonne">
			<label class="LabelTache">Date tâche : </label><p class="textTache"><%=t.getDate() %></p>
			<label class="LabelTache">Horaire :</label><p class="textTache"> <%=t.getHeuredeb() %> - <%=t.getHeurefin() %></p>
			<label class="LabelTache">Partagée par :</label><p class="textTache">  <%=gc.getLoginById(t.getIdUser())  %></p>
			</div>
	</div>
<% } %>


<form method="post" action="servletTacheP">
<select class="txtfield"name="tacheSelec">
	<option value="">Choisissez votre tache</option>
      <%for (TacheSimple ts : listeTache) { %>
      <option value="<%=ts.getIdTache()%>"> <%=ts.getDate() %> : <%=ts.getTitre()%> <%=ts.getHeuredeb()%> - <%=ts.getHeurefin() %></option>
      <% } %>
	 </select>
	<button  class="flatbtn-blu hidemodal" class="btnValid" type="submit" name="valider">Valider</button>
	<button class="flatbtn-blu hidemodal"  type="submit" name="refuser">Refuser</button>
</form>
            </div>
            <!-- /.box-body -->
          </div>
          <!-- /. box -->
        </div>
        <!-- /.col -->
      </div>
      <!-- /.row -->
    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->


  <!-- /.control-sidebar -->
  <!-- Add the sidebar's background. This div must be placed
       immediately after the control sidebar -->
  <div class="control-sidebar-bg"></div>
</div>
<!-- ./wrapper -->
  <div id="loginmodal" style="display:none;">
    <h2 class="titreModif">Modifier le profil</h2>
    
    <form  method="post" action="ModifProfil">
	<label class="LabelModif"  for="titre">Mot de passe</label>
    <input type="text" name="pass" value="<%=u.getPass() %>"id="titre" class="txtfield" tabindex="1">
      <label class="LabelModif" for="titre">Date de naissance (AAAA-MM-JJ)</label>
      <input type="text" name="DateNaissance" value="<%=u.getDateNaissance() %>" class="txtfield" tabindex="2">
      <label class="LabelModif" for="date">Adresse </label>
      <input type="text" name="Adresse" value="<%=u.getAdresse() %>"  class="txtfield" tabindex="3">
	  <label class="LabelModif" for="heuredeb">Téléphone </label>
      <input type="text" name="Telephone" value="<%=u.getTelephone()%>"  class="txtfield" tabindex="4">
      <label class="LabelModif" for="heurefin">Mail</label>
      <input type="text" name="Mail" value="<%=u.getMail()%>"  class="txtfield" tabindex="5">
	    <%if(u.getStatut().equals("professionnel")){
		        	Professionnel p = (Professionnel) session.getAttribute("user_identifie");%>
              <label class="LabelModif" for="mail">Nom Métier </label> 
			  <input type="text" name="NomMetier" value="<%=p.getNomMetier() %>" class="txtfield" tabindex="6">
			  <label class="LabelModif"  for="nomMetier">Adresse du lieu de travail </label>
			  <input type="text" name="AdresseLieuTravail" value="<%=p.getAdressePro() %>" class="txtfield" tabindex="7">
             
              <%} else if(u.getStatut().equals("autre")){
            	   Autre a = (Autre) session.getAttribute("user_identifie");%>
              <label class="LabelModif" for="adresseLieuTravail">Situation sociale </label>
			<input type="text" name="situationSocial" value="<%=a.getSocialStatus() %>" class="txtfield" tabindex="8">             
              <%} else {
            	  Etudiant e = (Etudiant) session.getAttribute("user_identifie");
              %>          
             <label class="LabelModif">Nom de l'établissement</label>
			<input type="text" name="ecole" value="<%=e.getEcole() %>" class="txtfield" tabindex="9"> 	 
             <label class="LabelModif">Date d'entrée (AAAA-MM-JJ) </label> 
			 <input type="text" name="dateDeb" value="<%=e.getDatedeb()%>" class="txtfield" tabindex="10">	
			<label class="LabelModif">Date de fin d'étude (AAAA-MM-JJ)</label> 
			<input type="text" name="dateFin" value="<%=e.getDatefin() %>" class="txtfield" tabindex="11">          
              <%} %>
              
	  
	  	 
      
      <div class="center"><button type="submit" name="btnModifProfil" class="btnProfil"  value="modifProfil">Modifer</button></div>
    </form>
  </div>
<!-- REQUIRED JS SCRIPTS -->

<!-- jQuery 2.2.3 -->
<!-- Bootstrap 3.3.6 -->
<script src="bootstrap/js/bootstrap.min.js"></script>
<!-- jQuery UI 1.11.4 -->
<script src="https://code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>
<!-- Slimscroll -->
<script src="plugins/slimScroll/jquery.slimscroll.min.js"></script>
<!-- FastClick -->
<script src="plugins/fastclick/fastclick.js"></script>
<!-- AdminLTE App -->
<script src="dist/js/app.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="dist/js/demo.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.11.2/moment.min.js"></script>
<script src="plugins/fullcalendar/fullcalendar.min.js"></script>
<!-- Optionally, you can add Slimscroll and FastClick plugins.
     Both of these plugins are recommended to enhance the
     user experience. Slimscroll is required when using the
     fixed layout. -->
     
      <script> 
  // popup js
  $(function(){
	  $('#loginform').submit(function(e){
	    return false;
	  });
	  $('#modaltrigger').leanModal({ top: 50, overlay: 0.45, closeButton: ".hidemodal" });
  });
  </script>
</body>
</html>