<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras"
	prefix="tilesx"%>
<!DOCTYPE html>
<html lang="en">
<head>


<title><tiles:insertAttribute name="title" ignore="true" /></title>

<title>Govihar a Travel Agency Category Flat bootstrap
	Responsive website Template | Weekend :: w3layouts</title>
<!-- Custom Theme files -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="Govihar Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
	Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript">
	
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 

</script>
<!-- css  -->
<spring:url value="/assets/css/bootstrap.css" var="bootstrapCss" />
<spring:url value="/assets/css/style.css" var="styleCss" />
<spring:url value="/assets/css/flexslider.css" var="flexsliderCss" />
<spring:url value="/assets/css/JFFormStyle-1.css" var="JFFormStyleCss" />
<!-- js  -->
<spring:url value="/assets/js/modernizr.custom.js" var="modernizrJs" />
<spring:url value="/assets/js/menu_jquery.js" var="menu_jqueryJs" />
<spring:url value="/assets/js/jquery.min.js" var="jquery" />
<!-- js  -->
<spring:url value="/assets/js/jquery.flexslider.js" var="flexsliderJs" />
<spring:url value="/assets/js/easyResponsiveTabs.js"
	var="easyResponsiveTabsJs" />
<spring:url value="/assets/js/jquery-ui.js" var="jqueryUiJs" />
<spring:url value="/assets/js/script.js" var="scriptJs" />
<spring:url value="/assets/js/load-img.js" var="load_img" />
<spring:url value="/assets/js/horizontalTab.js" var="horizontalTab" />
<spring:url value="/assets/js/isotope.pkgd.min.js" var="isotope_pkgd" />
<spring:url value="/assets/js/imagesloaded.pkgd.min.js" var="imagesloaded_pkgd" />
<spring:url value="/assets/js/isotope-min.js" var="isotope_min" />

<spring:url value="/assets/js/datepickerjs.js" var="datepickerjs" />
<spring:url value="/assets/js/cyclejs.js" var="cyclejs" />
<spring:url value="/assets/js/tooltipjs.js" var="tooltipjs" />
<spring:url value="/assets/js/jquery-client-ajax.js" var="jquery_client_ajax" />
<!-- //Custom Theme files -->
<link href="${bootstrapCss }" type="text/css" rel="stylesheet"
	media="all">
<link href="${styleCss }" type="text/css" rel="stylesheet" media="all">
<link rel="stylesheet" href="${flexsliderCss }" type="text/css"
	media="screen" />
<link type="text/css" rel="stylesheet" href="${JFFormStyleCss }" />
<!-- js -->
<script src="${jquery }"></script>
<script src="${modernizrJs }"></script>
<!-- //js -->

<!-- aler -->
<spring:url value="/assets/alertify/themes/alertify.core.css"
	var="coreCss" />
<spring:url value="/assets/alertify/themes/alertify.bootstrap.css"
	var="bootstrapCss" />
<spring:url value="/assets/alertify/themes/alertify.default.css"
	var="defaultCss" />
<link rel="stylesheet" href="${coreCss}" />
<link rel="stylesheet" href="${defaultCss}" />
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<spring:url value="/assets/alertify/js/alertify.min.js" var="alertifyJs" />
<spring:url value="/assets/alertify/js/alertifyLog.js" var="alertifyLogJs" />

<!-- aler -->

<!-- fonts -->
<link
	href='https://fonts.googleapis.com/css?family=Roboto:400,100,100italic,300,300italic,400italic,500,700,500italic,700italic,900,900italic'
	rel='stylesheet' type='text/css'>
<link
	href='https://fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600,600italic,700,700italic,800,800italic'
	rel='stylesheet' type='text/css'>
<!-- //fonts -->
<script type="text/javascript" src="${horizontalTab }"></script>
<!--pop-up-->
<script src="${menu_jqueryJs }"></script>
<!--//pop-up-->
</head>
<body>
	<div class="header">
		<tiles:insertAttribute name="header" />
	</div>

	<tiles:insertAttribute name="body" />

	<div class="footer-bottom-grids">
		<tiles:insertAttribute name="footer" />
	</div>

	<script defer src="${flexsliderJs }"></script>
	<script src="${easyResponsiveTabsJs }" type="text/javascript"></script>
	<script src="${jqueryUiJs }"></script>
	<script type="text/javascript" src="${scriptJs }"></script>
	<script src="${jquery_client_ajax }"></script>
		<script type="text/javascript" src="${load_img }"></script>
		<script type="text/javascript" src="${isotope_pkgd }"></script>
		<script type="text/javascript" src="${imagesloaded_pkgd }"></script>
		<script type="text/javascript" src="${isotope_min }"></script>
</body>
</html>
