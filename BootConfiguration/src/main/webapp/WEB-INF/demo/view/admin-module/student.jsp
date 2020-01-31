<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Bootstrap Dashboard by Bootstrapious.com</title>
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
				<h1 class="h3 display">STUDENT MASTER</h1>
			</header>
			<div class="row">
				<div class="col-lg-4">
					<div class="card border border-secondary">
						<div class="card-header d-flex align-items-center">
							<h4>Save Student</h4>
						</div>
						<div class="card-body">
							<form:form
								action="${pageContext.request.contextPath }/admin/student/save"
								modelAttribute="student" name="student" id="student"
								method="post">

								<form:hidden path="studentId" />

								<div class="row form-group">
									<div class="col-md-12 col-sm-12 col-lg-12 col-12">
										<form:label path="studentName"> Student Name </form:label>
										<form:input path="studentName" name="studentName"
											id="studentName" class="form-control"
											placeholder="Enter Student Name" required="required" />
										<form:errors path="studentName"></form:errors>
									</div>
									<div class="col-md-12 col-sm-12 col-lg-12 col-12">
										<form:label path="category"> Category </form:label>
										<form:select class="form-control" name="category" 
											path="category" id="category"
											itemLabel="categoryName" items="${ categoryList }"
											itemValue="categoryId">
										</form:select>
										<form:errors path="category" class="errors" />
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
					<div class="card border border-secondary">
						<div class="card-header">
							<h4>Student List</h4>
						</div>
						<div class="card-body">
							<div class="table-responsive table-striped">
								<table class="table">
									<thead>
										<tr>
											<th>Sr No</th>
											<th>Student Name</th>
											<th>Category Name</th>
											<th>Exam Marks</th>
											<th>Action</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="stud" items="${ studentList }" varStatus="ind">
											<tr>
											<td>${ ind.index+1 }</td>
											<td>${ stud.studentName }</td>
											<td>${ stud.category.categoryName }</td>
											<td>${ stud.exam.marks }</td>
											<td class="valigntop">
												<a data-toggle="tooltip" title="Edit" href="<c:url value='/admin/student/edit/${ stud.studentId }' />">
													<i style="width: 27px; height: 27px;" class="text-center text-white p-2 rounded-circle bg-success fa fa-edit"></i>
												</a>
												<a data-toggle="tooltip" title="Exam" href="<c:url value='/admin/exam/${ stud.studentId }' />">
													<i style="width: 27px; height: 27px;" class="text-center text-white p-2 rounded-circle bg-success fa fa-file-text"></i>
												</a>
												<a data-toggle="tooltip" title="Delete" href="<c:url value='/admin/student/delete/${ stud.studentId }' />">
													<i style="width: 27px; height: 27px;" class="text-center text-white p-2 rounded-circle bg-success fa fa-trash"></i>
												</a>
											</td>
											<tr>
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