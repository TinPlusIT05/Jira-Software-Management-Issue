$(document).ready(function(){

		$( '.namepriority' ).each(function() {
			var priority = $(this).attr("data-namep");
			var self = $(this).closest(".table-name").find('.valuei');
			$( '.nameissue' ).each(function() {
				var issueName = $(this).attr("data-namei");
				
				var x = '';
				$.ajax({
	            url: "/getvalue",
	            type: "GET",
	            encoding: "UTF-8",
	            dataType: "html",
	            contentType: "text/plain; charset=UTF-8",
	            data: {
	            	priority : priority,
	            	issueName: issueName,
	    
	            },
	            success: function (value) {
	            	console.log("bbbbbbbbbbbbbb"+ value);
	            		self.html(value);
	            		
	            		
	            }
	        });
				
			
				
			});
			
		});
		

	
});