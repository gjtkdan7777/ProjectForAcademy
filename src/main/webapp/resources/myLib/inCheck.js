/**
 *  member input Data 무결성 확인 function
 */
// ** member 오류 확인사항
// ID : 길이(4이상), 영문자,숫자 로만 구성
// password : 길이(4이상), 숫자와 특수문자로 구성, 특수문자는 반드시 1개 이상 포함할것
// Name : 길이(2이상), 영문 또는 한글로 만 입력
// Level : select 를 이용 (X)
// BirthDay : 입력 여부 확인  ( length == 10 )
// Point : 정수의 범위  ( 숫자이면서, '.'이 없어야함 )
// Weight: 구간 (20 ~ 200)
// 추천인 : 필수 사항이 아님 (X)

function validateEmail(sEmail) {
	var filter = /^([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;
	if (filter.test(sEmail)) {
		return true;
	}
	else {
		return false;
	}
}

// ** 작성 규칙
// => JavaScript function 으로 정의 하고 
//    결과를 true or false 로 return

function idCheck() {
	var email = $('#email').val();
	if ($.trim(email).length == 0) {
		$('#email').attr('placeholder','이메일을 입력해주세요.');
		return false;
	}else if(!validateEmail(email)){
		$('#email').val('').attr('placeholder','잘못된 이메일입니다');
		return false;
	}else {
		return true;
	}
}

function pwCheck() {
	var password = $('#password').val();
	var pLength = password.length;
	if (pLength < 4) {
		$('#pMessage').html('password는 5자 이상 입력해주세요. ');
		return false;
	} else if(password.replace(/[!-*]/gi,'').length>=pLength){
      	$('#pMessage').html('Password는 특수문자를 반드시 1개 이상 포함해야 됩니다 ~~');
        return false;
   }else if (password.replace(/[0-9.!-*]/gi,'').length>0){
      	$('#pMessage').html('Password는 숫자와 특수문자로만 입력하세요 ~~');
        return false;
   } else {
		$('#pMessage').html('');
		return true;
	}
} //pwCheck
function pw2Check() {
	var password = $("#password").val();
	var password2 = $('#password2').val();
	if(password != password2){
		$('#p2Message').html(' Password를 확인하세요.');
		return false;
	}else if(password2.length < 1){
		$('#p2Message').html(' Password를 입력해주세요.');
		return false;
	}else{
		$('#p2Message').html(' Password가 일치합니다.');
		return true;
		
	}
} //pw2Check

function bdCheck() {
	var birthd = $("#birthd").val();
	if (birthd.length != 10) {
		$('#birthd').val('').attr('placeholder','생일은 YYYY-MM-DD 정확하게 입력하세요');
		return false;
	} else {
		return true;
	}
} //bdCheck 

function phoCheck() {
	var phone = $("#phone").val();
	if (phone.length < 13) {
		$('#phoMessage').html('핸드폰 번호는 XXX-XXXX-XXXX 로 입력해주세요');
		return false;
	} else {
		$('#phoMessage').html('');
		return true;
	}
} //poCheck 