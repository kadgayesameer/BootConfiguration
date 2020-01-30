<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<!-- Required meta tags-->
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="au theme template">
<meta name="author" content="Hau Nguyen">
<meta name="keywords" content="au theme template">

<!-- Title Page-->
<title><tiles:insertAttribute name="title" /></title>

<!-- Fontfaces CSS-->
<link href="${pageContext.request.contextPath}/static/css/font-face.css"
	rel="stylesheet" type="text/css" media="all">
<link
	href="${pageContext.request.contextPath}/static/vendor/font-awesome-4.7/css/font-awesome.min.css"
	type="text/css" rel="stylesheet" media="all">
<link
	href="${pageContext.request.contextPath}/static/vendor/font-awesome-5/css/fontawesome-all.min.css"
	type="text/css" rel="stylesheet" media="all">
<link
	href="${pageContext.request.contextPath}/static/vendor/mdi-font/css/material-design-iconic-font.min.css"
	type="text/css" rel="stylesheet" media="all">

<!-- Bootstrap CSS-->
<link
	href="${pageContext.request.contextPath}/static/vendor/bootstrap-4.1/bootstrap.min.css"
	rel="stylesheet" type="text/css" media="all">

<!-- Vendor CSS-->
<link
	href="${pageContext.request.contextPath}/static/vendor/animsition/animsition.min.css"
	rel="stylesheet" type="text/css" media="all">
<link
	href="${pageContext.request.contextPath}/static/vendor/bootstrap-progressbar/bootstrap-progressbar-3.3.4.min.css"
	type="text/css" rel="stylesheet" media="all">
<link
	href="${pageContext.request.contextPath}/static/vendor/wow/animate.css"
	rel="stylesheet" type="text/css" media="all">
<link
	href="${pageContext.request.contextPath}/static/vendor/css-hamburgers/hamburgers.min.css"
	type="text/css" rel="stylesheet" media="all">
<link
	href="${pageContext.request.contextPath}/static/vendor/slick/slick.css"
	rel="stylesheet" type="text/css" media="all">
<link
	href="${pageContext.request.contextPath}/static/vendor/select2/select2.min.css"
	rel="stylesheet" type="text/css" media="all">
<link
	href="${pageContext.request.contextPath}/static/vendor/perfect-scrollbar/perfect-scrollbar.css"
	type="text/css" rel="stylesheet" media="all">

<!-- Main CSS-->
<link href="${pageContext.request.contextPath}/static/css/theme.css"
	rel="stylesheet" type="text/css" media="all">

<link href="${pageContext.request.contextPath}/static/demo.css"
	type="text/css" rel="stylesheet">

</head>

<body class="animsition page-content--bge5">
	<div class="container" style="margin-bottom: 3%;">
		<div class="login-wrap">
			<div class="login-content">
				<div class="login-logo">
					<a href="#"> <img
						src="${pageContext.request.contextPath}/static/images/icon/logo.png"
						alt="CoolAdmin">
					</a>
				</div>
				<div class="login-form">
					<c:if test="${userError != null}">
						<div class="alert alert-danger">
							<p>${userError }</p>
						</div>
					</c:if>
					<c:if test="${detailsError != null}">
						<div class="alert alert-danger">
							<p>${detailsError }</p>
						</div>
					</c:if>
					<c:if test="${updated != null}">
						<div class="alert alert-success">
							<p>${updated }</p>
						</div>
					</c:if>


					<form:form method="post">
						<div class="form-group">
							<label>User Name</label>
							<spring:message code="login.form.username.placeholder"
								var="username" />
							<input class="au-input au-input--full" type="text" id="userName"
								name="userName" placeholder="${username }" required="required">
						</div>

						<div class="form-group">
							<label>Email Id</label> <input class="au-input au-input--full"
								type="text" id="email" name="email"
								placeholder="Enter Registered Email" required="required">
						</div>
						<div class="form-group">
							<label>Mobile Number</label> <input
								class="au-input au-input--full" type="text" id="mobileNumber"
								name="mobileNumber" placeholder="Enter Registered Mobile Number"
								required="required">
						</div>
						<div class="form-group">
							<label>Password</label> <input class="au-input au-input--full"
								type="password" id="password" name="password"
								placeholder="Enter Password To Change" required="required">
						</div>

						<div class="form-actions">
							<input type="submit" class="btn btn-block btn-primary"
								value="Reset Password" />
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>





	<!-- Jquery JS-->
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/vendor/jquery-3.2.1.min.js"></script>
	<!-- Bootstrap JS-->
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/vendor/bootstrap-4.1/popper.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/vendor/bootstrap-4.1/bootstrap.min.js"></script>
	<!-- Vendor JS       -->
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/vendor/slick/slick.min.js">
		
	</script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/vendor/wow/wow.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/vendor/animsition/animsition.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/vendor/bootstrap-progressbar/bootstrap-progressbar.min.js">
		
	</script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/vendor/counter-up/jquery.waypoints.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/vendor/counter-up/jquery.counterup.min.js">
		
	</script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/vendor/circle-progress/circle-progress.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/vendor/perfect-scrollbar/perfect-scrollbar.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/vendor/chartjs/Chart.bundle.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/vendor/select2/select2.min.js">
		
	</script>

	<!-- Main JS-->
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/js/main.js"></script>
</body>

</html>
<!-- end document-->

