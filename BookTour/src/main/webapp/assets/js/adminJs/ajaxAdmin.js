$(document).ready(function () {

    $("#search-form").submit(function (event) {

        //stop submit the form, we will post it manually.
        event.preventDefault();

        fire_ajax_submit();

    });

});

function fire_ajax_submit() {

    var search = {}
    search["username"] = $("#username").val();

    $("#btn-search").prop("disabled", true);

    $.ajax({
        type: "GET",
        contentType: "application/json",
        url: "/test",
        data: JSON.stringify(search),
        dataType: 'json',
        cache: false,
        timeout: 600000,
        success: function (data) {

            var json = "<h4>Ajax Response</h4><pre>"
                + JSON.stringify(data, null, 4) + "</pre>";
            $('#feedback').html(json);

            console.log("SUCCESS : ", data);
            $("#btn-search").prop("disabled", false);

        },
        error: function (e) {

            var json = "<h4>Ajax Response</h4><pre>"
                + e.responseText + "</pre>";
            $('#feedback').html(json);

            console.log("ERROR : ", e);
            $("#btn-search").prop("disabled", false);

        }
    });

}

$("#btnUserDeleteDetail").on('click', function() {
	var $row = $('#idUser').html();
	alertify.set({
		buttonFocus : "cancel"
	});
	alertify.confirm("Want To Delete?", function(e) {
		if (e) {
			$.ajax({
				type : "DELETE",
				url :  $row,
				success : function(response) {
					window.location.replace("/BookTour1/admin/users");
				}
			});
			alertify.success("Delete");
		} else {
			alertify.error("Cancel Delete ");
		} 
	});
	return false;
});

/*Tour*/
$(".btnTourDelete").on('click', function() {
	var $row = $(this).closest("tr");
	var $text = $row.find(".idtour").text();
	alertify.set({
		buttonFocus : "cancel"
	});
	alertify.confirm("Want To Delete?", function(e) {
		if (e) {
			$.ajax({
				type : "DELETE",
				url : "tours/" + $text,
				success : function(response) {
					window.location.replace("tours");
				}
			});
			alertify.success("Delete");
		} else {
			alertify.error("Cancel Delete ");
		}
	});
	return false;
});

$("#btnDeleteTourDetail").on('click', function() {
	var $text = $("#idTour").html();
	alertify.set({
		buttonFocus : "cancel"
	});
	alertify.confirm("Want To Delete?", function(e) {
		if (e) {
			$.ajax({
				type : "DELETE",
				url :   $text,
				success : function(response) {
					window.location.replace("/BookTour1/admin/tours");
				}
			});
			alertify.success("Delete");
		} else {
			alertify.error("Cancel Delete ");
		}
	});
	return false;
});

/*user*/
$(".btnDeleteUser").on('click', function() {
	var $row = $(this).closest("tr");
	var $text = $row.find(".idUser").text();
	alertify.set({
		buttonFocus : "cancel"
	});
	alertify.confirm("Want To Delete?", function(e) {
		if (e) {
			$.ajax({
				type : "DELETE",
				url : "users/" + $text,
				success : function(response) {
					window.location.replace("users");
				}
			});
			alertify.success("Delete");
		} else {
			alertify.error("Cancel Delete ");
		}
	});
	return false;
});

$("#btnDeleteUserDetail").on('click', function() {
	var $text = $("#idUser").html();
	alertify.set({
		buttonFocus : "cancel"
	});
	alertify.confirm("Want To Delete?", function(e) {
		if (e) {
			$.ajax({
				type : "DELETE",
				url :   $text,
				success : function(response) {
					window.location.replace("/BookTour1/users");
				}
			});
			alertify.success("Delete");
		} else {
			alertify.error("Cancel Delete ");
		}
	});
	return false;
});

/*booking*/
$(".btnBookTourDelete").on('click', function() {
	var $row = $(this).closest("tr");
	var $text = $row.find(".idBookTour").text();
	alertify.set({
		buttonFocus : "cancel"
	});
	alertify.confirm("Want To Delete?", function(e) {
		if (e) {
			$.ajax({
				type : "DELETE",
				url :  "booktours/"+$text,
				success : function(response) {
					window.location.replace("/BookTour1/booktours");
				}
			});
			alertify.success("Delete");
		} else {
			alertify.error("Cancel Delete ");
		}
	});
	return false;
});


$(".btnPlaceDelete").on('click', function() {
	var $row = $(this).closest("tr");
	var $text = $row.find(".idPlace").text();
	alertify.set({
		buttonFocus : "cancel"
	});
	alertify.confirm("Want To Delete?", function(e) {
		if (e) {
			$.ajax({
				type : "DELETE",
				url :  "places/"+$text,
				success : function(response) {
					window.location.replace("/BookTour1/admin/places");
				}
			});
			alertify.success("Delete");
		} else {
			alertify.error("Cancel Delete ");
		}
	});
	return false;
});
