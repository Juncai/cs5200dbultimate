<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'left.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	<script type="text/javascript" src="<c:url value='/menu/mymenu.js'/>"></script>
	<link rel="stylesheet" href="<c:url value='/menu/mymenu.css'/>" type="text/css" media="all">
<script language="javascript">

var bar1 = new Q6MenuBar("bar1", "Bibliophiles Online Bookstore");
function load() {
	bar1.colorStyle = 2;
	bar1.config.imgDir = "<c:url value='/menu/img/'/>";
	bar1.config.radioButton=false;

	bar1.add("Category Admin", "All Categories", "<c:url value='/admin/AdminCategoryServlet?method=all'/>", "body");
	bar1.add("Category Admin", "Add Category", "<c:url value='/admin/AdminCategoryServlet?method=addPre'/>", "body");

	bar1.add("Book Admin", "All Books", "<c:url value='/admin/AdminBookServlet?method=all'/>", "body");
	bar1.add("Book Admin", "Add book", "<c:url value='/admin/AdminBookServlet?method=addPre'/>", "body");

	bar1.add("Order Admin", "All Orders", "<c:url value='/admin/AdminOrderServlet?method=all'/>", "body");
	bar1.add("Order Admin", "Unpaid Orders", "<c:url value='/admin/AdminOrderServlet?method=findByState&state=1'/>", "body");
	bar1.add("Order Admin", "Paid Orders", "<c:url value='/admin/AdminOrderServlet?method=findByState&state=2'/>", "body");
	bar1.add("Order Admin", "Unconfirmed Orders", "<c:url value='/admin/AdminOrderServlet?method=findByState&state=3'/>", "body");
	bar1.add("Order Admin", "Completed Orders", "<c:url value='/admin/AdminOrderServlet?method=findByState&state=4'/>", "body");
	

	var d = document.getElementById("menu");

	d.innerHTML = bar1.toString();
}
</script>

</head>

<body onload="load()" style="margin: 0px; background: rgb(254,238,189);">
<div id="menu"></div>

</body>
</html>

