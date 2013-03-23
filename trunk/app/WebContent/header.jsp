<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<head>
<script type="text/javascript" src="/script/jquery-1.7.2.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<s:form action="browse.action">
	<s:textfield name="query" label="Search"></s:textfield>
	<s:submit value="Search"></s:submit>
</s:form>