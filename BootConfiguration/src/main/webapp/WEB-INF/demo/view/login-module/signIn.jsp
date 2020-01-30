<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
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
<%-- <title><tiles:insertAttribute name="title" /></title> --%>

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

<body class="animsition">
	<div class="page-content--bge5">
		<div class="container">
			<div class="login-wrap">
				<div class="login-content">
					<div class="login-logo">
						<a href="#"> <img height="200px" width="200px"
							src="${pageContext.request.contextPath}/static/images/icon/logoiceico.png"
							alt="CoolAdmin">
						</a>
					</div>
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
							<div class="form-group">
								<label>Username</label> <input class="au-input au-input--full"
									type="text" id="username" name="ssoId"
									placeholder="Enter Username" required="required">
							</div>
							<div class="form-group">
								<label>Password </label> <input class="au-input au-input--full"
									type="password" id="password" name="password"
									placeholder="Enter Password" required="required">
							</div>
							<div class="login-checkbox">
								<label> <input type="checkbox" name="remember-me"
									id="rememberme">Remember Me
								</label> <label> <a
									href="${pageContext.request.contextPath }/forgot/password">
										Forgot Password</a>
								</label>
							</div>
							<button class="au-btn au-btn--block au-btn--green m-b-20"
								type="submit">Sign In</button>
							<input type="hidden" name="${_csrf.parameterName}"
								value="${_csrf.token}" />
						</form>
						<div class="register-link">
							<p>
								For Details Contact : <a href="https://www.iceico.in">ICEICO
									Technologies Pvt. Ltd.</a>
							</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>




	<%-- <div id="mainWrapper">
            <div class="login-container">
                <div class="login-card">
                    <div class="login-form">
                        <c:url var="loginUrl" value="/login" />
                        <form action="${loginUrl}" method="post" class="form-horizontal">
                            <c:if test="${param.error != null}">
                                <div class="alert alert-danger">
                                    <p>Invalid username and password.</p>
                                </div>
                            </c:if>
                            <c:if test="${param.logout != null}">
                                <div class="alert alert-success">
                                    <p>You have been logged out successfully.</p>
                                </div>
                            </c:if>
                            <div class="input-group input-sm">
                                <label class="input-group-addon" for="username"><i class="fa fa-user"></i></label>
                                <input type="text" class="form-control" id="username" name="ssoId" placeholder="Enter Username" required>
                            </div>
                            <div class="input-group input-sm">
                                <label class="input-group-addon" for="password"><i class="fa fa-lock"></i></label> 
                                <input type="password" class="form-control" id="password" name="password" placeholder="Enter Password" required>
                            </div>
                            <div class="input-group input-sm">
                              <div class="checkbox">
                                <label><input type="checkbox" id="rememberme" name="remember-me"> Remember Me</label>  
                              </div>
                            </div>
                            <input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}" />
                                 
                            <div class="form-actions">
                                <input type="submit"
                                    class="btn btn-block btn-primary btn-default" value="Log in">
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
  --%>
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