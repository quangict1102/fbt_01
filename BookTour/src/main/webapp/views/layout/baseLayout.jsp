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
<!-- fonts -->
<link
	href='https://fonts.googleapis.com/css?family=Roboto:400,100,100italic,300,300italic,400italic,500,700,500italic,700italic,900,900italic'
	rel='stylesheet' type='text/css'>
<link
	href='https://fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600,600italic,700,700italic,800,800italic'
	rel='stylesheet' type='text/css'>
<!-- //fonts -->
<script type="text/javascript">
	$(document).ready(function() {
		$('#horizontalTab').easyResponsiveTabs({
			type : 'default', //Types: default, vertical, accordion           
			width : 'auto', //auto or any width like 600px
			fit : true
		// 100% fit in a container
		});
	});
</script>
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
	<script type="text/javascript">
		$(function() {
			SyntaxHighlighter.all();
		});
		$(window).load(function() {
			$('.flexslider').flexslider({
				animation : "slide",
				start : function(slider) {
					$('body').removeClass('loading');
				}
			});
		});
	</script>
</body>
</html>
