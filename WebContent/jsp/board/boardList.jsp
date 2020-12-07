<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <!--  jstl 라이브러리 추가 --> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판보드</title>
<style>
	#container{
		margin : 0 auto;
		width: 100%;
	}
	table {
		width: 1100px;
		margin : 20px auto;
		border-collapse: collapse;
	}
	table th, td{
		height: 30px;
		text-align : center;
		border : 1px solid black;
	}
	
	table th {
		background-color: #22AB4B;
	}
	
	.write {
		margin: 20px 0px 20px 1200px;
	}
	h1 {
		display: block;
		margin: 0 auto;
		text-align: center;
	 }
	 .title{
	 width : 400px;
	 }
	 .page{
	 	text-align : center;
	 
	 }
	 td a{
	 	text-decoration: none;
	 	color : black;
	 }
	 tr:hover {
		background-color : #ABF9A0;
	}
</style>
</head>
<body>
<div id=container>
	<div>${loginUser.nm}님 하이 <a href = "/logout"><button>로그아웃</button></a></div>
	<h1>IT/ Education 정보공유 </h1>
	<a class=write href="/board/regmod"><button>글쓰기</button></a>
	<table>
		<tr>
		<th>글번호</th>
		<th class=title>제목</th>
		<th>글쓴이</th>
		<th>작성일자</th>
		<th>좋아요</th>
		</tr>
		<!--tl식을 이용하여 값을 반복해 뿌리 -->
		<c:forEach var="item" items="${list}" >
		<tr>
			<td>${item.i_board}</td>
			<td><a href="/board/detail?i_board=${item.i_board}">${item.title}</a></td>
			<td>${item.nm }</td>
			<td>${item.r_dt }</td>
			<td>${item.likecnt }</td>
		</tr>
		</c:forEach>
	</table>
	<!--페이징을 보여주는  -->
	<div class=page>
		<c:forEach var="item" begin="1" step="1" end="${pagingCnt}">
			<span class="page"><a href="/board/list?page=${item}">${item}</a></span>
		</c:forEach>
	</div>

</div>
</body>

</html>