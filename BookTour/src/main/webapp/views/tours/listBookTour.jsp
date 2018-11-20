<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<spring:url value="/assets/js/change-oney.js" var="change_oney" />
<div class="banner-bottom">
	<!-- container -->
	<div class="container">
		<div class="faqs-top-grids">
			<div class="book-grids">
				<div class="col-md-6 book-left">
					<div class="book-left-info">
						<h3>Danh sách Tour đã đăng ký</h3>
					</div>
					<div class="book-left-form">
						<div id="find-idBookTour">
							<c:forEach var="lBookTour" items="${booktours }">
								<div id='images1' data-idBookTour="${lBookTour.id }"
									class='list-tour-img'>
									<a href="<c:url value='/bills/${lBookTour.id }'/> "> <img
										alt='Paris' style='width: 150px'
										src="<c:url value='/assets/images/a1.jpg' />">
										<div class='list-tour-text' data-idBookTour="${lBookTour.id }">
												<p>
													<span>${lBookTour.tour.name }</span>
												</p>
											<p>
												Giá tour<span>${lBookTour.primeTour } VND</span>
											</p>
											<p>
												<a class="idBookTour" href="<c:url value='/bills/${lBookTour.id }'/> ">Thanh
													toán Tour này</a>
											</p>
											<form
												action="<c:url value="/booktours/${lBookTour.id }/del"/> "
												method="post">
												<button type="submit" onclick="if(!(confirm('Ban chan chan xoa?'))) return false" id="del_tour">Xóa Tour</button>
											</form>
											<button data-idBookTour="${lBookTour.id }"
												class="edit_tour_update" id="edit_tour">Cập nhật
												Tour</button>
										</div></a>
								</div>
							</c:forEach>
						</div>

					</div>
				</div>

				<div id="bill-display"
					class="col-md-6 book-left book-right bill-display-none">
					<div class="book-left-info">
						<h3>Chi tiết tour</h3>
					</div>
					<div id="edit_book_tour" class="book-left-form"></div>
				</div>
			</div>
		</div>
	</div>
</div>
<script src="${change_oney }" type="text/javascript"></script>