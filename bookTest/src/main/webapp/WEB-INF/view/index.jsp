<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 도서관리 </title>

<link rel="stylesheet" href="/css/default.css">


</head>
<body>
	
	<div id="wrap">
		<h2> 도서 관리 </h2>
		
		<div id="mainTitle">
			<h3> 등록 도서 목록 </h3>
			<a href="/bookWrite" id="enroll"> 도서 등록 </a>
		
		</div>
		<div id="bookListWrap">
			<ul id="bookList">
				<li class="blist">
					<span class="title"> 나혼자만 레벨업 </span>
					<span class="auth"> 추공 </span>
					<span class="bookCode"> 재밌네요</span>
					<span class="category"> 후속작이 나왔어요! </span>
				</li>
				<li class="blist">
					<span class="title"> 두 번 사는 랭커 </span>
					<span class="auth"> 사도연 </span>
					<span class="bookCode"> 이것도 재밌어요 </span>
					<span class="category"> 이건 시리즈물! </span>
				</li>
				<li class="blist">
					<span class="title"> 부서진 성좌의 귀환 </span>
					<span class="auth"> 사도연 </span>
					<span class="bookCode"> 두 번 사는 랭커의 후속작! </span>
					<span class="category"> 당연히 전작과 이어저요! </span>
				</li>
				<li class="blist">
					<span class="title">자바의 기초</span>
					<span class="auth"> </span>
					<span class="bookCode"></span>
					<span class="category"></span>
				</li>
				
			</ul>
		</div>
		
	</div>
</body>
</html>