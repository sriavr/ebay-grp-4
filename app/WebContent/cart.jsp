<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Shopping Cart</title>
</head>
<body>
	<div class="row">
	
		<s:iterator value="%{cartList}" var="cartItem">
			<div class="row">
				<div class="large-3 columns">
					<a class="th radius" data-reveal-id="myModal" href="#"> <img
						src="<%=request.getContextPath()%><s:property value="%{#cartItem.product.photo}" />">
					</a>
				</div>
				<br>
				<div class="columns large-8">
				<s:property value="%{#cartItem.product.tile}" />
				
				<div class="columns large-4">Price =
				<s:property value="%{#cartItem.product.price}" />
				</div>
				 <div class="columns large-4"> Quantity =
				<s:property value="%{#cartItem.product.quantity}" />
				</div>
				<div class="columns large-4"> Sub Total =Rs.
				<s:property
					value="%{#cartItem.product.price*#cartItem.product.quantity}" />
				</div>
				<a
					href="removeFromCartAction?cartId=<s:property value="%{#cartItem.cartId}" />"><input type="button" style="display:inline;" class="tiny button" value="Remove From Cart"></a>
				</div>
			</div>
		</s:iterator>
		<div style="float: right;">
		Total Price=Rs.<s:property value="%{cartAmount}"/>
		
		<a href="selectModeOfPaymentForward.action"><input type="button"   value="Proceed to Buy" 	style="border: thick;background: gray;width: auto;text-align: center;text-transform: uppercase;font-weight: bold;padding: 0.875em;"></a>
		</div>
	</div>
	<hr>
</body>
</html>