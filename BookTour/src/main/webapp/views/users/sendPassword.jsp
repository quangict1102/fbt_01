<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
<div class="banner-bottom">
	<!-- container -->
	<div class="container">
		<div class="faqs-top-grids">
			<div class="book-grids">
				<div class="col-md-8 book-left">
					<form action="<c:url value="/sendPassword/send"/> " method="post">
						<input type="text" placeholder="Email" name="email"> <input
							type="submit" value="Send">
					</form>
				</div>
			</div>
		</div>
	</div>
</div>
<div hidden  id="messageSendEmail">${sendLog}</div>
<script src="${alertifyJs}" type="text/javascript"></script>
<script src="${alertifyLogJs}" type="text/javascript"></script>