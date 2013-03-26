<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="js/jquery.avgrund.js"></script>
<link rel="stylesheet" href="styles/reset.css" />
<link rel="stylesheet" href="styles/style.css" />
<link rel="stylesheet" href="styles/avgrund.css" />
<script type="text/javascript">
	$(document).ready(function() {
		//alert("loaded");
		$("img").click(function() {
			//alert("clicked");
			$(this).avgrund({
				template : "<img src='" + $(this).prop('src') + "''"
			});
		});
	});
</script>
</head>
<body>
	<h1>Browse page</h1>
	<h2>
		Search query was:
		<s:property value="query" />
	</h2>
	<div class="lefthand-sidebar"></div>
	<div class="results-outer">
		<s:iterator value="products">
			<div class="results-box">
				<s:url action="someaction" var="urlTag">
					<s:param name="productId" value="productId"></s:param>
				</s:url>
				Name: <a href="<s:property value="#urlTag"></s:property>"> <s:text
						name="title"></s:text></a> <br> Product ID:
				<s:property value="productId" />
				<br> Description:
				<s:property value="description" />
				<br> Price:
				<s:property value="price" />
				<img alt="<s:property value="description" />"
					src="<%=request.getContextPath()%><s:property value="photo" />">
			</div>
		</s:iterator>
	</div>
</body>
</html>