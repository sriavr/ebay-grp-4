<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Scroller</title>

<!-- include jQuery + carouFredSel plugin -->
<%-- <script type="text/javascript" language="javascript" --%>
<%-- 	src="js/jquery-1.8.2.min.js"></script> --%>
<%-- <script type="text/javascript" language="javascript" --%>
<%-- 	src="js/jquery.carouFredSel-6.2.0-packed.js"></script> --%>

<!-- optionally include helper plugins -->
<%-- <script type="text/javascript" language="javascript" --%>
<%-- 	src="js/jquery.mousewheel.min.js"></script> --%>
<%-- <script type="text/javascript" language="javascript" --%>
<%-- 	src="js/jquery.touchSwipe.min.js"></script> --%>
<%-- <script type="text/javascript" language="javascript" --%>
<%-- 	src="js/jquery.transit.min.js"></script> --%>
<%-- <script type="text/javascript" language="javascript" --%>
<%-- 	src="js/jquery.ba-throttle-debounce.min.js"></script> --%>
<!-- fire plugin onDocumentReady -->
<script type="text/javascript" language="javascript">
	// 	$(function() {

	// 		//	Basic carousel, no options
	// 		$('#foo0').carouFredSel();

	// 		//	Basic carousel + timer, using CSS-transitions
	// 		$('#foo1').carouFredSel({
	// 			auto : {
	// 				pauseOnHover : 'resume',
	// 				progress : '#timer1'
	// 			}
	// 		}, {
	// 			transition : true
	// 		});

	// 		//	Scrolled by user interaction
	// 		$('.foo2').carouFredSel({
	// 			width:500,
	// 			auto : false,
	// 			prev : '.prev2',
	// 			next : '.next2',
	// 			pagination : ".pager2",
	// 			mousewheel : true,
	// 			swipe : {
	// 				onMouse : true,
	// 				onTouch : true
	// 			}
	// 		});

	// 		//	Variable number of visible items with variable sizes
	// 		$('#foo3').carouFredSel({
	// 			width : 360,
	// 			height : 'auto',
	// 			prev : '#prev3',
	// 			next : '#next3',
	// 			auto : false
	// 		});

	// 		//	Responsive layout, resizing the items
	// 		$('#foo4').carouFredSel({
	// 			responsive : true,
	// 			width : '100%',
	// 			scroll : 2,
	// 			items : {
	// 				width : 400,
	// 				//	height: '30%',	//	optionally resize item-height
	// 				visible : {
	// 					min : 2,
	// 					max : 6
	// 				}
	// 			}
	// 		});

	// 		//	Fuild layout, centering the items
	// 		$('#foo5').carouFredSel({
	// 			width : '100%',
	// 			scroll : 2
	// 		});

	// 	});
</script>
<style type="text/css" media="all">
/*
html,body {
	padding: 0;
	margin: 0;
}

body,div,p {
	font-family: Arial, Helvetica, Verdana;
	color: #333;
}

body {
	background-color: #eee;
}

h1 {
	font-size: 60px;
}

a,a:link,a:active,a:visited {
	color: black;
	text-decoration: underline;
}

a:hover {
	color: #9E1F63;
}

#intro {
	width: 580px;
	margin: 0 auto;
}

.wrapper {
	background-color: white;
	width: 480px;
	margin: 40px auto;
	padding: 50px;
	box-shadow: 0 0 5px #999;
}

.list_carousel {
	background-color: #ccc;
	margin: 0 0 30px 60px;
	width: 360px;
}

.list_carousel ul {
	margin: 0;
	padding: 0;
	list-style: none;
	display: block;
}

.list_carousel li {
	font-size: 40px;
	color: #999;
	text-align: center;
	background-color: #eee;
	border: 5px solid #999;
	width: 250px;
	height: 250px;
	padding: 0;
	margin: 6px;
	display: block;
	float: left;
}

.list_carousel.responsive {
	width: auto;
	margin-left: 0;
}

.clearfix {
	float: none;
	clear: both;
}

.prev {
	float: left;
	margin-left: 10px;
}

.next {
	float: right;
	margin-right: 10px;
}

.pager {
	float: left;
	width: 800px;
	text-align: center;
}

.pager a {
	margin: 0 5px;
	text-decoration: none;
}

.pager a.selected {
	text-decoration: underline;
}

.timer {
	background-color: #999;
	height: 6px;
	width: 0px;
}
*/
</style>

</head>
<body>
	<s:iterator value="productGroups" var="parent">
		<s:if test="#parent.deals.size()!=0">
			<div class="row" style="border: 1px solid black;">
				<h2>
					Category Name:
					<s:property value="#parent.category.categoryName" />
				</h2>
				<s:iterator var="child" value="#parent.deals">
					<div class="row">
						<div class="columns large-3">
							<img
								src="<%=request.getContextPath()%><s:property value="#child.photo" />"
								alt="" />
						</div>
						<div class="columns large-9">
							<s:url action="productdealdetails" var="urlTag">
								<s:param name="productId" value="productId"></s:param>
							</s:url>
							Name: <a href="<s:property value="#urlTag"></s:property>"> <s:text
									name="title"></s:text>
							</a> <br /> Product ID:
							<s:property value="#child.productId" />
							<br /> MRP Price:
							<s:property value="#child.price" />
							<br /> Selling Price:
							<s:property value="#child.dealSellingPrice" />
						</div>
					</div>
				</s:iterator>
			</div>
		</s:if>
	</s:iterator>
</body>
</html>
