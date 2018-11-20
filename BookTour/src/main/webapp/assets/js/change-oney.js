$(document).ready(function() {
// thay đổi giá tiền	
	function formatMoney(n, c, d, t) {
		  var c = isNaN(c = Math.abs(c)) ? 3 : c,
		    d = d == undefined ? "." : d,
		    t = t == undefined ? "." : t,
		    s = n < 0 ? "-" : "",
		    i = String(parseInt(n = Math.abs(Number(n) || 0).toFixed(c))),
		    j = (j = i.length) > 3 ? j % 3 : 0;

		  return s + (j ? i.substr(0, j) + t : "") + i.substr(j).replace(/(\d{3})(?=\d)/g, "$1" + t) + (c ? d + Math.abs(n - i).toFixed(c).slice(2) : "");
		};
	function formatTien(a){
		return parseFloat(a).toFixed(3).replace(/(\d)(?=(\d{3})+\,)/g, "$1,").toString();
	};
		tien_slnl(false);
	function tien_slnl(isChange){
		var tien_nl = $('#giatien-nl').text();
		var tien_tn = $('#giatien-tn').text();
		var tien_tour =$('#input-tour').val();
		var giatien_tour = parseFloat(tien_nl)+parseFloat(tien_tn)+parseFloat(tien_tour);
		var tong = formatMoney(giatien_tour);
		if(!isChange){
			$('#giatien-tour').html(tong);
		}
		$('#giatien-tour').html(tong);
		
	}
	// giá tiền người lớn
	$('.slnl').change(function(){
		var slnl = parseInt($(this).val());
		var giatien_nl = parseFloat($('#giatien-nl').attr('data-primeAdults'));
		var tongtien_slnl =  slnl*giatien_nl;
		var format_tongtien_slnl = formatTien(tongtien_slnl);
		$('#giatien-nl').html(format_tongtien_slnl);
		tien_slnl(true);
		
	});

	// giá tiền trẻ nhỏ
	$('.sltc').change(function(){
		var sltn = parseInt($(this).val());
		var giatien_tn = parseFloat($('#giatien-tn').attr('data-primeChilden'));
		var tongtien_sltn =  sltn*giatien_tn;
		var format_tongtien_sltn = formatTien(tongtien_sltn);
		$('#giatien-tn').html(format_tongtien_sltn);
		tien_slnl(true);
	});
	$('input[type=radio][name=primeTour]').on('change', function() {
	     switch($(this).val()) {
	         case '1':
	        	 var format_tien_loai_tour = formatTien('1200');
	        	$('#gia_tour_radio').html(format_tien_loai_tour);
	        	$('#input-tour').val(parseFloat('1200'))
	        	console.log(parseFloat('1200'));
	        	tien_slnl(true);
	        	 break;
	         case '2':
	        	 var format_tien_loai_tour = formatTien('3200');
	        	 $('#gia_tour_radio').html(format_tien_loai_tour);
		        	$('#input-tour').val(parseFloat('3200'))
	        	tien_slnl(true);
	        	 break;
	         case '3':
	        	 var format_tien_loai_tour = formatTien('5200');
	        	 $('#gia_tour_radio').html(format_tien_loai_tour);
		        	$('#input-tour').val(parseFloat('5200'))
	        	tien_slnl(true);
	        	 break;    
	     }
	});
	$('.book_tour').click(function(){
		var slnl =parseInt($('.slnl').val());
		var sltc =parseInt($('.sltc').val());
		var primeTour =  $("input[name='primeTour']:checked").val();
		var idTourEdit = $(this).attr('data-idBTourEdit');
		var notel = $('.notel').val();
		var idTour = parseInt(idTourEdit);
		$.ajax({
			url : "/BookTour1/booktours/update",
			type: "post",
			data: {
				slnl:slnl,
				sltc:sltc,
				primeTour:primeTour,
				idTour:idTour,
				notel:notel
			},
			success :function(value){
				if(value=="success"){
					alert("đã cập nhật")
					location.reload();
				}
				else if(value == 'error'){
				alert("cập nhật thất bại")
				  window.location = '/BookTour1/error';
				}
			}
		});
		return false;
	});
})