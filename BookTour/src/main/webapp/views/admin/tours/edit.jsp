<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url value="/editTourDo" var="editTourUrl" />
<div class="modal-body col-md-9">
	<table class="table table-user-information">
		<form:form class="form-horizontal" modelAttribute="editTour"
			action="${editTourUrl}">
			<div class=" form-group">
				<div class="form-label-group">
					<input value=${tourEdit.name } name="name" type="text" id="name"
						class="form-control" placeholder="Name" required="required"
						autofocus="autofocus" /> <label for="name">Name</label>
				</div>
			</div>
			<div class="form-group ">
				<div class="form-label-group">
					<input value=${tourEdit.maxPeople } name="maxPeople" type="number"
						min="1" max="100" id="maxPeople" class="form-control"
						placeholder="maxPeople" required="required" autofocus="autofocus" />
					<label for="maxPeople">Max People</label>
				</div>
			</div>
			<div class="form-group ">
				<div class="form-label-group">
					<input value=${tourEdit.primeAdults } name="primeAdults"
						type="number" value="0.00" id="primeAdults" min="0" step="10"
						class="form-control" placeholder="primeAdults" required="required"
						autofocus="autofocus" /> <label for="primeAdults">Prime
						Adults</label>
				</div>
			</div>

			<div class="form-group ">
				<div class="form-label-group">
					<input value=${tourEdit.primeChilden } name="primeChilden"
						type="number" value="0.00" id="primeChilden" min="0" step="10"
						class="form-control" placeholder="primeChilden"
						required="required" autofocus="autofocus" /> <label
						for="primeChilden">Prime Childen</label>
				</div>
			</div>
			<div class="form-group ">
				<div class="form-label-group">
					<select name="placeFromId">
						<option value="${places[tourEdit.placeFromId].name}" selected="selected">${places[tourEdit.placeFromId-1].name}</option>
						<c:forEach items="${places}" var="places" varStatus="count">
							<option value=${places.id }>${places.name}</option>
						</c:forEach>
					</select>
				</div>
			</div>

			<div class="form-group ">
				<div class="form-label-group">
					<select class="selectpicker" data-style="btn-primary"
						name="placeToId">
						<option value="${places[tourEdit.placeToId].id}" selected="selected">${places[tourEdit.placeToId-1].name}</option>
						<c:forEach items="${places}" var="places" varStatus="count">
							<option value=${places.id }>${places.name}</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="form-group ">
				<div class="form-label-group">
					<input value=${tourEdit.durationTime } name="durationTime"
						type="number" value="0" min="1" class="form-control"
						placeholder="durationTime" required="required" id="durationTime" />
					<label for="durationTime">Duration Time</label>
				</div>
			</div>
			<div class="form-group">
				<div class="form-label-group">
					<input value=${tourEdit.dateStart } name="dateStartConver"
						type="date" id="dateStartConver" class="form-control	"
						placeholder="dateStart" required="required" /> <label
						for="dateStart">Date Start</label>
				</div>
			</div>

			<div class="form-group">
				Describe
				<div class="form-label-group">
					<textarea id="describe" name="describe" rows="5" cols="33">
					${tourEdit.describe }
					</textarea>
				</div>
			</div>
			<button type="submit" class="btn btn-primary btn-block ">submit</button>
		</form:form>
	</table>
</div>

