<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<body>
	<div class="row">
	<div class="panel">
	 Sell Your Item steps >> <font size="3"><b>1.Tell us What You sell</b></font>  2.Create your Listing  3.Review your listing
	</div>
	
		<div class="panel">
			Select a suitable Category for your product


			<s:form action="makeListing.action" id='myform' theme="simple">

				<div class="row">


					<div class="small-4 columns">
						<s:select list="categoryList" id="catList" listKey="categoryID"
							listValue="categoryName" name="selectedCategoryId"
							  multiple="true"
							onclick="javascript:document.getElementById('myform').submit()"
							 />
					</div>
					<div class="small-4 columns">
						<s:select list="subcategoryList" id="subcatList"
							listKey="categoryID" listValue="categoryName"
							name="selectedsubCategoryId"  
							multiple="true"
							onclick="javascript:document.getElementById('myform').submit()" />
					</div>
					<div class="small-4 columns">
						<s:select list="subsubcategoryList" id="subsubcatList"
							listKey="categoryID" listValue="categoryName"
							name="selectedsubsubCategoryId"  
							multiple="true"
							onclick="javascript:document.getElementById('myform').submit()" />
					</div>
				</div>

                 <div class="row">
                   <input type="submit" value="continue" class="small button round" name="cont"/>
                 </div> 
        
			</s:form>
			
			<div class="row">
			  Your selection list : <s:property value="selection"/>
			</div>

		</div>
	</div>
	
</body>
</html>