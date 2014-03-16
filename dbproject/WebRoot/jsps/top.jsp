<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Welcome to Bibliophile</title>
<style type="text/css">
#Title {
	font-family: "MS Serif", "New York", serif;
	font-size: 24px;
}

#nav {
	
}

body {
	background: #4682B4;
}

a {
	text-transform: none;
	text-decoration: none;
}

a:hover {
	text-decoration: underline;
}
h1 {
	text-align: center;
}
div {
	font-size: 10pt;
}
</style>
</head>

<body>
	<h1>Biliophile -Your Online Book Store</h1>
	<div id="nav">
		<c:choose>
			<c:when test="${empty sessionScope.user }">
			<a href="<c:url value='/UserServlet?method=loginPre'/>"
			target="_parent">Login</a> &nbsp;|&nbsp; 
			<a href="<c:url value='/UserServlet?method=registPre'/>" target="_parent">Sign up </a> 
			</c:when>
			<c:otherwise>
			Hello, ${sessionScope.user.firstname }!&nbsp;&nbsp;|&nbsp;&nbsp; 
			<a href="<c:url value='/cart/CartServlet?method=showCart' />" target="body">Shopping Cart</a>&nbsp;&nbsp;|&nbsp;&nbsp; 
			<a href="<c:url value='/order/OrderServlet?method=myOrders' />" target="body">My Order</a>&nbsp;&nbsp;|&nbsp;&nbsp; 
			<a href="<c:url value='UserServlet?method=quit' />" target="_parent">Exit</a>
			</c:otherwise>
		</c:choose>
	</div>
</body>
</html>

