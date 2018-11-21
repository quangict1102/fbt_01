<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">

<head>
<title>Spring Boot ajax example</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<spring:url value="/assets/vendor/bootstrap/css/bootstrap.min.css" var="bootstrapCss" />
		<link rel="stylesheet" href="${bootstrapCss}" />

</head>
<body>

	<nav class="navbar navbar-inverse">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">Mkyong.com</a>
			</div>
		</div>
	</nav>

	<div class="container" style="min-height: 500px">

		<div class="starter-template">
			<h1>Spring Boot AJAX Example</h1>

			<div id="feedback"></div>

			<form class="form-horizontal" id="search-form">
				<div class="form-group form-group-lg">
					<label class="col-sm-2 control-label">Username</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="username" />
					</div>
				</div>

				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button type="submit" id="bth-search"
							class="btn btn-primary btn-lg">Search</button>
					</div>
				</div>
			</form>

		</div>

	</div>

	<div class="container">
		<footer>
			<p>
				© <a href="http://www.mkyong.com">Mkyong.com</a> 2017
			</p>
		</footer>
	</div>
	<spring:url value="/assets/js/adminJs/ajaxAdmin.js" var="ajaxAdmin" />
	<spring:url value="/assets/vendor/jquery/jquery.min.js" var="jqueryJs" />
		<script src="${jqueryJs}" type="text/javascript"></script>
	<script src="${ajaxAdmin}" type="text/javascript"></script>


</body>
</html>
