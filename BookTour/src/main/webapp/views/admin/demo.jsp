<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras"
	prefix="tilesx"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>alertify.js - example page</title>

<spring:url value="/assets/alertify/themes/alertify.core.css"var="coreCss" />
<spring:url value="/assets/alertify/themes/alertify.bootstrap.css"var="bootstrapCss" />
<spring:url value="/assets/alertify/themes/alertify.default.css"var="defaultCss" />
<link rel="stylesheet" href="${coreCss}" />
<link rel="stylesheet" href="${defaultCss}" />
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<spring:url value="/assets/alertify/js/alertify.min.js" var="alertifyJs" />
<script src="${alertifyJs}" type="text/javascript"></script>



</head>
<body>


	<h2>Dialogs</h2>
	<a href="#" id="alert">Alert Dialog</a>
	<br>
	<a href="#" id="confirm">Confirm Dialog</a>
	<br>
	<a href="#" id="prompt">Prompt Dialog</a>
	<br>
	<a href="#" id="labels">Custom Labels</a>
	<br>
	<a href="#" id="focus">Button Focus</a>
	<br>
	<a href="#" id="order">Button Order</a>

	<h2>Ajax</h2>
	<a href="#" id="ajax">Ajax - Multiple Dialog</a>

	<h2>Logs</h2>
	<a href="#" id="notification">Standard Log</a>
	<br>
	<a href="#" id="success">Success Log</a>
	<br>
	<a href="#" id="error">Error Log</a>
	<br>
	<a href="#" id="custom">Custom Log</a>
	<br>
	<a href="#" id="delay">Hide in 10 seconds</a>
	<br>
	<a href="#" id="forever">Persistent Log</a>
	<script>
		alertify.alert("This is an alert dialog");
	</script>
	<h2>Themes</h2>
	<a href="#" id="bootstrap">Bootstrap Theme</a>

	<spring:url value="/assets/alertify/js/alertifyLog.js"
		var="alertifyJsLog" />
	<script src="${alertifyJsLog}" type="text/javascript"></script>

</body>
</html>
