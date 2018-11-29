<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="modal-body">
	<table class="table table-user-information">
		<tbody>
			<tr>
				<td>Full Name</td>
				<td>${userDetail.fullName}</td>
			</tr>
			<tr>
				<td>Gender</td>
				<td>${userDetail.gender}</td>
			</tr>
			<tr>
				<td>Address</td>
				<td>${userDetail.address}</td>
			</tr>
			<tr>
				<td>Email</td>
				<td>${userDetail.email}</td>
			</tr>
			<tr>
				<td>Phone Number</td>
				<td>${userDetail.phoneNumber}</td>
			</tr>
			<tr>
				<td>Password</td>
				<td>${userDetail.password}</td>
			</tr>
			<tr>
				<td>Role</td>
				<td>${userDetail.role}</td>
			</tr>

		</tbody>
	</table>

<div class="container ">

	<div id="idUser" hidden>${userDetail.id}</div>
	<button class="btn btn-danger col-md-2  "
		id="btnDeleteUserDetail">Delete</button>
</div>


