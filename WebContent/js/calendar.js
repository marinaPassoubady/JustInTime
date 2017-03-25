var tab;

$(document).ready(function() {
	      		$(document).ready(function() {
	      			$( "#date" ).datepicker({dateFormat: "yy-mm-dd"}); 
	      			$( "#date1" ).datepicker({dateFormat: "yy-mm-dd"});});
		$('#calendar').fullCalendar({
			header: {
				left: 'prev,next today',
				center: 'title',
				right: 'month,agendaWeek,agendaDay'
			},
			navLinks: true, // can click day/week names to navigate views
			selectable: true,
			selectHelper: true,
			eventClick: function(event) {
				swal({
					title: event.title,
					type: 'info',
					html: '<!DOCTYPE html><html><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/></head><body><p>Jour : '+event.date+'</p><br><p>Débute a : '+event.heuredeb+'</p><br><p>Fini a : '+event.heurefin+'</p><br><p>Ne pas oublier : '+event.objet+'</p><br><p>Note : '+event.note+'</p><br></body></html>',
					width: 400,
					background: '#c2d6d6'		
				});
			},
			editable: false,
			disableDragging: true,
			eventLimit: true, // allow "more" link when too many events
			events: 'ServletCalendar'
			/*events: function(start, end, timezone, callback) {
		        jQuery.ajax({
		            url: 'ServletCalendar',
		            dataType: 'json',
		            success: function(doc) {
		                var events = [];
		                if(!doc.result){
		                    $.map( doc.result, function( r ) {
		                        events.push({
		                            title: r.title,
		                            start: r.date_start,
		                            end: r.date_end
		                        });
		                    });
		                }
		                callback(events);
		            }
		        });
		        alert(events);
		    }*/
		});
		
	});

/*
function chargerJSON() {
	try {
	$.ajax({
	url : "ServletCalendar",
	type : "GET",
	async: false, // Mode synchrone
	dataType : "json",
success : function(data){
	$('#calendar').fullCalendar({
		header: {
			left: 'prev,next today',
			center: 'title',
			right: 'month,agendaWeek,agendaDay'
		},
		defaultDate: '2017-02-12',
		navLinks: true, // can click day/week names to navigate views
		selectable: true,
		selectHelper: true,
		select: function(start, end) {
			var title = prompt('Event Title:');
			var eventData;
			if (title) {
				eventData = {
					title: title,
					start: start,
					end: end
				};
				$('#calendar').fullCalendar('renderEvent', eventData, true); // stick? = true
			}
			$('#calendar').fullCalendar('unselect');
			alert(title +" "+start+" "+end);
		},
		editable: true,
		eventLimit: true, // allow "more" link when too many events
		events : data+""
	});	
		},
		error : function(error){alert("erreur :" + error);}
		});
	}
	catch(err) {
		alert("erreur :" +err.message)
	}
	
}*/