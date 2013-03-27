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
	<div class="row">
		<h2>
			<s:if test="!query.isEmpty()">
				<b><s:property value="products.size()" /></b> results found for <b><s:property
						value="query" /></b>
			</s:if>
		</h2>
	</div>
	<div class="row">
		<div class="lefthand-sidebar large-4 columns">
			<s:iterator value="categories">
				<div class="category-box">
					<s:url action="somecategoryaction" var="urlTag">
						<s:param name="categoryID" value="categoryID"></s:param>
					</s:url>
					<a href="<s:property value="#urlTag"></s:property>"> <s:text
							name="categoryName"></s:text></a>
				</div>
			</s:iterator>
		</div>
		<div class="results-outer large-8 columns">
			<s:if test="products.size() == 0">
				<h2>Your search returned no results!</h2>
			</s:if>
			<s:iterator value="products">
				<div class="row padding-4">

					<div class="large-5 columns">
						<s:url action="someaction" var="urlTag">
							<s:param name="productId" value="productId"></s:param>
						</s:url>
						<a class="th radius"
							href="<%=request.getContextPath()%><s:property value="photo" />">
							<img alt="<s:property value="description" />"
							src="<%=request.getContextPath()%><s:property value="photo" />">
						</a>
						<hr />
					</div>
					<div class="large-7 columns">
						Name: <a href="<s:property value="#urlTag"></s:property>"> <s:text
								name="title"></s:text></a> <br> Product ID:
						<s:property value="productId" />
						<br> Description:
						<s:property value="description" />
						<br> Price:
						<s:property value="price" />
					</div>
				</div>
			</s:iterator>
		</div>
	</div>
</body>
</html>