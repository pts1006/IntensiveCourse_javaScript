<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test = "${empty member }">
	<h1>Welcome Guest</h1>
</c:if>
<c:if test = "${not empty member }">
	<h1>Welcome ${member.name }</h1>
</c:if>
<!--

	여기서 "c:if"
	request.setAttribute("member", ???);	페이지 당 정보 유지 객체
	session.setAttribute("member", ???);	클라이언트 단위 정보 저장 객체
	contextPath.setAttribute("member", ???);	
	
	차례대로 "~가 없으면 밑으로 가서 ~"
-->