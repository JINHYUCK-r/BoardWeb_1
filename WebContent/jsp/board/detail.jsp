<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<style>
	.container{
	margin: 10px auto;
	width: 1000px;
	height: 2000px;
	font-size : large;
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
	.material-icons{
	color : red;
	cursor: pointer;
	float : right;
	}
	.likenum{
	float : right;
	font-size: 16px;
	}
	h3{
	color : green;
	}
	#cmtFrm{
	margin : 10px auto 10px 100px;
	}
	#list{
	margin : auto auto auto 100px;
	}
	.cotainer_cmt{
	text-align: center;
	}
	

	
</style>
</head>
<body>
<div class ="container">
	<a href="/board/list" id="list"><button>글목록</button></a>
<table>
	<tr>
	<td width="20%">글번호 : ${vo.i_board}</td>
	<td width="60%">제목 : ${vo.title}
	
	<div class="likenum">${vo.likecnt}</div>
	<c:if test="${vo.yn_like == 0}">
	<span class="material-icons" onclick="togglelike()"> favorite_border </span>
	</c:if>
	<c:if test="${vo.yn_like == 1}">
	<span class="material-icons" onclick="togglelike()" >favorite</span>
	</c:if>
	
	
	
	</td>
	<td width="20%">작성자 : ${vo.nm} <br>
	<a href = "/board/regmod?i_board=${vo.i_board}"><button>글수정</button></a>
	<button onclick = "chk()" >글삭제</button>
	</td>
	</tr>
	<tr>
	<td colspan="3" height="500" style="
    padding: 20px; ">
	${vo.ctnt}
	</td>
	</tr>
</table>

	
    	
    	
    	<div class="cotainer_cmt">
    		<h3> 댓글 리스트 </h3>
    		<table class="table_cmt">
    			<tr class="cmtRow">
					<th>번호</th>
					<th>내용</th>
					<th>글쓴이</th>
					<th>등록일</th>
					<th>비고</th>
				</tr>
				
		    	<c:forEach items="${list}" var="item">
				<tr class="cmtRow">
					<td width="10%">${item.i_cmt} </td>
					<td width="50%">${item.cmt} </td>
					<td width="12%">
						${item.nm}
					</td>
					<td width="18%">${item.r_dt}</td>
					<td width="10%"> 
						<c:if test="${ loginUser.i_user == item.i_user }">
								<button onclick="updateCmt('${item.cmt}', '${item.i_cmt}')">수정</button>
	                    		<button onclick="clkCmtDel(${item.i_cmt})">삭제</button>
	            		</c:if>
					</td>
				</tr>
				</c:forEach>
			
    		</table>
    	</div>

	<div>
    		<form id="cmtFrm" action="/board/cmt" method="post">
    			<input type="hidden" name="i_cmt" value="0" class="i_cmtt">
    			<input type="hidden" name="i_board" value="${vo.i_board}">
    			<input type="hidden" name="i_user" value="${vo.i_user}">
    			<div class="cmt-buttons">
    				<input type="text" name="cmt" placeholder="댓글내용" class="cmt-box" value="">
    				<input type="submit" value="전송" id="cmtSubmit">
    				<input type="submit" value="취소" onclick="clkCmtCancel()">
    			</div>
    		</form>
    	</div>

</div>
<script>
function chk(){
	let chk = confirm("삭제하시겠습니까?");
	if(chk){
		location.href="/board/delete?i_board=${vo.i_board}";
	}else{
		location.href="/board/detail?i_board=${vo.i_board}";
	}
}
function togglelike(){
	location.href="/UserLikeSer?i_board=${vo.i_board}&yn_like=${vo.yn_like}&i_user=${vo.i_user}";
}

function updateCmt(cmt2, i_cmt2) {
	
	cmtFrm.i_cmt.value = i_cmt2;
	cmtFrm.cmt.value = cmt2;
	
	cmtSubmit.value = '수정';
}

function clkCmtCancel() {
	cmtFrm.i_cmt = 0;
	cmtFrm.cmt.value = '';
	cmtSubmit.value = '전송';
}

function clkCmtDel(i_cmt) {
	if(confirm('삭제하시겠습니까?')) {
		location.href = '/board/cmt?i_board=${vo.i_board}&i_cmt=' + i_cmt;
	}
}

</script>
</body>
</html>