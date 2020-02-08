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

<style>
h4 {
	margin-bottom: 2% !important
}
</style>

</head>
<body>
	<section class="forms">
		<div class="container-fluid">
			<!-- Page Header-->
			<header>
				<h1 class="h3 display">ENGINE FACTORY MASTER</h1>
			</header>
			<div class="row">
				<div class="col-12">
					<div class="card border border-secondary">
						<form:form
							action="${pageContext.request.contextPath }/admin/engine/factory/save"
							modelAttribute="engineFactory" name="engineFactory"
							id="engineFactory" method="post">
							<div class="card-header d-flex align-items-center">
								<div class="row w-100">
									<h4 class="col-lg-6 col-md-6 col-sm-12 text-center mb-3">Save Engine
										Factory</h4>
									<div class="col-lg-6 col-md-6 col-sm-12 text-right text-sm-center text-xs-center">
										<div class="d-inline-block">
											<form:hidden path="factoryId" />
											Factory Name &nbsp;&nbsp;&nbsp;
											<form:input path="factoryName" name="factoryName"
												id="factoryName" class="" placeholder="Enter Factory Name"
												required="required" />
											<form:errors path="factoryName"></form:errors>
	
											<input id="engineJson" type="hidden" name="engineJson" />
										</div>
									</div>
								</div>
							</div>
							<div class="card-body">
								<div class="card border">
									<div class="card-header d-flex align-items-center row">
										<div class="col-lg-3 col-md-12 p-0">
											<h4
												class="text-lg-left text-md-center text-sm-center text-center">Add
												Engine</h4>
										</div>
										<div class="col-md-12 col-lg-9 p-0 row w-100 m-0">
											<div
												class="row col-lg-6 col-md-6 col-sm-12 text-sm-center p-0 text-xs-right">
												<span class="col-sm-5"> Model Name </span> <input
													name="engineModelName" id="engineModelName"
													class="col-sm-7" placeholder="Enter Model Name" />
											</div>
											<div
												class="row col-lg-6 col-md-6 col-sm-12 text-sm-center text-xs-right p-0">
												<span class="col-sm-5"> Engine HP </span> <input
													name="engineHP" id="engineHP" class="col-sm-7"
													placeholder="Enter Engine HP" />
											</div>
										</div>
									</div>
									<div class="card-body">
										<div class="row">
											<div class="col-lg-4">
												<div class="card border">
													<!-- 
													<div class="card-header d-flex align-items-center text-md-left">
														
													</div> -->
													<div class="card-body">
														<h4>Add Car</h4>
														<div class="row form-group">
															<div class="col-md-12 col-sm-12 col-lg-12 col-12">
																<label> Model Name </label> <input name="carModelName"
																	id="carModelName" class="form-control"
																	placeholder="Enter Model" />
															</div>
														</div>
														<div class="row form-group">
															<div class="col-md-12 text-right">
																<button type="button" class="btn btn-success"
																	onclick="addCar()">Add Car</button>
															</div>
														</div>
													</div>
												</div>
											</div>
											<div class="col-lg-8">
												<div class="card border">
													<div class="card-header">
														<h4>Car List</h4>
													</div>
													<div class="card-body">
														<div class="table-responsive table-striped">
															<table class="table text-center" id="carTable">
																<thead>
																	<tr>
																		<th>Sr No</th>
																		<th>Model Name</th>
																	</tr>
																</thead>
																<tbody id="carBody">

																</tbody>
															</table>
														</div>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
							<div class="col-lg-12">
								<div class="col-md-12 text-center mb-4">
									<button type="button" onclick="addEngine()"
										class="btn btn-success">Add Engine</button>
								</div>
								<div class="card border">
									<div class="card-header">
										<h4>Engine List</h4>
									</div>
									<div class="card-body">
										<div class="table-responsive table-striped">
											<table class="table text-center" id="engineTable">
												<thead>
													<tr>
														<th>Sr No</th>
														<th>Engine Model Name</th>
														<th>Engine HP</th>
														<th>Cars</th>
													</tr>
												</thead>
												<tbody id="engineBody">

												</tbody>
											</table>
										</div>
									</div>
								</div>
							</div>
							<div class="col-md-12 text-center mb-4">
								<button onclick="getJson()" class="btn btn-success">Save
									Engine Factory</button>
							</div>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</section>

	<script>
		var i = 0, j = 0;
		function addCar() {
			car = document.getElementById('carModelName').value;

			var tBody = document.getElementById('carTable');
			var tRow = document.createElement('tr');
			var tData1 = document.createElement('td');
			var tData2 = document.createElement('td');

			i += 1;
			tData1.innerText = i;
			tData2.innerText = car;

			tRow.appendChild(tData1);
			tRow.appendChild(tData2);
			tBody.appendChild(tRow);

			document.getElementById('carModelName').value = '';
		}

		function addEngine() {
			engineModel = document.getElementById('engineModelName').value;
			engineHP = document.getElementById('engineHP').value;

			var tBody = document.getElementById('engineBody');
			var tRow = document.createElement('tr');
			var tData1 = document.createElement('td');
			var tData2 = document.createElement('td');
			var tData3 = document.createElement('td');
			var tData4 = document.createElement('td');

			var carTable = document.getElementById("carTable");
			var rowCount = carTable.rows.length;

			var carsArray = [];
			for (var i = 1; i < rowCount; i++) {
				var car = {}

				car["carName"] = carTable.rows[i].cells[1].innerHTML;
				carsArray.push(car);
			}

			j += 1;
			tData1.innerText = j;
			tData2.innerText = engineModel;
			tData3.innerText = engineHP;
			tData4.innerText = JSON.stringify(carsArray);

			tRow.appendChild(tData1);
			tRow.appendChild(tData2);
			tRow.appendChild(tData3);
			tRow.appendChild(tData4);
			tBody.appendChild(tRow);

			document.getElementById('carTable').innerHTML = '<thead> <tr> <th>Sr No</th> <th>Model Name</th> </tr> </thead>'
					+ '<tbody id="carBody"> </tbody>';
			document.getElementById('engineModelName').value = '';
			document.getElementById('engineHP').value = '';
		}

		function getJson() {
			var engineTable = document.getElementById("engineTable");
			var rowCount = engineTable.rows.length;

			var engineArray = [];
			for (var i = 1; i < rowCount; i++) {
				var engine = {};
				engine["engineModel"] = engineTable.rows[i].cells[1].innerHTML;
				engine["engineHP"] = engineTable.rows[i].cells[2].innerHTML;
				engine["cars"] = engineTable.rows[i].cells[3].innerHTML;
				engineArray.push(engine);
			}

			document.getElementById("engineJson").value = JSON
					.stringify(engineArray);
			alert(JSON.stringify(engineArray));
		}
	</script>




</body>
</html>