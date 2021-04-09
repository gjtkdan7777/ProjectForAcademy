<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Q&#38;A</title>
<!-- admin common file setting -->
<c:import url="../common/adminSettings.jsp"></c:import>
<style type="text/css">
.ellipsis { overflow: hidden; text-overflow: ellipsis; white-space: nowrap;}
</style>
<script src="../resources/myLib/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
$(function() {
	//최상단 체크박스 클릭
	$("#checkall").click(function() {
		//클릭되었으면
		if ($("#checkall").prop("checked")) {
			//input태그의 name이 chk인 태그들을 찾아서 checked옵션을 true로 정의
			$("input[name=chk]").prop("checked", true);
			//클릭이 안되있으면
		} else {
			//input태그의 name이 chk인 태그들을 찾아서 checked옵션을 false로 정의
			$("input[name=chk]").prop("checked", false);
		}
	});

});
	
</script>
</head>
<body>
<c:if test="${msg!=null}">
	<script type="text/javascript">
		alert('${msg}');
	</script>
</c:if>
	<div class="container-scroller">
		<!-- header -->
		<nav class="navbar default-layout col-lg-12 col-12 p-0 fixed-top d-flex flex-row">
			<!-- 상단 로고 박스 -->
			<div class="text-center navbar-brand-wrapper d-flex align-items-top justify-content-center">
				<a class="navbar-brand brand-logo" href="MemberList">
					<img src="../resources/admin/images/logo.svg" alt="logo" />
				</a>
				<a class="navbar-brand brand-logo-mini" href="MemberList">
					<img src="../resources/admin/images/logo-mini.svg" alt="logo" />
				</a>
			</div>
			<!-- //상단 로고 박스 -->
			<!-- 상단 흰색 바 -->
			<div class="navbar-menu-wrapper d-flex align-items-center"></div>
			<!-- //상단 흰색 바 -->
		</nav>
		<!-- header -->
		<!-- main -->
		<div class="container-fluid page-body-wrapper">
			<!-- side menu -->
			<nav class="sidebar sidebar-offcanvas" id="sidebar">
				<ul class="nav">
					<!-- menu title -->
					<li class="nav-item nav-category">Main Menu</li>
					<!-- //menu title -->
					<!-- item -->
					<li class="nav-item">
						<a class="nav-link" href="MemberList"> 
							<i class="menu-icon typcn typcn-document-text"></i>
							<span class="menu-title">회원관리</span>
						</a>
					</li>
					<!-- //item -->
					<!-- item -->
					<li class="nav-item">
						<a class="nav-link" href="TicketingList">
							<i class="menu-icon typcn typcn-document-text"></i>
							<span class="menu-title">예매관리</span>
						</a>
					</li>
					<!-- //item -->
					<!-- item -->
					<li class="nav-item">
						<a class="nav-link" href="QuestionsList">
							<i class="menu-icon typcn typcn-document-text"></i>
							<span class="menu-title">Q&#38;A 답변관리</span>
						</a>
					</li>
					<!-- //item -->
				</ul>
			</nav>
			<!-- //side menu -->
			<!-- white box  -->
			<div class="main-panel">
				<!-- content box -->
				<div class="content-wrapper">
					<!-- white box -->
					<div class="col-lg-12 grid-margin stretch-card">
						<div class="card">
							<div class="card-body">
								<h3>Q&#38;A 리스트</h3>
								<br>
								<div class="form-group">
									<select id="test04" class="form-control col-sm-1">
										<option>전체</option>
										<option>email</option>
									</select>
									<input type="text" class="form-control col-sm-1" value="검색내용">
									<input type="button" class="btn btn-secondary" value="검색">
								</div>
								<!-- table -->
								<form action="questionDelete">
								<table class="table table-bordered" style="table-layout: fixed;">
									<thead>
										<tr>
											<th><input type="checkbox" id="checkall"></th>
											<th>seq</th>
											<th>작성자</th>
											<th>문의내역</th>
											<th>날짜</th>
											<th>비고</th>
										</tr>
									</thead>
									<tbody>
									<c:forEach var="li" items="${li}">
										<tr>
											<td><input type="checkbox" name="chk" value="${li.seq}"></td>
											<td>${li.seq}</td>
											<td>${li.email}</td>
											<td class="ellipsis" style="width:50%;">${li.content}</td>
											<td>${li.registration_date}</td>
											<c:if test="${li.answer_content==null}">
												<td>
													<a class="btn btn-primary" href="QuestionsDetail?seq=${li.seq}" style="color:#fff">답변 등록</a>
												</td>
											</c:if>
											<c:if test="${li.answer_content!=null}">
												<td>
													<a class="btn btn-primary" style="color:#fff">답변 완료</a>
												</td>
											</c:if>
											
										</tr>
									</c:forEach>
									</tbody>
								</table>
								<!-- //table -->
								
								<br>
								<div class="form-group">
									<button type="submit" class="btn btn-danger">삭제</button>
								</div>
								</form>
							</div>
						</div>
					</div>
					
					<!-- //white box -->
				</div>
				<!-- //content box -->
				<!-- footer -->
				<footer class="footer">
					<div class="container-fluid clearfix">
						<span class="text-muted d-block text-center text-sm-left d-sm-inline-block">Copyright © bootstrapdash.com 2020</span>
						<span class="float-none float-sm-right d-block mt-1 mt-sm-0 text-center">
							Free 
							<a href="https://www.bootstrapdash.com/bootstrap-admin-template/" target="_blank">Bootstrap admin templates</a> 
							from Bootstrapdash.com
						</span>
					</div>
				</footer>
				<!-- //footer -->
			</div>
			<!-- //white box  -->
		</div>
		<!-- //main -->
	</div>
</body>
</html>