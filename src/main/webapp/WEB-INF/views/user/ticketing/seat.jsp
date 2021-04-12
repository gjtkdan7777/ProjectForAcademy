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
<link rel="stylesheet" type="text/css" href="../resources/user/css/ticketing/seat.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
	// 날짜 출력
	let today = new Date();   
	let year = today.getFullYear(); // 년도
	let month = today.getMonth() + 1;  // 월
	let date = today.getDate();  // 날짜
	let day = today.getDay();  // 요일

	var week = new Array('일','월','화','수','목','금','토');
	
function check(){ 
	var select_obj = '';
	var check_length = $('input:checkbox[name=seat]:checked').length;
   
	$('input[type="checkbox"]:checked').each(function (index) {
        if (index != 0) {
            select_obj += ', ';
        }
        select_obj += $(this).val();
    });
    	$('#seat_length').text(check_length);
    	 
    	$('#seatresult').text(select_obj);
    	$('#seatresult2').text(select_obj);
    	
    	$('#priceresult').text(check_length * 1000);
    	$('#priceresult2').text(check_length * 1000);
}
	
$(document).ready(function() {
	$('.payment-btn').click(function(){
		
		var departure_area = $('#departure_area').text();
		var destination = $('#destination').text();
		var number_of_tickets = $('#seat_length').text();
		var seat_number = $('#seatresult2').text();
		var departure_date = $('#departure_date').text();
		var bus_name = $('#bus_name').text();
		
		location.replace('buyTicket?departure_area='+departure_area
						+'&destination='+destination
						+'&number_of_tickets='+number_of_tickets
						+'&seat_number='+seat_number
						+'&departure_date='+departure_date
						+'&bus_name='+bus_name
						+''
						);
		
		/* var allData = {
				"departure_area" : departure_area,
				"destination" : destination,
				"number_of_tickets" : number_of_tickets,
				"seat_number" : seat_number,
				"departure_date" : departure_date,
				"bus_name" : bus_name
		};
		if(confirm('구매하시겠습니까?')){
		 $.ajax({
		        url:"buyTicket",
		        type:'POST',
		        data: allData,
		        error:function(){
		        	alert('다시 시도해주세요 정상적으로 예매가 되지 않았습니다.');S
		        }
		    });
		} */
		
		/* console.log(departure_area);
		console.log(destination);
		console.log(number_of_tickets);
		console.log(seat_number);
		console.log(departure_date);
		console.log(bus_name); */
	});
});

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
			<h2>고속버스예매</h2>
		</header>
		<!-- // header -->
		<!-- sub-pame-menu -->
		<ul id="sub-pame-menu">
			<li><a href="main">HOME</a></li>
			<li>고속버스예매</li>
		</ul>
		<!-- // sub-pame-menu -->
		<!-- content -->
		<section id="content" class="seat-data-box">
			<h3>매수 및 좌석선택</h3>
			<!-- content-box -->
			<div class="content-box">
				<!-- info-box -->
				<div class="info-box">
					<div class="date-box">2021. 3. 31. 수</div>
					<div class="time-box"><span>출발</span><span>${vo.departure_time}</span></div>
					<div class="terminal-box">
						<div class="start">
							<div class="round">출발</div>
							<div class="text">${vo.departure_area}</div>
						</div>
						<div class="end">
							<div class="round">도착</div>
							<div class="text">${vo.destination}</div>
						</div>
					</div>
				</div>
				<!-- // info-box -->
				<!-- detail-box -->
				<div class="detail-box">
					<div class="detail-head-box">
						<div class="seat">잔여 ${vo.remaining_seats}석 / 전체 28석</div>
					</div>
					<div class="detail-body-box">
						<div class="select-seat-box">
							<div class="seat-bg">
								<div class="seat-list" >
									<!-- item -->
										<c:forEach var="li" items="${li}" varStatus="st">
											<c:if test="${li.available_seat==0}">
												<div class="seat-area" >
													<input type="checkbox" name="seat" id="seat0+${st.count}" value="${st.count}" 
													onclick="check(this)" />
													<label for="seat0+${st.count}">${st.count}</label>
												</div>
											</c:if>
											<c:if test="${li.available_seat==1}">
												<div class="seat-area disabled"  >
													<label>${st.count}</label>
												</div>
											</c:if>
										</c:forEach>
								</div>
							</div>
						</div>
						<div class="select-data-box">
							<div class="seat-info">
								<div class="text">선택좌석</div>
								<div class="seat-number" id="seatresult"></div>
							</div>
							<div class="price-info">
								<span class="text">총 결제금액</span>
								<span class="price" id="priceresult"></span>
							</div>
							<input type="button" class="seat-btn" value="선택완료"/>
						</div>
					</div>
				</div>
				<!-- // detail-box -->
			</div>
			<!-- // content-box -->
			<!-- text-box -->
			<ul class="text-box">
				<li>심야 시간대 출발차량의 1번부터 9번 좌석까지는 여성고객 및 노약자를 위한 좌석으로 운영되고 있습니다. 교통 약자를 위해 배려해 주시기 바랍니다.</li>
				<li>일부 버스의 경우 실제 좌석배치와 다를 수 있습니다.</li>
				<li><span class="square-orange">색상표기 좌석</span>은 여성고객 및 노약자를 위한 좌석입니다. 배려해 주시기 바랍니다.</li>
			</ul>
			<!-- // text-box -->
		</section>
		<!-- // content -->
		<!-- content -->
		<section id="content" class="payment-data-box">
			<h3>가는 편 승차권 정보</h3>
			<!-- content-box -->
			<div class="content-box">
				<div class="payment-head-box" id="departure_date">${serverTime} ${vo.departure_time}시</div>
				<div class="payment-body-box">
					<div class="right-box">
						<div class="start">
							<div class="round">출발</div>
							<div class="text" id="departure_area">${vo.departure_area}</div>
						</div>
						<div class="end">
							<div class="round">도착</div>
							<div class="text" id="destination">${vo.destination}</div>
						</div>
					</div>
					<div class="left-box">
						<div class="basics-box">
							<div>매수</div>
							<div id="seat_length"></div>
						</div>
						<div class="basics-box">
							<div>좌석</div>
							<div id="seatresult2"></div>
						</div>
						<div class="price-box">
							<div>총 결제금액</div>
							<div id="priceresult2"></div>
						</div>
						<div class="price-box" hidden="true">
							<div hidden="true">버스이름</div>
							<div id="bus_name" hidden="true">${vo.bus_name}</div>
						</div>
					</div>
				</div>
			</div>
			<!-- // content-box -->
			<input type="button" class="payment-btn" value="결제하기"/>
		</section>
		<!-- // content -->
		<!-- footer -->
		<c:import url="../common/footer.jsp"></c:import>
		<!-- // footer -->		
	</div>
	<!-- // main -->
	<!-- js -->
	<script src="../resources/user/js/ticketing/seat.js"></script>
</body>
</html>