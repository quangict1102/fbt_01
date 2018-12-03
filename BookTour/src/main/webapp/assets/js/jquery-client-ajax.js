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
				html +="<a href='/BookTour1/detailtours/"+value[i].id+"'> <img src='assets/images/a1.jpg' alt='Paris'style='width: 150px'>";
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
	
	$('#login').click(function(){
		var email = $('#email_user').val();
		var password = $('#password_user').val();
		$.ajax({
			url: "/BookTour1/clientAjax/user/login",
			type: "get",
			data: {
				email:email,
				password:password
			},
			success: function(value){
				if(value == "error"){
					alert("Account not exists");
				}else{
					location.reload();
				}
				
			}
		});
		return false;
	});
	
	$('#logout_user').click(function(){
		$.ajax({
			url :"/BookTour1/clientAjax/user/logout",
			type:"get",
			success:function(value){
				location.reload();
			}
		})
	});
	
	// comment
	$('#comment-mess').click(function(){
		var idTour = parseInt($('#idTour').attr('data-idTour'));
		var idUser = parseInt($('#idUser').attr('data-idUser'));
		var status = parseInt($('#comment-mess').attr('data-idStatus'));
		var name_user = $('#nameUser').attr('data-nameUser');
		var message = $('.message').val();
		var currentdate = new Date();
		var date = currentdate.getFullYear()+ "-"+ (currentdate.getMonth() + 1)+ "-"+ (currentdate.getDate()+1);
		$.ajax({
			url:"/BookTour1/clientAjax/addComment",
			type:"post",
			data:{
				idTour:idTour,
				idUser:idUser,
				message:message,
				date:date,
				status:status
				
			},
			success: function(value){
				if(value == "success"){
					var datetimemss = currentdate.getDate()+ "-"
					+ (currentdate.getMonth() + 1)+ "-"
					+ currentdate.getFullYear();	
					var cmt='<div class="media response-info">';
						cmt+='<div class="media-left response-text-left">';
						cmt+='<a href="#"> <img class="media-object" src="assets/images/user3.jpg" alt=""></a>';
						cmt+='<h5><a href="#">'+name_user+'</a></h5></div>';
						cmt+='<div class="media-body response-text-right">';
						cmt+='<p>'+message+'</p>';
						cmt+='<ul><li>'+datetimemss+'</li><li><a href="#">Reply</a></li></ul>';
						cmt+='<form><textarea style="min-height: 0px; width: 100%" placeholder="Message" required=""></textarea>';
						cmt+='<input type="submit" value="SEND"></form></div>';
						cmt+='<div class="clearfix"></div></div>';
						
						if($('#comment_user .ul_comment li').length==0){
							$('#comment_user .ul_comment').append(cmt);
							}else{		
						$('#comment_user').find('ul li:eq(0)').before(cmt);
							}
							 $('.message').val('');
				}
			}
		});
		return false;
	});
	
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

	// Add book tour
	$('.book_tour').click(function(){
		if($('.user_id').val() == ''){
			alert('Ban can dang nhap');
			return false;
		}
	});
	
	$('#search-tour').click(function(){
		var date_js = $('#date_js').val();
		var idCity_js = $('#idCity_js').val();
		if(date_js == '' || idCity_js == ''){
			alert("Bạn cần chọn ngày và thành phố")
			return false;
		}
		
	})
	
		// format date
	formatDate = function date2str(x, y) {
	    var z = {
	        M: x.getMonth() + 1,
	        d: x.getDate(),
	        h: x.getHours(),
	        m: x.getMinutes(),
	        s: x.getSeconds()
	    };
	    y = y.replace(/(M+|d+|h+|m+|s+)/g, function(v) {
	        return ((v.length > 1 ? "0" : "") + eval('z.' + v.slice(-1))).slice(-2)
	    });

	    return y.replace(/(y+)/g, function(v) {
	        return x.getFullYear().toString().slice(-v.length)
	    });
	}
	
	var primeA = parseInt($('.count-adults').text())*parseFloat($('.prime-adults').text());
	var primeC = parseInt($('.count-children').text())*parseFloat($('.prime-children').text());
	var primeT = $('.prime-tour').text();
	if(primeT == '1.200.000'){
		printTour = parseFloat(1200);
	}else if(primeT == '3.200.000'){
		printTour = parseFloat(3200);
	}else{
		printTour = parseFloat(5200);
	}
	$('.totailTour').html(formatMoney(primeA+primeC+printTour));
	$('.totailMoneyBill').val(formatMoney(primeA+primeC+printTour));
	$('#create_bill').click(function(){
		var fullNameBill = $('.fullNameBill').val();
		var emailBill = $('.emailBill').val();
		var phoneBill = $('.phoneBill').val();
		var dateBill = $('.dateBill').val();
		var totailMoneyBill = $('.totailMoneyBill').val();
		var idTourBill = parseInt($('#create_bill').attr('data-idTour'));
		$.ajax({
			url: "/BookTour1/bills/create",
			type:"post",
			data:{
				fullNameBill:fullNameBill,
				emailBill:emailBill,
				phoneBill:phoneBill,
				dateBill:dateBill,
				totailMoneyBill:totailMoneyBill,
				idTourBill:idTourBill
			},
			success:function(value){
				if(value=="success"){
					alert("Đã đặt tour")
					location.reload();
				}
			}
		})
		return false;
	});
	
	$('.edit_tour_update').click(function(){
		var idBt =parseInt($(this).attr('data-idBookTour'));
		$.ajax({
			url : "/BookTour1/booktours/edit",
			type: "get",
			data : {
				idBt:idBt
			},
			success: function(tour){
				
				html='';
				html+='<p>'+tour.name+'</p>';
				html+='<form action="" method="post">';
				html+='	<p>Số lương người lớn</p>';
				html+='	<input type="number" name="adults" value="1" class="slnl" min="1" max="20" ">';
				html+='	<p >Giá tiền người lớn: <span id="giatien-nl" data-primeAdults="'+tour.primeAdults+'">'+tour.primeAdults+'</span> </p>';	
				html+='	<p>Số lượng trẻ con</p>';
				html+='	<input type="number" name="children" value="1" class="sltc" min="1" max="20">';
				html+='	<p >Giá tiền trẻ nhỏ: <span id="giatien-tn" data-primeChilden="'+tour.primeChilden+'">'+tour.primeChilden+'</span> </p>';	
				html+='	<p>Ghi chú</p>';
				html+='	<textarea type="text" class="notel" name="notel"></textarea>';
				html+='	<p>Giá tour</p>';
				html+='	<p><input type="radio" value="1" checked="checked"  name="primeTour">Standard package 2*  1.200.000 VND</p>';
				html+='	<p><input type="radio" value="2"  name="primeTour">Superior package 3* 3.200.000 VND</p>';
				html+='	<p><input type="radio" value="3"  name="primeTour">Deluxe package 4* 5.200.000 VND</p>';
				html+='	<p>Bạn chọn: <span id="gia_tour_radio">1.200.000</span></p>';
				html+='	<input type="hidden" id="input-tour" value="1200">';
				html+='	<p>Book</p>';
				html+='	<input type="submit" data-idBTourEdit="'+tour.id+'" class="book_tour" name="Book" value="Update">';
				html+='</form>';
				html+='<p >Giá toàn bộ Tour: <span id="giatien-tour">1.200.000</span> VND</p>';
				html+='<script src="/BookTour1/assets/js/change-oney.js" type="text/javascript"></script>';
				$('#edit_book_tour').html(html);
				
			}
		});
		return false;
	});
	
	$('#search').keyup(function(){ 
		var search = $(this).val();
		if(search != ''){
			$.ajax({
				url:"/BookTour1/clientAjax/searchTourAndPlace",
				type:"get",
				data:{
					search:search
					},
				success:function(value){
					var html ='';
					html += '<ul>';
					if(value.length>0){
					for(var i =0;i<value.length;i++){
						html +='<li data-idTour="'+value[i].id+'" style="border-bottom: 1px solid #000000;display:block;padding:5px"> Name Tour: '+value[i].name+'</li>';
					}
					}else{
						html +='<li>Not Found</li>';
					}
					html += '</ul>';
					$('#search-list').fadeIn(); 
					$('#search-list').html(html);
				}
			})
		}else{
			  $('#search-list').fadeOut();  
			
		}
	});

	 $('#search-list').on('click', 'li', function(){  
		$('#search').val($(this).text());
		var id = $(this).attr('data-idTour');
		var idTour = parseInt(id);
        $('#search-list').fadeOut(); 
        window.location.href = '/BookTour1/detailtours/'+idTour+'';
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