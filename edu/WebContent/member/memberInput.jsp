<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사용자 등록(memberInput.jsp)</title>
</head>
	
<!--

지금부터 만들 거
 
MVC
Model : 클래스 (클래스(Member), 서비스(Service), 디비처리(DAO))
View : 사용자에게 화면(jsp)
Controller : jsp(MVC1), servlet(MVC2)

memberInput.jsp (입력 화면)
~> memberProc.jsp (사용자 입력을 처리해 주는 화면)
~> MemberServlet.java (서비스 로직)
~> MemberDAO.java (실제 데이터 처리하는 곳)
~> OracleDBMS
~> memberOutput.jsp (출력 화면)


흐름을 알아보기 위해 하는 실습!
-->
<body>
	<form action = "memberProc.do" method = "post">
		ID : <input type = "text" name = "id"><br>
		PW : <input type = "password" name = "passwd"><br>
		Name : <input type = "text" name = "name"><br>
		Mail : <input type = "text" name = "mail"><br><br>
		<input type = "submit" value = "등록">
	</form>
</body>
</html>