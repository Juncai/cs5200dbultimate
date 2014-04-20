<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Welcome to Bibliophile</title>
<link href="./css/bootstrap.css" rel="stylesheet">
<link href="./css/jumbotron.css" rel="stylesheet">
<style type="text/css">
#Title {
	font-family: "MS Serif", "New York", serif;
	font-size: 24px;
}

#nav {
	
}

body {
	background: #C0C0C0;
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

	
	
	    <div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">Project name</a>
        </div>
        
        <div class="navbar-collapse collapse">
        <c:choose>
			<c:when test="${empty sessionScope.user }">
			<form class="navbar-form navbar-right" role="form">
			<a href="<c:url value='/UserServlet?method=loginPre'/>" target="_parent" class="btn btn-info" role="button">Sign in </a>
			<a href="<c:url value='/UserServlet?method=registPre'/>" target="_parent" class="btn btn-info" role="button">Register</a>            
          </form>
			</c:when>
          <c:otherwise>
          <form class="navbar-form navbar-right" role="form">
			Hello, ${sessionScope.user.firstname }!&nbsp;&nbsp;|&nbsp;&nbsp; 
			<a href="<c:url value='/cart/CartServlet?method=showCart'/>" target="body">Shopping Cart</a>&nbsp;&nbsp;|&nbsp;&nbsp; 
			<a href="<c:url value='/order/OrderServlet?method=myOrders'/>" target="body">My Order</a>&nbsp;&nbsp;|&nbsp;&nbsp; 
			<a href="<c:url value='/UserServlet?method=quit'/>" target="_parent">Exit</a>
			</form>
			</c:otherwise>
			</c:choose>
        </div>
        
      </div>
    </div> 
    <div style="background-color=grey;"><h1>Biliophile -Your Online Book Store</h1>
    </div>
    
</body>
</html>

