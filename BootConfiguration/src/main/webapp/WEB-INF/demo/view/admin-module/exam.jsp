<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="robots" content="all,follow">
<!-- Bootstrap CSS-->
<link rel="stylesheet" href="vendor/bootstrap/css/bootstrap.min.css">
<!-- Font Awesome CSS-->
<link rel="stylesheet"
	href="vendor/font-awesome/css/font-awesome.min.css">
<!-- Fontastic Custom icon font-->
<link rel="stylesheet" href="css/fontastic.css">
<!-- Google fonts - Roboto -->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700">
<!-- jQuery Circle-->
<link rel="stylesheet"
	href="css/grasp_mobile_progress_circle-1.0.0.min.css">
<!-- Custom Scrollbar-->
<link rel="stylesheet"
	href="vendor/malihu-custom-scrollbar-plugin/jquery.mCustomScrollbar.css">
<!-- theme stylesheet-->
<link rel="stylesheet" href="css/style.default.css"
	id="theme-stylesheet">
<!-- Custom stylesheet - for your changes-->
<link rel="stylesheet" href="css/custom.css">
<!-- Favicon-->
<link rel="shortcut icon" href="img/favicon.ico">
</head>
<body>

	<section class="forms">
		<div class="container-fluid">
			<!-- Page Header-->
			<header>
				<h1 class="h3 display">Exam Master</h1>
			</header>
			<div class="row">
				<div class="col-lg-4">
					<div class="card">
						<div class="card-header d-flex align-items-center">
							<h4>Save Exam</h4>
						</div>
						<div class="card-body">
							<form:form
								action="${pageContext.request.contextPath }/admin/exam/save"
								modelAttribute="exam" name="exam" id="exam" method="post">

								<form:hidden path="examId" />

								<div class="row form-group">
									<div class="col-md-12 col-sm-12 col-lg-12 col-12">
										<form:label path="student">Student ID</form:label>
										<form:input path="student" name="student" id="student"
											class="form-control" value="${studentId}"
											required="required" />
										<form:errors path="student"></form:errors>
									</div>
								</div>

								<div class="row form-group">
									<div class="col-md-12 col-sm-12 col-lg-12 col-12">
										<form:label path="marks"> Marks </form:label>
										<form:input path="marks" name="marks" id="marks"
											class="form-control" placeholder="Enter Marks"
											required="required" value="${ exam.marks }" />
										<form:errors path="marks"></form:errors>
									</div>
								</div>

								<div class="row form-group">
									<div class="col-md-12 text-right">
										<c:if test="${ edit==false }">
											<button class="btn btn-danger" type="reset">RESET</button>
										</c:if>
										<button type="submit" class="btn btn-success">SAVE</button>
									</div>
								</div>
							</form:form>
						</div>
					</div>
				</div>
				<div class="col-lg-8">
					<div class="card">
						<div class="card-header">
							<h4>Marks List</h4>
						</div>
						<div class="card-body">
							<div class="table-responsive table-striped">
								<table class="table">
									<thead>
										<tr>
											<th>Sr No</th>
											<th>Student Name</th>
											<th>Marks Name</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="cas" items="${ marksList }" varStatus="ind">
											<tr>
												<td>${ ind.index+1 }</td>
												<td>${ cas.student.studentName }</td>
												<td>${ cas.marks }</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>

	<!-- JavaScript files-->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="vendor/popper.js/umd/popper.min.js">
		
	</script>
	<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
	<script src="js/grasp_mobile_progress_circle-1.0.0.min.js"></script>
	<script src="vendor/jquery.cookie/jquery.cookie.js">
		
	</script>
	<script src="vendor/chart.js/Chart.min.js"></script>
	<script src="vendor/jquery-validation/jquery.validate.min.js"></script>
	<script
		src="vendor/malihu-custom-scrollbar-plugin/jquery.mCustomScrollbar.concat.min.js"></script>
	<!-- Main File-->
	<script src="js/front.js"></script>
</body>
</html>