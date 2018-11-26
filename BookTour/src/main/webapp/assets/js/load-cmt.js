$(document).ready(function() {
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
	
	$(window).on("load", function() {
		var idTour = parseInt($('#idTour').attr('data-idTour'));
		$.ajax({
			url:"/BookTour1/clientAjax/loadComment",
			type:"get",
			data:{
				idTour:idTour
			},
			success:function(value){
				var cmt = [];
				var replycmt = [];
				for(var i=0;i<value.length;i++){
					var cmtObject = {};
					var replyObject = {};
					if(value[i].status == 0){
						cmtObject['id'] = value[i].id;
						cmtObject['context'] = value[i].context;
						cmtObject['time'] = value[i].time;
						cmtObject['nameUser'] = value[i].nameUser;
						cmt.push(cmtObject);
					}else{
						replyObject['id'] = value[i].id;
						replyObject['context'] = value[i].context;
						replyObject['time'] = value[i].time;
						replyObject['nameUser'] = value[i].nameUser;
						replycmt.push(replyObject);
					}					
				}
				
				var html="";
				for(var i=0;i<cmt.length;i++){
			 html+="<li>";
				html+='<div class="media response-info">';
				html+='<div class="media-left response-text-left">';
				html+='<a href="#"> <img class="media-object" src="assets/images/user1.jpg" alt=""></a>';
				html+='<h5><a href="#">'+cmt[i].nameUser+'</a></h5>';
				html+='</div>';
				html+='	<div class="media-body response-text-right">';
				html+='	<p>'+cmt[i].context+'</p>';
				html+='	<ul><li>'+formatDate(new Date(cmt[i].time),'dd-MM-yyyy')+'</li><li><a href="#">Reply</a></li></ul>';
				/*<!-- reply comment -->*/
				html+='<div class="media response-info">';
				html+='<div class="media-left response-text-left">';
				html+='<a href="#"> <img class="media-object" src="assets/images/user1.jpg" alt=""></a>';
				html+='<h5><a href="#">Admin</a></h5>';
				html+='</div>';
				html+='	<div class="media-body response-text-right">';
				html+='	<p>Noi dung cmt</p>';
				html+='	<ul><li>June 21, 2013</li><li><a href="#">Reply</a></li></ul>';
				/*<!-- form reply comment -->*/
				html+='<form>';
				html+='<textarea style="min-height: 0px; width: 100%" placeholder="Message" required=""></textarea>';
				html+='<input type="submit" value="SEND">';
				html+='	</form></div>';
				html+='<div class="clearfix"></div>';
				html+='	</div>';
				html+='	</div>';
				html+='	<div class="clearfix"></div>';
				html+='</div>';
				html+='</li>';
				}
				var remove_comment = $('#comment_user').find('ul');
				
				remove_comment.append(html);
			}
		})
	});
});