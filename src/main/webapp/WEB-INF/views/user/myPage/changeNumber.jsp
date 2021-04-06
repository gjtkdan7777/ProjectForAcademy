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
<link rel="stylesheet" type="text/css" href="../resources/user/css/myPage/changeNumber.css">
<script src="../resources/myLib/jquery-3.2.1.min.js"></script>
<script src="../resources/myLib/inCheck.js"></script>
<script>
var pCheck=false;
var poCheck=false;

$(function(){
	$('#password').focusout(function(){
		pCheck=pwCheck();
	}); // password
	
	$('#phone').focusout(function() {
		poCheck=phoCheck();
	}); //password2
});
	
function inCheck() {
	if (pCheck==false) {
		$('#pMessage').html(' Password 를 확인 하세요 ~~');
		$('#password').focus();
	}
	if (pCheck==true && poCheck==true) {
		if(confirm('변경하시겠습니까?')){
			return true;
		}else{
			return false;
		}
	}else {
      return false;   // submit 무효화 
	}
} //inCheck
	
 //ready
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
			<h2>휴대폰번호 변경</h2>
		</header>
		<!-- // header -->
		<!-- content -->
		<section id="content">
			<h3>현재 사이트에 등록된 비밀번호와 변경하실 새로운 휴대폰 번호를 입력하세요.</h3>
			<!-- content-box -->
			<form action="changeNumber" method="post">
			<div class="content-box">
				<!-- change-pn-box -->
				<div class="change-pn-box">
					<div class="area">
						<div class="input-box">
							<label for="pn">비밀번호</label>
							<input type="password" id="password" name="password" placeholder="비밀번호를 입력하세요."/>
							<br><span  id="pMessage" class="message"></span>
						</div>
					</div>
					<div class="area">
						<div class="input-box">
							<label for="phone">휴대폰번호</label>
							<input type="text" id="phone" name="phone" placeholder="휴대폰번호를 입력하세요."/>
							<br><span  id="phoMessage" class="message"></span>
						</div>
					</div>
				</div>
				<!-- // change-pn-box -->
			</div>
			<!-- // content-box -->
			<input type="submit" class="change-pn-btn" value="인증번호 발송" onclick="return inCheck()"/>
			<!-- content-box -->
		</form>
		</section>
		<!-- // content -->
		<!-- footer -->
		<c:import url="../common/footer.jsp"></c:import>
		<!-- // footer -->		
	</div>
	<!-- // main -->
	<!-- js -->
	<script src="../resources/user/js/myPage/changeNumber.js"></script>
</body>
</html>