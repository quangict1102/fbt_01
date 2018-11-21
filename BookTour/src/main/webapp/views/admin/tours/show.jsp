<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras"
	prefix="tilesx"%>

<spring:url value="/addTour" var="addTourUrl" />
<div id="wrapper">
	<!-- DataTables Example -->
	<div class="card mb-3">
		<div class="card-header">
			<i class="fas fa-table"></i> Data Table Tour
			<div class="col-md-12 text-right">
				<div class="col-md-12 text-right">
					<button type="button" data-toggle="modal" data-target="#addTour"
						class="btn btn-primary custom-button-width .navbar-right">Add
						Tour</button>
				</div>
			</div>
		</div>

		<div class="card-body">
			<div class="table-responsive">
				<table class="table table-bordered" id="dataTable" width="100%"
					cellspacing="0">
					<thead>
						<tr>
							<th>#</th>
							<th>Name</th>
							<th>Max People</th>
							<th>Prime Adults</th>
							<th>Prime Childen</th>
							<th>Duration Time</th>
							<th>Date Start</th>
							<th>Action</th>
						</tr>
					</thead>
					<tfoot>
						<tr>
							<th>#</th>
							<th>Name</th>
							<th>Max People</th>
							<th>Prime Adults</th>
							<th>Prime Childen</th>
							<th>Duration Time</th>
							<th>Date Start</th>
							<th>Action</th>
						</tr>
					</tfoot>

					<tbody>
						<c:forEach items="${tours}" var="tour" varStatus="count">
							<tr>
								<th scope="row">${count.index + 1}</th>
								<td>${tour.name}</td>
								<td>${tour.maxPeople}</td>
								<td>${tour.primeAdults}</td>
								<td>${tour.primeChilden}</td>
								<td>${tour.durationTime}</td>
								<td>${tour.dateStart}</td>
								<td><spring:url value="/${tour.id}" var="detailActionUrl" />
									<button class="btn btn-info" data-toggle="modal"
										data-target="#myModal">Detail</button> <spring:url
										value="/${tour.id}/edit" var="editActionUrl" />
									<button class="btn btn-warning"
										onclick="location.href='${editActionUrl}'">Edit</button> <spring:url
										value="/${tour.id}/delete" var="deleteActionUrl" />
									<button class="btn btn-danger"
										onclick="location.href='${deleteActionUrl}'">Delete</button></td>
							</tr>
						</c:forEach>
					</tbody>

				</table>
			</div>
		</div>
		<div class="card-footer small text-muted">Updated yesterday at
			11:59 PM</div>
	</div>
</div>
<div class="container">
	<div class="modal fade" id="addTour" role="dialog">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title">Add Tour</h4>
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>
				<div class="modal-body">
					<table class="table table-user-information">
						<form:form class="form-horizontal" modelAttribute="addTour"
							action="${addTourUrl}">

							<div class=" form-group">
								<div class="form-label-group">
									<input name="name" type="text" id="name" class="form-control"
										placeholder="Name" required="required" autofocus="autofocus" />
									<label for="name">Name</label>
								</div>
							</div>
							<div class="form-group ">
								<div class="form-label-group">
									<input name="maxPeople" type="number" min="1" max="100"
										id="maxPeople" class="form-control" placeholder="maxPeople"
										required="required" autofocus="autofocus" /> <label
										for="maxPeople">Max People</label>
								</div>
							</div>
<!-- 							<div class="form-group "> -->
<!-- 								<div class="form-label-group"> -->
<!-- 									<input name="primeAdults" type="number" value="0.00" -->
<!-- 										id="primeAdults" min="0" step="10" class="form-control" -->
<!-- 										placeholder="primeAdults" required="required" -->
<!-- 										autofocus="autofocus" /> <label for="primeAdults">Prime -->
<!-- 										Adults</label> -->
<!-- 								</div> -->
<!-- 							</div> -->

<!-- 							<div class="form-group "> -->
<!-- 								<div class="form-label-group"> -->
<!-- 									<input name="primeChilden" type="number" value="0.00" -->
<!-- 										id="primeChilden" min="0" step="10" class="form-control" -->
<!-- 										placeholder="primeChilden" required="required" -->
<!-- 										autofocus="autofocus" /> <label for="primeChilden">Prime -->
<!-- 										Childen</label> -->
<!-- 								</div> -->
<!-- 							</div> -->
<!-- 							<div class="form-group "> -->
<!-- 								<div class="form-label-group"> -->
<!-- 									<select name="placeFromId"> -->
<!-- 										<option value="-" label="--Select Place From" /> -->
<%-- 										<c:forEach items="${places}" var="places" varStatus="count"> --%>
<%-- 											<option value=${places.id}>${places.name}</option> --%>
<%-- 										</c:forEach> --%>
<!-- 									</select> -->
<!-- 								</div> -->
<!-- 							</div> -->

<!-- 							<div class="form-group "> -->
<!-- 								<div class="form-label-group"> -->
<!-- 									<select name="placeToId"> -->
<!-- 										<option value="-" label="--Select Place To" /> -->
<%-- 										<c:forEach items="${places}" var="places" varStatus="count"> --%>
<%-- 											<option value=${places.id}>${places.name}</option> --%>
<%-- 										</c:forEach> --%>
<!-- 									</select> -->
<!-- 								</div> -->
<!-- 							</div> -->
<!-- 							<div class="form-group "> -->
<!-- 								<div class="form-label-group"> -->
<!-- 									<input name="durationTime" type="number" value="0" min="1" -->
<!-- 										class="form-control" placeholder="durationTime" -->
<!-- 										required="required" id="durationTime" /> <label -->
<!-- 										for="durationTime">Duration Time</label> -->
<!-- 								</div> -->
<!-- 							</div> -->
<!-- 							<div class="form-group"> -->
<!-- 								<div class="form-label-group"> -->
<!-- 									<input name="dateStartConver" type="date" id="dateStartConver" -->
<!-- 										class="form-control	" placeholder="dateStart" -->
<!-- 										required="required" /> <label for="dateStart">Date -->
<!-- 										Start</label> -->
<!-- 								</div> -->
<!-- 							</div> -->


<!-- 							<div class="form-group"> -->
<!-- 								<div class="form-label-group"> -->
									
<!-- 									<textarea id="describe" name="describe" rows="5" cols="33"> -->
								
<!-- 									</textarea> -->
<!-- 									<label for="describe">Tell us your story:</label> -->
<!-- 								</div> -->
<!-- 							</div> -->



							<button type="submit" class="btn btn-primary btn-block ">submit</button>
						</form:form>
					</table>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>
</div>


<div class="container">
	<div class="modal fade" id="myModal" role="dialog">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title">Modal Header</h4>
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>
				<div class="modal-body">
					<table class="table table-user-information">
						<tbody>

						</tbody>

						<tbody>
							<tr>
								<td>Name</td>
								<td>name</td>
							</tr>
							<tr>
								<td>Email</td>
								<td>email</td>
							</tr>
							<tr>
								<td>Gender</td>
								<td>gender</td>
							</tr>
						</tbody>
					</table>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>
</div>

<footer class="sticky-footer">
	<div class="container my-auto">
		<div class="copyright text-center my-auto">
			<span>Copyright © Your Website 2018</span>
		</div>
	</div>
</footer>



