<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
	function formCheck(){
		
		if(frm.memberId.value == ""){
			alert("아이디를 입력하세요.");
			frm.memberId.focus();
			// 초점을 이곳에 맞추겠다.
			return false;
			// return false를 만나면 도중에 종료됨.
		}
		
		if(frm.idCheck.value == 'unChecked'){
			alert('중복 체크!');
			return false;
		}
		
		if(frm.memberPwd.value == ""){
			alert("비밀번호를 입력하세요.");
			frm.memberPwd.focus();			
			return false;
			// return false를 만나면 도중에 종료됨.
		}
		
		frm.submit();
	}
	
	$(function(){
		//document.ready 생략돼 있음.
		
		$('#idCheck').click(function(){
			
			if($('#memberId').val() == ""){
				alert('아이디 입력!');
				$('#memberId').focus();
				return;
			};
			
			$.ajax({
				
				url : 'ajaxMemberIdCheck',
				data : {id : $('#memberId').val()},
				type : 'POST',
				success : function(data){
					console.log(data);
					if(data != 0){
						alert('이미 존재하는 아이디. 다른 아이디 입력!');
						$('#memberId').val("");
						$('#memberId').focus();
						
					} else {
						alert('가능!');
						$('#idCheck').val('checked');
						$('#memberPwd').focus();
					}
				},
				error : function(err){
					console.log(err);
				}
			})
		});
	});
	
</script>

<div align="center">
	<div>
		<H1>회원 가입</H1>
	</div>
	<div>
		<form id="frm" action="memberJoin.do" method="post">
			<div>
				<table border="1">
					<tr>
						<th width="150">아이디</th>
						<td width="300">
							<input type="text" id="memberId" name="memberId">
							<button type = "button" id = "idCheck" value = "unChecked">중복 체크</button>
						</td>
					</tr>
					<tr>
						<th width="150">비밀번호</th>
						<td width="300"><input type="password" id="memberPwd" name="memberPwd"></td>
					</tr>
					<tr>
						<th width="150">이름</th>
						<td width="300"><input type="text" id="memberName" name="memberName"></td>
					</tr>
					<tr>
						<th width="150">주소</th>
						<td width="300"><input type="text" id="memberAddress" name="memberAddress"></td>
					</tr>
				</table>
			</div>
			<div>
				<button type = "button" onclick = "formCheck()">회원 가입</button>
				<button type = "reset">취소</button>
				<button type = "button" onclick = "location.href='main.do'">홈</button>
			</div>
		</form>
	</div>
</div>