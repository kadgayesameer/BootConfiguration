<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src="https://cdnjs.cloudflare.com/ajax/libs/ace/1.4.7/ace.js"
	type="text/javascript" charset="utf-8"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/static/css/compiler.css">

</head>
<body>
	<!--Compiler-->
	<!-- 
	<form id="editorForm" action="../controller/SaveController.php"
		method="post"> -->
	<div id="code-edit" class="row code-div container mx-auto">
		<div id="editor-menu">
			<select name="language" class="options" id="prolang">
				<option value="java">Java</option>
				<option value="python">Python</option>
				<option value="c">C</option>
				<option value="cpp">Cpp</option>
				<option value="javascript">Javascript</option>
			</select> <select class="options" id="theme">
				<option value="dracula">Dark</option>
				<option value="xcode">Light</option>
			</select> <input type="text" hidden name="code" id="hiddencode">
			<button id="screen">
				<img id="screen-img"
					src="${pageContext.request.contextPath }/static/img/compiler/short.png">
			</button>
			<button id="run" type="submit">
				<img id="run-img"
					src="${pageContext.request.contextPath }/static/img/compiler/run.png">
			</button>
		</div>
		<div id="editor"></div>
		<script src="${pageContext.request.contextPath }/static/js/compiler.js"  type="text/javascript">
		</script>
	</div>
	<!-- </form> -->


</body>

</html>