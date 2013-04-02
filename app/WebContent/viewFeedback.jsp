<!--
	FileName	:	viewFeedback.jsp
	Description	:	Show the feedback of particular product.
	Author		:	Pratibind Jha
	Created Date:	01/04/2013 
 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Feedback</title>
</head>
<body>
	
	<table>	
			<tr>
				<th>criteria</th>
				<th>AverageRating</th>
				<th>#rating</th>
			</tr>
			
			<s:iterator value="userFeedbackModelPage">
				<tr>
					<td><s:text name="Item as Describe" >Item as Describe</s:text></td>
					<td><s:property value="avgRating1"/></td>
					<td><s:property value="rating1" /></td>
				</tr>
				<tr>
					<td><s:text name="Communication" >Communication</s:text></td>
					<td><s:property value="avgRating2"/></td>
					<td><s:property value="rating2" /></td>
				</tr>
				<tr>
					<td><s:text name="Shiping time" >Shiping time</s:text></td>
					<td><s:property value="avgRating3"/></td>
					<td><s:property value="rating3" /></td>
				</tr>
			</s:iterator>
	</table>
	</div>
</body>
</html>