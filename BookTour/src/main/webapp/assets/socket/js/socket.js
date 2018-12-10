var stompClient = null;
var from = 0;
function connect() {
	var socket = new SockJS('/BookTour1/websocket');
	from = Math.floor(Math.random() * 100000) + 9;
	stompClient = Stomp.over(socket);
	stompClient.connect({}, function(frame) {
		stompClient.subscribe('/topic/user/' + from, function(messageOutput) {
			showMessageOutputMe(JSON.parse(messageOutput.body));
		});
		stompClient.subscribe('/topic/admin/*', function(messageOutput) {
			showMessageOutputUser(JSON.parse(messageOutput.body));
		});
	});
}

function connectAdmin() {
	var socket = new SockJS('/BookTour1/websocket');
	from = Math.floor(Math.random() * 100000) + 9;
	stompClient = Stomp.over(socket);
	stompClient.connect({}, function(frame) {
		stompClient.subscribe('/topic/user/*', function(messageOutput) {
			showMessageOutputUser(JSON.parse(messageOutput.body));
		});
		stompClient.subscribe('/topic/admin/'+from, function(messageOutput) {
			showMessageOutputMe(JSON.parse(messageOutput.body));
		});
	});

}

function disconnect() {
	if (stompClient != null) {
		stompClient.disconnect();
	}

}
function checkClick(e) {
	if (e.keyCode === 13) {
		document.getElementById("idclick").click();
	}
}

function sendMessage() {
	var text = document.getElementById('text').value;
	$('#text').val('');
	stompClient.send("/app/chat/user/" + from, {}, JSON.stringify({
		'from' : from,
		'text' : text
	}));

}
function sendMessageAdmin() {
	var text = document.getElementById('text').value;
	 $('#text').val('');
	stompClient.send("/app/chat/admin/" + from, {}, JSON.stringify({
		'from' : from,
		'text' : text
	}));

}

function showMessageOutputMe(messageOutput) {
	var divChat = document.getElementById('idDivChat');

	var div = document.createElement('div');
	div.setAttribute("class", "d-flex justify-content-end mb-4");
	var divImg = document.createElement('div');
	divImg.setAttribute("class", "img_cont_msg");
	var img = document.createElement('IMG');
	img.setAttribute("class", "rounded-circle user_img_msg");
	img
			.setAttribute(
					"src",
					"https://res.cloudinary.com/quangict/image/upload/v1544584361/download.png");
	divImg.appendChild(img);

	var divText = document.createElement('div');
	divText.setAttribute("class", "msg_cotainer_send");
	divText.appendChild(document.createTextNode(messageOutput.text));
	var span = document.createElement("SPAN");
	span.setAttribute("class", "msg_time_send");
	span.appendChild(document.createTextNode(messageOutput.time));
	divText.appendChild(span);

	div.appendChild(divText);
	div.appendChild(divImg);
	div.style.wordWrap = 'break-word';

	divChat.appendChild(div);
}

function showMessageOutputUser(messageOutput) {
	var divChat = document.getElementById('idDivChat');

	var div = document.createElement('div');
	div.setAttribute("class", "d-flex justify-content-start mb-4");
	var divImg = document.createElement('div');
	divImg.setAttribute("class", "img_cont_msg");
	var img = document.createElement('IMG');
	img.setAttribute("class", "rounded-circle user_img_msg");
	img
			.setAttribute(
					"src",
					"https://res.cloudinary.com/quangict/image/upload/v1544584361/download.png");
	divImg.appendChild(img);

	var divText = document.createElement('div');
	divText.setAttribute("class", "msg_cotainer");
	divText.appendChild(document.createTextNode(messageOutput.text));
	var span = document.createElement("SPAN");
	span.setAttribute("class", "msg_time");
	span.appendChild(document.createTextNode(messageOutput.time));
	divText.appendChild(span);

	div.appendChild(divImg);
	div.appendChild(divText);
	div.style.wordWrap = 'break-word';

	divChat.appendChild(div);
}
