<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Select Mode of Payment</title>
</head>
<body>
	<label style="font: bolder;font-size: large;">Choose Mode of Payment:</label>
	<div class="row" style="text-align: center;text-indent: 0.875em;text-transform: uppercase;">
	<div class="modeOfPayment">
		<a style="color: #2ba6cb;" href="debitCardBuyForward.action">Debit Card</a>
	</div><br>
	<div style="color: #2ba6cb;" class="modeOfPayment">
		<a href="creditCardBuyForward.action">Credit Card</a>
	</div><br>
	<div class="modeOfPayment">
		<a style="color: #2ba6cb;" href="cashOnDeliveryBuyForward.action">Cash on Delivery</a>
	</div>
	</div>
</body>
</html>