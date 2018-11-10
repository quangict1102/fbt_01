<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras"
	prefix="tilesx"%>

	<div class="header">
		<div class="container">
			<div class="header-grids">
				<div class="logo">
					<h1>
						<a href="index.html"><span>Go</span>vihar</a>
					</h1>
				</div>
				<!--navbar-header-->
				<div class="header-dropdown">
					<div class="emergency-grid">
						<ul>
							<li>Toll Free :</li>
							<li class="call">+1 234 567 8901</li>
						</ul>
					</div>
					<div class="clearfix"></div>
				</div>
				<div class="clearfix"></div>
			</div>
			<div class="nav-top">
				<div class="top-nav">
					<span class="menu"><img src="images/menu.png" alt="" /></span>
					<ul class="nav1">
						<li><a href="index.html">Flights</a></li>
						<li><a href="hotels.html">Hotels</a></li>
						<li><a href="holidays.html">Holidays</a></li>
						<li><a href="flights-hotels.html">Flight+Hotel</a></li>
						<li><a href="bus.html">Bus</a></li>
						<li><a href="trains.html">Trains</a></li>
						<li><a href="weekend.html">Weekend Getaways</a></li>
						<li><a href="deals.html">Deals</a></li>
					</ul>
					<div class="clearfix"></div>
				</div>
				<div class="dropdown-grids">
					<div id="loginContainer">
						<a href="#" id="loginButton"><span>Login</span></a>
						<div id="loginBox"></div>
					</div>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>
	<div class="banner-bottom">
		<!-- container -->
		<div class="container">
			<div class="about-info">
				<h2>A brief history of Govihar</h2>
			</div>
			<div class="about-grids">
				<div class="col-md-8 about-left">
					<h3>Phasellus dignissim massa nisl, et elementum lacus gravida
						at. Suspendisse vel turpis mi.Praesent luctus, est hendrerit
						ornare faucibus, ex neque tristique lorem</h3>
					<p>Aliquam suscipit diam eget dolor dapibus consequat ut sit
						amet lorem. Duis iaculis tristique mauris a aliquam. Aliquam
						scelerisque eros lacus, sit amet tincidunt eros bibendum in.
						Aliquam erat volutpat. Cras tincidunt quis erat ac ornare. Aliquam
						porttitor mattis sem, commodo semper risus tempus vestibulum.
						Proin ipsum est Aliquam suscipit diam eget dolor dapibus consequat
						ut sit amet lorem. Duis iaculis tristique mauris a aliquam.
						Aliquam scelerisque eros lacus, sit amet tincidunt eros bibendum
						in. Aliquam erat volutpat. Cras tincidunt quis erat ac ornare.
						Aliquam porttitor mattis sem, commodo semper risus tempus
						vestibulum. Proin ipsum est</p>
				</div>
				<div class="col-md-4 about-right">
					<img src="images/w1.jpg" alt="" />
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>
	<div class="footer">
		<!-- container -->
		<div class="container">
			<div class="footer-top-grids">
				<div class="footer-grids">
					<div class="col-md-3 footer-grid">
						<h4>Our Products</h4>
						<ul>
							<li><a href="index.html">Flight Schedule</a></li>
							<li><a href="flights-hotels.html">City Airline Routes</a></li>
							<li><a href="index.html">International Flights</a></li>
							<li><a href="hotels.html">International Hotels</a></li>
							<li><a href="bus.html">Bus Booking</a></li>
							<li><a href="index.html">Domestic Airlines</a></li>
							<li><a href="holidays.html">Holidays Trip</a></li>
							<li><a href="hotels.html">Hotel Booking</a></li>
						</ul>
					</div>
					<div class="col-md-3 footer-grid">
						<h4>Company</h4>
						<ul>
							<li><a href="about.html">About Us</a></li>
							<li><a href="faqs.html">FAQs</a></li>
							<li><a href="terms.html">Terms &amp; Conditions</a></li>
							<li><a href="privacy.html">Privacy </a></li>
							<li><a href="contact.html">Contact Us</a></li>
							<li><a href="#">Careers</a></li>
							<li><a href="blog.html">Blog</a></li>
							<li><a href="booking.html">Feedback</a></li>
						</ul>
					</div>
					<div class="col-md-3 footer-grid">
						<h4>Travel Resources</h4>
						<ul>
							<li><a href="holidays.html">Holidays Packages</a></li>
							<li><a href="weekend.html">Weekend Getaways</a></li>
							<li><a href="index.html">International Airports</a></li>
							<li><a href="index.html">Domestic Flights Booking</a></li>
							<li><a href="booking.html">Customer Support</a></li>
							<li><a href="booking.html">Cancel Bookings</a></li>
							<li><a href="booking.html">Print E-tickets</a></li>
							<li><a href="booking.html">Customer Forums</a></li>
							<li><a href="booking.html">Make a Payment</a></li>
							<li><a href="booking.html">Complete Booking</a></li>
							<li><a href="booking.html">Assurance Claim</a></li>
							<li><a href="booking.html">Retail Offices</a></li>
						</ul>
					</div>
					<div class="col-md-3 footer-grid">
						<h4>More Links</h4>
						<ul class="chf_footer_list">
							<li><a href="#">Flights Discount Coupons</a></li>
							<li><a href="#">Domestic Airlines</a></li>
							<li><a href="#">Indigo Airlines</a></li>
							<li><a href="#">Air Asia</a></li>
							<li><a href="#">Jet Airways</a></li>
							<li><a href="#">SpiceJet</a></li>
							<li><a href="#">GoAir</a></li>
							<li><a href="#">Air India</a></li>
							<li><a href="#">Domestic Flight Routes</a></li>
							<li><a href="#">Indian City Flight</a></li>
							<li><a href="#">Flight Sitemap</a></li>
						</ul>
					</div>
					<div class="clearfix"></div>
				</div>
				<div class="news-letter">
					<div class="news-letter-grids">
						<div class="col-md-4 news-letter-grid">
							<p>
								Toll Free No : <span>1234-5678-901</span>
							</p>
						</div>
						<div class="col-md-4 news-letter-grid">
							<p class="mail">
								Email : <a href="mailto:info@example.com">mail@example.com</a>
							</p>
						</div>
						<div class="col-md-4 news-letter-grid"></div>
						<div class="clearfix"></div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="footer-bottom-grids">
		<!-- container -->
		<div class="container">
			<div class="footer-bottom-top-grids">
				<div class="col-md-4 footer-bottom-left">
					<h4>Download our mobile Apps</h4>
					<div class="d-apps">
						<ul>
							<li><a href="#"><img src="images/app1.png" alt="" /></a></li>
							<li><a href="#"><img src="images/app2.png" alt="" /></a></a></li>
							<li><a href="#"><img src="images/app3.png" alt="" /></a></a></li>
						</ul>
					</div>
				</div>
				<div class="col-md-4 footer-bottom-left">
					<h4>We Accept</h4>
					<div class="a-cards">
						<ul>
							<li><a href="#"><img src="images/c1.png" alt="" /></a></li>
							<li><a href="#"><img src="images/c2.png" alt="" /></a></a></li>
							<li><a href="#"><img src="images/c3.png" alt="" /></a></a></li>
						</ul>
					</div>
				</div>
				<div class="col-md-4 footer-bottom-left">
					<h4>Follow Us</h4>
					<div class="social">
						<ul>
							<li><a href="#" class="facebook"> </a></li>
							<li><a href="#" class="facebook twitter"> </a></li>
							<li><a href="#" class="facebook chrome"> </a></li>
							<li><a href="#" class="facebook dribbble"> </a></li>
						</ul>
					</div>
				</div>
				<div class="clearfix"></div>
				<div class="copyright">
					<p>
						Copyrights © 2015 Govihar . Design by <a
							href="http://w3layouts.com/">W3layouts</a>
					</p>
				</div>
			</div>
		</div>
	</div>
