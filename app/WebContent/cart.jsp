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
<div>
	<s:iterator value="%{cartList}" var="cartItem">
		<div>
				<img src="%{#cartItem.product.photo}"> <br>
				<s:property value="%{#cartItem.product.tile}"/><br>
				Price = <s:property value="%{#cartItem.product.price}"/><br>
				Quantity = <s:property value="%{#cartItem.product.quantity}"/><br>
				Total Price = <s:property value="%{#cartItem.product.price*#cartItem.product.quantity}"/>
				<a href="removeFromCartAction?cartId=<s:property value="%{#cartItem.cartId}" />">Remove From Cart</a>
			</div>
	</s:iterator>
	<a href= "selectModeOfPaymentForward.action" >Proceed to Buy</a>
	
</div>
</body>
</html>