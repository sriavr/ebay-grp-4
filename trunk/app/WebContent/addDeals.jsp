<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<html>
<head>
  
<script language="javascript" type="text/javascript"
	src="js/datetimepicker.js"></script>
	
 <script type="text/javascript">
 
 jQuery.validator.addMethod("mydate", function(value, element) { 
	   return this.optional(element) || /^\d\d?-\w\w\w-\d\d\d\d/.test(value); 
	 }, "Please specify the date in DD-MMM-YYYY format");
 
	$(document)
			.ready(
					function() {
						$("#myForm")
								.validate(
										{
											onkeyup : true,
											rules : {
												
												endDate : {
													mydate : true
												},
												
												startDate : {
													 mydate : true
										            },

												price :  {
													
													required : true,
													digits : true,
												},
												
												
												
											},
											messages : {
												
												
												price : {
													
									                  digits : "Price should be numeric",
									                  required : "Price is mandatory to add deals"
												}
												
											}
										});

					
					});
	</script>	
	
</head>



<div class="row">
	<div class="small-6 columns">
		<div class="panel">
			<s:form name="dealform" action="addDeals" theme="simple" id="myForm">

				

				<s:label value="Deal Start Date" />
				<br>
              
			     <s:textfield   id="startDate"
								name="startDate"
								value="%{startDate}" cssClass="label" theme="simple" />
							<a
								href="javascript:NewCal('startDate','ddmmmyyyy',false,24)"><img
								src="images/cal.gif" width="16" height="16" border="0"
								alt="Pick a date"></a>
								
				<br>

				<s:label value="Deal End Date" />
				<br>
                
				  <s:textfield   id="endDate"
								name="endDate"
								value="%{endDate}" cssClass="label" theme="simple" />
							<a
								href="javascript:NewCal('endDate','ddmmmyyyy',false,24)"><img
								src="images/cal.gif" width="16" height="16" border="0"
								alt="Pick a date"></a>
					
					<br>

				<s:label value="Deal Seling Price" />
				<br>
                <s:textfield name="deal.price" id="price"
					value="%{deal.price}">
				</s:textfield>
				
				<s:hidden name="deal.productId" value="%{productId}"/>
				<s:hidden name="productId" value="%{productId}"/>
				
				<br>
				 
				 <input type="submit" value="save" class="small button round"/>
					
			</s:form>

		</div>
	</div>
</div>

</html>