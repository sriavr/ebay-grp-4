<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create Listing</title>


   
    <style type="text/css">
        .web_dialog_overlay
        {
            position: fixed;
            top: 0;
            right: 0;
            bottom: 0;
            left: 0;
            height: 100%;
            width: 100%;
            margin: 0;
            padding: 0;
            background: #000000;
            opacity: .15;
            filter: alpha(opacity=15);
            -moz-opacity: .15;
            z-index: 101;
            display: none;
        }
        .web_dialog
        {
            display: none;
            position: fixed;
            width: 380px;
            height: 200px;
            top: 50%;
            left: 50%;
            margin-left: -190px;
            margin-top: -100px;
            background-color: #ffffff;
            border: 2px solid #336699;
            padding: 0px;
            z-index: 102;
            font-family: Verdana;
            font-size: 10pt;
        }
        .web_dialog_title
        {
            border-bottom: solid 2px #336699;
            background-color: #336699;
            padding: 4px;
            color: White;
            font-weight:bold;
        }
        .web_dialog_title a
        {
            color: White;
            text-decoration: none;
        }
        .align_right
        {
            text-align: right;
        }
    </style>
    <script type="text/javascript">

        $(document).ready(function ()
        {
            $("#btnShowSimple").click(function (e)
            {
                ShowDialog(false);
                e.preventDefault();
            });

            $("#btnShowModal").click(function (e)
            {
                ShowDialog(true);
                e.preventDefault();
            });

            $("#btnClose").click(function (e)
            {
                HideDialog();
                e.preventDefault();
            });

            $("#btnSubmit").click(function (e)
            {
                var brand = $("#brands input:radio:checked").val();
                $("#output").html("<b>Your favorite mobile brand: </b>" + brand);
                HideDialog();
                e.preventDefault();
            });
        });

        function ShowDialog(modal)
        {
            $("#overlay").show();
            $("#dialog").fadeIn(300);

            if (modal)
            {
                $("#overlay").unbind("click");
            }
            else
            {
                $("#overlay").click(function (e)
                {
                    HideDialog();
                });
            }
        }

        function HideDialog()
        {
            $("#overlay").hide();
            $("#dialog").fadeOut(300);
        } 
        
    </script>
 
</head>

 <div class="row">
  <s:form theme="simple" action="createListing.action" enctype="multipart/form-data">
  <s:if test="hasActionErrors()">
			<div class="panel">
							<br />
							<s:iterator value="actionErrors">
								<div data-alert class="alert-box success">
								 <a href="#" class="close">&times;</a>
									<s:property />
								</div>
							</s:iterator>
			</div>				
						</s:if>
        <div class="panel">
	       Sell Your Item steps >> 1.Tell us What You sell  <font size="3"><b>2.Create your Listing</b></font>  3.Review your listing
	    </div>
		<div class="panel">
		
		 <font size="3"><b>Categories where your list will appear </b></font> <br>
		  Category<br>
		  <s:property value="selection"/> 
		  <s:hidden name="selection" value="%{selection}"/>
		   <s:hidden name="selectedCategoryId" value="%{selectedCategoryId}"/>
        <s:hidden name="selectedsubCategoryId" value="%{selectedsubCategoryId}"/>
        <s:hidden name="selectedsubsubCategoryId" value="%{selectedsubsubCategoryId}"/>
		  
		</div>
		
		<div class="panel">
		 <font size="3"><b>Help buyers find your item with a great title </b></font> 
		 
		 <s:label value="Title"/>
		 <s:textfield name="title"></s:textfield>
		</div>
		
		<div class="panel">
		 <font size="3"><b>Item Specifics</b></font><br>
		 <font size="3">Add more information to help buyers find your item in search results. Buyers can use popular item specifics to refine their search and locate your item faster.</font>
		<table>
		 <s:iterator value="itemspefics" status="stat">
		   
		     <tr>
		       <td><s:textfield name = "itemspefics[%{#stat.index}].property"/> </td>
		       
		        <td><s:textfield name = "itemspefics[%{#stat.index}].value"/> </td>
		     </tr>
		   
		 </s:iterator>
		</table>
		<a href="#" id="btnShowModal" >Add Item Specific</a>
		 
		</div>
	<div id="overlay" class="web_dialog_overlay"></div>
<div id="dialog" class="web_dialog">
        <table style="width: 100%; border: 0px;" cellpadding="3" cellspacing="0">
             <tr>
         <td class="web_dialog_title">Type in a unique detail that your buyers might look for.</td>
         <td class="web_dialog_title align_right">
            <a href="#" id="btnClose">Close</a>
         </td>
         </tr>
            <tr>
              <td>Enter Property Name</td>
              <td> <s:textfield  theme="simple" name="propertyName" tooltip="eg:Brand,Material,Year" placeholder="Enter Property Name"></s:textfield> 
            </tr>
            <tr>
                <td>Enter Property Value</td>
              <td> <s:textfield  theme="simple" name="propertyValue"  tooltip="eg:Ty,Plastic,2007" placeholder="Enter Property Value"></s:textfield> 
            </tr>
          <tr>
           <td><input type="submit" value="Save" name="itemSpec" class="small button"/>
          </tr>
        </table>
    </div>  	
		<div class="panel">
		  <font size="3"><b>Bring your Item to life with pictures</b></font><br>
		    <s:file name="userImage" label="User Image" />
            <s:submit value="Upload" align="center" name="upload"/>

            <a class="th radius" href="#" style="width:100px">
              <img src='<s:property value="filename"/>'>
            </a>
  
		   <s:hidden name="filename" value="%{filename}"/>
		</div>
		<div class="panel">
		<font size="3"><b>Describe your Item in Words</b></font><br>
		 <s:textarea  theme="simple" name="description"/>
		</div>
		<div class="panel">
		   <font size="3"><b>Fixed Price</b></font><br>
		    <font size="2">Buy It Now price*</font><br>
		    <div class="row">
		   <div class="small-2 columns">
		    Rs.<s:textfield cssClass="label" theme="simple" name="price"  tooltip="Enter Price"></s:textfield> <br>
		    </div>
		    </div>
		    
		    
		    <font  size="2">Quantity*</font><br>
		    <div class="row">
		    <div class="small-2 columns">
		    <s:textfield  theme="simple" name="quantity" tooltip="Quantity" size="4"></s:textfield>
		    </div>
		    </div>
		    <font size="2">Discount</font><br>
		    <div class="row">
		     <div class="small-2 columns">
		      Rs.<s:textfield  theme="simple" name="discount"  tooltip="Enter Discount"/>
		    </div>
		    </div>
		</div>
		
	<div class="panel">
	  <input type="submit" value="Save" name="save" class="small button"/>
	</div>	
	</s:form>	
</div>		




</html>