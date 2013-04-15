<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<script  type="text/javascript">
	function check(checkBoxId){
		/* var value = document.getElementById(checkBoxId).value;
		alert(value);  */
		var orderId = '<s:property value="orderId" />';
		var url = "updateToShipped.action?orderId="+orderId;
		window.location.href = url; 
	}
</script>
</head>
<body>
<div class="large-3 columns">
	<a class="th radius" data-reveal-id="myModal" href="#"> <img
		alt="<s:property value="description" />"
		src="<%=request.getContextPath()%><s:property value="product.photo" />">
	</a>
</div>
<s:form action = "updateProdDetailsBySeller.action" method="post" theme="simple">
<div class="large-9 columns">
	<div class="row">
		<h3>
			Order Details : 
		</h3>
		Product Name : <s:property value="product.title" /><br>
		
		Product Description :
		<p>
			<s:property value="product.description" />
		</p>
		
		Product price :
		<s:property value="product.price" /><br>
		
		Order Id :
		<s:property value="orderId" /><br>
		
		<h5>Order Status :</h5>
		<P style="color:red"> <s:property value="currentStatus" /><br></P>
		
		<s:if test="hiddenStatus != 1">
			<s:checkbox name="updateStatus" id ="updateStatus" onclick="check(this.name)" /> Make Status Shipped
			<P style="color:red">* Check the above box to make the product shipped</P>
		</s:if>
		<s:else>
		<h5> Shipped DateTime :</h5> <P style="color:red"><s:property value ="shippedDateTime"/></P>
		</s:else>
		<h3>
		
		Customer Details : 
		</h3>		
		Name : <s:property value="user.firstName" /><br>
		Address : <s:property value="user.homeAddress" /><br>
		City : <s:property value="user.city" /><br>
		<br><br>
	</div>
</div>
</s:form>
</body>
</html>

