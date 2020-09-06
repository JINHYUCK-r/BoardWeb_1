<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글작성</title>
</head>
<body>
<h1>글작성</h1>
<form method="post" action="/board/regmod">
<input type="hidden" name="i_board" value=${vo.i_board}> 
<div><input type="text" name = "title" required value=${vo.title}></div>
<div><textarea name="ctnt" required>${vo.ctnt}</textarea></div>
<div><input type="submit" value="${chk==false ? '글수정':'글작성' }"></div>
</form>
</body>
</html>