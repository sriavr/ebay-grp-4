<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>DebitCard Payment</title>
</head>

<body>
<div style="text-align: center;padding-left: 25em;">
<s:actionerror/>
<s:form action="creditCardPay.action">
	<s:textfield label="Account Number" name="accountNumber"/><br>
	<s:password label="Password" name="password" />
	<s:submit label="Pay"/>
</s:form>
</div>
</body>
</html>