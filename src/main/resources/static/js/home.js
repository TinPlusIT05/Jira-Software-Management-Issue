$(document).ready(function(){

	$('#our_table').find('td').each(function () {
	
		$(this).click();
		loadValue();
	});
	$('#our_table2').find('td').each(function () {
	
		$(this).click();
		loadValue2();
	});
	
	$('.btn-load').click(function() {
		console.log("loading ...");
	    location.reload();
	});
	
	function loadValue(){
		$('#our_table').on('click','td',function (e) {
			var tieude = e.delegateTarget.tHead.rows[0].cells[this.cellIndex];
			var	cot = this.parentNode.cells[0];
			var issueName = $(tieude).text();
			var priority = $(cot).text();
			console.log("priority"+priority);

			var self = $(this).closest('.valuei');
			$.ajax({
				url: "/getvalue",
				type: "GET",
				encoding: "UTF-8",
				dataType: "html",
				contentType: "text/plain; charset=UTF-8",
				data: {
					priority: priority,
					issueName: issueName
				},
				success: function (value) {
					$(self).text(value);

				}
			});


		})

	}
	
	function loadValue2(){
		$('#our_table2').on('click','td',function (e) {
			var tieude = e.delegateTarget.tHead.rows[0].cells[this.cellIndex];
			var	cot = this.parentNode.cells[0];
			var issueName = $(tieude).text();
			var priority = $(cot).text();
			console.log("priority"+priority);

			var self = $(this).closest('.valuei');
			$.ajax({
				url: "/getvalue-in",
				type: "GET",
				encoding: "UTF-8",
				dataType: "html",
				contentType: "text/plain; charset=UTF-8",
				data: {
					priority: priority,
					issueName: issueName
				},
				success: function (value) {
					$(self).text(value);

				}
			});


		})

	}



	
});