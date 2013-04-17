<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<link rel="stylesheet" href="styles/easyzoom.css" />
<style type="text/css">
.discount {
	text-decoration: line-through;
}
</style>
<script type="text/javascript">
	function editCart_BuyLinks() {
		quantity = document.getElementById("quantity").value;
		//alert(quantity);

		max_quantiy = document.getElementById("max_quantity").value;
		//alert((quantity-max_quantiy)<0);	
		if (((quantity - max_quantiy) > 0) || (quantity == 0) || (quantity < 0)) {
			document.getElementById("Error").innerText = "Please enter a value less than "
					+ max_quantiy;
			document.getElementById("cartLink").href = "#";
			document.getElementById("buyLink").href = "#";
		} else {
			document.getElementById("Error").innerText = " ";
			document.getElementById("cartLink").href = document
					.getElementById("cartHiddenLink").value
					+ quantity;
			document.getElementById("buyLink").href = document
					.getElementById("buyHiddenLink").value
					+ quantity;
		}
	}
</script>
<s:form id="myForm">
	<div class="large-3 columns">
		<div class="zoom-container">
			<a id="zoom-target"
				href="<%=request.getContextPath()%><s:property value="product.photo" />">
				<img class="zoom-image" width="300" height="250"
				alt="<s:property value="description" />"
				src="<%=request.getContextPath()%><s:property value="product.photo" />">
			</a>
		</div>
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
				<s:hidden name="product.quantity" id="max_quantity" />
				<b>Quantity:</b> <input type="text" step="1" min="1" value="1"
					name="quantity" onkeyup="editCart_BuyLinks()" id="quantity"
					style="width: 60px; display: inline;" value="1" />
				<div style="display: inline;">
					<s:if test="product.quantity==0">
						This product is out of stock currently.
					</s:if>
					<s:else>
						<s:property value="%{product.quantity}" />
					products available
					</s:else>
				</div>
				<label id="Error" style="color: red;"></label>

				<hr />
				<span class="<s:if test="(product.dealsId!=0)&&(offerExpired==false)">discount</s:if>"
					style="font-weight: bold; font-size: 1.2em;">Price: Rs. <s:property
						value="product.price"></s:property>
				</span> &nbsp; &nbsp;
				<s:if test="(product.dealsId!=0)&&(offerExpired==false)">
					<span style="font-weight: bold; font-size: 1.2em;"> After
						Discount: Rs. <s:property value="product.dealSellingPrice" />
					</span>
					<br />
						Offer valid till: <s:property value="product.dealEndDate" />
				</s:if>

				<div style="display: inline;">
					<a id="buyLink"
						href="buyProduct.action?productId=<s:property value="%{product.productId}"/>&qty=0"><input
						type="button" value="Buy Now" style="display: inline;"
						class="tiny button" /></a> <br>
				</div>

				<s:hidden id="buyHiddenLink"
					value="buyProduct.action?productId=%{product.productId}&qty="></s:hidden>
				<s:hidden id="cartHiddenLink"
					value="cartAction.action?productId=%{product.productId}&qty="></s:hidden>
				<hr>

				<a id="cartLink"
					href="cartAction.action?productId=<s:property value="%{product.productId}"/>&qty=0"><input
					type="button" value="Add to Cart" class="tiny button"
					style="display: inline;"></a> <br>
				<!-- Here this javascript function call will ensure that the hyperlink for buy now and add to cart are correct when this page is reached by pressing back button in browser-->
				<script type="text/javascript">
					editCart_BuyLinks();
				</script>
				<a id="watchLink"
					href="addWatchList.action?productId=<s:property value="%{product.productId}"/>"><input
					type="button" value="Add to watchlist" class="tiny button"
					style="display: inline;"></a>
				<hr>

			</div>
			<div class="columns large-4">
				<h4>
					<span data-tooltip class="has-tip"
						title="<s:property value="product.sellerId" />">Seller
						Information</span>
				</h4>
				<%-- 				<s:property value="product.sellerId" /> --%>
				<s:url var="url1" action="sellerdetails">
					<s:param name="sellerId" value="product.sellerId" />
				</s:url>

				<a href="<s:property value="#url1" />"> <s:property
						value="user.firstName" /> <s:property value="user.lastName" /></a>

			</div>
		</div>
	</div>
</s:form>
<script src="js/easyzoom.min.js"></script>
<script type="text/javascript">
	$(document)
			.ready(
					function() {
						$('#buyLink').click(function(){
							if($('#myForm').valid()){
								return true;
							}
							else{
								return false;
							}
						});
						
						$('#cartLink').click(function(){
							if($('#myForm').valid()){
								return true;
							}
							else{
								return false;
							}
						});
						$('#watchLink').click(function(){
							if($('#myForm').valid()){
								return true;
							}
							else{
								return false;
							}
						});
						$('#zoom-target').easyZoom();
						$("#myForm")
								.validate(
										{
											onkeyup : true,
											rules : {
												quantity : {
													maxlength : 6,
													digits : true,
													required : true,
													min : 1
												}
											},
											messages : {
												quantity : {
													digits : "Please enter integer value only",
													min : "At least 1 item should be entered in quanitity field"
												}
											}
										});

					});

	
</script>