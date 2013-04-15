<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit User Info</title>

<script type="text/javascript" src="js/jquery.maskedinput-1.0.js"></script>
<script type="text/javascript">
	$(document)
			.ready(
					function() {
						$("#userForm")
								.validate(
										{
											onkeyup : true,
											rules : {
												firstName : {
													required : true
												},

												lastName :  {
													required : true
												},
												
												pinCode : {
													maxlength : 6,
													digits : true,
													required : true
												},
												homeAddress: {
													required : true,
													minlength : 5
												},

												password : {
													required : true,
													minlength : 5
												},
												
												telephoneNo : {
													required : true,
													minlength : 5,
												}, 
												city: {
													required : true
												},
												email : {
													required : true,
													email : true
												}
											},
											messages : {
												firstName : {
													required: "Please enter your firstname"
												},
												lastName : {
													required: "Please enter your lastname"
												},
												pinCode : {
													maxlength : "pincode can be of length 6 only"
												},
												password : {
													required : "Please provide a password",
													minlength : "Your password must be at least 5 characters long"
												},
												homeAddress:{
													required : "Please provide HomeAddress",
													minlength : "Your HomeAddress should be of at lease 5 character long"
													
												},
												telephoneNo:{
													required : "Please Provide telephone no."
												},
												email : "Please enter a valid email address",
											}
										});

						$("#phone").mask("999-999-9999");
					});
</script>
</head>
<body>
	<div class="row" style="background-color:#EEEEEE; font: bold 12pt/30px Arial;margin-bottom:25px;border-radius:3px;">
	<b style="margin-left:2px;">Edit User Information</b>
	</div>
	<div class="row" style="border-top: 1px solid #F5F5F5;margin-top:5px;">
	</div>
	<s:iterator value="userModel">
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
		<s:form name="userModel" id="userForm" action="saveUserInfo.action" method="post" theme="simple">
		  <div class="row" style="border-top: 1px solid #F5F5F5;margin-top:5px;">
		    <div class="columns large-2">
		    	&nbsp;&nbsp;
		    </div>
		    <div class="columns large-2">
		    	<span class="label" style="padding:8.2px;width:150px;">First Name</span>
		    </div>
		    <div class="columns large-5">
		    	<s:textfield name="firstName" ></s:textfield>
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
		    	<span class="label" style="padding:8.2px;width:150px;">Last Name</span>
		    </div>
		    <div class="columns large-5">
		    	<s:textfield name="lastName" ></s:textfield>
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
		    	<span class="label" style="padding:8.2px;width:150px;">Home Address</span>
		    </div>
		    <div class="columns large-5">
		    	<s:textfield name="homeAddress" ></s:textfield>
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
		    	<span class="label" style="padding:8.2px;width:150px;">city</span>
		    </div>
		    <div class="columns large-5">
		    	<s:textfield name="city" ></s:textfield>
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
		    	<span class="label" style="padding:8.2px;width:150px;">Pin Code</span>
		    </div>
		    <div class="columns large-5">
		    	<s:textfield name="pinCode" ></s:textfield>
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
		    	<span class="label" style="padding:8.2px;width:150px;">Telephone</span>
		    </div>
		    <div class="columns large-5">
		    	<s:textfield name="telephoneNo" id="phone" ></s:textfield>
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
		    	<span class="label" style="padding:8.2px;width:150px;">email</span>
		    </div>
		    <div class="columns large-5">
		    	<s:textfield name="email" ></s:textfield>
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
		    	<s:textfield name="password" ></s:textfield>
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
		    	<input type="submit" name="save" value="save" class="small success button " />
		    </div>
		    <s:hidden name="userId"></s:hidden>
		    <div class="columns large-5">
		    	<a class="small success button " href="<s:url action="viewUserInfo">
					<s:param name="userId" value="userId"/>
				 	</s:url>">
					View User Info
				</a>
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