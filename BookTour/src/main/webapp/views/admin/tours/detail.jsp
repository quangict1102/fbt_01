<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="modal-body">
	<table class="table table-user-information">
		<tbody>
			<tr>
				<td>Name</td>
				<td>${tourDetail.name}</td>
			</tr>
			<tr>
				<td>maxPeople</td>
				<td>${tourDetail.maxPeople}</td>
			</tr>
			<tr>
				<td>Describe</td>
				<td>${tourDetail.describe}</td>
			</tr>
			<tr>
				<td>Prime Adults</td>
				<td>${tourDetail.primeAdults}</td>
			</tr>
			<tr>
				<td>Prime Childen</td>
				<td>${tourDetail.primeChilden}</td>
			</tr>
			<tr>
				<td>Place From</td>
				<td>${planceFrom.name}</td>
				<td>${planceFrom.city.name}</td>
			</tr>
			<tr>
				<td>Place To</td>
				<td>${planceTo.name}</td>
				<td>${planceTo.city.name}</td>
			</tr>

			<tr>
				<td>Duration Time</td>
				<td>${tourDetail.durationTime}</td>
			</tr>

			<tr>
				<td>Date Start</td>
				<td>${tourDetail.dateStart}</td>
			</tr>
		</tbody>
	</table>
</div>


<div class="container ">
	<spring:url value="/tours/${tourDetail.id}/edit" var="editActionUrl" />
	<button class="btn btn-info col-md-2"
		onclick="location.href='${editActionUrl}'">Edit</button>
	<div id="idTour" hidden>${tourDetail.id}</div>
	<button class="btn btn-danger col-md-2  "
		id="btnDeleteTourDetail">Delete</button>
</div>




