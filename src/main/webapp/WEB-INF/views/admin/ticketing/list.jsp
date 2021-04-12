<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예매관리</title>
<!-- admin common file setting -->
<c:import url="../common/adminSettings.jsp"></c:import>
</head>
<body>
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
								<h3>예매 리스트</h3>
								<br>
								<div class="form-group">
									<select id="test04" class="form-control col-sm-1">
										<option>전체</option>
										<option>예매 완료</option>
										<option>취소</option>
									</select>
									<input type="text" class="form-control col-sm-1" value="달력넣기">
									<input type="button" class="btn btn-secondary" value="검색">
								</div>
								<!-- table -->
								<table class="table table-bordered" style="table-layout: fixed;">
									<thead>
									
										<tr>
											<th><input type="checkbox"></th>
											<th>email</th>
											<th>출발</th>
											<th>도착</th>
											<th>날짜</th>
											<th>매수</th>
											<th>좌석</th>
											<th>상태</th>
											<th>비고</th>
										</tr>
									
									</thead>
									<tbody>
									<c:forEach var="li" items="${li}">
										<tr>
											<td><input type="checkbox" value="ticketing_number"></td>
											<td>${li.email}</td>
											<td>${li.departure_area}</td>
											<td>${li.destination}</td>
											<td>${li.departure_date}</td>
											<td>${li.number_of_tickets}</td>
											<td>${li.seat_number}</td>
											<td>${li.ticketing_status}</td>
											<td>
												<button type="button" class="btn btn-danger">예매 취소</button>
											</td>
										</tr>
									</c:forEach>
									</tbody>
								</table>
								<!-- //table -->
								<br>
								<div class="form-group">
									<button type="button" class="btn btn-danger">삭제</button>
								</div>
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