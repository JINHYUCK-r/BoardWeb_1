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
	<a href="/board/list"><button>글목</button></a>
<table>
	<tr>
	<td width="10%">글번호 : ${vo.i_board}</td>
	<td width="70%">제목 : ${vo.title}</td>
	<td width="20%">작성자 : ${vo.nm} <button onclick = "chk()" >글삭제</button>
	<a href = "/board/regmod?i_board=${vo.i_board}"><button>글수정</button></a>
	</td>
	</tr>
	<tr>
	<td colspan="3" height="800">
	내용: ${vo.ctnt}
	</td>
	</tr>
</table>



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

</script>
</body>
</html>