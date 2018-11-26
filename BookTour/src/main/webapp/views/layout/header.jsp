<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<spring:url value="/" var="urlHome" />
<spring:url value="/user/login" var="loginUrl" />
<%-- <spring:url value="/students/add" var="addActionUrl" /> --%>

<div class="container">
	<div class="header-grids">
		<div class="logo">
			<h1>
				<a href="#"><span>Go</span>vihar</a>
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
			<span class="menu"><img src="assets/images/menu.png" alt="" /></span>
			<ul class="nav1">
				<li class="active"><a href="index.html">HOME</a></li>
				<li><a href="weekend.html">Weekend Getaways</a></li>
			</ul>
			<div class="clearfix"></div>
		</div>
		<div class="dropdown-grids">

			<div id="loginContainer">
				<c:choose>
					<c:when test="${userSession.fullName==null }">
						<a href="#" id="loginButton"><span>Login</span></a>
						<div id="loginBox">
							<form id="loginForm" action="" method="get">
								<div class="login-grids">
									<div class="login-grid-left">
										<fieldset id="body">
											<fieldset>
												<label for="email">Email Address</label> <input type="text"
													name="email" id="email_user">
											</fieldset>
											<fieldset>
												<label for="password">Password</label> <input
													type="password" name="password" id="password_user">
											</fieldset>
											<input type="submit" id="login" value="Sign in"> <label
												for="checkbox"><input type="checkbox" id="checkbox">
												<i>Remember me</i></label>
										</fieldset>
										<span><a href="#">Forgot your password?</a></span>
										<div class="or-grid">
											<p>OR</p>
										</div>
										<div class="social-sits">
											<div class="facebook-button">
												<a href="#">Connect with Facebook</a>
											</div>
											<div class="chrome-button">
												<a href="#">Connect with Google</a>
											</div>
											<div class="button-bottom">
												<p>
													New account? <a href='<c:url value="/register"></c:url>'>Signup</a>
												</p>
											</div>
										</div>
									</div>
								</div>
							</form>

						</div>
					</div>	
					</c:when>
					<c:otherwise>
					<div class="login_cart">
						<span>Hello <c:out value="${userSession.fullName }" /></span>
						<button id="logout_user">
							<span>Logout</span>
						</button>
						<a href="#" class="notification_cart"> <img
							src="<c:url value='assets/images/cart.png'/> " width="50px"> 
							<span id="soluong_giahang" class="badge">5</span>
						</a>
					</div>	
					</c:otherwise>
				</c:choose>
		</div>
		<div class="clearfix"></div>
	</div>
</div>
