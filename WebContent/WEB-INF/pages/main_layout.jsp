<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<!DOCTYPE html>
<html>
	<head>
		<title>Spring</title>
		<tiles:insertAttribute name="css" />
	</head>
	
	<body>
		<tiles:insertAttribute name="body" />
		<tiles:insertAttribute name="js" />
		<tiles:insertAttribute name="footer" />
	</body>
</html>


	


