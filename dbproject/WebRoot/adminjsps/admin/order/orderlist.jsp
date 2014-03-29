<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

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
	border: solid 2px rgb(78, 78, 78);
	width: 75px;
	height: 75px;
	text-align: center;
}

li {
	margin: 10px;
}
</style>
</head>

<body style="background: rgb(254,238,189);">
	<h1>Order List</h1>

	<table border="1" width="100%" cellspacing="0" background="black">

		<c:forEach items="${orderList }" var="order">
			<tr bgcolor="gray" bordercolor="gray">
				<td colspan="6">Order: ${order.orderID } Order Time: <fmt:formatDate
						value="${order.ordertime }" pattern="yyyy-MM-dd HH:mm:ss" />
					Total：<font color="red"><b>$ ${order.total }</b></font> <c:choose>
						<c:when test="${order.state eq 1 }">Unpaid</c:when>
						<c:when test="${order.state eq 2 }"><a
								href="<c:url value='/admin/AdminOrderServlet?method=updateDeliver&orderID=${order.orderID }'/>">Ship</a></c:when>
						<c:when test="${order.state eq 3 }">Wait for confirm</c:when>
						<c:when test="${order.state eq 4 }">Order completed</c:when>
					</c:choose>
				</td>
			</tr>
			<c:forEach items="${order.orderItemSet }" var="orderItem">
				<tr bordercolor="gray" align="center">
					<td width="15%">
						<div>
							<img src="<c:url value='/${orderItem.book.cover }'/>" height="75" />
						</div>
					</td>
					<td>Title: ${orderItem.book.title }</td>
					<td>Price: $ ${orderItem.book.price }</td>
					<td>Authors: <c:forEach items="${orderItem.book.authors }"
							var="author">${author.firstname } ${author.lastname }    </c:forEach></td>
					<td>Quantity: ${orderItem.count }</td>
					<td>Subtotal: $ <fmt:formatNumber
							value="${orderItem.subtotal }" pattern="#.00" />
					</td>
				</tr>
			</c:forEach>
		</c:forEach>

	</table>
</body>
</html>
