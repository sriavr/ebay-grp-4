<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div class="row">
	<s:if test="!query.isEmpty()">
		<b><s:property value="products.size()" /></b>
		<s:if test="products.size()==1">result</s:if>
		<s:else>results</s:else> found for <b><s:property value="query" /></b>
	</s:if>
</div>
<div class="row">
	<div class="lefthand-sidebar large-3 columns">
		<div class="categories-box">
			<h4>Categories</h4>
			<ul class="side-nav">
				<s:iterator value="categories" var="parent">
					<li class="category-box"><s:url action="browse.action"
							var="urlTag">
							<s:param name="categoryId" value="categoryID"></s:param>
						</s:url> <a href="<s:property value="#urlTag"></s:property>"> <s:text
								name="categoryName"></s:text></a>
						<ul>
							<s:iterator var="child" value="#parent.categories">
								<li>
									<s:url action="browse.action" var="urlTag">
										<s:param name="categoryId" value="#child.categoryID"></s:param>
									</s:url> 
									<a href="<s:property value="#urlTag"></s:property>"> 
									<s:text name="#child.categoryName"></s:text> </a>
								</li>
							</s:iterator>
						</ul>
					</li>
				</s:iterator>
			</ul>
		</div>
		<s:form action="browse.action" method="get" theme="simple">
			<div class="price-box">
				<h4>Price</h4>
				From Rs
				<s:textfield name="priceLower" cssClass="price-text"></s:textfield>
				to Rs
				<s:textfield name="priceHigher" cssClass="price-text"></s:textfield>
				<s:submit class="button small" value=">>"></s:submit>
			</div>
		</s:form>

	</div>
	<div class="results-outer large-9 columns">
		<s:if test="products.size() == 0">
			<h2>Your search returned no results!</h2>
		</s:if>
		<s:iterator value="products">
			<div class="row padding-4">

				<div class="large-3 columns">
					<s:url action="productdetails" var="urlTag">
						<s:param name="productId" value="productId"></s:param>
					</s:url>
					<a class="th radius" data-reveal-id="myModal" href="#"> <img
						alt="<s:property value="description" />"
						src="<%=request.getContextPath()%><s:property value="photo" />">
					</a> <img id="myModal" class="reveal-modal large"
						alt="<s:property value="description" />"
						src="<%=request.getContextPath()%><s:property value="photo" />">

				</div>
				<div class="large-6 columns">
					Name: <a href="<s:property value="#urlTag"></s:property>"> <s:text
							name="title"></s:text></a> <br> Product ID:
					<s:property value="productId" />
					<br> Description:
					<s:property value="description" />
					<br> Price:
					<s:property value="price" />
				</div>
			</div>
			<hr />
		</s:iterator>
		<div class="pagination-centered">
			<ul class="pagination">
				<li class="arrow unavailable"><a href="?pageNum=1">&laquo;</a></li>
				<li class="current"><a href="?pageNum=1">1</a></li>
				<li><a href="?pageNum=2">2</a></li>
				<li><a href="">3</a></li>
				<li><a href="">4</a></li>
				<li class="unavailable"><a href="">&hellip;</a></li>
				<li><a href="">12</a></li>
				<li><a href="">13</a></li>
				<li class="arrow"><a href="">&raquo;</a></li>
			</ul>
		</div>
	</div>
</div>
