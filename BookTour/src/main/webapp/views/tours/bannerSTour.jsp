<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- banner -->
<div class="banner">
	<!-- container -->
	<div class="container">
		<div class="col-md-4 banner-left">
			<section class="slider2">
				<div class="flexslider">
					<ul class="slides">
						<li>
							<div class="slider-info">
								<img src="assets/images/3.jpg" alt="">
							</div>
						</li>
						<li>
							<div class="slider-info">
								<img src="assets/images/2.jpg" alt="">
							</div>
						</li>
						<li>
							<div class="slider-info">
								<img src="assets/images/1.jpg" alt="">
							</div>
						</li>
						<li>
							<div class="slider-info">
								<img src="assets/images/7.jpg" alt="">
							</div>
						</li>
						<li>
							<div class="slider-info">
								<img src="assets/images/8.jpg" alt="">
							</div>
						</li>
					</ul>
				</div>
			</section>
			<!--FlexSlider-->
		</div>
		<div class="col-md-8 banner-right">
			<div class="sap_tabs">
				<div class="booking-info">
					<h2><spring:message code="page.titel" /></h2>
				</div>
				<div id="horizontalTab"
					style="display: block; width: 100%; margin: 0px;">
					<ul class="resp-tabs-list">
						<li class="resp-tab-item" aria-controls="tab_item-0" role="tab"><span>Tour</span></li>
						<div class="clearfix"></div>
					</ul>
					<!---->
					<div class="resp-tabs-container" style="width: 30%">
						<div class="tab-1 resp-tab-content" aria-labelledby="tab_item-0">
							<div class="facts">
								<div class="booking-form">
									<!---strat-date-piker---->
									<script type="text/javascript" src="${datepickerjs}"></script>
									<!---/End-date-piker---->
									<!-- Set here the key for your domain in order to hide the watermark on the web server -->

									<div class="online_reservation">
										<div class="b_room">
											<div class="booking_room">
												<div class="reservation">
													<ul>
														<li class="span1_of_1 desti">
															<h5>City</h5>
															<div class="book_date">
																<div class="section_room">
																	<select id="city" name="citys"
																		class="frm-field required">
																		<option value="null">--Select--</option>
																		<c:forEach var="lCity" items="${ cities}">
																			<option value="${lCity.id }">${lCity.name }</option>
																		</c:forEach>
																	</select>
																</div>
															</div>
														</li>
														<div class="clearfix"></div>
													</ul>
												</div>
												<div class="reservation">
													<ul>
														<li class="span1_of_1">
															<h5>Departure</h5>
															<div class="book_date">
																<form>
																	<span class="glyphicon glyphicon-calendar" aria-hidden="true"></span> 
																	<input type="date" id="date_select" onblur="if (this.value == '') {this.value = 'Select date';}">
																</form>
															</div>
														</li>
														<div class="clearfix"></div>
													</ul>
												</div>
												<div class="reservation">
													<ul>
														<li class="span1_of_3">
															<div class="date_btn">
																<form action="<c:url value="/product/search/" />" method="get">
																<input name="date_tour" id="date_js" type="hidden" />
																<input name="idCity" id="idCity_js" type="hidden"/>
																	<input type="submit" id="search-tour" value="Search" />
																</form>
															</div>
														</li>
														<div class="clearfix"></div>
													</ul>
												</div>
											</div>
											<div class="clearfix"></div>
										</div>
									</div>
									<!---->
								</div>
							</div>
						</div>
					</div>
					<div class="list-tour-by-city" id="list-tour-by-city12">
					</div>
				</div>
			</div>
		</div>
		<div class="clearfix"></div>
	</div>
	<!-- //container -->
</div>
<!-- //banner -->
<div class="banner-bottom">
	<!-- container -->
	<div class="container">
		<div class="banner-bottom-info">
			<h3><spring:message code="page.todaytour" /></h3>
		</div>
		<div class="banner-bottom-grids">
			<div class="col-md-3 banner-bottom-grid">
				<div class="destinations">
					<ul>
					<c:forEach var="lTourToday" items="${tourToday }">
						<li class="button"><a href="#"><div>${lTourToday.name }</div></a>
						<li class="dropdown "><a href="detailtours/${lTourToday.id }">
								<div class="destinations-grid">
									<img src="assets/images/a1.jpg" alt="" />
								</div>
								<div class="destinations-grid-info">
									<div class="destinations-hotel">Lorem ipsum dolor sit
										amet , Goa</div>
									<div class="destinations-star">
										<span class="glyphicon glyphicon-star" aria-hidden="true"></span><span
											class="glyphicon glyphicon-star" aria-hidden="true"></span><span
											class="glyphicon glyphicon-star" aria-hidden="true"></span>
									</div>
									<div class="destinations-price fix-width-auto"><spring:message code="page.least" /> ${lTourToday.primeAdults }VND</div>
									<div class="clearfix"></div>
								</div>
						</a></li>
						</li>
					</c:forEach>
					</ul>
				</div>

			</div>
			<div class="col-md-9">
			<div  id="pagination-page">
			<c:forEach var="tourPagination" items="${tourPagination }">
			<div class="col-md-5 banner-bottom-grid" style="padding-top: 10px">
				<div class="banner-bottom-middle">
					<a href="products.html"> <img src="assets/images/a2.jpg" alt="" />
						<div class="destinations-grid-info tours">
							<h5>${tourPagination.name }</h5>
							<p>${tourPagination.dateStart }</p>
							<p class="b-period">Adluts: ${tourPagination.primeAdults }  |
								Chidren: ${tourPagination.primeChilden }</p>
						</div>
					</a>
				</div>
			</div>
			</c:forEach>
			</div>
			
			</div>

		<div class="clearfix"></div>
		<div class="col-md-3"></div>
		<div class="col-md-6">
		<input type="hidden" name="sumPage" value="${sumPage }">
			<div class="pagination-item">
  			<a href="#" class="pre">&laquo;</a>
 			<c:forEach var = "i" begin="1" end="${sumPage }">
 				<c:choose>
 					<c:when test="${i==1 }">
 						<a href="#" id="page${i }" class="page-pargin active">${i }</a>
 					</c:when>
 					<c:otherwise>
 						<a href="#" id="page${i }" class="page-pargin" >${i }</a>
 					</c:otherwise>
 				</c:choose>
 			</c:forEach>
 			 <a href="#" class="next">&raquo;</a>
			</div>
		</div>
		</div>
	</div>
	<!-- //container -->
</div>
<spring:url value="/assets/vendor/bootstrap/css/bootstrap.min.css" var="bootstrapCss" />
<link rel="stylesheet" href="${bootstrapCss}" />
<spring:url value="/assets/socket/js/form.js" var="formJs" />
<script src="${formJs}" type="text/javascript"></script>
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
<button class="open-button" onclick="openForm(); connect();">Chat</button>
<button class="open-button" onclick="openForm(); connect();">Chat</button>
<div class="chat-popup" id="myForm">
	<div class="row justify-content-center h-100" id="idfromchat">
		<div class="card" id="card1">
			<div class="card-header msg_head" id="card2">
				<div class="d-flex bd-highlight"onclick="closeForm();">
					<div class="img_cont">
						<img
							src="https://res.cloudinary.com/quangict/image/upload/v1544584361/download.png"
							class="rounded-circle user_img"> <span class="online_icon"></span>
					</div>
					<div class="user_info" >
						<span>Chat Admin</span>
					</div>
				</div>

			</div>
			<div class="card-body msg_card_body" id="idDivChat">
			</div>
			<div class="card-footer">
				<div class="input-group">
					<div class="input-group-append">
						<span class="input-group-text attach_btn"><i
							class="fas fa-paperclip"></i></span>
					</div>
					<input id="text" type="text" class="form-control type_msg" onkeypress="return checkClick(event)"></input>
					<div id="idclick" class="input-group-append" onclick="sendMessage();">
						<span class="input-group-text send_btn"><i
							class="fas fa-location-arrow"></i></span>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
