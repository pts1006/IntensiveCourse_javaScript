<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>bulletinForm.jsp</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<!-- 제이쿼리 -->
<script src="//cdn.ckeditor.com/4.16.1/standard/ckeditor.js"></script>
<!-- CK에디터 -->

<script>
	$(function(){
		CKEDITOR.replace('content',{
			filebrowserUploadUrl : '${pageContext.request.contextPath }/fileUpload',
			height : '600px',
			width : '800px'
		});
	})
	
	function formCheck(){
		
		if(frm.title.value == ""){
			alert("제목을 입력하세요.");
			frm.title.focus();
			// 초점을 이곳에 맞추겠다.
			return false;
			// return false를 만나면 도중에 종료됨.
		}
		
		frm.submit();
	}
</script>
</head>
<body>
	<div align="center">

		<div>
			<H1>게시글 등록</H1>
		</div>

		<div>
			<form id="frm" action="bulletinInsert.do" method="post">
				<input type = "hidden" name = "id" value = "${id }">
				<div>
					<table border="1">
						<tr>
							<th width="150">제목</th>
							<td width="300"><input type="text" id="title" name="title">
							</td>
						</tr>
						<tr>
							<th width="150">내용</th>
							<td width="300"><textarea id="content" name="content"></textarea></td>
						</tr>
					</table>
				</div>
				<div>
					<button type="button" onclick="formCheck()">등록</button>
					<button type="reset">취소</button>
					<button type="button" onclick="location.href='bulletinList.do'">뒤로 가기</button>
				</div>
			</form>
		</div>
		
	</div>
</body>
</html>