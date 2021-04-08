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
<link rel="stylesheet" type="text/css" href="../resources/user/css/qna/register.css">
<script src="../resources/myLib/jquery-3.2.1.min.js"></script>
<script>
	$(function(){
		$('#submit').on("click",function(){
			var content = $('#textarea').val();
			location.href="contentSub?content="+content;
		});// click
	}); // ready
	
</script>
</head>
<body>
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
			<h2>자주하는 질문</h2>
		</header>
		<!-- // header -->
		<!-- sub-pame-menu -->
		<ul id="sub-pame-menu">
			<li><a href="main">HOME</a></li>
			<li>고객센터</li>
			<li>자주하는 질문</li>
		</ul>
		<!-- // sub-pame-menu -->
		<!-- content -->
		<section id="content">
			<h3>고객님들이 문의 내역을 등록해 주세요.</h3>
			<!-- content-box -->
			<div class="content-box">
				<!-- data-box -->
				<div class="data-box" id="content">
					<textarea id="textarea" placeholder="문의 내역을 등록해 주세요."></textarea>
				</div>
				<!-- // data-box -->
				<input type="button" class="register-btn" value="등록" id="submit"/>
			</div>
			<!-- // content-box -->
		</section>
		<!-- // content -->
		<!-- footer -->
		<c:import url="../common/footer.jsp"></c:import>
		<!-- // footer -->	
	</div>
	<!-- // main -->
</body>
</html>