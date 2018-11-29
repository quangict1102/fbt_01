<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
					<c:forEach items="${detailTours }" var="list">
						<p>Tên tour: <span>${tourObject.name }</span></p>
						<p>Số lượng người lớn: <span class="count-adults">${list.adults }</span></p>
						<p>Giá 1 người lớn: <span class="prime-adults">${tourObject.primeAdults }</span></p>
						<p>Số lượng trẻ nhỏ: <span class="count-children">${list.children }</span></p>
						<p>Giá 1 trẻ nhỏ: <span class="prime-children">${tourObject.primeChilden }</span></p>
						<p>Giá tour: <span class="prime-tour">${list.primeTour }</span></p>
						<p>Tổng tiền: <span class="totailTour"></span></p>
					</c:forEach>
					</div>					
				</div>
				<div id="bill-display"
					class="col-md-6 book-left book-right bill-display-none">
					<div class="book-left-form">
						<form>
							<p>FullName</p>
							<input type="text" required="required" name="fullName" class="fullNameBill">
							<p>Email</p>
							<input type="text" required="required" name="eail" class="emailBill">
							<p>Phone Number</p>
							<input type="text" required="required" name="phoneNumber" class="phoneBill">
							<p>Time Start</p>
							<input type="date" required="required" value="Select date" name="time" class="dateBill">
							<p>Totail Money</p>
							<input type="text" name="totailMoney" readonly="readonly"  value="" class="totailMoneyBill"> <input
								type="submit" data-idTour="${id_bills }" id="create_bill" value="Submit">
						</form>
					</div>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>
</div>