<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
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
		<h2>
			<s:property value="product.title" />
		</h2>
		<p>
			<s:property value="product.description" />
		</p>
	</div>
	<div class="row">
		<div class="columns large-8">		
			<h5>
				Price (Rs.):
				<s:textfield name="price"  value="%{product.price}"  />
			</h5>
		</div>
	</div>
		<h5>
				Quantity Present:
		<s:textfield name="quantity" value ="%{product.quantity}" />
		</h5>
		<h5>
				Discount (%) :
		<s:textfield name="discount"  value="%{product.discount}"  />
		</h5>
	<div class="panel">
            <input type="submit" class="small button round" value="Update"  />
    </div>
    <s:hidden name="productId" value ="%{product.productId}" />
</div>
</s:form>
</body>
</html>

