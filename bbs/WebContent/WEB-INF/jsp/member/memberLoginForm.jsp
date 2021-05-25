<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberLoginForm.jsp</title>
<script>
	function formCheck(){
		
		if(frm.memberId.value == ""){
			
			alert("아뒤 입력")
			frm.memberId.focus();
			
			return false;
		}
		if(frm.memberPwd.value == ""){
			
			alert("비번 입력")
			frm.memberId.focus();
			
			return false;
		}
		
		frm.submit();
	}
</script>
</head>
<body>
	<div align = "center">
		<h1>로그인</h1>
		<form id = "frm" action="memberLogin.do" method = "POST">
			<div>
				<table border = "1">
					<tr>
						<th>아이디</th>
						<td><input type = "text" id = "memberId" name = "memberId"></td>
					</tr>
					<tr>
						<th>패스워드</th>
						<td><input type = "password" id = "memberPwd" name = "memberPwd"></td>
					</tr>
				</table>
			</div>
			<br>
			<div>
				<button type = "button" onclick = "formCheck()">로그인</button>
				<button type = "reset" onclick = >취소</button>
				<button type = "button" onclick = "location.href = 'main.do'">홈</button>
			</div>
		</form>
	</div>
</body>
</html>