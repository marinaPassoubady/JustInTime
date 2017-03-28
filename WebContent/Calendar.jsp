<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="metier.User"
    import="metier.TacheSimple"
    import="java.util.ArrayList"
    import="java.util.Date" 
    %>
    
<%ArrayList<String> moisS = new ArrayList<String>();

for(int i = 0; i < 11; ++i) {
	moisS.add("janvier");
	moisS.add("février");
	moisS.add("mars");
	moisS.add("avril");
	moisS.add("mai");
	moisS.add("juin");
	moisS.add("juillet");
	moisS.add("aout");
	moisS.add("septembre");
	moisS.add("octobre");
	moisS.add("novembre");
	moisS.add("décembre");	
} %>
<!doctype html>
<html lang="en-US">
<head>
  <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
  <title>Modal Login Window Demo</title>
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
	
   <!-- JavasScript + JQueryUI (pour le datepicker) -->
	<link rel="stylesheet" href="jquery-ui-1.12.1.custom/jquery-ui.min.css">
	<script src="jquery-ui-1.12.1.custom/external/jquery/jquery.js"></script>
	<script src="jquery-ui-1.12.1.custom/jquery-ui.min.js"></script>
	<script src="jquery-ui-1.12.1.custom/jquery-ui.js"></script>

	
  <!-- Theme style -->
  <link rel="stylesheet" href="dist/css/AdminLTE.min.css">
  <link rel="stylesheet" href="dist/css/skins/skin-blue.min.css">
  <link rel="shortcut icon" href="http://designshack.net/favicon.ico">
  <link rel="icon" href="http://designshack.net/favicon.ico">
  <link rel="stylesheet" type="text/css" media="all" href="style.css">
  <script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>

  <script type="text/javascript" charset="utf-8" src="js/jquery.leanModal.min.js"></script>
  <!-- jQuery plugin leanModal under MIT License http://leanmodal.finelysliced.com.au/ -->
    <!-- Calendar -->
<link href='css/fullcalendar.min.css' rel='stylesheet' />
<link href='css/fullcalendar.print.min.css' rel='stylesheet' media='print' />
<link rel="stylesheet" type="text/css" href="css/sweetalert2.min.css">
<link href="toast/build/toastr.css" rel="stylesheet"/>
<script src='lib/moment.min.js'></script>
<script src='js/fullcalendar.min.js'></script>
<script src="js/sweetalert2.min.js"></script>
<script src='js/calendar.js'></script>
<script src="toast/toastr.js"></script>
<script src='js/ajoutAmi.js'></script>
  
</head>

<% session = request.getSession();
ArrayList<TacheSimple> taches = (ArrayList<TacheSimple>) session.getAttribute("listeTaches");
User u = (User) session.getAttribute("user_identifie");

String msgErrorTache = (String) request.getAttribute("erreur_saisietache");
String msgConfirmTache = (String) request.getAttribute("msgConfirmTache");
String msgErrorInsert = (String) request.getAttribute("erreur_horaire");
String msgErrorDispo = (String) request.getAttribute("erreur_horairePartage");
String msgErrorTacheBase = (String) request.getAttribute("erreur_tacheBase");
String msgFriendExst = (String) request.getAttribute("erreur_AmiExiste"); 
%>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">

  <!-- Main Header -->
  <header class="main-header">

    <!-- Logo -->
    <a href="Calendar.jsp" class="logo">
      <!-- mini logo for sidebar mini 50x50 pixels -->
      <span class="logo-mini"><b>J</b>iT</span>
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
          <!-- Messages: style can be found in dropdown.less-->
          <li class="dropdown messages-menu">
            <!-- Menu toggle button -->
           
           
          </li>
          <!-- /.messages-menu -->

          <!-- Notifications Menu -->
          <li class="dropdown notifications-menu">
            <!-- Menu toggle button -->
            
            <ul class="dropdown-menu">
              
                <!-- Inner Menu: contains the notifications -->
                <ul class="menu">
                  <li><!-- start notification -->
                  
                  </li>
                  <!-- end notification -->
                </ul>
              </li>
             
            </ul>
          </li>
          <!-- Tasks Menu -->
          <li class="dropdown tasks-menu">
            <!-- Menu Toggle Button -->
            
            <ul class="dropdown-menu">
              
              <li>
                <!-- Inner menu: contains the tasks -->
                
              </li>
             
            </ul>
          </li>
          <!-- User Account Menu -->
          <li class="dropdown user user-menu">
            <!-- Menu Toggle Button -->
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
              <!-- The user image in the navbar-->
             
              
                    
              <!-- hidden-xs hides the username on small devices so only the image appears. -->
             
              <span class="hidden-xs" style="font-size: 13px; font-weight: bold;font-family: helvetica;"><%=u.getNom()%> <%=u.getPrenom() %></span>
            </a>
            <ul class="dropdown-menu">
              <!-- The user image in the menu -->
              <li class="user-header">
               <%if(u.getStatut().equals("professionnel")){ %>
              <img src="images/pro.jpg" class="img-circle" alt="User Image">
              <%} else if(u.getStatut().equals("autre")){ %>
             <img src="images/autre.jpg" class="img-circle" alt="User Image">
              <%} else {%>
               <img src="images/etudiant.jpg"class="img-circle" alt="User Image">
              <%} %>
                <p>
                  <%=u.getNom()%> <%=u.getPrenom() %> (<%=u.getStatut()%>)
                </p>
              </li>
              <!-- Menu Body -->
         
              <!-- Menu Footer-->
              <li class="user-footer">
                <div class="pull-left">
                  <a href="servletTacheP" class="btn btn-default btn-flat">Profil</a>
                </div>
                <div class="pull-right">
                  <a href="ServletDeco" class="btn btn-default btn-flat">D&eacute;connexion</a>
                </div>
              </li>
            </ul>
          </li>
          <!-- Control Sidebar Toggle Button -->
          <li>
            <a href="#" data-toggle="control-sidebar"><i class="fa fa-gears"></i></a>
          </li>
        </ul>
      </div>
    </nav>
  </header>
  <!-- Left side column. contains the logo and sidebar -->
  <aside class="main-sidebar">

    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">

      <!-- Sidebar user panel (optional) -->
      <div class="user-panel">
        <div class="pull-left image">
          <%if(u.getStatut().equals("professionnel")){%>
               <img src="images/pro.jpg" class="img-circle"  alt="User Image">
              <%} else if(u.getStatut().equals("autre")){ %>
                <img src="images/autre.jpg"   class="img-circle" alt="User Image">
              <%} else { %>
             <img src="images/etudiant.jpg"  class="img-circle" alt="User Image">
              <%} %>
          
        </div>
        <div class="pull-left info">
          <p style="color: white;"> <%=u.getNom() %>  <%=u.getPrenom() %></p>
          <!-- Status -->
          <a href="servletTacheP"><i class="fa fa-circle text-success"></i>En ligne</a>
        </div>
      </div>

<!-- search form (Optional) -->
      <div class="sidebar-form">
        <div class="input-group">
          <input type="text" id="amiSearch" name="amiSearch" class="form-control" placeholder="Ajouter un ami..">
              <span class="input-group-btn">
                <button name="ajoutAmi" id="search-btn" class="btn btn-flat" onClick="onSubmit();"><i class="fa fa-search"></i>
                </button>
              </span>
        </div>
      </div>
      <!-- /.search form -->

      <!-- Sidebar Menu -->
      <ul class="sidebar-menu">
        <li class="header" style="text-align:center">PLANIFIER VOTRE AGENDA </li>
        <!-- Optionally, you can add icons to the links -->
      
        <li><a href="#loginmodal9"  id="modaltrigger9" ><i class="fa fa-link"></i><span>Ajouter une t&acirc;che Mensuelle</span></a></li>
        <li><a href="#loginmodal10"  id="modaltrigger10" ><i class="fa fa-link"></i><span>Ajouter une t&acirc;che Continue</span></a></li>
        <li><a href="#loginmodal11"  id="modaltrigger11" ><i class="fa fa-link"></i><span>Ajouter une t&acirc;che Partag&eacutee</span></a></li>
        <li><a href="#loginmodal12"  id="modaltrigger12" ><i class="fa fa-link"></i><span>Ajouter une t&acirc;che Group&eacutee</span></a></li>
        <li><a href="#loginmodal13"  id="modaltrigger13" ><i class="fa fa-link"></i><span>Ajouter une t&acirc;che Obligatoire</span></a></li>
           
        <li class="treeview">
          <a href="#loginmodal"  id="modaltrigger" ><i class="fa fa-link"></i><span>Ajouter une t&acirc;che Simple</span></a>
            <a class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </a>
          
          <ul class="treeview-menu">
            
        <%if(u.getStatut().equals("professionnel")){  %>
      	<li><a href="#loginmodal2"   id="modaltrigger2"><i class="fa fa-link"></i><span>Fixer une conf&eacute;rence</span></a></li>
     	 <li> <a href="#loginmodal3"  id="modaltrigger3"><i class="fa fa-link"></i> <span>Fixer une r&eacute;union</span></a></li>
         <%} else if(u.getStatut().equals("autre")){ %>
        <li> <a href="#loginmodal7"  id="modaltrigger7"><i class="fa fa-link"></i> <span>Fixer un rendez-vous</span></a></li>
        <li> <a href="#loginmodal8"  id="modaltrigger8"><i class="fa fa-link"></i><span>Fixer une sortie</span></a></li>
         <%} else {  %>
         <li> <a href="#loginmodal4"  id="modaltrigger4"><i class="fa fa-link"></i> <span>Fixer un DST</span></a></li>
        <li> <a href="#loginmodal5"  id="modaltrigger5"><i class="fa fa-link"></i><span>Fixer un projet</span></a></li>
         <li> <a href="#loginmodal6"  id="modaltrigger6"><i class="fa fa-link"></i> <span>Fixer une soir&eacute;e &eacute;tudiante</span></a></li>
         <%} %>
          </ul>
        </li>
      </ul>
      <!-- /.sidebar-menu -->
    </section>
    <!-- /.sidebar -->
	        
  </aside>

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper" style="min-height: 1px;">
    <!-- Content Header (Page header) -->
    <section class="content-header">
    </section>
    <!-- Main content -->
    <section class="content">
      <div class="row">
        <div class="col-md-3">

        </div>
        <!-- /.col -->
        <div class="col-md-9" >
          <div class="box box-primary">
            <div class="box-body no-padding">
              <!-- THE CALENDAR -->
              <div id="calendar"></div>
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

  <!-- Main Footer -->
  <footer class="main-footer">
    <!-- To the right -->
    <div class="pull-right hidden-xs">
      Anything you want
    </div>
    <!-- Default to the left -->
    <strong>Copyright &copy; 2016 <a href="#">Company</a>.</strong> All rights reserved.
  </footer>


  <aside class="control-sidebar control-sidebar-dark">
    <!-- Create the tabs -->
    
    <!-- Tab panes -->
    <div class="tab-content">
    <div >
        <h3 class="control-sidebar-heading">T&acirc;ches R&eacute;centes</h3>
        <ul class="control-sidebar-menu">
          <li>
          <%for(TacheSimple t : taches){ %>
            <a href="javascript:;">
   

              <div class="menu-info">
              
                 <img src="images/tache.png" style="width:50px; height:50px;float: left;margin-left: -34px;margin-right: 12px;">
                <h4 class="control-sidebar-subheading"><%=t.getTitre() %></h4>

                <p><%=t.getDate() %></p>
                <p><%=t.getHeuredeb().substring(1,5) %> - <%=t.getHeurefin().substring(1,5)%> </p>
              </div>
            </a>
            <%} %>
          </li>
        </ul>
        <!-- /.control-sidebar-menu -->
         </aside>
        
</div>
      </div>
      
  <!-- /.control-sidebar -->
  <!-- Add the sidebar's background. This div must be placed
       immediately after the control sidebar -->
  <div class="control-sidebar-bg"></div>
</div>
<!-- ./wrapper -->
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

<%if (msgFriendExst != null) { %>
<script>
toastr.options = {
		  "closeButton": true,
		  "debug": false,
		  "newestOnTop": false,
		  "progressBar": false,
		  "positionClass": "toast-top-center",
		  "preventDuplicates": false,
		  "onclick": null,
		  "showDuration": "200",
		  "hideDuration": "1000",
		  "timeOut": "5000",
		  "extendedTimeOut": "1000",
		  "showEasing": "swing",
		  "hideEasing": "linear",
		  "showMethod": "fadeIn",
		  "hideMethod": "fadeOut"
		}
toastr["error"]("<div style='text-align:center'><h3 style='color: white; font-size:15px; padding-top:10px'>Votre liste d'amis n'est pas correcte !</h3></div>","<div style='text-align:center'><h3 style='color: white; font-size:15px'>D&eacutesol&eacute !</h3></div><br>");

</script>
<%} %>

<%if (msgErrorTacheBase != null) { %>
<script>
toastr.options = {
		  "closeButton": true,
		  "debug": false,
		  "newestOnTop": false,
		  "progressBar": false,
		  "positionClass": "toast-top-center",
		  "preventDuplicates": false,
		  "onclick": null,
		  "showDuration": "200",
		  "hideDuration": "1000",
		  "timeOut": "5000",
		  "extendedTimeOut": "1000",
		  "showEasing": "swing",
		  "hideEasing": "linear",
		  "showMethod": "fadeIn",
		  "hideMethod": "fadeOut"
		}
toastr["error"]("<div style='text-align:center'><h3 style='color: white; font-size:15px; padding-top:10px'>Cette t&acircche n'existe pas !</h3></div>","<div style='text-align:center'><h3 style='color: white; font-size:15px'>D&eacutesol&eacute !</h3></div><br>");

</script>
<%} %>

<%if (msgErrorDispo != null) { %>
<script>
toastr.options = {
		  "closeButton": true,
		  "debug": false,
		  "newestOnTop": false,
		  "progressBar": false,
		  "positionClass": "toast-top-center",
		  "preventDuplicates": false,
		  "onclick": null,
		  "showDuration": "200",
		  "hideDuration": "1000",
		  "timeOut": "5000",
		  "extendedTimeOut": "1000",
		  "showEasing": "swing",
		  "hideEasing": "linear",
		  "showMethod": "fadeIn",
		  "hideMethod": "fadeOut"
		}
toastr["error"]("<div style='text-align:center'><h3 style='color: white; font-size:15px; padding-top:10px'>Certains amis ne sont pas disponibles</h3></div>","<div style='text-align:center'><h3 style='color: white; font-size:15px'>D&eacutesol&eacute !</h3></div><br>");

</script>
<%} %>

<%if (msgErrorTache != null) { %>
<script>
toastr.options = {
		  "closeButton": true,
		  "debug": false,
		  "newestOnTop": false,
		  "progressBar": false,
		  "positionClass": "toast-top-center",
		  "preventDuplicates": false,
		  "onclick": null,
		  "showDuration": "200",
		  "hideDuration": "1000",
		  "timeOut": "5000",
		  "extendedTimeOut": "1000",
		  "showEasing": "swing",
		  "hideEasing": "linear",
		  "showMethod": "fadeIn",
		  "hideMethod": "fadeOut"
		}
toastr["error"]("<div style='text-align:center'><h3 style='color: white; font-size:15px; padding-top:10px'>Vous n'avez pas remplis tous les champs !</h3></div>","<div style='text-align:center'><h3 style='color: white; font-size:15px'>D&eacutesol&eacute !</h3></div><br>");

</script>
<%} %>
<%if (msgErrorInsert != null) { %>
<script>
toastr.options = {
		  "closeButton": true,
		  "debug": false,
		  "newestOnTop": false,
		  "progressBar": false,
		  "positionClass": "toast-top-center",
		  "preventDuplicates": false,
		  "onclick": null,
		  "showDuration": "200",
		  "hideDuration": "1000",
		  "timeOut": "5000",
		  "extendedTimeOut": "1000",
		  "showEasing": "swing",
		  "hideEasing": "linear",
		  "showMethod": "fadeIn",
		  "hideMethod": "fadeOut"
		}
toastr["error"]("<div style='text-align:center'><h3 style='color: white; font-size:15px; padding-top:10px'>Ce cr&eacuteneau horaire n'est pas disponible !</h3></div>","<div style='text-align:center'><h3 style='color: white; font-size:15px'>G&eacutenial  !</h3></div><br>");
</script>
<%} %>
<%if (msgConfirmTache != null) { %>
<script>
toastr.options = {
		  "closeButton": true,
		  "debug": false,
		  "newestOnTop": false,
		  "progressBar": false,
		  "positionClass": "toast-top-center",
		  "preventDuplicates": false,
		  "onclick": null,
		  "showDuration": "200",
		  "hideDuration": "1000",
		  "timeOut": "5000",
		  "extendedTimeOut": "1000",
		  "showEasing": "swing",
		  "hideEasing": "linear",
		  "showMethod": "fadeIn",
		  "hideMethod": "fadeOut"
		}
toastr["success"]("<div style='text-align:center'><h3 style='color: white; font-size:15px; padding-top:10px'>La t&acircche a bien &eacutet&eacute ajout&eacutee !</h3></div>","<div style='text-align:center'><h3 style='color: white; font-size:15px'>G&eacutenial  !</h3></div><br>");
</script>
<%} %>
 
  <div id="loginmodal" style="display:none;">
    <h1>T&acirc;che Simple</h1>
    <form  method="post" action="CreerTache">
      <label for="titre">Titre de la t&acirc;che</label>
      <input type="text" name="titre" id="titre" class="txtfield" tabindex="1">
      
      <label for="date">Date (aaaa-mm-jj)</label>
      <input type="text" name="date" id="date" class="txtfield" tabindex="2">
	  
	  <label for="heuredeb">Heure d&eacute;but (HH:MM:SS)</label>
      <input type="text" name="heuredeb" id="heuredeb" class="txtfield" tabindex="3">
      
      <label for="heurefin">Heure fin (HH:MM:SS)</label>
      <input type="text" name="heurefin" id="heurefin" class="txtfield" tabindex="4">
	  
	  	  <label for="note">Note</label>
      <input type="text" name="note" id="note" class="txtfield" tabindex="5">
      
      <label for="objet">Liste d'objet</label>
      <input type="text" name="objet" id="objet" class="txtfield" tabindex="6">
      
      <div class="center"><button type="submit" name="tachebtn" class="flatbtn-blu hidemodal"  value="tacheSimple">Ajouter</button></div>
    </form>
  </div>

  <div id="loginmodal2" style="display:none;">
    <h1>Fixer une conf&eacute;rence</h1>
    <form  method="post" action="CreerTache" >
      <label for="titre">Titre de la t&acirc;che</label>
      <input type="text" name="titre" id="titre" class="txtfield" value="Conference"tabindex="1">
       <label for="date">Date (aaaa/mm/jj)</label>
      <input type="text" name="date" id="date" class="txtfield" tabindex="2">
	  
	  <label for="heuredeb">Heure d&eacute;but (HH:MM:SS)</label>
      <input type="text" name="heuredeb" id="heuredeb" class="txtfield" tabindex="3">
      
      <label for="heurefin">Heure fin (HH:MM:SS)</label>
      <input type="text" name="heurefin" id="heurefin" class="txtfield" tabindex="4">
	  
	 <input id="labelSpec1" name="labelSpec1" value="Lieux" for="note" style="border: none;background: none;">
      <input type="text" name="note" id="note" class="txtfield" tabindex="5">
      
       <input id="labelSpec2" name="labelSpec2" value="Sujet de conf&eacute;rence" for="note" style="border: none;background: none;">
      <input type="text" name="objet" id="objet" class="txtfield" tabindex="6">
      
      <div class="center"><button type="submit" name="tachebtn" class="flatbtn-blu hidemodal"  value="tacheSpecifique">Ajouter</button></div>
      </form>
  </div>

  <div id="loginmodal3" style="display:none;">
    <h1>Fixer une r&eacute;union</h1>
    <form  method="post" action="CreerTache">
      <label for="titre">Titre de la t&acirc;che</label>
      <input type="text" name="titre" id="titre" class="txtfield" value="Reunion"tabindex="1">
       <label for="date">Date (aaaa/mm/jj)</label>
      <input type="date" name="date" id="date" class="txtfield" tabindex="2">
	  
	  <label for="heuredeb">Heure d&eacute;but (HH:MM:SS)</label>
      <input type="text" name="heuredeb" id="heuredeb" class="txtfield" tabindex="3">
      
      <label for="heurefin">Heure fin (HH:MM:SS)</label>
      <input type="text" name="heurefin" id="heurefin" class="txtfield" tabindex="4">
	  
	  <input id="labelSpec1" name="labelSpec1" value="Lieux" for="note" style="border: none;background: none;">
      <input type="text" name="note" id="note" class="txtfield" tabindex="5">
      
      <input id="labelSpec2" name="labelSpec2" value="Sujet de la r&eacute;union" for="note" style="border: none;background: none;">
      <input type="text" name="objet" id="objet" class="txtfield" tabindex="6">
      
      <div class="center"><button type="submit" name="tachebtn" class="flatbtn-blu hidemodal"  value="tacheSpecifique">Ajouter</button></div>
      </form>
  </div>
 
  <div id="loginmodal4" style="display:none;">
    <h1>Fixer un DST</h1>
       <form  method="post" action="CreerTache">
    	<div class='formTache'>
      <label for="titre">Titre de la t&acirc;che</label>
      <input type="text" name="titre" id="titre" class="txtfield" value="DST" tabindex="1">
      
      <label for="date">Date (AAAA-MM-JJ)</label>
      <input type="text" name="date" id="date" class="txtfield" tabindex="2">
	  
	  <label for="heuredeb">Heure d&eacute;but(HH:MM:SS)</label>
      <input type="text" name="heuredeb" id="heuredeb" class="txtfield" tabindex="3">
      
      <label for="heurefin">Heure fin(HH:MM:SS)</label>
      <input type="text" name="heurefin" id="heurefin" class="txtfield" tabindex="4">
	  
	  	<input id="labelSpec1" name="labelSpec1" value="Matiere" for="note" style="border: none;background: none;">
      <input type="text" name="note" id="note" class="txtfield" tabindex="5">
      
      <input id="labelSpec2" name="labelSpec2" value="Fourniture" for="note" style="border: none;background: none;">
      <input type="text" name="objet" id="objet" class="txtfield" tabindex="6">
      
      <div class="center"><button type="submit" name="tachebtn" class="flatbtn-blu hidemodal"  value="tacheSpecifique">Ajouter</button></div>
    </div>   
    </form>
  </div>
   <div id="loginmodal5" style="display:none;">
    <h1>Fixer un projet </h1>
       <form  method="post" action="CreerTache">
    	<div class='formTache'>
      <label for="titre">Titre de la t&acirc;che</label>
      <input type="text" name="titre" id="titre" class="txtfield" tabindex="1">
      
      <label for="date">Date (AAAA-MM-JJ)</label>
      <input type="text" name="date" id="date" class="txtfield" tabindex="2">
	  
	  <label for="heuredeb">Heure d&eacute;but(HH:MM:SS)</label>
      <input type="text" name="heuredeb" id="heuredeb" class="txtfield" tabindex="3">
      
      <label for="heurefin">Heure fin(HH:MM:SS)</label>
      <input type="text" name="heurefin" id="heurefin" class="txtfield" tabindex="4">
	  
	  	<input id="labelSpec1" name="labelSpec1" value="Matiere" for="note" style="border: none;background: none;">
      <input type="text" name="note" id="note" class="txtfield" tabindex="5">
      
      <input id="labelSpec2" name="labelSpec2" value="Date de rendu" for="note" style="border: none;background: none;">
      <input type="text" name="objet" id="objet" class="txtfield" tabindex="6">
      
      <div class="center"><button type="submit" name="tachebtn" class="flatbtn-blu hidemodal"  value="tacheSpecifique">Ajouter</button></div>
    </div>   
    </form>
  </div>
  
  <div id="loginmodal6" style="display:none;">
    <h1>Fixer une soir&eacute;e </h1>
       <form  method="post" action="CreerTache">
    	<div class='formTache'>
      <label for="titre">Titre de la t&acirc;che</label>
      <input type="text" name="titre" id="titre" class="txtfield" tabindex="1">
      
      <label for="date">Date (AAAA-MM-JJ)</label>
      <input type="text" name="date" id="date" class="txtfield" tabindex="2">
	  
	  <label for="heuredeb">Heure d&eacute;but(HH:MM:SS)</label>
      <input type="text" name="heuredeb" id="heuredeb" class="txtfield" tabindex="3">
      
      <label for="heurefin">Heure fin(HH:MM:SS)</label>
      <input type="text" name="heurefin" id="heurefin" class="txtfield" tabindex="4">
	  
	  	<input id="labelSpec1" name="labelSpec1" value="Theme de la soir&eacute;e" for="note" style="border: none;background: none;">
      <input type="text" name="note" id="note" class="txtfield" tabindex="5">
      
      <input id="labelSpec2" name="labelSpec2" value="Type vestimentaire" for="note" style="border: none;background: none;">
      <input type="text" name="objet" id="objet" class="txtfield" tabindex="6">
      
      <div class="center"><button type="submit" name="tachebtn" class="flatbtn-blu hidemodal"  value="tacheSpecifique">Ajouter</button></div>
    </div>   
    </form>
  </div>
  
    <div id="loginmodal7" style="display:none;">
    <h1>Fixer un rendez-vous </h1>
       <form  method="post" action="CreerTache">
    	<div class='formTache'>
      <label for="titre">Titre de la t&acirc;che</label>
      <input type="text" name="titre" id="titre" class="txtfield" tabindex="1">
      
      <label for="date">Date (AAAA-MM-JJ)</label>
      <input type="text" name="date" id="date" class="txtfield" tabindex="2">
	  
	  <label for="heuredeb">Heure d&eacute;but(HH:MM:SS)</label>
      <input type="text" name="heuredeb" id="heuredeb" class="txtfield" tabindex="3">
      
      <label for="heurefin">Heure fin(HH:MM:SS)</label>
      <input type="text" name="heurefin" id="heurefin" class="txtfield" tabindex="4">
	  
	  	<input id="labelSpec1" name="labelSpec1" value="Type de rendez-vous" for="note" style="border: none;background: none;">
      <input type="text" name="note" id="note" class="txtfield" tabindex="5">
      
      <input id="labelSpec2" name="labelSpec2" value="Lieux du rendez-vous" for="note" style="border: none;background: none;">
      <input type="text" name="objet" id="objet" class="txtfield" tabindex="6">
      
     <div class="center"><button type="submit" name="tachebtn" class="flatbtn-blu hidemodal"  value="tacheSpecifique">Ajouter</button></div>
    </div>   
    </form>
  </div>
  
    <div id="loginmodal8" style="display:none;">
    <h1>Fixer une sortie </h1>
       <form  method="post" action="CreerTache">
    	<div class='formTache'>
      <label for="titre">Titre de la t&acirc;che</label>
      <input type="text" name="titre" id="titre" class="txtfield" tabindex="1">
      
      <label for="date">Date (AAAA-MM-JJ)</label>
      <input type="text" name="date" id="date" class="txtfield" tabindex="2">
	  
	  <label for="heuredeb">Heure d&eacute;but(HH:MM:SS)</label>
      <input type="text" name="heuredeb" id="heuredeb" class="txtfield" tabindex="3">
      
      <label for="heurefin">Heure fin(HH:MM:SS)</label>
      <input type="text" name="heurefin" id="heurefin" class="txtfield" tabindex="4">
	  
	  	<input id="labelSpec1" name="labelSpec1" value="Lieux" for="note" style="border: none;background: none;">
      <input type="text" name="note" id="note" class="txtfield" tabindex="5">
      
      <input id="labelSpec2" name="labelSpec2" value="Budget envisag&eacute;" for="note" style="border: none;background: none;">
      <input type="text" name="objet" id="objet" class="txtfield" tabindex="6">
      
     <div class="center"><button type="submit" name="tachebtn" class="flatbtn-blu hidemodal"  value="tacheSpecifique">Ajouter</button></div>
    </div>   
    </form>
  </div>
  
   <div id="loginmodal9" style="display:none;">
    <h1>T&acirc;che Mensuelle</h1>
    <form  method="post" action="CreerTache">
      <label for="titre">Titre de la t&acirc;che</label>
      <input type="text" name="titre" id="titre" class="txtfield" tabindex="1">
      
      <label for="mois">Pour le mois de</label>
      <%Date d = new Date(); int mois = d.getMonth();%>
      <select name="mois" class="txtfield" tabindex="3">
      <%for (int j = mois; j <= 11; j++) { %>
      <option value="<%=j+1%>"><%= moisS.get(j) %></option>
      <% } %>
	 </select>
    
      <label for="jour">Repeter tous les</label>
      <select name="jour" class="txtfield" tabindex="3">
				 	<option value="MONDAY">Lundi</option>
				 	<option value="TUESDAY">Mardi</option>
				 	<option value="WEDNESDAY">Mercredi</option>
				 	<option value="THURSDAY">Jeudi</option>
				 	<option value="FRIDAY">Vendredi</option>
				 	<option value="SATURDAY">Samedi</option>
				 	<option value="SUNDAY">Dimanche</option>
	 </select>
	 
	  <label for="heuredeb">Heure d&eacute;but (HH:MM:SS)</label>
      <input type="text" name="heuredeb" id="heuredeb" class="txtfield" tabindex="2">
      
      <label for="heurefin">Heure fin (HH:MM:SS)</label>
      <input type="text" name="heurefin" id="heurefin" class="txtfield" tabindex="3">
	  
	  	  <label for="note">Note</label>
      <input type="text" name="note" id="note" class="txtfield" tabindex="4">
      
      <label for="objet">Liste d'objets</label>
      <input type="text" name="objet" id="objet" class="txtfield" tabindex="5">
      
      <div class="center"><button type="submit" name="tachebtn" class="flatbtn-blu hidemodal" value="tacheRec" tabindex="5">Ajouter</button></div>
    </form>
  </div>

  <div id="loginmodal10" style="display:none;">
    <h1>T&acirc;che Continue</h1>
    <form  method="post" action="CreerTache">
      <label for="titre">Titre de la t&acirc;che</label>
      <input type="text" name="titre" id="titre" class="txtfield" tabindex="1">
    
      <label for="jour">A partir du </label>
      <input type="text" name="date" id="date1" class="txtfield" tabindex="2">

      <label for="jour">Pendant </label>
      <input type="text" name="nbJour" id="nbJour" class="txtfield" tabindex="3">
	 
	  <label for="heuredeb">Heure d&eacute;but (HH:MM:SS)</label>
      <input type="text" name="heuredeb" id="heuredeb" class="txtfield" tabindex="4">
      
      <label for="heurefin">Heure fin (HH:MM:SS)</label>
      <input type="text" name="heurefin" id="heurefin" class="txtfield" tabindex="5">
	  
	  	  <label for="note">Note</label>
      <input type="text" name="note" id="note" class="txtfield" tabindex="6">
      
      <label for="objet">Liste d'objets</label>
      <input type="text" name="objet" id="objet" class="txtfield" tabindex="7">
      
      <div class="center"><button type="submit" name="tachebtn" class="flatbtn-blu hidemodal" value="tacheContinue" tabindex="8">Ajouter</button></div>
    </form>
  </div>

<div id="loginmodal11" style="display:none;">
    <h1>T&acirc;che Partag&eacute;e</h1>  
     <form  method="post" action="CreerTache">
      <label for="titre">Titre de la t&acirc;che</label>
      <input type="text" name="titre" id="titre" class="txtfield" tabindex="1">
    
      <label for="date">Date (AAAA-MM-JJ)</label>
      <input type="text" name="date" id="date2" class="txtfield" tabindex="2">
	 
	  <label for="heuredeb">Heure d&eacute;but (HH:MM:SS)</label>
      <input type="text" name="heuredeb" id="heuredeb" class="txtfield" tabindex="4">
      
      <label for="heurefin">Heure de fin (HH:MM:SS)</label>
      <input type="text" name="heurefin" id="heurefin" class="txtfield" tabindex="5">
	  
	   <label for="friends">Partag&eacute;e avec </label>
      <input type="text" name="friends" id="friends" class="txtfield" tabindex="6">
      
      <div class="center"><button type="submit" name="tachebtn" class="flatbtn-blu hidemodal" value="tachePartageFixe" tabindex="8">Ajouter</button></div>
    </form>
</div>

<div id="loginmodal12" style="display:none;">
    <h1>Ajout T&acirc;che Group&eacute;e</h1>  
     <form  method="post" action="CreerTache">
      <label for="titre">Titre de la t&acirc;che</label>
      <input type="text" name="titre" id="titre" class="txtfield" tabindex="1">
    
      <label for="date">Date (AAAA-MM-JJ)</label>
      <input type="text" name="date" id="date3" class="txtfield" tabindex="2">
	 
	  <label for="duree">Dur&eacute;e (en heure) </label>
      <input type="text" name="duree" id="duree" class="txtfield" tabindex="4">
	  
	   <label for="friends">Partag&eacute;e avec </label>
      <input type="text" name="friends" id="friends" class="txtfield" tabindex="6">
      
      <label for="note">Note</label>
      <input type="text" name="note" id="note" class="txtfield" tabindex="6">
      
      <label for="objet">Liste d'objets</label>
      <input type="text" name="objet" id="objet" class="txtfield" tabindex="7">
      
      <div class="center"><button type="submit" name="tachebtn" class="flatbtn-blu hidemodal" value="tachePartageContrainteGrp" tabindex="8">Ajouter</button></div>
    </form>
</div> 

<div id="loginmodal13" style="display:none;">
    <h1>Ajout T&acirc;che Obligatoire </h1>  
     <form  method="post" action="CreerTache">
      <label for="titre">Titre de la t&acirc;che</label>
      <input type="text" name="titre" id="titre" class="txtfield" tabindex="1">
    
      <label for="date">Date (AAAA-MM-JJ)</label>
      <input type="text" name="date" id="date4" class="txtfield" tabindex="2">
	 
	  <label for="duree">Dur&eacute;e (en heure)</label>
      <input type="text" name="duree" id="duree" class="txtfield" tabindex="4">
      
      <label for="note">Note</label>
      <input type="text" name="note" id="note" class="txtfield" tabindex="6">
      
      <label for="objet">Liste d'objets</label>
      <input type="text" name="objet" id="objet" class="txtfield" tabindex="7">
      
      <div class="center"><button type="submit" name="tachebtn" class="flatbtn-blu hidemodal" value="tachePartageContrainteMoi" tabindex="8">Ajouter</button></div>
    </form>
</div>  
  
  <script> 
  // popup js
  $(function(){
	  $('#loginform').submit(function(e){
	    return false;
	  });
	  $('#modaltrigger').leanModal({ overlay: 0.45, closeButton: ".hidemodal" });
	  $('#modaltrigger2').leanModal({  overlay: 0.45, closeButton: ".hidemodal" });
	  $('#modaltrigger3').leanModal({ overlay: 0.45, closeButton: ".hidemodal" });
	  $('#modaltrigger4').leanModal({  overlay: 0.45, closeButton: ".hidemodal" });
	  $('#modaltrigger5').leanModal({ overlay: 0.45, closeButton: ".hidemodal" });
	  $('#modaltrigger6').leanModal({  overlay: 0.45, closeButton: ".hidemodal" });
	  $('#modaltrigger7').leanModal({  overlay: 0.45, closeButton: ".hidemodal" });
	  $('#modaltrigger8').leanModal({ overlay: 0.45, closeButton: ".hidemodal" });
	  $('#modaltrigger9').leanModal({  overlay: 0.45, closeButton: ".hidemodal" });
	  $('#modaltrigger10').leanModal({  overlay: 0.45, closeButton: ".hidemodal" });
	  $('#modaltrigger11').leanModal({  overlay: 0.45, closeButton: ".hidemodal" });
	  $('#modaltrigger12').leanModal({  overlay: 0.45, closeButton: ".hidemodal" });
	  $('#modaltrigger13').leanModal({  overlay: 0.45, closeButton: ".hidemodal" });
	  
	  function onSubmit() { 
		  //code de r action suite   la soumission du formulaire,
		      //dans le cas d'une soumission   faire via une requ te ajax
		   var login = document.getElementById('amiSearch').value;
		   $.ajax({
		   url  : "http://localhost:8088/PJS4_Version3/ServletGestionCompte",
		   type :"GET",
		   data: {"amiSearch": login},
		   contentType: "application/json; charset=utf-8",      
		   dataType: "text",
		   success : function() {
		   document.getElementById('amiSearch').value = "";
		 	swal({
		 			title: "Vous avez ajoute "+login,
		 			type: 'info',
		 			background: '#c2d6d6'		
		 		});
		   }
		 }); 
		 }
  });
  </script>

</body>
</html>