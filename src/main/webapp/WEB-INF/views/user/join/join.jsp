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
<link rel="stylesheet" type="text/css" href="../resources/user/css/join/join.css">
<script src="../resources/myLib/jquery-3.2.1.min.js"></script>
<script src="../resources/myLib/inCheck.js"></script>
<script>
//** 입력 오류 확인 ( inCheck )
//1. 개별적 오류 확인을 위한 switch 변수 정의
var iCheck=false;
var pCheck=false;
var bCheck=false;
var poCheck=false;

//2. 개별적 focusout 이벤트리스너 function 작성 : JQuery,
$(function(){
	$('#email').focus();
	$('#email').focusout(function() {
		iCheck=idCheck();
	}); //id
	$('#password').focusout(function() {
		pCheck=pwCheck();
	}); //password
//password 재입력 동일성 확인
	$('#password2').focusout(function(){
		pCheck=pw2Check();
	}); // password2
	
	$('#birthd').focusout(function() {
		bCheck=bdCheck();
	}); //birthd

	$('#phone').focusout(function() {
		poCheck=phoCheck();
	}); //name
	
}); //ready

//3. 전체적으로 입력 오류 가 없음을 확인하고 submit 여부를 판단
function inCheck() {
	if (iCheck==false) {
		$('#iMessage').html(' ID 를 확인 하세요 ~~');
		$('#id').focus();
	}
	if (pCheck==false) {
		$('#pMessage').html(' Password 를 확인 하세요 ~~');
		$('#p2Message').html(' Password 재입력 확인 하세요 ~~');
		$('#password').focus();
	}
	if (bCheck==false) {
		$('#bMessage').html(' BirthDay 를 확인 하세요 ~~');
		$('#birthd').focus();
	}

	if (poCheck==false) {
		$('#poMessage').html(' Point 를 확인 하세요 ~~');
		$('#point').focus();
	}
	if (iCheck==true && pCheck==true &&	bCheck==true && poCheck==true) {
		if(confirm('~~ 입력 성공, 전송하시겠습니까?')){
			return true;
		}else{
			return false;
		}
	}else {
      return false;   // submit 무효화 
	}
} //inCheck



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
		<!-- header -->
		<header id="header">
			<h2>회원가입</h2>
		</header>
		<!-- // header -->
		<!-- content -->
		<section id="content">
			<h3>회원정보를 입력해주세요.</h3>
			<!-- content-box -->
			<form action="join" method="post">
			<div class="content-box">
				<!-- join-box -->
				<div class="join-box">
					<!-- input-box -->
					<div class="input-box">
						<label for="user-ID">아이디</label>
						<input type="text" id="email" name="email" value="${vo.email}" placeholder="이메일을 입력해 주세요."/>
					
					</div>
					<!-- // input-box -->
					<!-- input-box -->
					<div class="input-box">
						<label for="user-PW">비밀번호</label>
						<input type="password" id="password" name="password" value="${vo.password}" placeholder="영문 숫자 5자리 이상"/>
						<br><span  id="pMessage" class="message"></span>
					</div>
					<!-- // input-box -->
					<!-- input-box -->
					<div class="input-box">
						<label for="check-PW">비밀번호 확인</label>
						<input type="password" id="password2" placeholder="비밀번호를 재입력 하세요."/>
						<br><span  id="p2Message" class="message"></span>
					</div>
					<!-- // input-box -->
					<!-- select-box -->
					<div class="input-box">
						<label for="birthd">출생년도</label>
						<input type="text" id="birthd" name="birthd" value="${vo.birthd}" placeholder="YYYY-MM-DD"/>
					</div>
					<!-- // select-box -->
					<!-- input-box -->
					<div class="input-box">
						<label for="phone">휴대폰번호</label>
						<input type="text" id="phone" name="phone" value="${vo.phone}" placeholder="000-0000-0000"/>
						<br><span  id="phoMessage" class="message"></span>
					</div>
					<!-- // input-box -->
				</div>
				<!-- // join-box -->
			</div>
			<!-- // content-box -->
			<ul class="btn-box">
				<li><input type="submit" class="join-btn" value="회원가입" onclick="return inCheck()"/></li>
			</ul>
			</form>
			<ul class="text-box">
				<li>고객님의 이메일과 출생, 성별은 아이디와 비밀번호 분실 시 필요한 정보입니다.</li>
				<li>고객님의 출생과 성별은 더 나은 서비스를 위해 마케팅 정보로 활용됩니다.</li>
			</ul>
			
			
		</section>
		<!-- // content -->
		<!-- footer -->
		<c:import url="../common/footer.jsp"></c:import>
		<!-- // footer -->		
	</div>
	<!-- // main -->
</body>
</html>