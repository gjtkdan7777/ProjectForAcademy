<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<ul>
	<li><a href="admin/MemberList">Admin Member List</a></li>
	<li><a href="admin/MemberModify">Admin Member Modify</a></li>
	<li><a href="admin/TicketingList">Admin ticketing List</a></li>
	<li><a href="admin/TicketingModify">Admin ticketing Modify</a></li>
	<li><a href="admin/QuestionsList">Admin questions List</a></li>
	<li><a href="admin/QuestionsDetail">Admin questions Detail</a></li>
</ul>
<hr>
<ul>
	<li><a href="user/mainf">User Main</a></li>
	<li><a href="user/loginf">User login</a></li>
	<li><a href="user/findIDf">User find ID</a></li>
	<li><a href="user/findPWf">User find PW</a></li>
	<li><a href="user/joinf">User join</a></li>
	<li><a href="user/search">User ticketing search</a></li>
	<li><a href="user/seat">User ticketing seat</a></li>
	<li><a href="user/myPage">User myPage</a></li>
	<li><a href="user/changeNumber">User change phone number</a></li>
	<li><a href="user/changePW">User change PW</a></li>
	<li><a href="user/ticketList">User ticket List</a></li>
	<li><a href="user/terminal">User terminal</a></li>
	<li><a href="user/qnaList">User QnA list</a></li>
	<li><a href="user/qnaRegister">User QnA register</a></li>
</ul>

</body>
</html>
