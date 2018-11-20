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
					<h2>Book Domestic & International Flight Tickets</h2>
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
			<h3>Today's Top Deals</h3>
		</div>
		<div class="banner-bottom-grids">
			<div class="col-md-4 banner-bottom-grid">
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
									<div class="destinations-price fix-width-auto">Ít nhất ${lTourToday.primeAdults }VND</div>
									<div class="clearfix"></div>
								</div>
						</a></li>
						</li>
					</c:forEach>
					</ul>
				</div>
				<div class="choose">
					<div class="choose-info">
						<h4>Why Choose Us</h4>
					</div>
					<div class="choose-grids">
						<div class="choose-grids-info">
							<div class="choose-left">
								<h5>09</h5>
								<span>Million</span>
							</div>
							<div class="choose-right">
								<a href="products.html">Aliquam faucibus vehicula vulputate</a>
								<p>Maecenas euismod tortor a tristique convallis diam eros
									aliquam.</p>
							</div>
							<div class="clearfix"></div>
						</div>
						<div class="choose-grids-info">
							<div class="choose-left">
								<span class="glyphicon glyphicon-globe" aria-hidden="true"></span>
							</div>
							<div class="choose-right">
								<a href="products.html">Sed tincidunt consectetur augue</a>
								<p>Nulla bibendum libero in nunc eleifend tincidunt. Aliquam
									quis molestie lectus</p>
							</div>
							<div class="clearfix"></div>
						</div>
						<div class="choose-grids-info">
							<div class="choose-left">
								<h6>$</h6>
							</div>
							<div class="choose-right">
								<a href="products.html">Nullam et arcu interdum, accumsan
									justo</a>
								<p>Maecenas dapibus eu purus vel imperdiet. Maecenas cursus,
									arcu sed tempus</p>
							</div>
							<div class="clearfix"></div>
						</div>
					</div>
				</div>
			</div>
			<div class="col-md-4 banner-bottom-grid">
				<div class="banner-bottom-middle">
					<a href="products.html"> <img src="assets/images/a2.jpg" alt="" />
						<div class="destinations-grid-info tours">
							<h5>Book your next Malaysia holiday!</h5>
							<p>Integer eget aliquam nibh. Donec blandit volutpat libero
								id lacinia</p>
							<p class="b-period">Book Period: Now - 7 September 2015 |
								Travel Period: Now - 31 October 2015</p>
						</div>
					</a>
				</div>
				<div class="top-destinations-grids">
					<div class="top-destinations-info">
						<h4>Top Destinations</h4>
					</div>
					<div class="top-destinations-bottom">
						<div class="td-grids">
							<div class="col-xs-3 td-left">
								<img src="assets/images/t1.jpg" alt="" />
							</div>
							<div class="col-xs-7 td-middle">
								<a href="products.html">Donec libero id lacinia</a>
								<p>Dapibus eu purus vel libero in nunc</p>
								<span class="glyphicon glyphicon-star" aria-hidden="true"></span>
								<span class="glyphicon glyphicon-star" aria-hidden="true"></span>
								<span class="glyphicon glyphicon-star" aria-hidden="true"></span>
							</div>
							<div class="col-xs-2 td-right">
								<p>$190</p>
							</div>
							<div class="clearfix"></div>
						</div>
						<div class="td-grids">
							<div class="col-xs-3 td-left">
								<img src="assets/images/t2.jpg" alt="" />
							</div>
							<div class="col-xs-7 td-middle">
								<a href="products.html">Donec libero id lacinia</a>
								<p>Dapibus eu purus vel libero in nunc</p>
								<span class="glyphicon glyphicon-star" aria-hidden="true"></span>
								<span class="glyphicon glyphicon-star" aria-hidden="true"></span>
								<span class="glyphicon glyphicon-star" aria-hidden="true"></span>
								<span class="glyphicon glyphicon-star" aria-hidden="true"></span>
							</div>
							<div class="col-xs-2 td-right">
								<p>$213</p>
							</div>
							<div class="clearfix"></div>
						</div>
						<div class="td-grids">
							<div class="col-xs-3 td-left">
								<img src="assets/images/t3.jpg" alt="" />
							</div>
							<div class="col-xs-7 td-middle">
								<a href="products.html">Donec libero id lacinia</a>
								<p>Dapibus eu purus vel libero in nunc</p>
								<span class="glyphicon glyphicon-star" aria-hidden="true"></span>
								<span class="glyphicon glyphicon-star" aria-hidden="true"></span>
								<span class="glyphicon glyphicon-star" aria-hidden="true"></span>
								<span class="glyphicon glyphicon-star" aria-hidden="true"></span>
							</div>
							<div class="col-xs-2 td-right">
								<p>$176</p>
							</div>
							<div class="clearfix"></div>
						</div>
						<div class="td-grids">
							<div class="col-xs-3 td-left">
								<img src="assets/images/t4.jpg" alt="" />
							</div>
							<div class="col-xs-7 td-middle">
								<a href="products.html">Donec libero id lacinia</a>
								<p>Dapibus eu purus vel libero in nunc</p>
								<span class="glyphicon glyphicon-star" aria-hidden="true"></span>
								<span class="glyphicon glyphicon-star" aria-hidden="true"></span>
								<span class="glyphicon glyphicon-star" aria-hidden="true"></span>
							</div>
							<div class="col-xs-2 td-right">
								<p>$490</p>
							</div>
							<div class="clearfix"></div>
						</div>
					</div>
				</div>
			</div>
			<div class="col-md-4 banner-bottom-grid">
				<div class="banner-bottom-right">
					<a href="products.html"> <img src="assets/images/a3.jpg" alt="" />
						<div class="destinations-grid-info tours">
							<h5>New Hotel Experiences at Your Favourite Destinations</h5>
							<p>Integer eget aliquam nibh. Donec blandit volutpat libero
								id lacinia</p>
							<p class="b-period">Book Period: Now - 7 September 2015 |
								Travel Period: Now - 31 October 2015</p>
						</div>
					</a>
				</div>
				<div class="news-grids">
					<div class="news-grids-info">
						<h4>Latest News</h4>
					</div>
					<div class="news-grids-bottom">
						<!-- date -->
						<div id="design" class="date">
							<div id="cycler">
								<div class="date-text">
									<a href="single.html">August 15,2015</a>
									<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
								</div>
								<div class="date-text">
									<a href="single.html">July 08,2015</a>
									<p>Nullam non turpis sit amet metus tristique egestas et et
										orci.</p>
								</div>
								<div class="date-text">
									<a href="single.html">February 15,2015</a>
									<p>Duis venenatis ac ipsum vel ultricies in placerat quam</p>
								</div>
								<div class="date-text">
									<a href="single.html">January 15,2015</a>
									<p>Pellentesque ullamcorper fringilla ipsum, ornare dapibus
										velit volutpat sit amet.</p>
								</div>
								<div class="date-text">
									<a href="single.html">September 24,2014</a>
									<p>In lobortis ipsum mi, ac imperdiet elit pellentesque at.</p>
								</div>
							</div>
							<script type="text/javascript" src="${cyclejs}"></script>
						</div>
						<!-- //date -->
					</div>
				</div>
			</div>
			<div class="clearfix"></div>
		</div>
	</div>
	<!-- //container -->
</div>