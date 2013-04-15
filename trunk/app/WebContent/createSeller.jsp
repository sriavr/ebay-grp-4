<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<head>
   <script type="text/javascript">
	$(document)
			.ready(
					function() {
						$("#myForm")
								.validate(
										{
											onkeyup : true,
											rules : {
												location : {
													required : true
												},

												sla :  {
													min: 0,
													max: 100,
													required : true,
													digits : true,
												},
												
												
												
											},
											messages : {
												location : {
													required: "location is mandatory"
												},
												
												sla : {
													
													min : "Discount percent should be within 0 and 100",
													max : "Discount percent should be within 0 and 100",
												    digits : "sla shouled be a percentage value"
												}
												
											}
										});

					
					});
	</script>
</head>
<div class="row">
 <font size="6"><b><u>WELCOME SELLER</u></b></font>
 
 <s:form action="createSeller" method="POST" name="myForm" id="myForm">
 <div class="panel">
   <font size="3"><b>You are not a registered seller .Register as Seller before selling</b></font><br>
  
   Location:
    <s:textfield name="location" placeholder="enter location,eg:city,State" theme="simple" id="location"></s:textfield><br>
   
    Percentage SLA
    <s:textfield name="sla" placeholder="enter sla as percentage value(1-100)" theme="simple" id="sla"></s:textfield><br>
   
  
   
 </div>
 
 <div class="panel">
 
    <input type="submit" name="register" value="register" class="small button round"/>
 </div>
 </s:form>
</div>