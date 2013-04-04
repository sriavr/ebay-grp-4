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
	<style>
		.border {
		    border-top: 1px solid #FAB46B;
		    font: bold 12pt/30px Arial;
		    margin: 0 9px;
		    vertical-align: middle;
		    margin-bottom:15px;
		    /*text-align:center;*/
		}
	</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Feedback</title>
</head>
<body>
	<s:actionmessage/>
	<s:iterator value="userFeedbackModelPage">
	<div  class="row" style="background-color:#FFE2BB; font: bold 12pt/30px Arial;margin-bottom:15px;border-radius:5px;" >
		<s:text name="">eBay My World: <s:property value="productTitle"/></s:text>
	</div>
	<div  style="background-color:#FFE2BB;border-radius:3px;" class="row">
		<s:text name="header">Feedback earned for transactions on eBay</s:text>
	</div>
	<div class="large-3 columns">
		<div class="row" style="margin-top:15px;">
			<s:text name="">Positive Feedback:<s:property value="positiveFeedback"/>%</s:text>
		</div>
		<div class="row" >
			<s:text name="">Feedback Score:<s:property value="feedbackScore"/></s:text>
		</div>
	</div>
	<div class="large-9 columns" style="border-top: 1px solid #F5F5F5;">
		<div class="row" style="background-color:#EBEBEB;border-radius:3px; font:bold 10pt/30px Arial;margin-top:15px;">
			<s:text name="">Detailed Seller Ratings </s:text>
		</div>
		<div class="row" style="background-color:#F5F5F5;">
			<div class="large-3 columns">
				<s:text name="">Criteria</s:text>
			</div>
			<div class="large-3 columns">
				<s:text name="">Average rating</s:text>
			</div>
			<div class="large-3 columns">
				<s:text name="">Number of ratings</s:text>
			</div>
		</div>
		
			<div class="row" style="border-left: 1px solid #EBEBEB;border-right: 1px solid #EBEBEB;">
				<div class="large-3 columns">
					<s:text name="">Item as Describe</s:text>
				</div>
				<div class="large-3 columns">
					<s:text name=""><s:property value="avgRating1"/></s:text>
				</div>
				<div class="large-3 columns">
					<s:text name=""><s:property value="rating1" /></s:text>
				</div>
			</div>
			<div class="row" style="border-left: 1px solid #EBEBEB;border-right: 1px solid #EBEBEB;">
				<div class="large-3 columns">
					<s:text name="">Communication</s:text>
				</div>
				<div class="large-3 columns">
					<s:text name=""><s:property value="avgRating2"/></s:text>
				</div>
				<div class="large-3 columns">
					<s:text name=""><s:property value="rating2" /></s:text>
				</div>
			</div>
			<div class="row" style="border-left: 1px solid #EBEBEB;border-right: 1px solid #EBEBEB;
				border-bottom: 1px solid #EBEBEB; margin-bottom:15px;">
				<div class="large-3 columns">
					<s:text name="">Shiping time</s:text>
				</div>
				<div class="large-3 columns">
					<s:text name=""><s:property value="avgRating3"/></s:text>
				</div>
				<div class="large-3 columns">
					<s:text name=""><s:property value="rating3" /></s:text>
				</div>
			</div>
		</s:iterator>
	</div>
<%-- 	<table>	
		<caption style="background-color:#EBEBEB;border-top: 1px solid #FAB46B;">Detailed Seller Ratings</caption>
			<tr>
				<th  style="background-color:#EBEBEB;">criteria</th>
				<th  style="background-color:#EBEBEB;">AverageRating</th>
				<th  style="background-color:#EBEBEB;">#rating</th>
			</tr>
			
			<s:iterator value="userFeedbackModelPage">
				<div class="row">
					<tr>
						<td><s:text name="Item as Describe" >Item as Describe</s:text></td>
						<td><s:property value="avgRating1"/></td>
						<td><s:property value="rating1" /></td>
					</tr>
				</div>
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
	</table> --%>

	<div class="large-3 columns">
	</div>
	<div class="large-9 columns">
		<div class="row">
		</div>
	</div>
	
</body>
</html>