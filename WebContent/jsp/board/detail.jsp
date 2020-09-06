<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.container{
	margin: 0 auto;
	width: 1000px;
	height: 2000px;
	}
	table{
	margin: auto;
	width: 800px; 
	border : 2px solid black;
	border-collapse: collapse;  
	
	}
	td{
		border: 2px solid black;
	}
</style>
</head>
<body>
<div class ="container">
<table>
	<tr>
	<td width="10%">글번호 : ${vo.i_board}</td>
	<td width="70%">제목 : ${vo.title}</td>
	<td width="20%">작성자 : ${vo.nm}</td>
	</tr>
	<tr>
	<td colspan="3" height="800">
	내용: ${vo.ctnt}
	</td>
	</tr>
</table>

</div>
</body>
</html>