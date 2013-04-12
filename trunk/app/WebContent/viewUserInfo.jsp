<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View User Info</title>
</head>
<body>
	<div class="row" style="background-color:#EEEEEE; font: bold 12pt/30px Arial;margin-bottom:25px;border-radius:3px;">
		<b style="margin-left:2px;">User Information</b>
	</div>
	<div class="row" style="border-top: 1px solid #F5F5F5;margin-top:5px;">
	</div>
	<div class="row" style="margin-top:10px;background-color:#EEEEEE; font: bold 12pt/30px Arial;
		border-top: 1px solid #F5F5F5;margin-top:15px;">
		<div class="columns large-2">
			Name
		</div>
		<div class="columns large-3">
			Email
		</div>
		<div class="columns large-2">
			Address
		</div>
		<div class="columns large-2">
			Phone
		</div>
		<div class="columns large-1">
			Country
		</div>
		<div class="columns large-1">
			
		</div>
	</div>
	
	<s:iterator value="userModel">
		<div class="row" style="border-top: 1px solid #F5F5F5;margin-top:7px;">
			<div class="columns large-2">
				<s:property value="firstName"/>
			</div>
			<div class="columns large-3">
				<s:property value="email"/>
			</div>
			<div class="columns large-2">
				<s:property value="homeAddress" />
			</div>
			<div class="columns large-2">
				<s:property value="telephoneNo"/>
			</div>
			<div class="columns large-1">
				<s:property value="city"/>
			</div>
			<div class="columns large-2">
				<a class="tiny success button " href="<s:url action="editUserInfo">
					<s:param name="userId" value="userId"/>
				 	</s:url>">
					Edit
				</a>
			</div>
		</div>
	</s:iterator>

</body>
</html>