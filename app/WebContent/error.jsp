<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<style type="text/css">
div.excerpt {
	height: 5em;
	overflow: hidden;
}

div.excerpt:hover {
	height: auto;
}
</style>
<h2>An unexpected error has occurred</h2>
<p>Please report this error to your system administrator or
	appropriate technical support personnel. Thank you for your
	cooperation.</p>
<hr />
<h3>Error Message</h3>
<p>
	<s:actionerror />
	<s:property value="%{exception.message}" />
</p>
<hr />
<h3>Technical Details</h3>
<b>Hover to see more details</b>
<div class="excerpt">
	<s:property value="%{exceptionStack}" />
</div>
