<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.errors {
	color: red;
}
</style>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12 col-sm-12 col-lg-12 col-xl-12 col-12">
				<div class="card">
					<form:form modelAttribute="newUser" method="post">
						<form:hidden path="id" id="id" name="id" />
						<form:hidden path="ssoId" />
						<div class="card-header">
							<h4 class="card-title">Register User</h4>
						</div>
						<div class="card-body">
							<c:if test="${updated != null}">
								<div class="alert alert-success">${updated }</div>
							</c:if>
							<div class="row form-group">
								<div class="col-md-6 col-sm-6 col-lg-6 col-xl-6 col-12">
									<div class="row">
										<div class="col-md-4 col-sm-4 col-lg-4 col-xl-4 col-12">
											<b>First Name</b>
										</div>
										<div class="col-md-8 col-sm-8 col-lg-8 col-xl-8 col-12">
											<form:input path="firstName" name="firstName" id="firstName"
												class="form-control" placeholder="Enter First Name"
												required="true" />
											<form:errors path="firstName" class="errors" />
										</div>
									</div>

								</div>
								<div class="col-md-6 col-sm-6 col-lg-6 col-xl-6 col-12">
									<div class="row">
										<div class="col-md-4 col-sm-4 col-lg-4 col-xl-4 col-12">
											<b>Last Name</b>
										</div>
										<div class="col-md-8 col-sm-8 col-lg-8 col-xl-8 col-12">
											<form:input path="lastName" name="lastName" id="lastName"
												class="form-control" placeholder="Enter Last Name"
												required="true" />
											<form:errors path="lastName" class="errors" />
										</div>
									</div>

								</div>

							</div>



							<div class="row form-group">
								<div class="col-md-6 col-sm-6 col-lg-6 col-xl-6 col-12">
									<div class="row">
										<div class="col-md-4 col-sm-4 col-lg-4 col-xl-4 col-12">
											<b>Username</b>
										</div>
										<div class="col-md-8 col-sm-8 col-lg-8 col-xl-8 col-12">

											<c:if test="${edit == true }">

												<form:input path="ssoId" name="ssoId" id="ssoId"
													class="form-control" placeholder="Enter User Name"
													disabled="true" />
												<form:errors path="ssoId" class="errors" />
											</c:if>

											<c:if test="${edit == false }">
												<form:input path="ssoId" name="ssoId" id="ssoId"
													class="form-control" placeholder="Enter User Name"
													required="true" />
												<form:errors path="ssoId" class="errors" />
											</c:if>


										</div>
									</div>

								</div>
								<div class="col-md-6 col-sm-6 col-lg-6 col-xl-6 col-12">
									<div class="row">
										<div class="col-md-4 col-sm-4 col-lg-4 col-xl-4 col-12">
											<b>Password</b>
										</div>
										<div class="col-md-8 col-sm-8 col-lg-8 col-xl-8 col-12">
											<form:input path="password" name="password" id="password"
												class="form-control" placeholder="Enter Password"
												type="password" required="true" />
											<form:errors path="password" class="errors" />
										</div>
									</div>

								</div>

							</div>

							<div class="row form-group">
								<div class="col-md-6 col-sm-6 col-lg-6 col-xl-6 col-12">
									<div class="row">
										<div class="col-md-4 col-sm-4 col-lg-4 col-xl-4 col-12">
											<b>Email</b>
										</div>
										<div class="col-md-8 col-sm-8 col-lg-8 col-xl-8 col-12">
											<form:input path="email" name="email" id="email"
												class="form-control" placeholder="Enter Email Id"
												type="email"
												pattern="[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}"
												title="Enter Valid Email Id" required="true" />
											<form:errors path="email" class="errors" />
										</div>
									</div>

								</div>
								<div class="col-md-6 col-sm-6 col-lg-6 col-xl-6 col-12">
									<div class="row">
										<div class="col-md-4 col-sm-4 col-lg-4 col-xl-4 col-12">
											<b>Mobile Number</b>
										</div>
										<div class="col-md-8 col-sm-8 col-lg-8 col-xl-8 col-12">
											<form:input path="mobileNumber" name="mobileNumber"
												id="mobileNumber" class="form-control"
												placeholder="Enter Mobile Number" pattern="[0-9]{10,10}"
												title="Enter 10 digit Mobile Number" required="true" />
											<form:errors path="mobileNumber" class="errors" />
										</div>
									</div>

								</div>

							</div>


							<div class="row form-group">
								<div class="col-md-6 col-sm-6 col-lg-6 col-xl-6 col-12">
									<div class="row">
										<div class="col-md-4 col-sm-4 col-lg-4 col-xl-4 col-12">
											<b>Roles</b>
										</div>
										<div class="col-md-8 col-sm-8 col-lg-8 col-xl-8 col-12">
											<form:select path="userProfiles" items="${roles}"
												itemValue="id" itemLabel="type"
												class="form-control input-sm" required="true" />
											<form:errors path="userProfiles" class="errors" />
										</div>
									</div>
								</div>


								<div class="col-md-6 col-sm-6 col-lg-6 col-xl-6 col-12">
									<div class="row">
										<div class="col-md-4 col-sm-4 col-lg-4 col-xl-4 col-12">
											<b>Description</b>
										</div>
										<div class="col-md-8 col-sm-8 col-lg-8 col-xl-8 col-12">
											<form:textarea path="description" name="description"
												id="description" class="form-control"
												placeholder="Enter Description" />
											<form:errors path="description" class="errors" />
										</div>
									</div>

								</div>

							</div>

							<hr />
							<div class="row form-group">
								<input type="submit" name="submit" id="submit" value="REGISTER"
									class="btn btn-primary btn-block" />
							</div>
						</div>
					</form:form>
				</div>
			</div>
		</div>

		<security:authorize access="hasRole('ADMIN') or hasRole('DBA')">
			<div class="row">
				<div class="col-md-12 col-sm-12 col-lg-12 col-xl-12 col-12">
					<div class="card">
						<div class="card-header">
							<h4 class="card-title">All Users</h4>
						</div>
						<div class="card-body">
							<table class="table table-responsive table-striped" id="example1">
								<thead>
									<tr>
										<th scope="row">Id</th>
										<th scope="row">UserName</th>
										<th scope="row">First Name</th>
										<th scope="row">Last Name</th>
										<th scope="row">Email Id</th>
										<th scope="row">Mobile Number</th>
										<th scope="row">Actions</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="users" items="${ userList}">
										<tr>
											<td>${users.id }</td>
											<td>${users.ssoId }</td>
											<td>${users.firstName }</td>
											<td>${users.lastName }</td>
											<td>${users.email }</td>
											<td>${users.mobileNumber }</td>
											<td><a
												href="<c:url value='/admin/user/update/${users.ssoId}' />"><strong><i
														class="fa fa-pencil-square-o"></i></strong></a>&nbsp; <a
												href="<c:url value='/admin/user/delete/${users.ssoId }' />"><strong><i
														class="fa fa-times"></i></strong></a></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
		</security:authorize>

	</div>
</body>
</html>