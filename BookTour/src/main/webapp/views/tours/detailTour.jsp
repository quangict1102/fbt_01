<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<spring:url value="/assets/js/load-cmt.js" var="load_cmt" />
<spring:url value="/assets/js/load-img.js" var="load_img" />
<spring:url value="/assets/js/jquery.flexslider.js" var="flexsliderJs" />
<spring:url value="/assets/css/google-map.css" var="google_mapcss" />
<spring:url value="/assets/js/google-map.js" var="google_mapjs" />
<link type="text/css" rel="stylesheet" href="${google_mapcss }" />
<div class="banner-bottom">
	<!-- container -->
	<div class="container">
		<div class="faqs-top-grids">
			<!--single-page-->
			<div class="single-page">
				<div class="col-md-8 single-gd-lt">
					<div class="single-pg-hdr">
						<h2>${tours.name }</h2>
						<p><fmt:formatDate pattern = "dd-MM-yyyy" value = "${tours.dateStart}" /></p>
						<p>
							<spring:message code="search.PriceAdults" /> ${tours.primeAdults } VND
						</p>
						<p>
							<spring:message code="search.childen" /> ${tours.primeChilden } VND
						</p>
						<p>${tours.describe }</p>

					</div>
					<div class="flexslider">
						<ul class="slides">
							<li data-thumb="<c:url value="/assets/images/p1.jpg"/>"><img
								src="<c:url value="/assets/images/p1.jpg"/>" alt="" /></li>
							<li data-thumb="<c:url value="/assets/images/p2.jpg"/>"><img
								src="<c:url value="/assets/images/p2.jpg"/>" alt="" /></li>
							<li data-thumb="<c:url value="/assets/images/p3.jpg"/>"><img
								src="<c:url value="/assets/images/p3.jpg"/>" alt="" /></li>
							<li data-thumb="<c:url value="/assets/images/p4.jpg"/>"><img
								src="<c:url value="/assets/images/p4.jpg"/>" alt="" /></li>
							<li data-thumb="<c:url value="/assets/images/p1.jpg"/>"><img
								src="<c:url value="/assets/images/p1.jpg"/>" alt="" /></li>
							<li data-thumb="<c:url value="/assets/images/p2.jpg"/>"><img
								src="<c:url value="/assets/images/p2.jpg"/>" alt="" /></li>
							<li data-thumb="<c:url value="/assets/images/p3.jpg"/>"><img
								src="<c:url value="/assets/images/p3.jpg"/>" alt="" /></li>
							<li data-thumb="<c:url value="/assets/images/p4.jpg"/>"><img
								src="<c:url value="/assets/images/p4.jpg"/>" alt="" /></li>
						</ul>
					</div>
					<!-- FlexSlider -->
					<script defer src="${flexsliderJs }"></script>
					<script type="text/javascript" src="${load_img }"></script>
					<!-- Comment -->
					<div id="comment_user" class="response">
						<h3>Responses</h3>
						<div id="idTour" data-idTour="${idTour }"></div>
						<div id="idUser" data-idUser="${idUser }"></div>
						<div id="nameUser" data-nameUser="${nameUser }"></div>
						<ul class="ul_comment" style="list-style-type: none;">
						</ul>
					</div>
					<div class="opinion">
						<h3><spring:message code="detailTour.yourcomment" /></h3>
						<form>
							<textarea class="message" style="min-height: 0px; width: 100%"
								placeholder="Message" required=""></textarea>
							<input type="submit" data-idStatus="0" id="comment-mess" value="SEND">
						</form>
					</div>
				</div>
				<div class="col-md-4 single-gd-rt">
					<div class="spl-btn">
						<div class="spl-btn-bor">
							<a href="#"> <span class="glyphicon glyphicon-tag"
								aria-hidden="true"></span>
							</a>
							<p>Special Offer</p>
							<script type="text/javascript" src="${tooltipjs }">
							</script>
						</div>
						<div class="sp-bor-btn text-right">
							<p class="best-pri"><spring:message code="detailTour.bestprice" /></p>
							<a class="best-btn" href="<c:url value="/bookings/${idTour}" />"><spring:message code="detailTour.book" /></a>
						</div>
					</div>
					
					 <input id="pac-input" class="controls" type="text" placeholder="Search Box">
   					 <div id="map"></div>
				
			
				</div>
				<div class="clearfix"></div>
			</div>
			<!--//single-page-->
		</div>
		<div class="c-rooms">
			<div class="p-table">
				<div class="p-table-grids">
					<div class="col-md-3 p-table-grid">
						<div class="p-table-grad-heading">
							<h6>Room type</h6>
						</div>
						<div class="p-table-grid-info">
							<a href="#"><img src="<c:url value="/assets/images/p2.jpg"/>" alt=""></a>
							<div class="room-basic-info">
								<a href="#">Fusce vestibulum ultricies rutrum</a>
								<h6>1 king bed or 2 single beds</h6>
								<p>Vestibulum ullamcorper(condimentum luctus)</p>
							</div>
						</div>
					</div>
					<div class="col-md-3 p-table-grid">
						<div class="p-table-grad-heading">
							<h6>Options</h6>
						</div>
						<div class="rate-features">
							<ul>
								<li>Morbi mollis mattis</li>
								<li>Donec egestas</li>
								<li>Donec non risus</li>
								<li>Pellentesque sem</li>
								<li>Sed ut urna id metus</li>
							</ul>
						</div>
					</div>
					<div class="col-md-3 p-table-grid">
						<div class="p-table-grad-heading">
							<h6>Avg rate per night</h6>
						</div>
						<div class="avg-rate">
							<h5>Recommended for you</h5>
							<p>Price is now:</p>
							<span class="p-offer">$140</span> <span class="p-last-price">$230</span>
						</div>
					</div>
					<div class="col-md-3 p-table-grid">
						<div class="p-table-grad-heading">
							<h6>Book</h6>
						</div>
						<div class="book-button-column">
							<a href="#">Book</a>
						</div>
					</div>
					<div class="clearfix"></div>
				</div>
			</div>
			<div class="p-table">
				<div class="p-table-grids">
					<div class="col-md-3 p-table-grid">
						<div class="p-table-grad-heading">
							<h6>Room type</h6>
						</div>
						<div class="p-table-grid-info">
							<a href="#"><img src="<c:url value="/assets/images/p1.jpg"/>" alt=""></a>
							<div class="room-basic-info">
								<a href="#">Fusce vestibulum ultricies rutrum</a>
								<h6>1 king bed or 2 single beds</h6>
								<p>Vestibulum ullamcorper(condimentum luctus)</p>
							</div>
						</div>
					</div>
					<div class="col-md-3 p-table-grid">
						<div class="p-table-grad-heading">
							<h6>Options</h6>
						</div>
						<div class="rate-features">
							<ul>
								<li>Morbi mollis mattis</li>
								<li>Donec egestas</li>
								<li>Donec non risus</li>
								<li>Pellentesque sem</li>
								<li>Sed ut urna id metus</li>
							</ul>
						</div>
					</div>
					<div class="col-md-3 p-table-grid">
						<div class="p-table-grad-heading">
							<h6>Avg rate per night</h6>
						</div>
						<div class="avg-rate">
							<h5>Recommended for you</h5>
							<p>Price is now:</p>
							<span class="p-offer">$140</span> <span class="p-last-price">$230</span>
						</div>
					</div>
					<div class="col-md-3 p-table-grid">
						<div class="p-table-grad-heading">
							<h6>Book</h6>
						</div>
						<div class="book-button-column">
							<a href="#">Book</a>
						</div>
					</div>
					<div class="clearfix"></div>
				</div>
			</div>
			<div class="p-table">
				<div class="p-table-grids">
					<div class="col-md-3 p-table-grid">
						<div class="p-table-grad-heading">
							<h6>Room type</h6>
						</div>
						<div class="p-table-grid-info">
							<a href="#"><img src="images/p2.jpg" alt=""></a>
							<div class="room-basic-info">
								<a href="#">Fusce vestibulum ultricies rutrum</a>
								<h6>1 king bed or 2 single beds</h6>
								<p>Vestibulum ullamcorper(condimentum luctus)</p>
							</div>
						</div>
					</div>
					<div class="col-md-3 p-table-grid">
						<div class="p-table-grad-heading">
							<h6>Options</h6>
						</div>
						<div class="rate-features">
							<ul>
								<li>Morbi mollis mattis</li>
								<li>Donec egestas</li>
								<li>Donec non risus</li>
								<li>Pellentesque sem</li>
								<li>Sed ut urna id metus</li>
							</ul>
						</div>
					</div>
					<div class="col-md-3 p-table-grid">
						<div class="p-table-grad-heading">
							<h6>Avg rate per night</h6>
						</div>
						<div class="avg-rate">
							<h5>Recommended for you</h5>
							<p>Price is now:</p>
							<span class="p-offer">$140</span> <span class="p-last-price">$230</span>
						</div>
					</div>
					<div class="col-md-3 p-table-grid">
						<div class="p-table-grad-heading">
							<h6>Book</h6>
						</div>
						<div class="book-button-column">
							<a href="#">Book</a>
						</div>
					</div>
					<div class="clearfix"></div>
				</div>
			</div>
		</div>
	</div>
	<!-- //container -->
</div>
<script type="text/javascript" src="${load_cmt }"></script>
<script type="text/javascript" src="${google_mapjs }"></script>
    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAVwQyE1e90XiLhltYdPQen_d27CdspVU8&libraries=places&callback=initAutocomplete"
         async defer></script>