<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras"
	prefix="tilesx"%>
<spring:url value="/admin/login" var="loginUrl" />

<div class="container">
	<div class="card card-login mx-auto mt-5">
		<div class="card-header">Login</div>
		<div class="card-body">
	 
			<form class="form-horizontal" method="post" 
			modelAttribute="userLogin" action="${loginUrl}">
			
				<div class="form-group">
					<div class="form-label-group">
						<input name="email" type="email" id="inputEmail" class="form-control"
							placeholder="Email address" required="required"
							autofocus="autofocus"/> <label for="inputEmail">Email
							address</label>
					</div>
				</div>
				<div class="form-group">
					<div class="form-label-group">
						<input name="password" type="password" id="inputPassword" class="form-control"
							placeholder="Password" required="required"/> <label
							for="inputPassword">Password</label>
					</div>
				</div>
				<div class="form-group">
					<div class="checkbox">
						<label> <input type="checkbox" value="remember-me">
							Remember Password
						</label>
					</div>
				</div>
				<button type="submit" class="btn btn-primary btn-block ">Login</button>
			</form>
			<div class="text-center">
				<a class="d-block small mt-3" href="register.html">Register an
					Account</a> <a class="d-block small" href="forgot-password.html">Forgot
					Password?</a>
			</div>
		</div>
	</div>
</div>

<div id="messageLogin" hidden>${logNotice}</div>






