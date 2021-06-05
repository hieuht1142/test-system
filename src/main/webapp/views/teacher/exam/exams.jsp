<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="apiUrl" value="/api-teacher-exam"/>
<c:url var="examUrl" value="/teacher-exam"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Kho đề thi</title>
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
	
			<li class="active">
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
	
					<li class="active">
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
					<li class="active">Quản lý đề thi</li>
					<li class="active">Kho đề thi</li>
				</ul>
				<!-- /.breadcrumb -->

			</div>

			<!-- .page-content -->
			<div class="page-content">
				<div class="row">
					<div class="col-xs-12">
						<form class="form-inline" id="formSearch" action="<c:url value='/teacher-exam'/>" method="get">
							<div class="form-group col-sm-4">
								<label for="subjectTitle" class="col-sm-3 control-label no-padding-right">
									Tên học phần
								</label>
								<div class="col-sm-9">	
									<select class="form-control" id="subject" name="subject">
										<c:if test="${not empty exam.subject }">
											<c:forEach var="item" items="${subjects}">
	                                    		<option value="${item.id}" <c:if test="${item.id == exam.subject}">selected="selected"</c:if>>${item.subjectTitle}</option>
	                                		</c:forEach>
										</c:if>
										
										<c:if test="${empty exam.subject }">
											<c:forEach var="item" items="${subjects}">
	                                    		<option value="${item.id}" >${item.subjectTitle}</option>
	                                		</c:forEach>
										</c:if>
	                                	
	                           		</select>
								</div>
							</div>

							<div class="form-group col-sm-4">
								<label for="topic" class="col-sm-3 control-label no-padding-right">
									Học kỳ
								</label>
								<div class="col-sm-9">
									<input type="text" class="form-control" id="semester" name="semester" 
										value="<c:if test="${not empty exam.semester}">${exam.semester }</c:if>" />
								</div>
							</div>

							<div class="col-sm-1">
								<button class="btn btn-info" type="submit" id="btnSearch" data-toggle="tooltip" 
									title="Tìm kiếm">
									<i class="ace-icon fa fa-search bigger-110"></i>
								</button>
							</div>
							
							<input type="hidden" value="list" name="type" />
							
						</form>
					</div>
				</div>

				<div class="row">
					<br class="col-xs-12">
				</div>
				
				<div class="widget-box table-filter">
					<div class="table-btn-controls">
						<div class="pull-right tableTools-container">
							<div class="dt-buttons btn-overlap btn-group">
								<a
									class="dt-button buttons-colvis btn btn-white btn-primary btn-bold"
									data-toggle="tooltip" title='Tạo đề thi'
									href='<c:url value="/teacher-exam?type=create"/>'> 
										<span>
												<i class="fa fa-plus-circle bigger-110 purple"></i>
										</span>
								</a>
								<button id="btnDelete" type="button"
									class="dt-button buttons-html5 btn btn-white btn-primary btn-bold"
									data-toggle="tooltip" title='Xóa đề thi'>
									<span> 
										<i class="fa fa-trash-o bigger-110 pink"></i>
									</span>
								</button>
							</div>
						</div>
					</div>
				</div>

				<div class="row">
					<div class="col-xs-12">
						<div class="table-responsive">
							<table id="question-table"
								class="table table-striped table-bordered table-hover">
								<thead>
									<tr>
										<th class="center"><label class="pos-rel"> <input
												type="checkbox" class="ace" /> <span class="lbl"></span>
										</label></th>
										<th>Mã học phần</th>
										<th>Tên học phần</th>
										<th>Học kỳ</th>
										<th>Thời gian làm bài (phút)</th>
										<th></th>
									</tr>
								</thead>

								<tbody>
									<c:forEach var="item" items="${exam.examList}">
										<tr>
											<td class="center">
												<label class="pos-rel">
													<input type="checkbox" <c:if test="${item.status == 1 }">disabled</c:if> class="ace" id="checkbox_${item.id}" value="${item.id}" />
													<span class="lbl"></span>
												</label>
											</td>
											<td>${subjectModel.subjectId}</td>
											<td>${subjectModel.subjectTitle}</td>
											<td>${item.semester}</td>
											<td>${item.time}</td>
											<td>
												<c:url var="updateURL" value="/teacher-exam">
													<c:param name="type" value="update"></c:param>
													<c:param name="id" value="${item.id}"></c:param>
												</c:url>
												<a class="btn btn-xs btn-info" <c:if test="${item.status == 1 }">disabled</c:if> data-toggle="tooltip" 
													title="Sửa thông tin đề thi" href='${updateURL}'>
													<i class="ace-icon fa fa-pencil bigger-120"></i>
												</a>
												
												<c:url var="updateQuestionURL" value="/teacher-exam">
													<c:param name="type" value="updateQuestion"></c:param>
													<c:param name="id" value="${item.id}"></c:param>
													<c:param name="subject" value="${item.subject}"></c:param>
													<c:param name="page" value="1"></c:param>
													<c:param name="maxPageItem" value="5"></c:param>
												</c:url>
												<a class="btn btn-xs btn-info" <c:if test="${item.status == 1 }">disabled</c:if> data-toggle="tooltip" 
													title="Cập nhật câu hỏi" href='${updateQuestionURL}'>
													<i class="ace-icon fa fa-plus bigger-120"></i>													
												</a>
											</td>
										
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
			<!-- .page-content -->
		</div>
	</div>
	<!-- /.main-content -->
	
	<script>
		$('#btnDelete').click(function () {
			var data = {};
			var ids = $('tbody input:checked').map(function () {
				return $(this).val();
			}).get();
			data['ids'] = ids;
			deleteExam(data);
		});

		function deleteExam(data) {
			$.ajax({
				url: '${apiUrl}',
				type: 'DELETE',
	            contentType: 'application/json',
	            data: JSON.stringify(data),
	            success: function (result) {
	                window.location.href = "${examUrl}?type=list&id=";
	            },
	            error: function (error) {
	                console.log(error);
	            }
			});
		}
	</script>
</body>
</html>