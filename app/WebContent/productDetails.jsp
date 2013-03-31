<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div class="large-3 columns">
	<a class="th radius" data-reveal-id="myModal" href="#"> <img
		alt="<s:property value="description" />"
		src="<%=request.getContextPath()%><s:property value="product.photo" />">
	</a>
</div>
<div class="large-9 columns">
	<div class="row">
		<h2>
			<s:property value="product.title" />
		</h2>
		<p>
			<s:property value="product.description" />
		</p>
	</div>
	<div class="row">
		<div class="columns large-8">
			<s:textfield cssClass="" maxlength="4" size="4"
				name="product.quantity"></s:textfield>
			<hr />
			<h5>
				Price:
				<s:property value="product.price"></s:property>
			</h5>
			<hr />
			<%-- 			<s:submit --%>
			<%-- 				action="addtocart.action?productId=<s:property value="product.productId"/>"></s:submit> --%>
			<s:submit action="#url2" value="Buy Now" cssClass="button small"></s:submit>
			<s:submit action="#url1" value="Add to Cart" cssClass="button small"></s:submit>
			<s:url action="addtocart.action" var="url1">
				<s:param name="productId">product.productId</s:param>
			</s:url>
			<s:url action="buynow.action" var="url2">
				<s:param name="productId">product.productId</s:param>
			</s:url>
			<hr />
		</div>
		<div class="columns large-4">
			<h4>Seller Information</h4>
			Seller ID:
			<s:property value="product.sellerId" />

		</div>
	</div>
</div>

