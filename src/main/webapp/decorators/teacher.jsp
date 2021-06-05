<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
	<meta charset="utf-8" />
	
	<title><dec:title default="Online Test" /></title>
	
	<meta name="description" content="overview &amp; stats" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

	<link rel="stylesheet" href="<c:url value='/template/teacher/assets/css/bootstrap.min.css' />" />
	<link rel="stylesheet" href="<c:url value='/template/teacher/font-awesome/4.5.0/css/font-awesome.min.css' />" />
    <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css">
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <link rel="stylesheet" href="<c:url value='/template/teacher/assets/css/ace.min.css' />" class="ace-main-stylesheet" id="main-ace-style" />

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script type='text/javascript' src='<c:url value="/template/teacher/js/jquery-2.2.3.min.js" />'></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	<script src="<c:url value='/template/teacher/assets/js/ace-extra.min.js' />"></script>
	
</head>
<body class="no-skin">
	<!-- header -->
    <%@ include file="/common/teacher/header.jsp" %>
    <!-- header -->
    
    <div class="main-container" id="main-container">
		<script type="text/javascript">
				try{ace.settings.check('main-container' , 'fixed')}catch(e){}
		</script>
    	
    	<dec:body/>
		
		<!-- footer -->
    	<%@ include file="/common/teacher/footer.jsp" %>
    	<!-- footer -->
    	
    	<a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse display">
			<i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
		</a>
	</div>
	
	<script src="<c:url value='/template/teacher/assets/js/jquery.2.1.1.min.js' />"></script>
	<script src="<c:url value='/template/teacher/assets/js/bootstrap.min.js' />"></script>
	<script src="<c:url value='/template/teacher/assets/js/jquery-ui.custom.min.js' />"></script>
	<script src="<c:url value='/template/teacher/assets/js/jquery.ui.touch-punch.min.js' />"></script>
	<script src="<c:url value='/template/teacher/assets/js/jquery.easypiechart.min.js' />"></script>
	<script src="<c:url value='/template/teacher/assets/js/jquery.sparkline.min.js' />"></script>
	<script src="<c:url value='/template/teacher/assets/js/jquery.flot.min.js' />"></script>
	<script src="<c:url value='/template/teacher/assets/js/jquery.flot.pie.min.js' />"></script>
	<script src="<c:url value='/template/teacher/assets/js/jquery.flot.resize.min.js' />"></script>
	<script src="<c:url value='/template/teacher/assets/js/ace-elements.min.js' />"></script>
	<script src="<c:url value='/template/teacher/assets/js/ace.min.js' />"></script>
	
	<!-- page specific plugin scripts -->
	<script src="<c:url value='/template/teacher/assets/js/jquery-ui.min.js'/>"></script>
	<script src="<c:url value='/template/paging/jquery.twbsPagination.js' />"></script>

</body>
</html>