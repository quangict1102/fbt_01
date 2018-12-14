
<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras"
	prefix="tilesx"%>
<spring:url value="/booktours/searchEmail" var="searchBookTourByEmailurl" />
<spring:url value="/booktours/searchTourName" var="searchBookTourByTourNameurl" />
<div id="wrapper">
	<!-- DataTables Example -->
	<div class="card mb-3">
		<div class="card-header">
			<i class="fas fa-table"></i> Data Table Tour
		</div>

		<div class="card-body">
			<div class="table-responsive">
				<table class="table table-bordered" id="dataTable" width="100%"
					cellspacing="0">
					<thead>
						<tr>
							<th>#</th>
							<th>Name Tour</th>
							<th>mail User</th>
							<th>Name User</th>
							<th>Prime Tour</th>
							<th>adults</th>
							<th>children</th>
							<th>status</th>
							<th>notel</th>
							<th>Action</th>
							<th></th>
						</tr>
					</thead>
					<tfoot>
						<tr>
							<th>#</th>
							<th>Name Tour</th>
							<th>mail User</th>
							<th>Name User</th>
							<th>Prime Tour</th>
							<th>adults</th>
							<th>children</th>
							<th>status</th>
							<th>notel</th>
							<th>Action</th>
							<th></th>
						</tr>
					</tfoot>

					<tbody>
						<c:forEach items="${bookTours}" var="bookTour" varStatus="count">
							<tr>
								<th scope="row">${count.index + 1}</th>
								<td>${bookTour.tour.name}</td>
								<td>${bookTour.user.email}</td>
								<td>${bookTour.user.fullName}</td>
								<td>${bookTour.primeTour}</td>
								<td>${bookTour.adults}</td>
								<td>${bookTour.children}</td>
								<td>${bookTour.status}</td>
								<td>${bookTour.notel}</td>
								<td>
									<button class="btn btn-danger btnBookTourDelete">Delete</button>
								</td>
								<td class="idBookTour" hidden>${bookTour.id}</td>
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
	<div class="modal fade" id="myModal" role="dialog">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title">Modal Header</h4>
					<button type="button" class="close" data-dismiss="modal">&times;</button>
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

