var getMessageLogin = document.getElementById("messageLogin").innerHTML;
console.log(getMessageLogin);

	if (getMessageLogin=='success') {
		alertify.success("Login Success !");
		
	} 
	if (getMessageLogin=='err') {
		alertify.error("Login Error !");
	}


