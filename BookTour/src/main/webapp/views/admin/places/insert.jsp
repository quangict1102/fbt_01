<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras"
	prefix="tilesx"%>

<form:form  class="file-uploader" modelAttribute="addPlace"
	action="${addPlaceUrl}">
	<div class=" form-group">
		<div class="form-label-group">
			<input name="name" type="text" id="name" class="form-control"
				placeholder="Name" required="required" autofocus="autofocus" /> <label
				for="name">Name</label>
		</div>
	</div>

	<div class="form-group ">
		<div class="form-label-group">
			<select name="idCity">
				<option value="-" label="--Select City " />
				<c:forEach items="${cityInfos}" var="cityInfo" varStatus="count">
					<option value=${cityInfo.id }>${cityInfo.name}</option>
				</c:forEach>
			</select>
		</div>
	</div>

<div class="file-uploader__message-area">
			<p>Select a file to upload</p>
		</div>
		<div class="file-chooser">
			<input class="file-chooser__input" name="file" type="file" multiple>
		</div>
		<input class="file-uploader__submit-button" type="submit"
			value="Upload">

	<button type="submit" class="btn btn-primary btn-block ">submit</button>
</form:form>

