<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="/resources/js/jquery-3.1.1.min.js"></script>
<link rel="stylesheet" href="/resources/css/bootstrap.min.css">
<script src="/resources/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="/resources/css/chosen.min.css">
<script src="/resources/js/chosen.jquery.min.js"></script>
<script src="/resources/js/angular.js"></script>
<script src="/resources/js/dirPagination.js"></script>
<style type="text/css">
body{
background: #16222a; /* fallback for old browsers */
  background: -webkit-linear-gradient(to right, #16222a, #3a6073); /* Chrome 10-25, Safari 5.1-6 */
  background: linear-gradient(to right, #16222a, #3a6073);
}
h4, th, td{
color: #ffffff; font-family: 'Lato', sans-serif; 
}
</style>
<title><tiles:getAsString name="title" /></title>
</head>
<body>
		<tiles:insertAttribute name="body" />
</body>
</html>