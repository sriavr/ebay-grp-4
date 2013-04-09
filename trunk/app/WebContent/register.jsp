<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<head>
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.9.2/themes/base/jquery-ui.css" />
<script src="http://code.jquery.com/jquery-1.8.3.js"></script>
<script src="http://code.jquery.com/ui/1.9.2/jquery-ui.js"></script>
<script type="text/javascript" src="js/validate.js"></script>
<script>
	$(function() {
		$("#datepicker").datepicker();
	});
</script>
</head>
<body>

	<div class="large-6 columns">
		<s:form action="doRegister.action" id="regform" theme="simple">
			<div class="panel">
				<font size="4"><b>Registration Page</b> </font><br> <br>
				First name :
				<s:textfield name="firstName" onblur="javascript:checkname()"
					id="uname" />
				<s:label id="m_uname"></s:label>
				Last name :
				<s:textfield name="lastName" />
				Home address :
				<s:textfield name="homeAddress" key="Home address" />
				City :
				<s:textfield name="city" key="City" />
				State :
				<s:textfield name="state" key="State" />
				Pin code :
				<s:textfield name="pinCode" key="Pin code" />
				Phone Number :
				<s:textfield name="phNumber" key="Phone Number" />
				Email Id :
				<s:textfield name="emailId" key="Email Id" />
				Password :
				<s:password name="password" key="Password" />
				Re-type password :
				<s:password name="rePassword" key="Re-type Password" />
				<%--  	Date Of Birth : <s:textfield label="dob" id="datepicker" theme ="simple" /> --%>
			</div>

			<div class="panel">
				<input type="submit" class="small button round" value="Register" />
			</div>
		</s:form>
	</div>
</body>