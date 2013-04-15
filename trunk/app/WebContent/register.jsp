<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<script type="text/javascript" src="js/jquery.maskedinput-1.0.js"></script>
<script type="text/javascript">
	$(document)
			.ready(
					function() {
						$("#signupForm")
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

												password : {
													required : true,
													minlength : 5
												},
												
												rePassword : {
													required : true,
													minlength : 5,
													equalTo : "#password"
												},
												
												phNumber : {
													required : true,
													minlength : 5,
												}, 
												
												email : {
													required : true,
													email : true
												},
												
												dob : {
													required : true													
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
												rePassword : {
													required : "Please provide a password",
													minlength : "Your password must be at least 5 characters long",
													equalTo : "Please enter the same password as above"
												},
												email : "Please enter a valid email address",
												agree : "Please accept our policy"
											}
										});

						$("#phone").mask("999-999-9999");
						$("#dob").mask("99/99/9999");
					});
</script>

<div class="large-6 col	umns">
	<s:form action="doRegister.action" id="signupForm" theme="simple">
		<div class="panel">
			<font size="4"><b>Registration Page</b> </font><br> <br>
			<b>First name :</b> 
			<input name="firstName" id="firstName" type="text" title="First Name is required" />

			<b>Last name :</b> 
			<input type="text" name="lastName" />

			<b>Home address :</b>
			<input type="text" name="homeAddress" id="homeAddress" />
			
			<b>City :</b>
			<input type="text" name="city" id="city" />

			<b>State :</b>
			<input type="text" name="state" id="state" />

			<b>Pin code :</b>
			<input type="text" name="pinCode" id="pinCode" />

			<b>Phone Number :</b>
			<input type="text" name="phNumber" id="phone" />

			<b>Email :</b> 
			<input id="email" name="emailId" type="email" /> 
			
			<b>Password :</b> 
			<input id="password" name="password" type="password" /> 
				
			<b>Re-type password :</b>
			<input id="rePassword" name="rePassword" type="password" />
			
			<b>Date Of Birth :</b>
			<input type="text" name="dob" id="dob" />
		</div>

		<div class="panel">
			<input type="submit" class="small button round" value="Register" />
		</div>
	</s:form>
</div>
