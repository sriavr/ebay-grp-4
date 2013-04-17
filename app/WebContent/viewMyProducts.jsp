<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div class="row">
	<div class="results-outer large-9 columns">
		<s:if test="products.size() == 0">
			<h2>Your search returned no results!</h2>
		</s:if>
		<s:iterator value="products">
			<div class="row padding-4">

				<div class="large-3 columns">
					<s:url action="perticularSellerProductDetails" var="urlTag">
						<s:param name="productId" value="productId"></s:param>
					</s:url>
					<s:url action="addDeals" var="urlTag1">
						<s:param name="productId" value="productId"></s:param>
					</s:url>
					<s:url action="createListing" var="urlTag2">
						<s:param name="productId" value="productId"></s:param>
					</s:url>
					<!-- Added by Pratibind .Need to move it to view SOld products -->
					<s:url action="viewFeedback" var="urlTag3">
						<s:param name="productID" value="productId"></s:param>
					</s:url>
					
					<!-- End of addition -->
					<a class="th radius" data-reveal-id="myModal" href="#"> <img
						alt="<s:property value="description" />"
						src="<%=request.getContextPath()%><s:property value="photo" />">
					</a> <img id="myModal" class="reveal-modal large"
						alt="<s:property value="description" />"
						src="<%=request.getContextPath()%><s:property value="photo" />">

				</div>
				<div class="large-6 columns">
					Name: <a href="<s:property value="#urlTag"></s:property>"> <s:text
							name="title"></s:text></a> <br> Product ID:
					<s:property value="productId" />
					<br> Description:
					<s:property value="description" />
					<br> Price:
					<s:property value="price" />
					<br> Discount Present:
					<s:property value="discount" />
					<br>
					<a href="<s:property value="#urlTag1"></s:property>" class="small button round">Add Deal</a>
					<br>
					<a href="<s:property value="#urlTag2"></s:property>" class="small button round">Modify </a>
					
				</div>
			</div>
			<hr />
		</s:iterator>
<!-- 		<div class="pagination-centered"> -->
<!-- 			<ul class="pagination"> -->
<!-- 				<li class="arrow unavailable"><a href="">&laquo;</a></li> -->
<!-- 				<li class="current"><a href="">1</a></li> -->
<!-- 				<li><a href="">2</a></li> -->
<!-- 				<li><a href="">3</a></li> -->
<!-- 				<li><a href="">4</a></li> -->
<!-- 				<li class="unavailable"><a href="">&hellip;</a></li> -->
<!-- 				<li><a href="">12</a></li> -->
<!-- 				<li><a href="">13</a></li> -->
<!-- 				<li class="arrow"><a href="">&raquo;</a></li> -->
<!-- 			</ul> -->
<!-- 		</div> -->
	</div>
</div>
