<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Home page</title>
</head>
<body>
	<div id="sidebar" class="sidebar responsive">
		<script type="text/javascript">
			try{ace.settings.check('sidebar' , 'fixed')}catch(e){}
		</script>
	
		<ul class="nav nav-list">
			<li class="active">
				<a href='<c:url value = "teacher-home" />'>
					<i class="menu-icon fa fa-home"></i>
					
					<span class="menu-text"> Home Page </span>
				</a>
	
				<b class="arrow"></b>
			</li>
	
			<li class="">
				<a href="#" class="dropdown-toggle">
					<i class="menu-icon fa fa-file"></i>
					<span class="menu-text">
						Quản lý đề thi
					</span>
	
					<b class="arrow fa fa-angle-down"></b>
				</a>
	
				<b class="arrow"></b>
	
				<ul class="submenu">
					<li class="">
						<a href='<c:url value="teacher-exam?type=create" />'>
							<i class="menu-icon fa fa-caret-right"></i>
							Tạo đề thi
						</a>
	
						<b class="arrow"></b>
					</li>
	
					<li class="">
						<a href='<c:url value="teacher-exam?type=list" />'>
							<i class="menu-icon fa fa-caret-right"></i>
							Kho đề thi
						</a>
	
						<b class="arrow"></b>
					</li>
				</ul>
			</li>
	
			<li class="">
				<a href="#" class="dropdown-toggle">
					<i class="menu-icon fa fa-question"></i>
					<span class="menu-text"> Quản lý câu hỏi </span>
	
					<b class="arrow fa fa-angle-down"></b>
				</a>
	
				<b class="arrow"></b>
	
				<ul class="submenu">
					<li class="">
						<a href='<c:url value = "teacher-question?type=create" />'>
							<i class="menu-icon fa fa-caret-right"></i>
							Tạo câu hỏi
						</a>
	
						<b class="arrow"></b>
					</li>
	
					<li class="">
						<a href='<c:url value = "teacher-question?type=list" />'>
							<i class="menu-icon fa fa-caret-right"></i>
							Kho câu hỏi
						</a>
	
						<b class="arrow"></b>
					</li>
				</ul>
			</li>
		</ul><!-- /.nav-list -->
	
		<div class="sidebar-toggle sidebar-collapse" id="sidebar-collapse">
			<i class="ace-icon fa fa-angle-double-left" data-icon1="ace-icon fa fa-angle-double-left" data-icon2="ace-icon fa fa-angle-double-right"></i>
		</div>
	
		<script type="text/javascript">
			try{ace.settings.check('sidebar' , 'collapsed')}catch(e){}
		</script>
	</div>
	<div class="main-content">
		<div class="main-content-inner">
			<div class="breadcrumbs" id="breadcrumbs">
				<script type="text/javascript">
					try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
				</script>

				<ul class="breadcrumb">
					<li>
						<i class="ace-icon fa fa-home home-icon"></i>
						<a href='#'>Home</a>
					</li>
				</ul><!-- /.breadcrumb -->

			</div>

			<!-- .page-content -->
			<div class="page-content">
				<div class="row" >
					<div class="col-xs-12">
						<h1>Home page here!</h1>
					</div>
				</div>
			</div>
			<!-- .page-content -->
				
		</div>
	</div><!-- /.main-content -->

</body>
</html>