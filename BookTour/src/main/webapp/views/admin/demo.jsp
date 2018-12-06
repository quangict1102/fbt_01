<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras"
	prefix="tilesx"%>

<spring:url value="/assets/multiple-file-uploader/css/normalize.min.css"
	var="normalizeCss" />
<spring:url value="/assets/multiple-file-uploader/css/style.css" var="styleCss" />

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<title>Multiple File Uploader</title>
<link href="${normalizeCss }" type="text/css" rel="stylesheet">
<link href="${styleCss }" type="text/css" rel="stylesheet">


</head>

<body>

	<form method="post" class="file-uploader" action="/BookTour1/admin/demo/demo"
		enctype="multipart/form-data">
		<div class="file-uploader__message-area">
			<p>Select a file to upload</p>
		</div>
		<div class="file-chooser">
			<input class="file-chooser__input" name="file" type="file" multiple>
		</div>
		<input class="file-uploader__submit-button" type="submit"
			value="Upload">
	</form>
	<spring:url value="/assets/vendor/jquery/jquery.min.js" var="jqueryJs" />
	
	<spring:url value="/assets/multiple-file-uploader/js/index.js"
		var="indexJs" />
		
		<script src="${jqueryJs}" type="text/javascript"></script>
	<script src="${indexJs}" type="text/javascript"></script>


</body>

</html>
