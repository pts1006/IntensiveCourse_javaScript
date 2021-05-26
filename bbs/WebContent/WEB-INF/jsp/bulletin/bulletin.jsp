<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<!-- 제이쿼리 -->
<script src="//cdn.ckeditor.com/4.16.1/full/ckeditor.js"></script>
<!-- CK에디터 -->

<script>
	$(function(){
		CKEDITOR.replace('content',{
			filebrowserUploadUrl : '${pageContext.request.contextPath }/fileUpload',
			height : '600px',
			width : '800px'
		});
	});
	
	function bulletinDelete(){
		
		let id = document.getElementsByName("id")[0].value;
		console.log(id);
		$.ajax({
			url : 'deleteServlet',
			data : {id},
			type : 'POST',
			success : function(resp){
				location.href="bulletinDelete.do";
			},
			error : function(err){
				console.log(err);
			}
		});
		
	}
	
	
/* 	
  	입력하기
 	
 	$('#updateBtn').click(function(e){
		
		let id = $('#id').val();
		let title = $('#title').val();
		let contetn = CKEDITOR.instances.content.getData();
		
		$.ajax({
			url : 'ajaxBulletinUpdate',
			data : {
				id : id,
				title : tite,
				content : content
			},
			type : 'post',
			success : function(){
				
			},
			error : function(){
				
			}
		});
	}); */
</script>

<div align = "center">

	<h3>게시판 내용 보기</h3>

	<form id = "frm" action = "bulletinUpdate.do" method = "POST">
		<table border="1">
			<tr>
				<th>순번</th>
				<td><input type = "hidden" name = "id" value = "${bulletin.id }">${bulletin.id }</td>
				<th>작성일자</th>
				<td>${bulletin.regDate }</td>
				<th>작성자</th>
				<td>${bulletin.writer }</td>
				<th>조회 수</th>
				<td>${bulletin.hit + 1}</td>
			</tr>
			<tr>
				<th>제목</th>
				<td colspan="7">
					<c:if test="${id eq bulletin.writer || id eq 'admin' }">
						<input name="title" type="text" value="${bulletin.title }">
					</c:if>
					<c:if test="${id ne bulletin.writer }">
						${bulletin.title }
					</c:if>
				</td>
			</tr>
			<tr>
				<th>내용</th>
				<td colspan="7">
					<c:if test="${id eq bulletin.writer || id eq 'admin'}">
						<textarea name = "content" rows="6" cols="90">${bulletin.content }</textarea>
					</c:if>
					<c:if test="${id ne bulletin.writer }">
						${bulletin.content }
					</c:if>
				</td>
			</tr>
		</table>
		<div>
			<button type="button" onclick="location.href='bulletinListPaging.do'">목록 보기</button>
			<c:if test="${id eq bulletin.writer || id eq 'admin'}">
				<button type="submit">수정</button>
				<button type="button" onclick = "bulletinDelete()">삭제</button>
			</c:if>
		</div>
	</form>
</div>