<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> bookDetail.jsp </title>
</head>
<body>
		<form method="get" action="/write">

	    	<p>책 제목 : ${book.getTitle()}</p>
	    	<p>출판사 : ${book.getPub()}</p>

		</form>

	
	
</body>
</html>