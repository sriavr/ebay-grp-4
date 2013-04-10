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
			<s:hidden name="product.quantity" id="max_quantity" />
			<b>Quantity:</b> <input type="text" name="quantity"
				onkeyup="editCart_BuyLinks()" style="width: 30px" /> <label
				id="Error" style="color: red;"></label>

			<hr />
			<h5>
				Price:
				<s:property value="product.price"></s:property>
			</h5>
			<hr />


			<s:hidden id="buyHiddenLink"
				value="buyProduct.action?productId=%{product.productId}&qty="></s:hidden>
			<a id="buyLink"
				href="buyProduct.action?productId=<s:property value="%{product.productId}"/>&qty=">Buy
				Now </a> <br>
			<s:hidden id="cartHiddenLink"
				value="cartAction.action?productId=%{product.productId}&qty="></s:hidden>
			<a id="cartLink"
				href="cartAction.action?productId=<s:property value="%{product.productId}"/>&qty=">Add
				to Cart</a>
				
			<a id="watchLink"
				href="addWatchList.action?productId=<s:property value="%{product.productId}"/>">Add
				to Watch List</a>	
			<hr />	
			<hr />
		</div>
		<div class="columns large-4">
			<h4><span data-tooltip class="has-tip"
				title="<s:property value="product.sellerId" />" >Seller
					Information</span></h4>
			<%-- 				<s:property value="product.sellerId" /> --%>
			<s:url var="url1"></s:url>

			<a href="<s:property value="#url1" />"> <s:property
					value="user.firstName" /> <s:property value="user.lastName" /></a>

		</div>
	</div>
</div>
<script type="text/javascript">
	function editCart_BuyLinks() {
		quantity = document.getElementById("quantity").value;
		//alert(quantity);
		max_quantiy = document.getElementById("max_quantity").value;
		//alert((quantity-max_quantiy)<0);	
		if ((quantity - max_quantiy) > 0)
			document.getElementById("Error").innerText = "Please enter a value less than "
					+ max_quantiy;
		else {
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