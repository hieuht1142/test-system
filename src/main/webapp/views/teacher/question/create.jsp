<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="apiUrl" value="/api-teacher-question"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tạo câu hỏi</title>
</head>
<body>
	<div id="sidebar" class="sidebar responsive">
		<script type="text/javascript">
			try{ace.settings.check('sidebar' , 'fixed')}catch(e){}
		</script>
	
		<ul class="nav nav-list">
			<li class="">
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
	
			<li class="active">
				<a href="#" class="dropdown-toggle">
					<i class="menu-icon fa fa-question"></i>
					<span class="menu-text"> Quản lý câu hỏi </span>
	
					<b class="arrow fa fa-angle-down"></b>
				</a>
	
				<b class="arrow"></b>
	
				<ul class="submenu">
					<li class="active">
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
					try {
						ace.settings.check('breadcrumbs', 'fixed')
					} catch (e) {
					}
				</script>

				<ul class="breadcrumb">
					<li>
						<i class="ace-icon fa fa-home home-icon"></i>
						<a href='<c:url value="teacher-home" />'>Home</a>
					</li>
					<li class="active">Quản lý câu hỏi</li>
					<li class="active">Tạo câu hỏi</li>
				</ul>
				<!-- /.breadcrumb -->

			</div>

			<!-- .page-content -->
			<div class="page-content">
				<div class="row">
					<div class="col-xs-12">

						<form class="form-horizontal" id="formCreate">
							<div class="form-group">
								<label for="subjectTitle"
									class="col-sm-3 control-label no-padding-right"> Tên
									học phần </label>
								<div class="col-sm-9">										
									<select class="form-control" id="subject" name="subject">
	                                	<c:forEach var="item" items="${subjects}">
	                                    	<option value="${item.id}" >${item.subjectTitle}</option>
	                                	</c:forEach>
	                           		</select>
								</div>
							</div>

							<div class="form-group">
								<label for="topic"
									class="col-sm-3 control-label no-padding-right"> Chủ đề
								</label>
								<div class="col-sm-9">
									<input type="text" class="form-control" id="topic" name="topic"
										value="" />
								</div>
							</div>

							<div class="form-group">
								<label for="content"
									class="col-sm-3 control-label no-padding-right"> Nội
									dung câu hỏi </label>
								<div class="col-sm-9">
									<input type="text" class="form-control" id="content"
										name="content" value="" />
								</div>
							</div>

							<div class="form-group">
								<label for="answerA"
									class="col-sm-3 control-label no-padding-right"> Đáp án
									A </label>
								<div class="col-sm-9">
									<input type="text" class="form-control" id="answerA"
										name="answerA" value="" />
								</div>
							</div>

							<div class="form-group">
								<label for="answerB"
									class="col-sm-3 control-label no-padding-right"> Đáp án
									B </label>
								<div class="col-sm-9">
									<input type="text" class="form-control" id="answerB"
										name="answerB" value="" />
								</div>
							</div>

							<div class="form-group">
								<label for="answerC"
									class="col-sm-3 control-label no-padding-right"> Đáp án
									C </label>
								<div class="col-sm-9">
									<input type="text" class="form-control" id="answerC"
										name="answerC" value="" />
								</div>
							</div>

							<div class="form-group">
								<label for="answerD"
									class="col-sm-3 control-label no-padding-right"> Đáp án
									D </label>
								<div class="col-sm-9">
									<input type="text" class="form-control" id="answerD"
										name="answerD" value="" />
								</div>
							</div>
							
							<div class="form-group">
								<label for="trueAnswer" class="col-sm-3 control-label no-padding-right">Đáp án đúng</label>
								<div class="col-sm-9">
									<select class="col-xs-10 col-sm-5" id="trueAnswer" name="trueAnswer">
										<option>A</option>
										<option>B</option>
										<option>C</option>
										<option>D</option>
									</select>
								</div>
							</div>

							<div class="clearfix form-actions">
								<div class="col-md-offset-3 col-md-9">
									<button class="btn btn-info" type="button" id="btnSave">
										<i class="ace-icon fa fa-check bigger-110 "></i> Save
									</button>

									&nbsp; &nbsp; &nbsp;
									<button class="btn" type="reset" id="btnReset">
										<i class="ace-icon fa fa-undo bigger-110"></i> Reset
									</button>
								</div>
							</div>

						</form>

					</div>
				</div>
			</div>
			<!-- .page-content -->
		</div>
	</div>
	<!-- /.main-content -->

	<script>
		$('#btnSave').click(function (e) {
			e.preventDefault();
	        var data = {};
	        var formCreate = $('#formCreate').serializeArray();
	        $.each(formCreate, function(i, v) {
	            data["" + v.name + ""] = v.value;
	        });

	        saveQuestion(data);
		});

		function saveQuestion(data) {
			$.ajax({
				url: '${apiUrl}',
				type: 'POST',
	            contentType: 'application/json',
	            data: JSON.stringify(data),
	            dataType: 'json',
	            success: function (result) {
	                console.log(result);
	                alert("Tạo câu hỏi thành công");
	            },
	            error: function (error) {
	                console.log(error);
	            }
			});
		}
	</script>
</body>
</html>