<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<spring:url value="/assets/socket/css/form.css" var="formChatCss" />
<link rel="stylesheet" href="${formChatCss}" />
<spring:url value="/assets/socket/sockjs-0.3.4.js" var="socketJS" />
<spring:url value="/assets/socket/stomp.js" var="stompJs" />
<script src="${socketJS}" type="text/javascript"></script>
<script src="${stompJs}" type="text/javascript"></script>

<spring:url value="/assets/socket/js/socket.js" var="socketJsControll" />
<script src="${socketJsControll}" type="text/javascript"></script>
<spring:url value="/assets/socket/css/form2.css" var="formChatCss" />	
<link rel="stylesheet" href="${formChatCss}" />
<button class="open-button" onclick="openForm(); connectAdmin();">Chat</button>
<div class="chat-popup" id="myForm">
	<div class="row justify-content-center h-100" id="idfromchat">
		<div class="card" id="card1">
			<div class="card-header msg_head" id="card2" onclick="closeForm();">
				<div class="d-flex bd-highlight">
					<div class="img_cont">
						<img
							src="https://res.cloudinary.com/quangict/image/upload/v1544584361/download.png"
							class="rounded-circle user_img"> <span class="online_icon"></span>
					</div>
					<div class="user_info">
						<span>Chat User</span>
					</div>

				</div>

			</div>
			<div class="card-body msg_card_body" id="idDivChat">
				
			</div>
			<div>
			</div>
			<div class="card-footer">
				<div class="input-group">
					<div class="input-group-append">
						<span class="input-group-text attach_btn"><i
							class="fas fa-paperclip"></i></span>
					</div>
					<input id="text" type="text" class="form-control type_msg"
						onkeypress="return checkClick(event)"></input>
					<div id="idclick" class="input-group-append"
						onclick="sendMessageAdmin();">
						<span class="input-group-text send_btn"><i
							class="fas fa-location-arrow"></i></span>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

