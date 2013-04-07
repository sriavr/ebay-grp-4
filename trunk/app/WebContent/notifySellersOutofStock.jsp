<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Notify Sellers out of stock</title>
</head>
<body>
<div class="row">
	<s:iterator value="%{productList}" var="product">
		<div class="columns large-2">
			<s:property value="%{#product.title}"/>
		</div>
		<div class="columns large-2">
			<s:property value="%{#product.quantity}"/>
		</div>
		<div class="columns large-2">
			<a href="notifySellerAction.action?productId=<s:property value="%{#product.productId}"/>">Notify Seller</a>
			
		</div><br>
	</s:iterator>
	<a href="notifyAllSellersAction">Notify all sellers</a>
</div>
</body>
</html>