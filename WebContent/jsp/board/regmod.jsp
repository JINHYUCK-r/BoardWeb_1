<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글작성</title>
<style>
	h1{
		text-align : center;
	}
	.title{
		width : 500px;
		margin: 0 auto;
		margin-bottom : 10px;
		
	}
	.title input{
		width : 300px;
	}
	.content{
		margin: 0 auto;
		width: 500px;
	}
	.content textarea{
		width: 476px;
		height: 320px;
	}
	.button{
		margin-left : 900px;
	}
</style>
</head>
<body>
<div>
<h1>글작성</h1>
<form method="post" action="/board/regmod">
<input type="hidden" name="i_board" value=${vo.i_board}> 
<div class=title><input type="text" name = "title" required  placeholder="제목을 입력해세요." value=${vo.title}></div>
<div class=content><textarea name="ctnt" required placeholder ="내용">${vo.ctnt}</textarea></div>
<div class = button><input type="submit" value="${chk==false ? '글수정':'글작성' }"></div>
</form>
</div>
</body>
</html>