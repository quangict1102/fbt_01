<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras"
	prefix="tilesx"%>
	
<spring:url value="/user/add" var="registerUrl" />

<body class="bg-dark">

	<div class="container">
		<div class="card card-register mx-auto mt-5">
			<div class="card-header">Register an Account</div>
			<div class="card-body">
			<form:form class="form-horizontal" method="post" 
			modelAttribute="UserForm" action="${registerUrl}">
					<div class="form-group"></div>
					<div class="form-group">
						<div class="form-label-group">
							<input type="text" id="fullName" class="form-control"
								placeholder="Full name" required="required"> <label
								for="fullName">Full name</label>
						</div>
					</div>

					<div class="form-group">
						<div class="form-label-group">
							<select>
								<option value="0">Male</option>
								<option value="1">Female</option>
								<option value="2">Other</option>
							</select>
						</div>
					</div>
					<div class="form-group">
						<div class="form-label-group">
							<input type="text" id="address" class="form-control"
								placeholder="address" required="required"> <label
								for="address">Address</label>
						</div>
					</div>
					<div class="form-group">
						<div class="form-label-group">
							<input type="email" id="inputEmail" class="form-control"
								placeholder="Email " required="required"> <label
								for="inputEmail">Email </label>
						</div>
					</div>
					<div class="form-group">
						<div class="form-label-group">
							<input type="text" id="phoneNumber" class="form-control"
								placeholder="phoneNumber" required="required"> <label
								for="phoneNumber">Phone Number</label>
						</div>
					</div>

					<div class="form-group">
						<div class="form-row">
							<div class="col-md-6">
								<div class="form-label-group">
									<input type="password" id="inputPassword" class="form-control"
										placeholder="Password" required="required"> <label
										for="inputPassword">Password</label>
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-label-group">
									<input type="password" id="confirmPassword"
										class="form-control" placeholder="Confirm password"
										required="required"> <label for="confirmPassword">Confirm
										password</label>
								</div>
							</div>
						</div>
					</div>
					<button type="submit" class="btn btn-primary btn-block ">Register</button>
				</form:form>
				<div class="text-center">
					<a class="d-block small mt-3" href="login.html">Login Page</a> <a
						class="d-block small" href="forgot-password.html">Forgot
						Password?</a>
				</div>
			</div>
		</div>
	</div>