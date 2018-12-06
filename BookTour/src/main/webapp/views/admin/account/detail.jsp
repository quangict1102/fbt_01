<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<spring:url value="/password" var="changePassordUrl" />
<div class="modal-body">
	<table class="table table-user-information">
		<tbody>
			<tr>
				<td>Full Name</td>
				<td>${AccDetail.fullName}</td>
			</tr>
			<tr>
				<td>Gender</td>
				<td>${AccDetail.gender}</td>
			</tr>
			<tr>
				<td>Address</td>
				<td>${AccDetail.address}</td>
			</tr>
			<tr>
				<td>Email</td>
				<td>${AccDetail.email}</td>
			</tr>
			<tr>
				<td>Phone Number</td>
				<td>${AccDetail.phoneNumber}</td>
			</tr>
			<tr>
				<td>Password</td>
				<td>${AccDetail.password}</td>
			</tr>
			<tr>
				<td>Role</td>
				<td>${AccDetail.role}</td>
			</tr>

		</tbody>
	</table>

<div class="container ">

	<div id="idUser" hidden>${userDetail.id}</div>
	<button class="btn btn-danger col-md-2 " data-toggle="modal" data-target="#changePassword">Change Password</button>
</div>

<div class="container">
	<div class="modal fade" id="changePassword" role="dialog">
		<div class="modal-dialog modal-sm">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title">Repeat Password</h4>
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>
				<div class="modal-body">
					<table class="table table-user-information">
						<form:form class="form-horizontal"
							action="${changePassordUrl}" method="post">
							<div class=" form-group">
								<div class="form-label-group">
									<input name="password" type="password" id="password" class="form-control"
										placeholder="password" required="required" autofocus="autofocus" />
									<label for="password">password</label>
								</div>
							</div>

							<div class=" form-group">
								<div class="form-label-group">
									<input name="newPassword" type="password" id="newPassword" class="form-control"
										placeholder="newPassword" required="required" autofocus="autofocus" />
									<label for="newPassword">New Password</label>
								</div>
							</div>
							<div class=" form-group">
								<div class="form-label-group">
									<input name="passwordRepeat" type="password" id="passwordRepeat" class="form-control"
										placeholder="passwordRepeat" required="required" autofocus="autofocus" />
									<label for="passwordRepeat">Repeat Password</label>
								</div>
							</div>
							
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

