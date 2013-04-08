<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<style>
	label{
	display:inline;
	}
</style>
<script  type="text/javascript">
	function rating(id,parent){
		switch(id)
		{
		
		case parent+"_1":{ 	if(parent=="1"){
			element1=document.getElementById("itemrating1");
			element1.value=1;
			}
			else if(parent=="2"){
			element2=document.getElementById("itemrating2");
			element2.value=1;
			}
			else if(parent=="3"){
				element3=document.getElementById("itemrating3");
				element3.value=1;	
			}
				    document.getElementById(parent+"_1").src="images/solid-star.png";
				    document.getElementById(parent+"_2").src="images/blank-star.png";
				    document.getElementById(parent+"_3").src="images/blank-star.png";
				    document.getElementById(parent+"_4").src="images/blank-star.png";
				    document.getElementById(parent+"_5").src="images/blank-star.png";   
				};
				break;
		case parent+"_2":{ 
			if(parent=="1"){
				element1=document.getElementById("itemrating1");
				element1.value=2;
				}
				else if(parent=="2"){
				element2=document.getElementById("itemrating2");
    			element2.value=2;
				}
				else if(parent=="3"){
					element3=document.getElementById("itemrating3");
					element3.value=2;	
				}
	    			document.getElementById(parent+"_1").src="images/solid-star.png";
				    document.getElementById(parent+"_2").src="images/solid-star.png";
	    			document.getElementById(parent+"_3").src="images/blank-star.png";
	    			document.getElementById(parent+"_4").src="images/blank-star.png";
	    			document.getElementById(parent+"_5").src="images/blank-star.png";   
				};
				break;
		case parent+"_3":{ 	
			if(parent=="1"){
				element1=document.getElementById("itemrating1");
				element1.value=3;
				}
				else if(parent=="2"){
				element2=document.getElementById("itemrating2");
    			element2.value=3;
				}
				else if(parent=="3"){
					element3=document.getElementById("itemrating3");
					element3.value=3;	
				}
	    			document.getElementById(parent+"_1").src="images/solid-star.png";
	    			document.getElementById(parent+"_2").src="images/solid-star.png";
	    			document.getElementById(parent+"_3").src="images/solid-star.png";
	    			document.getElementById(parent+"_4").src="images/blank-star.png";
	    			document.getElementById(parent+"_5").src="images/blank-star.png";   
				};
				break;
		case parent+"_4":{ 	
			if(parent=="1"){
				element1=document.getElementById("itemrating1");
				element1.value=4;
				}
				else if(parent=="2"){
				element2=document.getElementById("itemrating2");
    			element2.value=4;
				}
				else if(parent=="3"){
					element3=document.getElementById("itemrating3");
					element3.value=4;	
				}
	    			document.getElementById(parent+"_1").src="images/solid-star.png";
	    			document.getElementById(parent+"_2").src="images/solid-star.png";
	    			document.getElementById(parent+"_3").src="images/solid-star.png";
	    			document.getElementById(parent+"_4").src="images/solid-star.png";
	    			document.getElementById(parent+"_5").src="images/blank-star.png";   
				};
				break;
		case parent+"_5":{ 	
					if(parent=="1"){
					element1=document.getElementById("itemrating1");
					element1.value=5;
					}
					else if(parent=="2"){
					element2=document.getElementById("itemrating2");
	    			element2.value=5;
					}
					else if(parent=="3"){
						element3=document.getElementById("itemrating3");
						element3.value=5;	
					}
	    			document.getElementById(parent+"_1").src="images/solid-star.png";
	    			document.getElementById(parent+"_2").src="images/solid-star.png";
	    			document.getElementById(parent+"_3").src="images/solid-star.png";
	    			document.getElementById(parent+"_4").src="images/solid-star.png";
	    			document.getElementById(parent+"_5").src="images/solid-star.png";   
				};
				break;
		}
	}
</script>
	<hr/>
	<div class="large-3 columns">
		<a class="th radius" data-reveal-id="myModal" href="#"> <img
			alt="<s:property value="description" />"
			src="<%=request.getContextPath()%><s:property value="%{product.photo}" />">
				</a>
	</div>
	
	<div class="large-9 columns">
		<div class="row">
			
				<div class="large-3 columns">
				<s:property value="%{product.title}"/>
				<s:property value="%{product.description}"/>
				</div>
				<div class="large-3 columns">
				<s:property value="%{product.price}"/>
					
				<br>					
				
				</div>		
		
		</div>
		
	</div>
	<hr/>
	<h4>
<s:form action="submitFeedback" method="post">
<s:hidden name="productId" value="%{productId}">
</s:hidden>
<s:hidden name="userId" value="%{userId}">
</s:hidden>
<s:hidden name="sellerId" value="%{sellerId}">
</s:hidden>
	<div >
	Feedback:
		<s:radio name="rate" list="ratings" value="defaultValue" theme="simple"></s:radio>
	</div>
	<div >
	Rate the Item:
	<s:hidden id="itemrating1" name="rate1">
	
			<img id="1_1" src="images/blank-star.png" width="16" height="16" onclick="rating(this.id,1)">
		
			<img id="1_2" src="images/blank-star.png" width="16" height="16" onclick="rating(this.id,1)">
		
			<img id="1_3" src="images/blank-star.png" width="16" height="16" onclick="rating(this.id,1)">
		
			<img id="1_4" src="images/blank-star.png" width="16" height="16" onclick="rating(this.id,1)">
		
			<img id="1_5" src="images/blank-star.png" width="16" height="16" onclick="rating(this.id,1)">
	
	</s:hidden>
	</div>
	<div>
	Rate the Transaction:
	<s:hidden id="itemrating2" name="rate2">
		
			<img id="2_1" src="images/blank-star.png" width="16" height="16" onclick="rating(this.id,2)">
		
			<img id="2_2" src="images/blank-star.png" width="16" height="16" onclick="rating(this.id,2)">
		
			<img id="2_3" src="images/blank-star.png" width="16" height="16" onclick="rating(this.id,2)">
		
			<img id="2_4" src="images/blank-star.png" width="16" height="16" onclick="rating(this.id,2)">
		
			<img id="2_5" src="images/blank-star.png" width="16" height="16" onclick="rating(this.id,2)">
		
	</s:hidden>
	</div>
	<div >
	Rate the Seller:
	<s:hidden id="itemrating3" name="rate3">
	
			<img id="3_1" src="images/blank-star.png" width="16" height="16" onclick="rating(this.id,3)">
		
			<img id="3_2" src="images/blank-star.png" width="16" height="16" onclick="rating(this.id,3)">
		
			<img id="3_3" src="images/blank-star.png" width="16" height="16" onclick="rating(this.id,3)">
		
			<img id="3_4" src="images/blank-star.png" width="16" height="16" onclick="rating(this.id,3)">
	
			<img id="3_5" src="images/blank-star.png" width="16" height="16" onclick="rating(this.id,3)">
	
	</s:hidden>
	</div>
	<div>
	Item Description:
	<s:textfield name="description" size="20"></s:textfield>
	</div>
	<div>
	<s:submit   ></s:submit>
	</div>
</s:form>
	</h4>