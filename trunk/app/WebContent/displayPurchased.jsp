<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<hr/>
<div class="large-3 columns">
<h5>PHOTO</h5>
</div>
<div class="large-9 columns">
<div class="row">
<div class="large-3 columns">
<h5>Title</h5>
</div>
<div class="large-3 columns">
<h5>Price</h5>
</div>
<div class="large-3 columns">
<h5>Current Status</h5>
</div>
<div class="large-3 columns">
<h5>Seller Name</h5>
</div>
</div>
</div>
<hr/>
<s:iterator begin="0" end="%{productId.size()-1}" var="index">
	
	<div class="large-3 columns">
		<a class="th radius" data-reveal-id="myModal" href="#"> <img
			alt="<s:property value="description" />"
			src="<%=request.getContextPath()%><s:property value="%{products.get(#index).photo}" />">
				</a>
	</div>
	
	<div class="large-9 columns">
		<div class="row">
			
				<div class="large-3 columns">
					<s:property value="%{products.get(#index).title}"/>
					<s:property value="%{products.get(#index).description}"/>
				</div>
				<div class="large-3 columns">
					<s:property value="%{products.get(#index).price}"/>
					<a href="#" >
						<s:property value="%{sellers.get(#index).sellerName}"/>
					</a>	
				
				</div>		
				<div class="large-3 columns">
					<s:property value="%{ordersList.get(#index).currentStatus}"/>
				</div>
				<div class="large-3 columns">
					<s:if test="%{!(ordersList.get(#index).currentStatus.equals(\"SHIPPED\")||ordersList.get(#index).currentStatus.equals(\"DELIVERED\")||ordersList.get(#index).currentStatus.equals(\"ORDER_CANCELLED\"))}">
						<a href="cancelOrderAction.action?orderId=<s:property value="ordersList.get(#index).orderId"/>">Cancel Order</a>
					</s:if>
					<br>	
					<s:if test="%{!(ordersList.get(#index).currentStatus.equals(\"PAYMENT_RECEIVED\")||ordersList.get(#index).currentStatus.equals(\"DELIVERED\")||ordersList.get(#index).currentStatus.equals(\"ORDER_CANCELLED\"))}">				
					<a href="leaveFeedback?productId=<s:property value="%{products.get(#index).productId}"/>&userId=<s:property value="%{userId}"/>&sellerId=<s:property value="%{products.get(#index).sellerId}"/>&orderId=<s:property value="%{ordersList.get(#index).orderId}"/>">
					Update Status as Delivered & Leave Feedback </a>
					</s:if>
				</div>
		</div>
		
	</div>
	
	<hr/>
</s:iterator>