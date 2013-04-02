<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="row">
 <font size="6"><b><u>WELCOME SELLER</u></b></font>
 
 <s:form action="createSeller" method="POST">
 <div class="panel">
   <font size="3"><b>You are not a registered seller .Register as Seller before selling</b></font><br>
  
   Location:
    <s:textfield name="location" placeholder="enter location,eg:city,State" theme="simple"></s:textfield><br>
   
    
   
  
   
 </div>
 
 <div class="panel">
 
    <input type="submit" name="register" value="register" class="small button round"/>
 </div>
 </s:form>
</div>