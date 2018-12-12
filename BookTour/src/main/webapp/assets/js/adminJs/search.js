$('#searchTour').keyup(function(){ 
		var searchTour = $(this).val();
		
		if(searchTour != ''){
			$.ajax({
				url:"/BookTour1/admin/tours/search",
				type:"get",
				data:{
					searchTour:searchTour
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
		$('#searchTour').val($(this).text());
		var id = $(this).attr('data-idTour');
		var idTour = parseInt(id);
        $('#search-list').fadeOut(); 
        window.location.href = '/BookTour1/admin/tours/'+idTour+'';
	});