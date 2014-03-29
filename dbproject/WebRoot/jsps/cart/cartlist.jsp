<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'bookdesc.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
	* {
		font-size: 11pt;
	}
	div {
		margin:20px;
		border: solid 2px gray;
		width: 150px;
		height: 150px;
		text-align: center;
	}
	li {
		margin: 10px;
	}
	
	#buy {
		background: url(<c:url value='/images/all.png'/>) no-repeat;
		display: inline-block;
		
		background-position: 0 -902px;
		margin-left: 30px;
		height: 36px;
		width: 146px;
	}
	#buy:HOVER {
		background: url(<c:url value='/images/all.png'/>) no-repeat;
		display: inline-block;
		
		background-position: 0 -938px;
		margin-left: 30px;
		height: 36px;
		width: 146px;
	}
</style>
  </head>
  
  <body>
<h1>Shopping Cart</h1>

<c:choose> 
	<c:when test="${empty cartItems }">
		<p style="text-align: center;">
			<img src="<c:url value='/images/cart.png'/>"/>
			<span>The shopping cart is empty. </span>
		</p>
	</c:when>
	<c:otherwise>
	


<table border="1" width="100%" cellspacing="0" background="black">
	<tr>
		<td colspan="7" align="right" style="font-size: 15pt; font-weight: 900">
			<a href="<c:url value='/cart/CartServlet?method=clear'/>">Clear Shopping Cart</a>
		</td>
	</tr>
	<tr>
		<th>Cover</th>
		<th>Title</th>
		<th>Author</th>
		<th>Price</th>
		<th>Quantity</th>
		<th>Subtotal</th>
		<th>Actions</th>
	</tr>
	<c:forEach items="${cartItems }" var="cartItem">
	<tr>
		<td><div><img src="<c:url value='/${cartItem.book.cover }'/>"/></div></td>
		<td>${cartItem.book.title }</td>
		<td><c:forEach items="${cartItem.book.authors }" var="author" >${author.firstname } ${author.lastname }  </c:forEach></td>
		<td>$ <fmt:formatNumber value="${cartItem.book.price }" pattern="0.00"/></td>
		<td>${cartItem.count }</td>
		<td>$ <fmt:formatNumber value="${cartItem.subtotal }" pattern="0.00"/></td>
		<td><a href="<c:url value='/cart/CartServlet?method=del&isbn=${cartItem.book.isbn }'/>">Delete</a></td>
	</tr>
	</c:forEach>
	<tr>
		<td colspan="7" align="right" style="font-size: 15pt; font-weight: 900">
			Total: $ <fmt:formatNumber value="${sessionScope.cart.total }" pattern="0.00"/>
		</td>
	</tr>
	<tr>
		<td colspan="7" align="right" style="font-size: 15pt; font-weight: 900">
			<a href="<c:url value='/order/OrderServlet?method=add'/>">Place Order</a>
		</td>
	</tr>
</table>
	
	</c:otherwise>
</c:choose>
  </body>
</html>

