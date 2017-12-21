<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
	<head><link rel="stylesheet" type="text/css" href="css/prefSelectExtension.css" />
	<script type="text/javascript" src="js/prefSelectExtension.js"></script>
	<title>Home画面</title>

	<style type="text/css">

	#header{
	display: none;

	}
	</style>
    <script>
    </script>

</head>
<body>
	<div id="main">
		<div id="main-center">

		<h1><s:property value="addressDAOResult"/></h1>


		</div>
	</div>
	<div id="footer">
	 	<div id="pr">
		</div>
	</div>
</body>
</html>