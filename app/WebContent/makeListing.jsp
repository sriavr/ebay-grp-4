<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Make Listing</title>
<link rel="stylesheet" href="styles/foundation/normalize.css" />
<link rel="stylesheet" href="styles/foundation/foundation.css" />
</head>
<body>
	<div class="row">
		<div class="panel">
			Select Categories






			<s:form action="makeListing.action" id='myform'>

				<div class="row">


					<div class="small-4 columns">
						<s:select list="categoryList" id="catList" listKey="categoryID"
							listValue="categoryName" name="selectedCategoryId"
							cssClass="label" theme="simple" multiple="true"
							onclick="javascript:document.getElementById('myform').submit()"
							cssStyle="color:white" />
					</div>
					<div class="small-4 columns">
						<s:select list="subcategoryList" id="subcatList"
							listKey="categoryID" listValue="categoryName"
							name="selectedsubCategoryId" cssClass="label" theme="simple"
							multiple="true"
							onclick="javascript:document.getElementById('myform').submit()" />
					</div>
					<div class="small-4 columns">
						<s:select list="subsubcategoryList" id="subsubcatList"
							listKey="categoryID" listValue="categoryName"
							name="selectedsubsubCategoryId" cssClass="label" theme="simple"
							multiple="true"
							onclick="javascript:document.getElementById('myform').submit()" />
					</div>
				</div>

			</s:form>
			
			<div class="row">
			  Your selection list : <s:property value="selection"/>
			</div>

		</div>
	</div>
	
	<div class="row">
	  <a href="#" class="button">Continue</a>
	</div>
</body>
</html>