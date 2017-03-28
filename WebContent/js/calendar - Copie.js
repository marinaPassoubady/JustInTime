var tab;

$(document).ready(function() {
		$('#calendar').fullCalendar({
			header: {
				left: 'prev,next today',
				center: 'title',
				right: 'month,agendaWeek,agendaDay'
			},
			navLinks: true, // can click day/week names to navigate views
			selectable: false,
			selectHelper: false,
			editable: false,
			disableDragging: true,
			eventLimit: true, // allow "more" link when too many events
			events: 'events.json',
			eventClick: function(event) {
				var date = new Date(1490115600000);
				swal({
					title: "Nom de la tâche :"+event.title,
					type: 'info',
					html: '<p>Débute à : '+date.toString()+'</p><br><p>Fini à : '+event.end+'</p><br>',
					width: 400,
					background: '#c2d6d6'		
				});
			},
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

function msToTime(A) {

	seconds=(A/1000)%60
	minutes=(A/(1000*60))%60
	hours=(A/(1000*60*60))%24

	  return hours+":"+minutes+":"+seconds;
	}

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