$(document).ready(function() {
	$("#city").change(function() {
		var id = parseInt($(this).val());
		$.ajax({
			url : "/BookTour1/clientAjax/getAllPlaceByCity",
			type : "get",
			data : {
				id : id
			},
			success : function(value) {
				
				html="<div>";
				for (var i = 0; i < value.length; i++) {
				html +="<div id='images1' data-idPlace="+value[i].id+" class='list-tour-img'>";
				html +="<a href='detailtour/"+value[i].id+"'> <img src='assets/images/a1.jpg' alt='Paris'style='width: 150px'>";
				html +="<div class='list-tour-text'>";
				html +="<p><span>"+value[i].name+" </span></p>";
				html +="<p>Người lớn: <span>2.300.000VND</span></p>";
				html +="<p>Trẻ nhỏ: <span>2.300.000VND</span>";
				html +="</p></div></a></div>";
				}
				html +="</div>";
				
				$("#list-tour-by-city12").html(html);
			}
		});
	})

	$('#date_select').change(function(){
		console.log($(this).val());
		$('#date_js').val($(this).val())
	});
	$("#city").change(function() {
		var id = parseInt($(this).val());
		console.log(id)
		$('#idCity_js').val(id);
	});
/*	$('#search-tour').click(function() {
		var date_tour = $('#date-tour').val();
		var idCity = parseInt($('#city').val());
		$.ajax({
			url : "/BookTour1/product/search",
			type : "get",
			data : {
				date_tour : date_tour,
				idCity : idCity
			},
			success : function(value) {

			}
		})
	})*/
});