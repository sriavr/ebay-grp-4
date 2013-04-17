<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div class="row">
	<div class="results-outer large-9 columns">
		<s:if test="products.size() == 0">
			<h2>Your search returned no results!</h2>
		</s:if>
		<s:iterator begin="0" end="%{ordersList.size()-1}" var="index">
			<div class="row padding-4">

				<div class="large-3 columns">
					<s:url action="orderDetails" var="urlTag">
						<s:param name="orderId" value="%{ordersList.get(#index).orderId}"></s:param>
					</s:url>
					<a class="th radius" data-reveal-id="myModal" href="#"> <img
						alt="<s:property value="description" />"
						src="<%=request.getContextPath()%><s:property value="%{products.get(#index).photo}" />">
					</a> <img id="myModal" class="reveal-modal large"
						alt="<s:property value="description" />"
						src="<%=request.getContextPath()%><s:property value="%{products.get(#index).photo}" />">

				</div>
				<div class="large-6 columns">
					<h5>Order Details</h5>
					Order No. : <a href="<s:property value="#urlTag"></s:property>"> <s:text
							name="%{ordersList.get(#index).orderId}"></s:text></a> <br> Product Title:
					<s:property value="%{products.get(#index).title}" />
					<br><p style='color:red'>* Click Order No. to view Complete Order Details</p>
					<br><a href="viewFeedback?productID=<s:property value="%{products.get(#index).productId}"/>">View Feedback </a>
				</div>
			</div>
			<hr />
		</s:iterator>
		<div class="pagination-centered">
			<ul class="pagination">
				<li class="arrow unavailable"><a href="">&laquo;</a></li>
				<li class="current"><a href="">1</a></li>
				<li><a href="">2</a></li>
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
