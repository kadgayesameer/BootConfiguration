<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>DREAM PROJECT</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="robots" content="all,follow">
<!-- Bootstrap CSS-->
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/static/vendor/bootstrap/css/bootstrap.min.css">
<!-- Font Awesome CSS-->
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/static/vendor/font-awesome/css/font-awesome.min.css">
<!-- Fontastic Custom icon font-->
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/static/css/fontastic.css">
<!-- Google fonts - Roboto -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/https://fonts.googleapis.com/css?family=Roboto:300,400,500,700">
<!-- jQuery Circle-->
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/static/css/grasp_mobile_progress_circle-1.0.0.min.css">
<!-- Custom Scrollbar-->
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/static/vendor/malihu-custom-scrollbar-plugin/jquery.mCustomScrollbar.css">
<!-- theme stylesheet-->
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/static/css/style.default.css"
	id="theme-stylesheet">
<!-- Custom stylesheet - for your changes-->
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/static/css/custom.css">
<!-- Favicon-->
<link rel="shortcut icon"
	href="${pageContext.request.contextPath }/static/img/favicon.ico">
<!-- Tweaks for older IEs-->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script><![endif]-->
</head>
<body>
	<div class="page">
		<tiles:insertAttribute name="sidebar"></tiles:insertAttribute>
		<tiles:insertAttribute name="header"></tiles:insertAttribute>

		<div id="content"
			style="position: absolute; top: 67px; bottom: 40px; left: 0px; right: 0px; overflow: auto;">
			<tiles:insertAttribute name="body"></tiles:insertAttribute>
		</div>
		<%-- <tiles:insertAttribute name="chatSidebarContainer"></tiles:insertAttribute> --%>

		<tiles:insertAttribute name="footer"></tiles:insertAttribute>
	</div>

	<!-- JavaScript files-->
	<script
		src="${pageContext.request.contextPath }/static/vendor/jquery/jquery.min.js"></script>
	<script
		src="${pageContext.request.contextPath }/static/vendor/popper.js/umd/popper.min.js">
		
	</script>
	<script
		src="${pageContext.request.contextPath }/static/vendor/bootstrap/js/bootstrap.min.js"></script>
	<script
		src="${pageContext.request.contextPath }/static/js/grasp_mobile_progress_circle-1.0.0.min.js"></script>
	<script
		src="${pageContext.request.contextPath }/static/vendor/jquery.cookie/jquery.cookie.js">
		
	</script>
	<script
		src="${pageContext.request.contextPath }/static/vendor/chart.js/Chart.min.js"></script>
	<script
		src="${pageContext.request.contextPath }/static/vendor/jquery-validation/jquery.validate.min.js"></script>
	<script
		src="${pageContext.request.contextPath }/static/vendor/malihu-custom-scrollbar-plugin/jquery.mCustomScrollbar.concat.min.js"></script>
	<script
		src="${pageContext.request.contextPath }/static/js/charts-home.js"></script>
	<!-- Main File-->
	<script src="${pageContext.request.contextPath }/static/js/front.js"></script>
</body>
</html>