<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="styles/foundation/normalize.css" />
  <link rel="stylesheet" href="styles/foundation/foundation.css" />
  
  <script language="javascript" type="text/javascript">
	function refresh() {
		document.getElementById("myform").action = "gradeAction";
		document.getElementById("myform").method="post";
		document.getElementById("myform").submit();
	}
	function tryFunc(node){
	    var root = node.parentNode.parentNode;
	   
	    var allRows = root.getElementsByTagName('tr');
	    var cRow = allRows[2].cloneNode(true);
	    root.appendChild(cRow);
	}
	
	function addRow(tableID) {

		
		var table = document.getElementById(tableID);
		var rowCount = table.rows.length;
		
		var row = table.insertRow(rowCount);
        rowCount = parseInt(rowCount)-2;
       
		var cell1 = row.insertCell(0);
		var element1 = document.createElement("input");
		element1.type = "checkbox";
		element1.name="categoryList["+rowCount+"].selected";
		element1.value="true";
		element1.checked = 'checked';
		element1.onclick="javascript:onSelect(this.id);";
		cell1.appendChild(element1);

		

		var cell2 = row.insertCell(1);
		var element2 = document.createElement("input");
		element2.type = "text";
		element2.name = "categoryList["+rowCount+"].categoryName";
	
		element2.id="namein["+rowCount+"]";
		
		cell2.appendChild(element2);
		
		
		var cell3 = row.insertCell(2);
		var element3 = document.getElementById("catList").cloneNode(true);
		element3.name = "categoryList["+rowCount+"].parentCategoryId";
		
		cell3.appendChild(element3);
		
		var cell4 = row.insertCell(3);
		var element4 = document.createElement("input");
		element4.type = "hidden";
		element4.name = "categoryList["+rowCount+"].categoryID";
		element4.value= "0";
		
		cell4.appendChild(element4);
		


	}
	
	function onSelect(checkId)
	{
		
		var elements=checkId.split("_");
		
		var select = document.getElementById(checkId);
		
		if(select.checked==true)
	    {
			
		   
			document.getElementById("namein["+elements[2]+"]").disabled = false;
			
			
	    }
		else
		{
			document.getElementById("namein["+elements[2]+"]").disabled=true;
		}	
		
	}

	
</script>

</head>
<body>
 <s:form action="saveCategory.action" method="GET" theme="simple" id="myForm"> 
  <div class="row">
  
    <div class="large-12 columns">
    <table id="categories">
       <thead>
       <tr>
        <th colspan="3">Manage Categories/SubCategories</th>
       </tr>
    <tr>
    <th>Select</th>
  
      <th width="300">Category Name</th>
      <th width="300">Parent Category</th>
    </tr>
  </thead>
  <tbody>
  
  <s:iterator value="categoryList" status="stat" >
		<tr>
				
			
		    <td width="2"><s:checkbox value="%{selected}" name="categoryList[%{#stat.index}].selected"
								theme="simple" onclick="javascript:onSelect(this.id);"/></td>
			<td><s:textfield id="namein[%{#stat.index}]"
								name="categoryList[%{#stat.index}].categoryName"
								value="%{categoryName}"  theme="simple" disabled="true" size="100" />
								
			
								
								
								
		   </td>
		   
		 
		 
		   <td>
		     <s:select  headerKey="0" headerValue="--Select--" list="categoryList" id="catList"   listKey="categoryID" listValue="categoryName" name="categoryList[%{#stat.index}].parentCategoryId"  theme="simple"/>
		      <s:hidden name="categoryList[%{#stat.index}].categoryID" value="%{categoryID}" />
		   </td>
		   
		  
		</tr>
	</s:iterator>
	
    </tbody>
    </table>
     
     </div>
   
  </div>
 
  <div class="row">
   <ul class="button-group">
  <li><input type="button" value="Add Row" onclick="javascript:addRow('categories');" class="small button"/></li>
  <li><input type="submit" value="Save" class="small button"/></li>
   <li><input type="submit" value="Delete" class="small button"/></li>
</ul>
   
  </div>
 </s:form>
</body>
</html>