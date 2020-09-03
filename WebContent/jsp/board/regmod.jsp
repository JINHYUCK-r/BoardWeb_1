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
<div><input type="text" name = "title" required></div>
<div><textarea name="ctnt" required></textarea></div>
<div><input type="submit" value="글작성"></div>
</form>
</body>
</html>