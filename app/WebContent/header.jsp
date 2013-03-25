<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet" href="styles/foundation/normalize.css" />
  <link rel="stylesheet" href="styles/foundation/foundation.css" />


</head>
<body>

	     <div class="row">

<div class="small-2 columns"><img alt src="images/ebay.jpg"></div>
<div class="small-2 columns">
 <span>
 Welcome !
 <a href="#">Sign in</a>
 or
 <a href="#">Register</a>
 </span>

</div>

<div class="small-8 columns">
  <nav class="top-bar">
  
  <section class="top-bar-section">
    <!-- Left Nav Section -->
    <ul class="left">
      <li class="divider"></li>
      <li class="has-dropdown"><a href="#">My eBay</a>
        <ul class="dropdown">
          <li><a href="#">Summary</a></li>
           <li><a href="#">Bids/Offers</a></li>
             <li><a href="#">Watch List</a></li>
             <li><a href="#">All List</a></li>
        </ul>
       
      </li>
      <li class="divider"></li>
      <li><a href="#">My  Paisa Pay</a></li>
      <li class="divider"></li>
      <li class="has-dropdown"><a href="#">Sell</a>

        <ul class="dropdown">
          <li><a href="#">How to Sell</a>
          <li><a href="#">Seller Central</a> 
          <li><a href="#">Seller Tools</a> 
              
        </ul>
      </li>
      <li class="divider"></li>
      <li class="has-dropdown"><a href="#">Community</a>

        <ul class="dropdown">
          <li><a href="#">News</a>
          <li><a href="#">FeedBack forum</a> 
          <li><a href="#">FeedBack To eBay</a> 
              
        </ul>
      </li> 
      <li class="divider"></li>
        <li><a href="#">Cart</a>
    </ul>
    </section>
  </nav>
</div>
</div>

 <div class="row">
  
  <nav class="top-bar">
  
  <section class="top-bar-section">
    <!-- Right Nav Section -->
    <ul class="center">
       <li class="has-form">
        <s:form action="browse.action" theme="simple">
          
            <div class="small-6 columns">
              <s:textfield name="query" label="Search"/>
            </div>
            <div class = "small-4 columns">
              <select  name="categories" 	>
               <option>All categories</option>
               <option>Mobiles</option>
               <option>Cars</option>
               <option>Sports</option>
              </select>
            </div>
            <div class="small-2 columns">
              <a href="browse.action" class="button">Search</a>
             </div>
          
        </s:form>
      </li>
     
    </ul>
  
</section>
</nav>





</div>

	
	
</body>
</html>