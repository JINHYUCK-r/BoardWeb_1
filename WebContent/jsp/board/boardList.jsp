<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <!--  jstl 라이브러리 추가 --> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판보드</title>
</head>
<body>
<div>${loginUser.nm}님 하이 </div>
<h1>게시판 </h1>
<a href="/board/regmod"><button>글쓰기</button></a>
<table>
	<tr>
	<th>글번호</th>
	<th>제목</th>
	<th>글쓴이</th>
	<th>작성일자</th>
	</tr>
	<!--tl식을 이용하여 값을 반복해 뿌리 -->
	<c:forEach var="item" items="${list}" >
	<tr>
		<td>${item.i_board}</td>
		<td><a href="/board/detail?i_board=${item.i_board}">${item.title}</a></td>
		<td>${item.nm }</td>
		<td>${item.r_dt }</td>
	</tr>
	</c:forEach>
</table>
<!--페이징을 보여주는  -->
<div>
	<c:forEach var="item" begin="1" step="1" end="${pagingCnt}">
		<span class="page"><a href="/board/list?page=${item}">${item}</a></span>
	</c:forEach>
</div>


</body>
</html>