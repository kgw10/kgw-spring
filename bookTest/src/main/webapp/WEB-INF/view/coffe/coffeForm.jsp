<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="/css/coffeWrite.css">

</head>
<body>

	<div id="Wrap">
		<a href="/coffeReg">HOME</a>
		<h3 id="coffeCount">${count }잔 주문 완료</h3>
		
		<form method="post" action="/CoffeForm">
			<div id="coffeWrap">
				<div class="inputField">
					<label for="itemName"> 음료 </label>
					<input type="text" name="itemName" id="itemName">
				</div>
				<div class="inputField">
					<label for="price">가격</label>
					<input type="number" name="price" id="price">
				</div>
				<div class="inputField">
					<label for="decaffein">디카페인</label>
					<input type="text" name="decaffein" id="decaffein">
				</div>
				<button id="bt">등록</button>
			</div>
		</form>
		
	</div>

</body>
</html>