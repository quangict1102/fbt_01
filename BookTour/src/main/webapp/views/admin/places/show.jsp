<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras"
	prefix="tilesx"%>
<spring:url value="places/add" var="addPlaceUrl" />
<div id="wrapper">
	<!-- DataTables Example -->
	<div class="card mb-3">
		<div class="card-header">
			<i class="fas fa-table"></i> Data Table Place
			<div class="col-md-12 text-right">
				<button type="button" data-toggle="modal" data-target="#addPlace"
					class="btn btn-primary custom-button-width .navbar-right">Add
					Place</button>
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
							<th>Name City</th>
							<th>Action</th>
							<th></th>
						</tr>
					</thead>
					<tfoot>
						<tr>
							<th>#</th>
							<th>Name</th>
							<th>Name City</th>
							<th>Action</th>
							<th></th>
						</tr>
					</tfoot>

					<tbody>
						<c:forEach items="${places}" var="place" varStatus="count">
							<tr>
								<th scope="row">${count.index + 1}</th>
								<td>${place.name}</td>
								<td>${place.cityInfo.name }</td>
								<td><spring:url value="places/${place.id}"
										var="detailActionUrl" />
									<button class="btn btn-info" data-toggle="modal"
										data-target="#myModal">Detail</button> <spring:url
										value="places/${place.id}/edit" var="editActionUrl" />
									<button class="btn btn-warning"
										onclick="location.href='${editActionUrl}'">Edit</button>
									<button class="btn btn-danger btnPlaceDelete">Delete</button></td>
								<td class="idPlace" hidden>${place.id}</td>
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
	<div class="modal fade" id="addPlace" role="dialog">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title">Add Tour</h4>
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>
				<div class="modal-body">

					<form class="file-uploader" modelAttribute="addPlace" enctype="multipart/form-data"
						action="${addPlaceUrl}" method="post">
						<div class=" form-group">
							<div class="form-label-group">
								<input name="name" type="text" id="name" class="form-control"
									placeholder="Name" required="required" autofocus="autofocus" />
								<label for="name">Name</label>
							</div>
						</div>

						<div class="form-group ">
							<div class="form-label-group">
								<select name="idCity">
									<option value="-" label="--Select City " />
									<c:forEach items="${cityInfos}" var="cityInfo"
										varStatus="count">
										<option value=${cityInfo.id }>${cityInfo.name}</option>
									</c:forEach>
								</select>
							</div>
						</div>

						<div class=" form-group">
							<div class="form-label-group">
								<div class="file-uploader__message-area">
									<p>Select a file to upload</p>
								</div>
								<div class="file-chooser">
									<input class="file-chooser__input" name="files" type="file"
										>
								</div>
							</div>
						</div>

						<button type="submit" class="btn btn-primary btn-block file-uploader__submit-button">submit</button>
					</form>

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

