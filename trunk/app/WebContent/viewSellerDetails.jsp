<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>




<div class="columns large-4">
	<h3>Seller Info</h3>
	<div class="row">
		<h5>
			<s:property value="user.firstName" />
			<s:property value="user.lastName" />
		</h5>
	</div>

	<div class="row">
		<b>Date of registration:</b>
		<s:property value="seller.dateOfRegistration" />
	</div>
</div>
<div class="columns large-4">
	<h3>Seller Feedback</h3>
	<div class="row">
		<b>Feedback Score:</b>
		<s:property value="seller.feedbackScore" />
	</div>
	<div class="row">
		<b>Positive Feedback:</b>
		<s:property value="seller.positivFeedBack" />
	</div>
	<div class="row">
		<b>SLA:</b>
		<s:property value="seller.sla" />
	</div>
</div>
<div class="columns large-4">
	<h3>Seller Contact</h3>

	<div class="row">
		<div class="columns large-3">
			<b>Address:</b>
		</div>
		<div class="columns large-9">
			<s:property value="user.homeAddress" />
			<br />
			<s:property value="user.city" />
			<br />
			<s:property value="user.pinCode" />
		</div>
	</div>
	<div class="row">
		<b>Telephone:</b>
		<s:property value="user.telephoneNo" />
	</div>
	<div class="row">
		<b>Email:</b>
		<s:property value="user.email" />
	</div>

</div>
