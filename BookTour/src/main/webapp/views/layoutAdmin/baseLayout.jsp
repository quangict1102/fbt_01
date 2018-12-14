<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras"
	prefix="tilesx"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="">
<meta name="author" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<spring:url value="/assets/vendor/bootstrap/css/bootstrap.min.css" var="bootstrapCss" />
<spring:url value="/assets/vendor/fontawesome-free/css/all.min.css" var="allCss" />
<spring:url value="/assets/vendor/datatables/dataTables.bootstrap4.css" var="bootstrap4Css" />
<spring:url value="/assets/css/sb-admin.css" var="sbAdminCss" />

<link rel="stylesheet" href="${bootstrapCss}" />
<link rel="stylesheet" href="${allCss}" />
<link rel="stylesheet" href="${bootstrap4Css}" />
<link rel="stylesheet" href="${sbAdminCss}" />

<spring:url value="/assets/vendor/jquery/jquery.min.js" var="jqueryJs" />
<script src="${jqueryJs}" type="text/javascript"></script>

<!-- aler -->
<spring:url value="/assets/alertify/themes/alertify.core.css" var="coreCss" />
<spring:url value="/assets/alertify/themes/alertify.bootstrap.css" var="bootstrapCss" />
<spring:url value="/assets/alertify/themes/alertify.default.css" var="defaultCss" />
<link rel="stylesheet" href="${coreCss}" />
<link rel="stylesheet" href="${defaultCss}" />
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<spring:url value="/assets/alertify/js/alertify.min.js" var="alertifyJs" />
<script src="${alertifyJs}" type="text/javascript"></script>

<!-- uploadFile -->
<spring:url value="/assets/multiple-file-uploader/css/normalize.min.css" var="normalizeCss" />
<spring:url value="/assets/multiple-file-uploader/css/style.css" var="styleCss" />
<spring:url value="/assets/multiple-file-uploader/js/index.js" var="indexJs" />

<link href="${normalizeCss }" type="text/css" rel="stylesheet">
<link href="${styleCss }" type="text/css" rel="stylesheet">

<title><tiles:insertAttribute name="title" ignore="true" /></title>
</head>
<body>

	<tiles:insertAttribute name="header" />
	<div id="wrapper">
		<tiles:insertAttribute name="menu" />
		<tiles:insertAttribute name="body" />
	</div>

	<spring:url value="/assets/vendor/bootstrap/js/bootstrap.bundle.min.js" var="bootstrapBundleJs" />
	<spring:url value="/assets/vendor/jquery-easing/jquery.easing.min.js" var="bootstrapEasingJs" />
	<spring:url value="/assets/vendor/chart.js/Chart.min.js" var="chartJs" />
	<spring:url value="/assets/vendor/datatables/jquery.dataTables.js" var="dataTablesJs" />
	<spring:url value="/assets/vendor/datatables/dataTables.bootstrap4.js" var="bootstrap4Js" />
	<spring:url value="/assets/js/adminJs/sb-admin.min.js" var="adminJs" />
	<spring:url value="/assets/js/adminJs/datatables-demo.js" var="dataTableDemoJs" />
	<spring:url value="/assets/js/adminJs/chart-area-demo.js" var="chartDemoJs" />

	<script src="${bootstrapBundleJs}" type="text/javascript"></script>
	<script src="${bootstrapEasingJs}" type="text/javascript"></script>
	<script src="${chartJs}" type="text/javascript"></script>
	<script src="${dataTablesJs}" type="text/javascript"></script>
	<script src="${bootstrap4Js}" type="text/javascript"></script>
	<script src="${adminJs}" type="text/javascript"></script>
	<script src="${dataTableDemoJs}" type="text/javascript"></script>
	

	<spring:url value="/assets/js/adminJs/ajaxAdmin.js" var="ajaxAdmin" />
	<script src="${ajaxAdmin}" type="text/javascript"></script>

  	<spring:url value="/assets/CKEditor/callCHEdittor.js" var="callCHEditorJs" />  
 	<script src="${callCHEditorJs}" type="text/javascript"></script>    
 	
 	<script src="${indexJs}" type="text/javascript"></script>
 	<script src="${chartDemoJs}" type="text/javascript"></script>


</body>
</html>
