<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="styles/foundation/normalize.css" />
 <link rel="stylesheet" href="styles/foundation/foundation.css" />
<title>View WatchList</title>
</head>
<body>
	<div class="row" style="background-color:#EEEEEE; font: bold 12pt/30px Arial;margin-bottom:25px;border-radius:3px;">
		<b style="margin-left:2px;">Items in your watch list</b>
	</div>
	<div class="row" style="border-top: 1px solid #F5F5F5;margin-top:5px;">
	</div>
	<div class="row" style="margin-top:10px;">
		<div class="columns large-3">
		</div>
		<div class="columns large-3">
		</div>
		<div class="columns large-3">
			
		</div>
		<div class="columns large-3">
			<s:select label="Sort By" 
					headerKey="-1" headerValue="-sort Option-"
					list="#{'1':'price : lowest', '2':'price : highest'}" 
					name="course" value="-1" onchange="this.form.submit()" >
			</s:select>
		</div>
		 
		
		
	</div>

	<div class="row" style="border-top: 1px solid #F5F5F5;margin-top:15px;">
		
		<div class="columns large-5">
		
		</div>
		<div class="columns large-3">
	
		</div>
		<div class="columns large-2">
			Price
		</div>
		<div class="columns large-2">
			Actions
		</div>
		
	</div>
	<s:actionerror/>
	<%-- <s:form  action="removewatchlist.action" method="post" theme="simple"> --%>
		<%-- <s:checkboxlist list="viewWatchListModel" name="selectedCheckBox" listValue="watchListId" listKey="watchListId"></s:checkboxlist> --%>
		<s:iterator value="viewWatchListModel">
			<div class="row" style="border-top: 1px solid #F5F5F5;margin-top:15px;">
				<div class="columns large-5">
					<%-- <s:checkbox fieldValue="watchListId" name="selectedCheckBox" /> --%>
					
					<a class="th radius" data-reveal-id="myModal" href="#"> <img
								alt="<s:property value="description" />"
								src="<%=request.getContextPath()%><s:property value="photo" />">
					</a>
				</div>
				<div class="columns large-3">
					<s:property value="productTitle" />
				</div>
				<div class="columns large-1">
					<s:property value="price" />
				</div>
				<div class="columns large-3">
					<s:property value="actions" />
					<a class="tiny success button " href="<s:url action="removewatchlist">
				<s:param name="selectedCheckBox" value="watchListId"/>
			 	</s:url>">
				Remove
		</a>
				</div>
				
			</div>
		</s:iterator>
		<div class="row">
		 <!-- <input type="submit" value="Remove" name="fromSubmit" class="small button " /> -->
		 
		</div>
	<%-- </s:form> --%>
	
</body>
</html>