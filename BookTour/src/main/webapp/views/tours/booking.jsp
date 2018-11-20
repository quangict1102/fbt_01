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
						<h3>Chi tiết tour</h3>
					</div>
					<div class="book-left-form">
						<p>${tour.name }</p>
						<form action='<c:url value="/booking/${tour.id }/add" />'
							 method="post">
							<p>Số lương người lớn</p>
							<input type="number" name="adults" value="1" class="slnl" min="1"
								max="20" ">
							<p >Giá tiền người lớn: <span id="giatien-nl" data-primeAdults="${tour.primeAdults }">${tour.primeAdults }</span> </p>	
							<p>Số lượng trẻ con</p>
							<input type="number" name="children" value="1" class="sltc"
								min="1" max="20">
							<p >Giá tiền trẻ nhỏ: <span id="giatien-tn" data-primeChilden="${tour.primeChilden }">${tour.primeChilden }</span> </p>		
							<p>Ghi chú</p>
							<textarea type="text" name="notel" value=""
								onfocus="this.value='';"
								onblur="if (this.value == '') {this.value ='';}"></textarea>
							<p>Giá tour</p>
							<input type="radio" value="1" checked="checked"  name="primeTour">1.200.000
							<input type="radio" value="2"  name="primeTour">3.200.000
							<input type="radio" value="3"  name="primeTour">5.200.000
							<p>Bạn chọn: <span id="gia_tour_radio">1.200.000</span></p>
							<input type="hidden" id="input-tour" value="1200">
							<p>Book</p>
							<input type="submit" class="" name="Book" value="Book">
						</form>
						<p >Giá toàn bộ Tour: <span id="giatien-tour">1.200.000</span> VND</p>
					<strong>${statusLogin}</strong>
							<c:if test="${not empty statusLogin }">
								<strong>${statusLogin}</strong>
							</c:if>
						
					</div>
				</div>
				<div class="col-md-6 book-left book-right">
					<div class="book-left-info">
						<h3>View/print your booking without signing in</h3>
					</div>
					<div class="book-left-form">
						<form>
							<p>FullName</p>
							<input type="text" value="" onfocus="this.value='';"
								onblur="if (this.value == '') {this.value ='';}">
							<p>Email</p>
							<input type="text" value="" onfocus="this.value='';"
								onblur="if (this.value == '') {this.value ='';}">
							<p>Phone Number</p>
							<input type="text" value="" onfocus="this.value='';"
								onblur="if (this.value == '') {this.value ='';}">
							<p>Time Start</p>
							<input type="date" value="Select date" onfocus="this.value = '';"
								onblur="if (this.value == '') {this.value = 'Select date';}">
							<p></p>
							<input type="submit" id="login" value="Submit">
						</form>

					</div>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>
	<!-- //container -->
</div>