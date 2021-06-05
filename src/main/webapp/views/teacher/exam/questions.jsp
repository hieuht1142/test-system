<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="apiUrl" value="/api-teacher-exam"/>
<c:url var="questionsUrl" value="/teacher-exam"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Kho câu hỏi</title>
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
		<form action="<c:url value='/teacher-exam'/>" id="formSubmit" method="get">
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
						<li class="active">Cập nhật câu hỏi</li>
					</ul>
					<!-- /.breadcrumb -->
	
				</div>
	
				<!-- .page-content -->
				<div class="page-content">
					<div class="row">
						<div class="col-xs-12">
							<div class="table-responsive">
								<table id="question-table"
									class="table table-striped table-bordered table-hover">
									<thead>
										<tr>
											<th>Chủ đề</th>
											<th>Nội dung</th>
											<th>Đáp án A</th>
											<th>Đáp án B</th>
											<th>Đáp án C</th>
											<th>Đáp án D</th>
											<th>Đáp án đúng</th>
											<th></th>
										</tr>
									</thead>
	
									<tbody>
										<c:forEach var="item" items="${question.listQuestions}">
											<tr>
												<td>${item.topic}</td>
												<td>${item.content}</td>
												<td>${item.answerA}</td>
												<td>${item.answerB}</td>
												<td>${item.answerC}</td>
												<td>${item.answerD}</td>
												<td>${item.trueAnswer}</td>
												<td>
													<c:url var="updateURL" value="/teacher-exam">
														<c:param name="type" value="updateQuestion"></c:param>
														<c:param name="subject" value="${exam.subject}"></c:param>
														<c:param name="addedQuestion" value="${item.id}"></c:param>
														<c:param name="id" value="${exam.id}"></c:param>
														<c:param name="page" value="${question.page}"></c:param>
														<c:param name="maxPageItem" value="${question.maxPageItem}"></c:param>
													</c:url>
													<a class="btn btn-xs btn-info" data-toggle="tooltip" 
														title="Thêm vào đề thi" href='${updateURL}'>
														<i class="ace-icon fa fa-plus bigger-120"></i>
													</a>
												</td>
											
											</tr>
										</c:forEach>
									</tbody>
								</table>
								<ul class="pagination" id="pagination"></ul>
								
								<input type="hidden" value="" id="page" name="page" />
								<input type="hidden" value="" id="maxPageItem" name="maxPageItem" />
								<input type="hidden" value="" id="type" name="type" />
								<input type="hidden" value="${exam.id }" id="id" name="id" />
								<input type="hidden" value="${exam.subject }" id="subject" name="subject" />
							</div>
							
							<c:if test="${not empty exam.questionList}">
								<c:forEach var="item" items="${exam.questionList}">
									<div class="row"><hr></div>
	
									<div class="row">
										<div class="col-xs-12">
										    <div class="row">
										    	<b>${item.content }</b>
										    	
										    	<c:url var="removeURL" value="/teacher-exam">
													<c:param name="type" value="updateQuestion"></c:param>
													<c:param name="subject" value="${exam.subject}"></c:param>
													<c:param name="removedQuestion" value="${item.id}"></c:param>
													<c:param name="id" value="${exam.id}"></c:param>
													<c:param name="page" value="${question.page}"></c:param>
													<c:param name="maxPageItem" value="${question.maxPageItem}"></c:param>
												</c:url>
												<a class="btn btn-xs btn-info" data-toggle="tooltip" 
													title="Xóa khỏi đề thi" href='${removeURL}'>
													<i class="fa fa-trash-o bigger-110 pink"></i>
												</a>
												
										    </div>
										    <div class="row">
										    	<span>A. </span>
												<span class="">
						                             ${item.answerA }
						                        </span>
										    </div>
										    <div class="row">
										        <span>B. </span>
												<span class="">
						                             ${item.answerB }
						                        </span>		
										    </div>
										    <div class="row">
										    	<span>C. </span>
												<span class="">
						                             ${item.answerC }
						                        </span>									        		
										   	</div>
										    <div class="row">
										    	<span>D. </span>
												<span class="">
						                             ${item.answerD }
						                        </span>										  		
										   	</div>
										</div>
									</div>
									
								</c:forEach>
							</c:if>
								
						</div>
					</div>
					
				</div>
				<!-- .page-content -->
			</div>
		</form>
	</div>
	<!-- /.main-content -->
	
	<script type="text/javascript">
		var totalPage = ${question.totalPage};
		var currentPage = ${question.page};
		var visiblePages = ${question.maxPageItem};
		var limit = ${question.maxPageItem};
		
		$(function() {
			window.pagObj = $('#pagination').twbsPagination({
				totalPages : totalPage,
				visiblePages : 10,
				startPage : currentPage,
				onPageClick : function(event, page) {
					if (currentPage != page) {
						$('#maxPageItem').val(limit);
						$('#page').val(page);
						$('#type').val('updateQuestion');
						$('#formSubmit').submit();
					}
				}
			});
		});
	</script>
</body>
</html>