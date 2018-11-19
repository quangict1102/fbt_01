<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras"
	prefix="tilesx"%>

<div id="wrapper">
	<!-- DataTables Example -->
	<div class="card mb-3">
		<div class="card-header">
			<i class="fas fa-table"></i> Data Table User
		</div>
		<div class="card-body">
			<div class="table-responsive">
				<table class="table table-bordered" id="dataTable" width="100%"
					cellspacing="0">
					<thead>
						<tr>
							<th>#</th>
							<th>Full Name</th>
							<th>Gender</th>
							<th>Address</th>
							<th>Email</th>
							<th>Phone Number</th>
							<th>Role</th>
							<th>Action</th>
						</tr>
					</thead>
					<tfoot>
						<tr>
							<th>#</th>
							<th>Full Name</th>
							<th>Gender</th>
							<th>Address</th>
							<th>Email</th>
							<th>Phone Number</th>
							<th>Role</th>
							<th>Action</th>
						</tr>
					</tfoot>

					<tbody>
						<c:forEach items="${users}" var="user" varStatus="count">
							<tr>
								<th scope="row">${count.index + 1}</th>
								<td>${user.fullName}</td>
								<td><c:if test="${user.gender == 1}">
										     Fmale
										 </c:if> <c:if test="${user.gender == 0}">
										     Male
										 </c:if> <c:if test="${user.gender != 0 && user.gender != 1}">
										 	N/A
										 </c:if></td>
								<td>${user.address}</td>
								<td>${user.email}</td>
								<td>${user.phoneNumber}</td>
								<td>${user.role}</td>
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
<footer class="sticky-footer">
	<div class="container my-auto">
		<div class="copyright text-center my-auto">
			<span>Copyright © Your Website 2018</span>
		</div>
	</div>
</footer>



