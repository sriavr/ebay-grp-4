<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>eBay</title>
<link rel="stylesheet" href="styles/reset.css" />
<link rel="stylesheet" href="styles/foundation/normalize.css" />
<link rel="stylesheet" href="styles/foundation/foundation.css" />
<style type="text/css">
.category-select {
	padding-top: 5px;
	height: 42px;
}

.search-btn {
	height: 35px !important;
	width: 120px;
}

.product-img {
	height: 170px;
	width: 200px;
}
</style>

</head>
<body>

	<div class="row">

		<div class="small-2 columns">
			<img alt src="images/ebay.jpg">
		</div>
		<div class="small-2 columns">
			<span> Welcome ! <a href="#">Sign in</a> or <a
				href="registerAction">Register</a>
			</span>

		</div>
		<div class="small-8 columns">
			<nav class="top-bar"> <section class="top-bar-section">
			<!-- Left Nav Section -->
			<ul class="left">
				<li class="divider"></li>
				<li class="has-dropdown"><a href="#">My eBay</a>
					<ul class="dropdown">
						<li><a href="#">Summary</a></li>
						<li><a href="#">Bids/Offers</a></li>
						<li><a href="#">Watch List</a></li>
						<li><a href="#">All List</a></li>
					</ul></li>
				<li class="divider"></li>
				<li><a href="#">My Paisa Pay</a></li>
				<li class="divider"></li>
				<li class="has-dropdown"><a href="#">Sell</a>

					<ul class="dropdown">
						<li><a href="#">How to Sell</a>
						<li><a href="#">Seller Central</a>
						<li><a href="#">Seller Tools</a>
					</ul></li>
				<li class="divider"></li>
				<li class="has-dropdown"><a href="#">Community</a>

					<ul class="dropdown">
						<li><a href="#">News</a>
						<li><a href="#">FeedBack forum</a>
						<li><a href="#">FeedBack To eBay</a>
					</ul></li>
				<li class="divider"></li>
				<li><a href="#">Cart</a>
			</ul>
			</section> </nav>
		</div>
	</div>

	<div class="row">

		<nav class="top-bar"> <section class="top-bar-section">
		<!-- Right Nav Section --> <s:form action="browse.action"
			theme="simple">

			<div class="small-6 columns">
				<s:textfield name="query" label="Search" />
			</div>
			<div class="small-4 columns">
				<s:select list="categories" listKey="categoryID" headerKey="-1"
					headerValue="All Categories" listValue="categoryName"
					cssClass="category-select"></s:select>
			</div>
			<div class="small-2 columns">

				<s:submit label="Search" cssClass="search-btn" value="search"></s:submit>

			</div>

		</s:form> </section> </nav>

	</div>



</body>
</html>