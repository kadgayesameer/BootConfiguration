<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
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
<!-- Tweaks for older IEs-->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script><![endif]-->
</head>
<body>
	<div class="page login-page">
		<div class="container">
			<div class="form-outer text-center d-flex align-items-center">
				<div class="form-inner">
					<div class="logo text-uppercase">
						<span>Bootstrap</span><strong class="text-primary">Dashboard</strong>
					</div>
					<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit,
						sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.
						Ut enim ad minim veniam, quis nostrud.</p>

					<div class="login-form">
						<c:url var="loginUrl" value="/login" />

						<c:if test="${expireDate == true}">
							<div class="alert alert-danger">
								<p>YOUR APPLICATION DATE IS EXPIRED......!</p>
							</div>
						</c:if>

						<c:if test="${param.error != null}">
							<div class="alert alert-danger">
								<p>Inavalid Credentials</p>
							</div>
						</c:if>
						<c:if test="${param.logout != null}">
							<div class="alert alert-success">
								<p>Logged Out Successfully</p>
							</div>
						</c:if>
						<form action="${loginUrl}" method="post">
							<div class="form-group-material">
								<input id="username" type="text" name="loginUsername"
									name="ssoId" data-msg="Please enter your username"
									class="input-material" required="required"> <label
									for="login-username" class="label-material">Username</label>
							</div>
							<div class="form-group-material">
								<input id="login-password" type="password" id="password"
									name="password" data-msg="Please enter your password"
									class="input-material"> <label for="login-password"
									class="label-material">Password</label>
							</div>
							<div class="form-group-material login-checkbox">
								<label> <input type="checkbox" name="remember-me"
									id="rememberme">Remember Me
								</label>
							</div>

							<div class="form-group text-center">
								<button id="login" class="btn btn-primary" type="submit">Sign
									In</button>
								<input type="hidden" name="${_csrf.parameterName}"
									value="${_csrf.token}" />
								<!-- <a id="login" href="index.html" class="btn btn-primary">Login</a> -->
								<!-- This should be submit button but I replaced it with <a> for demo purposes-->
							</div>
							<a href="${pageContext.request.contextPath }/forgot/password"
								class="forgot-pass">Forgot Password?</a>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
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