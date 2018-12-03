<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- banner-bottom -->
<div class="banner-bottom">
	<!-- container -->
	<div class="container">
		<div class="faqs-top-grids">
			<div class="book-grids">
				<div class="col-md-6 book-left">
					<div class="book-left-info">
						<h3><spring:message code="booktour.detailtour" /></h3>
					</div>
					<div class="book-left-form">
						<p>${tour.name }</p>

						<input value="${tour.id }" type="hidden" class="tour_id">
						<input value="${userSession.id }" type="hidden" class="user_id">
						<form action='<c:url value="/bookings/${tour.id }/add" />'
							 method="post" modelAttribute="formBook">
							<p><spring:message code="book.numberAdults" /></p>
							<input type="number" name="adults" value="1" class="slnl" min="1"
								max="20" ">
							<p ><spring:message code="book.priceAdults" />: <span id="giatien-nl" data-primeAdults="${tour.primeAdults }">${tour.primeAdults }</span> </p>	
							<p><spring:message code="book.numberChilden" /></p>
							<input type="number" name="children" value="1" class="sltc"
								min="1" max="20">
							<p ><spring:message code="book.priceChilden" />: <span id="giatien-tn" data-primeChilden="${tour.primeChilden }">${tour.primeChilden }</span> </p>		
							<p><spring:message code="book.note" /></p>
							<textarea type="text" name="notel" value=""
								onfocus="this.value='';"
								onblur="if (this.value == '') {this.value ='';}"></textarea>
							<p><spring:message code="booktour.pricetour" /></p>
							<p><input type="radio" value="1" checked="checked"  name="primeTour">Standard package 2*  1.200.000 VND</p>
							<p><input type="radio" value="2"  name="primeTour">Superior package 3* 3.200.000 VND</p>
							<p><input type="radio" value="3"  name="primeTour">Deluxe package 4* 5.200.000 VND</p>
							<p><spring:message code="book.select" />: <span id="gia_tour_radio">1.200.000</span></p>
							<input type="hidden" id="input-tour" value="1200">
							<p>Book</p>
							<input type="submit"  class="book_tour btn btn-primary" name="Book" value="Book">
						</form>
						<p ><spring:message code="book.totailTour" />: <span id="giatien-tour">1.200.000</span> VND</p>
						
					</div>
				</div>
				<div id="bill-display" class="col-md-6 book-left book-right bill-display-none">
					<div class="book-left-info">
						<h3><spring:message code="booktour.list" /></h3>
					</div>
					<div class="book-left-form">
					
					
				<div>	
					<c:forEach var="lBookTour" items="${booktours }">
				<div id='images1'  class='list-tour-img'>
				<a href="<c:url value='/bills/${lBookTour.id }'/> "> <img alt='Paris'style='width: 150px' src="<c:url value='/assets/images/a1.jpg' />" >
				<div class='list-tour-text'>
				<p><span></span></p>
				<p><spring:message code="book.totailTour" /><span>${lBookTour.primeTour } VND</span></p>
				<p><a href="<c:url value='/bills/${lBookTour.id }'/> "><spring:message code="booktour.pay" /></a></p>
				</div></a></div>
				</c:forEach>
				</div>
				
					</div>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>
	<!-- //container -->
</div>