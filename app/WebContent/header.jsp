<%@page import="edu.iiitb.ebay.dao.BrowseDAO"%>
<%@page import="edu.iiitb.ebay.model.entity.CategoryModel"%>
<%@page import="java.util.ArrayList"%>
<%@ page import="edu.iiitb.ebay.model.entity.UserModel"%>
<%@ page import="edu.iiitb.ebay.model.entity.AdminModel"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div class="row">
	<div class="large-2 columns">
		<a href="browse.action"><img src="images/ebay.jpg"></a>
	</div>
	<div class="large-3 columns">
		<%
			if (session.getAttribute("user") == null
					&& session.getAttribute("admin") == null) {
		%>
		<span> Welcome ! <a href="login.action">Sign in</a> or <a
			href="register.action">Register</a>
		</span>
		<%
			} else if (session.getAttribute("admin") == null) {
				UserModel user = (UserModel) session.getAttribute("user");
		%>
		<span> Hi <%=user.getFirstName()%> (<a href="logout.action">Sign
				out</a>)
		</span>
		<%
			} else {
				AdminModel a = (AdminModel) session.getAttribute("admin");
		%>
		<span> Hi admin <%=a.getAdminName()%> (<a href="logout.action">Sign
				out</a>)
		</span>
		<%
			}
		%>

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
							<li><a href="viewWatchList.action">Watch List</a></li>
							<li><a href="#">All List</a></li>
						</ul></li>
					<li class="divider"></li>
					<li><a href="#">My Paisa Pay</a></li>
					<li class="divider"></li>
					<li class="has-dropdown"><a href="createSeller.action">Sell</a>

						<ul class="dropdown">
							<li><a href="#">How to Sell</a>
							<li><a href="createSeller.action">Seller Central</a>
							<li><a href="#">Seller Tools</a>
							<li><a href="viewMyProducts.action">View My Products</a>
							<li><a href="viewMySoldProducts.action">View My Sold Products</a>
						</ul></li>
					<li class="divider"></li>
					<li class="has-dropdown"><a href="#">Community</a>

						<ul class="dropdown">
							<li><a href="#">News</a>
							<li><a href="#">FeedBack forum</a>
							<li><a href="#">FeedBack To eBay</a>
						</ul></li>
					<li class="divider"></li>
					<li><a href="cartAction">Cart</a> <%
 	if (session.getAttribute("admin") != null) {
 %>
					<li class="has-dropdown"><a href="#">Admin</a>

						<ul class="dropdown">
							<li><a href="manageCategory.action">Manage Category</a>
							<li><a href="viewUserInfo.action">Manage User </a>
						</ul></li>
					<li class="divider"></li>

					<%
						}
					%>
				</ul>
			</section>
		</nav>
	</div>
</div>
<%
	ArrayList<CategoryModel> categories = new ArrayList<CategoryModel>();
	BrowseDAO browseDAO = new BrowseDAO();
	categories = browseDAO.getRelevantCategories();
%>
<div class="row">

	<nav class="top-bar">
		<section class="top-bar-section">
			<!-- Right Nav Section -->
			<s:form action="browse.action" method="get" theme="simple">
				<jsp:useBean id="obj" class="edu.iiitb.ebay.dao.BrowseDAO"
					scope="page" />
				<div class="row">
					<div class="columns large-6">
						<input name="query" type="text"
							style="margin-left: 20px; max-width: 350px" />
						<%-- 						<s:textfield name="query" cssClass="searchBar" label="Search" /> --%>
					</div>
					<div class="columns large-4">
						<select style="padding-top: 5px; height: 45px" name="categoryId">
							<option value="0">All Categories</option>
							<%
								for (int i = 0; i < categories.size(); i++) {
							%>
							<option value="<%=categories.get(i).getCategoryID()%>"><%=categories.get(i).getCategoryName()%></option>
							<%
								i++;
									}
							%>
						</select>

					</div>
					<div class="columns large-2">
						<input type="submit" value="Search" />
<!-- 						<a href="deals">Deals</a> -->
						<s:submit action="deals" value="Deals"></s:submit>
						<%-- 						<s:submit label="Search" cssClass="small button" value="search"></s:submit> --%>
					</div>
				</div>
			</s:form>
		</section>
	</nav>

</div>

