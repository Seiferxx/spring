<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<!DOCTYPE html>
<html>
	<head>
		<title>seifernet Spring</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
		
		<link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
		<link type="text/css" rel="stylesheet" href="/spring/resources/css/materialize.min.css"  media="screen,projection"/>
		<tiles:insertAttribute name="css" />
	</head>
	
	<body>
		<tiles:insertAttribute name="body" />
		
		<tiles:insertAttribute name="footer" />
		
		<script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
		<script type="text/javascript" src="/spring/resources/js/materialize.min.js"></script>
		<tiles:insertAttribute name="js" />
	</body>
</html>


	


