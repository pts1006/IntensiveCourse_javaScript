<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<script>
	function noticeInsert(){
		let title = document.getElementsByName("nTitle")[0].value;
		let content = document.getElementsByName("nContent")[0].value;
		
		console.log(title);
		console.log(content);
		
		frm.title.value = title;
		frm.content.value = content;
		
		frm.submit();
	}
	
	function backToThePastPage(){
		
		alert("뒤로 감.");
		history.back();
	}
</script>
<div align = "center">
	<!-- 제목, 내용을 submit ~> noticeInsert.do ~> 리스트 페이지 -->
	<h3>공지사항 등록</h3>
	<form id = "frm" action = "noticeInsert.do" method = "POST">
		<input type = "hidden" name = "title">
		<input type = "hidden" name = "content">
	</form>
	<table border = "1">
		<tr>
			<th>제목</th>
			<td>
				<input name = "nTitle" type = "text" value = "${notice.title }">
			</td>
		</tr>
		<tr>
			<th>내용</th>
			<td>
				<input name = "nContent" type = "text" value = "${notice.content }">
			</td>
		</tr>
	</table>
	<div>
		<button type = "button" onclick = "noticeInsert()">등록</button>
		<button type = "button" onclick = "backToThePastPage()">나가기</button>
	</div>
</div>