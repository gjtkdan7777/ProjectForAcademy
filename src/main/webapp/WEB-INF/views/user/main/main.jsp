<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>고속버스통합예매</title>
<!-- user common file setting -->
<c:import url="../common/userSettings.jsp"></c:import>
<!-- css -->
<link rel="stylesheet" type="text/css" href="../resources/user/css/main/main.css">
<script>
// Buton 으로 현재 입력 & 선택한 keyword와 searchType을 queryString으로 보내기 때문에 
// makeQuery()메서드를 사용해야함 
// $(document).ready(function(){....})
	$(function(){
		$('#searchBtn').on("click",function(){
			location.href="search?area="+$('#area').val();
		});// click
	}); // ready
	
	// 날짜 출력
	let today = new Date();   
	let year = today.getFullYear(); // 년도
	let month = today.getMonth() + 1;  // 월
	let date = today.getDate();  // 날짜
	
	
	let day = today.getDay();  // 요일

</script>
</head>
<body>
	<c:if test="${msg!=null}">
		<script>
			alert('${msg}');
		</script>
	</c:if>
	<!-- side-manu -->
	<c:import url="../common/sideMenu.jsp"></c:import>
	<!-- // side-manu -->
	<!-- main -->
	<div id="main">
		<!-- top-menu -->
		<c:import url="../common/topMenu.jsp"></c:import>
		<!-- // top-menu -->
		<!-- main-box -->
		<div id="main-box">
			<h2>즐거운 여행의 시작과 끝, 프리미엄 버스와 함께!</h2>
			<!-- main-tap -->
			<ul class="main-tap">
				<li class="active">
					<div class="main-tab-img"></div>
					<p>고속버스예매</p>
				</li>
				<li>
					<div class="main-tab-img"></div>
					<p>예매확인</p>
				</li>
			</ul>
			<!-- // main-tap -->
			<!-- main_content -->
			<div class="main-content ticketing">
				<div class="tab-content">
					<div class="place">
						<p class="title">출발지</p>
						<select name="area" id="area">
							<option value="gangwon" >강원</option>
							<option value="gyeonggi">경기</option>
							<option value="gyeongnam">경남</option>
							<option value="gyeongbuk">경북</option>
							<option value="gwangju">광주</option>
							<option value="daegu">대구</option>
							<option value="daejeon">대전</option>
							<option value="busan">부산</option>
							<option value="seoul">서울</option>
							<option value="ulsan">울산</option>
							<option value="incheon">인천</option>
							<option value="jeonnam">전남</option>
							<option value="jeonbuk">전북</option>
							<option value="chungnam">충남</option>
							<option value="chungbuk">충북</option>
						</select>
					</div>
					<div class="date">
						<p class="title">가는날</p>
						<p class="text"><script> document.write(year + '년 ' + month + '월 ' + date + '일');</script></p>
					</div>
				</div> 
				<input type="button" class="main-content-btn" value="조회하기" id="searchBtn">
			</div>
			<!-- // main_content -->
			<!-- main_content -->
			<div class="main-content ticket">
<c:if test="">
				<!-- detail-ticket -->
				<div class="detail-ticket">
					<div class="detail-ticket-head">
						<p class="date">2021. 03. 31 (수) 17:00 출발</p>
					</div>
					<div class="detail-ticket-body">
						<!-- place -->
						<div class="detail-ticket-area place">
							<div class="detail-ticket-box">
								<div class="round">출발</div>
								<p>동서울</p>
							</div>
							<div class="detail-ticket-box">
								<div class="round">도착</div>
								<p>강릉</p>
							</div>
						</div>
						<!-- // place -->
						<!-- info -->
						<div class="detail-ticket-area info">
							<span class="name">좌석번호</span><span class="number">19</span>
						</div>
						<!-- // info -->
					</div>
				</div>
				<!-- // detail-ticket -->
				<a href="#e" class="page-move">
					자세히 보기
					<img src="../resources/user/images/main/main_more.png" alt="page-move" title="page-move" />
				</a>
</c:if>
				<!-- no-ticket -->
				<div class="no-ticket">
					<img src="../resources/user/images/main/ico_no_ticket.png" alt="no_ticket" alt="no_ticket"/>
					<p>예매내역이 없습니다.</p>
				</div>
				<!-- //no-ticket -->
			</div>
			<!-- // main_content -->
		</div>
		<!-- // main-box -->
		<!-- banner -->
		<div id="banner">
			<div class="banner-content">
				<p class="title">프리미엄 골드 익스프레스</p>
				<p class="text">도로 위 비즈니스 클래스 프리미엄 고속버스</p>
			</div>
			<div class="banner-content">
				<p class="title">ZERODAY EXPRESS</p>
				<p class="text">고속버스 당일배송 온라인 택배신청</p>
			</div>
			<div class="banner-content">
				<p class="title">All Pass 신한카드 출시</p>
				<p class="text">고속/시외버스 앱 결제시 30% 할인</p>
			</div>
			<div class="banner-content">
				<p class="title">이용안내</p>
				<a href="terminal" class="terminal-info">
					<img src="../resources/user/images/main/ico_info4.png" alt="terminal" title="terminal" />
					<span>터미널안내</span>
				</a>
			</div>
		</div>
		<!-- // banner -->
		<!-- footer -->
		<footer id="footer">
			<ul class="banner-logo">
				<li><img src="../resources/user/images/main/foot1_s.png" alt="banner-logo" title="banner-logo"/></li>
				<li><img src="../resources/user/images/main/foot2_s.png" alt="banner-logo" title="banner-logo"/></li>
				<li><img src="../resources/user/images/main/foot3_s.png" alt="banner-logo" title="banner-logo"/></li>
				<li><img src="../resources/user/images/main/foot4_s.png" alt="banner-logo" title="banner-logo"/></li>
				<li><img src="../resources/user/images/main/foot5_s.png" alt="banner-logo" title="banner-logo"/></li>
				<li><img src="../resources/user/images/main/foot6_s.png" alt="banner-logo" title="banner-logo"/></li>
				<li><img src="../resources/user/images/main/foot7_s.png" alt="banner-logo" title="banner-logo"/></li>
				<li><img src="../resources/user/images/main/foot8_s.png" alt="banner-logo" title="banner-logo"/></li>
			</ul>
			<ul class="sub-menu">
				<li>서비스 이용약관</li>
				<li>개인정보 처리방침</li>
				<li>고속버스 운송약관</li>
				<li>티머니</li>
				<li>고객센터 1644-9030</li>
			</ul>
			<p class="company-info">서울특별시 서초구 신반포로 194 통신판매업신고: 2009-서울서초 0587호 대표자 : 이광재</p>
			<p class="copyright">COPYRIGHT© 2016. WWW.KOBUS.CO.KR . ALL RIGHT RESERVED</p>
			<ul class="company-info2">
				<li><img src="../resources/user/images/main/foot_com1.png" alt="banner" title="banner" /></li>
				<li><img src="../resources/user/images/main/foot_com2.png" alt="banner" title="banner" /></li>
			</ul>
		</footer>
		<!-- // footer -->
	</div>
	<!-- // main -->
	<!-- js -->
	<script src="../resources/user/js/main/main.js"></script>
</body>
</html>