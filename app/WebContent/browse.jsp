<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<style>
.zoom {
	display: inline-block;
	position: relative;
}

/* magnifying glass icon */
.zoom:after {
	content: '';
	display: block;
	width: 33px;
	height: 33px;
	position: absolute;
	top: 0;
	right: 0;
	background: url(js/icon.png);
}

.zoom img {
	display: block;
}

.zoom img::selection {
	background-color: transparent;
}

#ex2 img:hover {
	cursor: url(js/grab.cur), default;
}

#ex2 img:active {
	cursor: url(js/grabbed.cur), default;
}
</style>
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
								<li><s:url action="browse.action" var="urlTag">
										<s:param name="categoryId" value="#child.categoryID"></s:param>
									</s:url> <a href="<s:property value="#urlTag"></s:property>"> <s:text
											name="#child.categoryName"></s:text>
								</a></li>
							</s:iterator>
						</ul></li>
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

				<div class="large-5 columns">
					<s:url action="productdetails" var="urlTag">
						<s:param name="productId" value="productId"></s:param>
					</s:url>
					<span class='zoom ex2'><img
						alt="<s:property value="description" />"
						src="<%=request.getContextPath()%><s:property value="photo" />"></span>

				</div>
				<div class="large-6 columns">
					<a href="<s:property value="#urlTag"></s:property>"><span
						style="font-size: 1.5em"> <s:text
							name="title"></s:text></span></a><br/>(Product Code:
					<s:property value="productId" />)
					<br> <i><s:property value="description" /></i> <br> <b><span
						style="font-size: 1.2em">Rs. <s:property value="price" /></span></b>
					<s:url action="sellerdetails" var="urlTag2">
						<s:param name="sellerId" value="sellerId"></s:param>
					</s:url>
					<br /> <span style="font-size: 0.9em">Seller Name: <a
						href="<s:property value="#urlTag2"></s:property>"> <s:text
								name="sellerName"></s:text></a></span>
				</div>
			</div>
			<hr />
		</s:iterator>
	<!--	<div class="pagination-centered">
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
		</div> -->
	</div>
</div>
<script src='js/jquery.zoom-min.js'></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('.ex2').zoom({
			on : 'grab'
		});
	});
</script>
