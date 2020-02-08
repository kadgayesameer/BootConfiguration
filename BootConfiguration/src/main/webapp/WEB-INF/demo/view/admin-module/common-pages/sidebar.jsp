<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<nav class="side-navbar">
		<div class="side-navbar-wrapper">
			<!-- Sidebar Header    -->
			<div
				class="sidenav-header d-flex align-items-center justify-content-center">
				<!-- User Info-->
				<div class="sidenav-header-inner text-center">
					<img
						src="${pageContext.request.contextPath }/static/img/sameer/compLogo.png"
						alt="person" class="img-fluid rounded-circle"
						style="width: 100px; height: 80px;">
					<h2 class="h5">PROJECT</h2>
					<!-- <span>Web Developer</span> -->
				</div>
				<!-- Small Brand information, appears on minimized sidebar-->
				<div class="sidenav-header-logo">
					<a href="${pageContext.request.contextPath }/"
						class="brand-small text-center"> <img
						src="${pageContext.request.contextPath }/static/img/sameer/compLogo.png"
						alt="person" class="img-fluid rounded-circle"
						style="width: 40px; height: 40px;"> <!-- <strong>C</strong><strong
						class="text-primary">P</strong> --></a>
				</div>
			</div>
			<!-- Sidebar Navigation Menus-->
			<div class="main-menu">
				<h5 class="sidenav-heading">Main</h5>
				<ul id="side-main-menu" class="side-menu list-unstyled">
					<li><a href="${pageContext.request.contextPath }/"> <i
							class="icon-home"></i>Home
					</a></li>
					<li><a href="#exampledropdownDropdown" aria-expanded="false"

						data-toggle="collapse"> <i class="icon-interface-windows"></i>Mapping Dropdown
					</a>
						<ul id="exampledropdownDropdown" class="collapse list-unstyled ">
							<li><a href="${pageContext.request.contextPath }/admin/students">Student</a></li>
							<li><a href="${pageContext.request.contextPath }/admin/category">Category</a></li>
						</ul>
					</li>
					<li><a href="#tripletsDropdown" aria-expanded="false"
						data-toggle="collapse"> <i class="icon-interface-windows"></i>Triplets Dropdown
					</a>
						<ul id="tripletsDropdown" class="collapse list-unstyled ">
							<li><a href="${pageContext.request.contextPath }/admin/engine/factory">Engine Factory</a></li>
						</ul>
					</li>
					<%-- <li><a href="${pageContext.request.contextPath }/sample/login">

						data-toggle="collapse"> <i class="icon-interface-windows"></i>Task
							Dropdown
					</a>
						<ul id="exampledropdownDropdown" class="collapse list-unstyled ">
							<li><a
								href="${pageContext.request.contextPath }/admin/students">Student</a></li>
							<li><a
								href="${pageContext.request.contextPath }/admin/category">Category</a></li>
							<li><a
								href="${pageContext.request.contextPath }/admin/caste">Caste</a></li>
						</ul></li>
					<li><a href="${pageContext.request.contextPath }/sample/login">

							<i class="icon-interface-windows"></i>Login page
					</a></li>
					<li><a href="#"> <i class="icon-mail"></i>Demo
							<div class="badge badge-warning">6 New</div></a></li>
					<li><a
						href="${pageContext.request.contextPath }/admin/students"> <i
							class="icon-form"></i>Forms
					</a></li>
					<li><a href="charts.html"> <i class="fa fa-bar-chart"></i>Charts
					</a></li>
					<li><a href="tables.html"> <i class="icon-grid"></i>Tables
					</a></li> --%>
				</ul>
			</div>
			<!-- <div class="admin-menu">
				<h5 class="sidenav-heading">Second menu</h5>
				<ul id="side-admin-menu" class="side-menu list-unstyled">
					<li><a href="#"> <i class="icon-screen"> </i>Demo
					</a></li>
					<li><a href="#"> <i class="icon-flask"> </i>Demo
							<div class="badge badge-info">Special</div></a></li>
					<li><a href=""> <i class="icon-flask"> </i>Demo
					</a></li>
					<li><a href=""> <i class="icon-picture"> </i>Demo
					</a></li>
				</ul>
			</div> -->
		</div>
	</nav>
</body>
</html>