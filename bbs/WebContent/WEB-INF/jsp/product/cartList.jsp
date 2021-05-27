<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<style>
	th, td{
		text-align : center;
	}
</style>
<center>
<table border="1">
	<tr>
		<th>상품 코드</th>
		<th>상품 명</th>
		<th>상품 가격</th>
		<th>상품 평점</th>
		<th>상품 이미지</th>
		<th>상품 개수</th>
	</tr>
	
	<c:forEach items="${list }" var="vo">
		<tr>
			<td>${vo.itemCode }</td>
			<td>${vo.itemName }</td>
			<td>${vo.salePrice }</td>
			<td>${vo.likeIt }</td>
			<td><img src="upload/${vo.itemImage }" width= "150px" height= "150px" /></td>
			<td>${vo.qty }</td>
		</tr>
	</c:forEach>
</table>
</center>