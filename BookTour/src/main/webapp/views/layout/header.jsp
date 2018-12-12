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
					<li><a href="?lang=en"><img alt="" style="width:50px" src="<c:url value="/assets/images/en.jpg"/> "> </a>
					 <a href="?lang=vi"><img alt="" style="width:50px" src="<c:url value="/assets/images/vn.jpg"/> "></a></li>
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
				<li class="active"> <a href='<c:url value="/"></c:url>'><spring:message code="page.main" /></a></li>
				<!-- <li><a href="weekend.html">Weekend Getaways</a></li> -->
			</ul>
			<input type="text" name="search" id="search"  class="form-control" placeholder="Search City Name, Place,..." />
			  <div id="search-list"></div>  
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
												<label for="email"><spring:message code="page.email" /></label> <input type="text"
													name="email" id="email_user">
											</fieldset>
											<fieldset>
												<label for="password"><spring:message code="page.password" /></label> <input
													type="password" name="password" id="password_user">
											</fieldset>
											<input type="submit" id="login" value="Sign in"> <label
												for="checkbox"><input type="checkbox" id="checkbox">
												<i><spring:message code="page.remenber" /></i></label>
										</fieldset>
										<span><a href='<c:url value="/sendPassword"></c:url>'><spring:message code="page.forgot" /></a></span>
										<div class="or-grid">
											<p><spring:message code="page.or" /></p>
										</div>
										<div class="social-sits">
											<div class="facebook-button">
												<a href="#"><spring:message code="page.fb" /></a>
											</div>
											<div class="chrome-button">
											<a href="https://accounts.google.com/o/oauth2/auth?scope=email&redirect_uri=http://localhost:8083/BookTour1/login-google&response_type=code
											&client_id=650605713330-9s9j72fd23vgfqdlc380mh0re75mj7cm.apps.googleusercontent.com&approval_prompt=force"><spring:message code="page.gmail" /></a>	
												
											</div>
											<div class="button-bottom">
												<p>
													<spring:message code="page.account" /> <a href='<c:url value="/register"></c:url>'>Signup</a>
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
						<span><spring:message code="users.login" /> <c:out value="${userSession.fullName }" /></span>
						<a href="<c:url value='/profileUser/${userSession.id }'/> ">Profile</a>
						<button class="btn btn-primary" id="logout_user">
							<span>Logout</span>
						</button>
						<a href="<c:url value="/booktours/${userSession.id }"/> " class="notification_cart">

							<img src="<c:url value='/assets/images/cart.png'/> " width="50px">
							<span id="soluong_giahang" class="badge">${cart}</span>
						</a>
					</div>	
					</c:otherwise>
				</c:choose>
		</div>
		<div class="clearfix"></div>
	</div>
</div>
<div hidden id="messageLogin">
	${sendLog }
</div>
<script src="${alertifyJs}" type="text/javascript"></script>
<script src="${alertifyLogJs}" type="text/javascript"></script>