<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bank Details</title>

<script type="text/javascript" src="js/jquery.maskedinput-1.0.js"></script>
</head>
<body>
	<div class="row" style="background-color:#EEEEEE; font: bold 12pt/30px Arial;margin-bottom:25px;border-radius:3px;">
	<b style="margin-left:2px;">Bank Details</b>
	</div>
	<div class="row" style="border-top: 1px solid #F5F5F5;margin-top:5px;">
	</div>
	<em style="color:green;"><s:actionmessage/></em>
	<s:iterator value="bankDetailsModel">
		<div class="row" style="margin-top:10px;background-color:#EEEEEE; font: bold 12pt/30px Arial;
			border-top: 1px solid #F5F5F5;margin-top:15px;">
			<div class="columns large-2">
				Name:
			</div>
			<div class="columns large-3" style="color:orange;">
				<s:property value="firstName" />&nbsp; <s:property value="lastName"/>
			</div>
			<div class="columns large-2">
				Email:
			</div>
			<div class="columns large-5" style="color:green;">
				<s:property value="email"/>
			</div>
			
		</div>
		<!-- Showing data in from -->
		<s:form name="bankDetailsModel" id="userForm" action="saveMyInfoDetails.action" method="post" theme="simple">		  
		  
		   <div class="row" style="border-top: 1px solid #F5F5F5;margin-top:5px;">
		    <div class="columns large-2">
		    	&nbsp;&nbsp;
		    </div>
		    <div class="columns large-2">
		    	<span class="label" style="padding:8.2px;width:150px;">Account Number</span>
		    </div>
		    <div class="columns large-5">
		    	<s:textfield name="accoutNum" disabled="true"></s:textfield>
		    </div>
		    <div class="columns large-2">
		    	&nbsp;&nbsp;
		    </div>
		  </div>
		  
		   <div class="row" style="border-top: 1px solid #F5F5F5;margin-top:5px;">
		    <div class="columns large-2">
		    	&nbsp;&nbsp;
		    </div>
		    <div class="columns large-2">
		    	<span class="label" style="padding:8.2px;width:150px;">ATM Number</span>
		    </div>
		    <div class="columns large-5">
		    	<s:textfield name="atmNum" disabled="true"></s:textfield>
		    </div>
		    <div class="columns large-2">
		    	&nbsp;&nbsp;
		    </div>
		  </div>
		  
		   <div class="row" style="border-top: 1px solid #F5F5F5;margin-top:5px;">
		    <div class="columns large-2">
		    	&nbsp;&nbsp;
		    </div>
		    <div class="columns large-2">
		    	<span class="label" style="padding:8.2px;width:150px;">Pin </span>
		    </div>
		    <div class="columns large-5">
		    	<s:textfield name="pin" disabled="true"></s:textfield>
		    </div>
		    <div class="columns large-2">
		    	&nbsp;&nbsp;
		    </div>
		  </div>
		  
		   <div class="row" style="border-top: 1px solid #F5F5F5;margin-top:5px;">
		    <div class="columns large-2">
		    	&nbsp;&nbsp;
		    </div>
		    <div class="columns large-2">
		    	<span class="label" style="padding:8.2px;width:150px;">Password</span>
		    </div>
		    <div class="columns large-5">
		    	<s:textfield name="bankPassword" disabled="true"></s:textfield>
		    </div>
		    <div class="columns large-2">
		    	&nbsp;&nbsp;
		    </div>
		  </div>
		  
		     <div class="row" style="border-top: 1px solid #F5F5F5;margin-top:5px;">
		    <div class="columns large-2">
		    	&nbsp;&nbsp;
		    </div>
		    <div class="columns large-2">
		    	<span class="label" style="padding:8.2px;width:150px;">Balance</span>
		    </div>
		    <div class="columns large-5">
		    	<s:textfield name="balance" disabled="true"></s:textfield>
		    </div>
		    <div class="columns large-2">
		    	&nbsp;&nbsp;
		    </div>
		  </div>
		  
		  <div class="row" style="border-top: 1px solid #F5F5F5;margin-top:5px;">
		  </div>
		</s:form>
	</s:iterator>
	

</body>
</html>