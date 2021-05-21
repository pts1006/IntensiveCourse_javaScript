<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.Date"%>

JSP 프로그래밍<br>

<%
	Date date = new Date(); /* 위에 직접 page import="~~.Date" 해줬음 */
%>

<%
	java.util.List<String> list = new java.util.ArrayList<>(); /* 아니면 이렇게 직접적으로 어디에 있는건지 다 치면 import 안해도 가능 */
	out.print(date);
%>
