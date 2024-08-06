<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 게시글 보기 </title>
</head>
<body>
	
    <a href="/board"> 목록으로 </a>
    <h2> 게시글 보기 </h2>
    

	<!-- 
	
		동작 내용
			- 글쓰기를 클릭하여 게시글 작성 페이지로 이동하고, 작성 버튼을 클릭하면 게시글 보기 페이지로 이동하여 작성한 내용을 출력한다.
		
		각 페이지 이동하기 위한 Mapping과 뷰 페이지에 데이터 출력 방법들을 작성하여 정상적으로 동작할 수 있게 하세요.
	
	
	 -->
	<h2>게시글 작성 결과</h2>
    <p>제목: ${title}</p>
    <p>작성자: ${writer}</p>
    <p>내용: ${content}</p>
    <p>비번 : ${boardPw }</p>
    
	
</body>
</html>