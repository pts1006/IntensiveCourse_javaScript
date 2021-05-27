<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<section class="py-5">
	<div class="container px-4 px-lg-5 mt-5">
		<div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">

			<!-- 첫 번째 데이터 (샘플용)-->
			<div class="col mb-5">
				<div class="card h-100">
					<!-- Product image-->
					<img class="card-img-top"
						src="https://dummyimage.com/450x300/dee2e6/6c757d.jpg" alt="..." />
					<!-- Product details-->
					<div class="card-body p-4">
						<div class="text-center">
							<!-- Product name-->
							<h5 class="fw-bolder">Fancy Product</h5>
							<!-- Product price-->
							$40.00 - $80.00
						</div>
					</div>
					<!-- Product actions-->
					<div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
						<div class="text-center">
							<a class="btn btn-outline-dark mt-auto" href="#">View options</a>
						</div>
					</div>
				</div>
			</div>

			<!-- 두 번째 데이터 (활용용)-->
			<c:forEach items = "${list }" var = "vo">
			<div class="col mb-5">
				<div class="card h-100">
					<!-- Sale badge-->
					<div class="badge bg-dark text-white position-absolute"
						style="top: 0.5rem; right: 0.5rem">Sale</div>
					<!-- Product image-->
					<img class="card-img-top"
						src="upload/${vo.itemImage }" width= "268px" height= "180px" alt="..." />
						<!-- 이미지 크기를 설정할 때 style을 적어서 style = "width: (x)px; height: (y)px;"로 하면 창 크기가 달라졌을 때 이미지 튀어나가는 현상 발생 -->
					<!-- Product details-->
					<div class="card-body p-4">
						<div class="text-center">
							<!-- Product name-->
							<h5 class="fw-bolder">${vo.itemName }</h5>
							<!-- Product reviews-->
							<div
								class="d-flex justify-content-center small text-warning mb-2">
								<c:forEach begin = "1" end = "${vo.likeIt }">
									<div class="bi-star-fill"></div>
								</c:forEach>
							</div>
							<!-- Product price-->
							<c:if test = "${vo.sale eq 'Y' || vo.sale eq 'y' }">
								<span class="text-muted text-decoration-line-through">
									<fmt:formatNumber type = "currency" value = "${vo.price }"></fmt:formatNumber>
								</span>
							</c:if>
							<br>
							<fmt:formatNumber type = "currency" value = "${vo.salePrice }"></fmt:formatNumber>
						</div>
					</div>
					<!-- Product actions-->
					<div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
						<div class="text-center">
							<a class="btn btn-outline-dark mt-auto" onclick="addCnt('${vo.itemCode }')">Add to cart</a>
						</div>
					</div>
				</div>
			</div>
			</c:forEach>
		</div>
	</div>
</section>
<script>
	function addCnt(itemCode){
		
		$.ajax({
			url : '${pageContext.request.contextPath}/addCart.do',
			data : {
				id: '${id }',
				itemCode : itemCode
			},
			success : function(resp){
				location.href = "productList.do";
				console.log(resp);
			},
			error : function(err){
				console.log(err);
			}
		});
	}
</script>