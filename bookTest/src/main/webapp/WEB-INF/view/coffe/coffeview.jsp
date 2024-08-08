<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 도서관리 </title>

<link rel="stylesheet" href="/css/coffeDefault.css">


</head>
<body>
	<a href="/">HOME</a>
	
	<!-- 
	 컨트롤 : CoffeControl
	 서비스 : CoffeService
	 DTO : CoffeDto
	 DAO : CoffeDao
	
	 -->
	<div id="wrap">
		<h2> 카페 관리 </h2>
		
		<div id="mainTitle">
			<h3> 커피 목록 </h3>
			<a href="/CoffeWrite" id="coffeEnroll"> 커피 등록 </a>
		
		</div>
		<div id="CoffeListWrap">
			<ul id="CoffeList">
				<li class="blist">
					<span class="coffename"> 카페 라떼 </span>
					<span class="coffeprice"> 3000 </span>
				</li>
				<li class="blist">
					<span class="coffename"> 아메리카노 </span>
					<span class="coffeprice"> 2700 </span>
				</li>
				<li class="blist">
					<span class="coffename"> 딸기라떼 </span>
					<span class="coffeprice"> 5000 </span>
				</li>
				<li class="blist">
					<span class="coffename"> 카라멜마끼아또 </span>
					<span class="coffeprice"> 6000 </span>
				</li>


				
			</ul>
		</div>
		
	</div>
</body>
</html>