<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>View WatchList</title>
</head>
<body>
	<div class="row" style="background-color:#EEEEEE; font: bold 12pt/30px Arial;margin-bottom:25px;border-radius:3px;">
		<b style="margin-left:2px;">Items in your watch list</b>
	</div>
	<div class="row" style="border-top: 1px solid #F5F5F5;margin-top:5px;">
	</div>
	<div class="row" style="margin-top:10px;">
		<em style="float:right;">Sort By&nbsp;&nbsp; 
		<s:select label="" style="float:right;"
					headerKey="-1" headerValue="-Select sort Option-"
					list="#{'1':'price : lowest', '2':'price : highest'}" 
					name="course" value="-1" onchange="this.form.submit()" >
		</s:select>
		</em>
	</div>
	<div class="row" style="border-top: 1px solid #F5F5F5;margin-top:35px;">
	</div>
</body>
</html>