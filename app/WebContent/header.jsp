<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>


<div class="row">
	<div class="large-2 columns">
		<img src="images/ebay.jpg">
	</div>
	<div class="large-3 columns">
		<span> Welcome ! <a href="#">Sign in</a> or <a
			href="registerAction">Register</a>
		</span>

	</div>
	<div class="large-7 columns">
		<nav class="top-bar">
			<section class="top-bar-section">
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
			</section>
		</nav>
	</div>
</div>

<div class="row">

	<nav class="top-bar">
		<section class="top-bar-section">
			<!-- Right Nav Section -->
			<s:form action="browse.action" method="get" theme="simple">

				<div class="large-6 columns">
					<s:textfield name="query" label="Search" />
				</div>
				<div class="large-4 columns">
					<s:select name="categoryId" list="categories" listKey="categoryID"
						headerKey="-1" headerValue="All Categories"
						listValue="categoryName" cssClass="category-select"></s:select>
				</div>
				<div class="large-2 columns">
					<s:submit label="Search" cssClass="small button" value="search"></s:submit>
				</div>

			</s:form>
		</section>
	</nav>

</div>

