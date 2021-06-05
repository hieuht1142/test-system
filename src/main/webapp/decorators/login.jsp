<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
	<meta charset="utf-8" />
	
	<title><dec:title default="Online Test - Login" /></title>
	
	<meta name="description" content="overview &amp; stats" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
	
	<!-- bootstrap & fontawesome -->
	<link rel="stylesheet" href="<c:url value='/template/teacher/assets/css/bootstrap.min.css' />" />
	<link rel="stylesheet" href="<c:url value='/template/teacher/assets/font-awesome/4.2.0/css/font-awesome.min.css' />" />

	<!-- text fonts -->
	<link rel="stylesheet" href="<c:url value='/template/teacher/assets/fonts/fonts.googleapis.com.css' />" />

	<!-- ace styles -->
	<link rel="stylesheet" href="<c:url value='/template/teacher/assets/css/ace.min.css' />" />

	<!--[if lte IE 9]>
		<link rel="stylesheet" href="<c:url value='/template/teacher/assets/css/ace-part2.min.css' />" />
	<![endif]-->
	<link rel="stylesheet" href="<c:url value='/template/teacher/assets/css/ace-rtl.min.css' />" />
	
</head>
<body class="login-layout light-login">    
    <div class="main-container" id="main-container">
    	<dec:body/>
	</div>
	
</body>
</html>