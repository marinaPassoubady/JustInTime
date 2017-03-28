var bool;
function onSubmit() { 
 //code de r action suite   la soumission du formulaire,
     //dans le cas d'une soumission   faire via une requ te ajax
  var login = document.getElementById('amiSearch').value;
  var bool;
  $.ajax({
  url  : "http://localhost:8085/Test/ServletGestionCompte",
  async: false,
  type :"GET",
  dataType: "json",
  data: {"amiSearch": login},
  success : function(data) {
	  document.getElementById('amiSearch').value = "";
	  if(data == "false") {
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
		  toastr["error"]("<div style='text-align:center'><h3 style='color: white; font-size:15px; padding-top:10px'>"+login+" est d&eacutej&agrave votre ami ou n'existe pas !</h3></div>","<div style='text-align:center'><h3 style='color: white; font-size:15px'>D&eacutesol&eacute !</h3></div><br>");

	  }
	  else {
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
		  toastr["success"]("<div style='text-align:center'><h3 style='color: white; font-size:15px; padding-top:10px'>Vous &ecirctes &agrave pr&eacutesent amis avec "+login+"!</h3></div>","<div style='text-align:center'><h3 style='color: white; font-size:15px'>G&eacutenial !</h3></div><br>");
	  }
  }
  
});
}

