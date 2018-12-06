var getMessageLogin = document.getElementById("messageLogin").innerHTML;
console.log(getMessageLogin);

if (getMessageLogin == 'success') {
	alertify.success("Login Success !");

}
if (getMessageLogin == 'err') {
	alertify.error("Login Error !");
}

var getmessageSendEmail = document.getElementById("messageSendEmail").innerHTML;

if (getmessageSendEmail == 'sendErr') {
	alertify.error("Send Error !");
}

if (getmessageSendEmail == 'sendSuccess') {
	alertify.success("Send Success !");
}
