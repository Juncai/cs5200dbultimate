<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>当前订单</title>

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
	border: solid 2px gray;
	width: 75px;
	height: 75px;
	text-align: center;
}

li {
	margin: 10px;
}

#buy {
	background: url(< c : url value = '/images/all.png'/ >) no-repeat;
	display: inline-block;
	background-position: 0 -412px;
	margin-left: 30px;
	height: 36px;
	width: 146px;
}

#buy:HOVER {
	background: url(< c : url value = '/images/all.png'/ >) no-repeat;
	display: inline-block;
	background-position: 0 -448px;
	margin-left: 30px;
	height: 36px;
	width: 146px;
}
</style>
</head>

<body>
	<h1>Order Details</h1>

	<table border="1" width="100%" cellspacing="0" background="black">
		<tr bgcolor="gray" bordercolor="gray">
			<td colspan="6">Order: ${order.orderID } Order Time: <fmt:formatDate
					value="${order.ordertime }" pattern="yyyy-MM-dd HH:mm:ss" />
				Total: <font color="red"><b>$ <fmt:formatNumber
							value="${order.total }" pattern="#.00" /></b></font>
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
				<td>Subtotal: $ <fmt:formatNumber value="${orderItem.subtotal }"
						pattern="#.00" />
				</td>
			</tr>
		</c:forEach>
	</table>
	<br />
	<form method="post" action="#" id="form" target="_parent">
		Delivery Address: <input type="text" name="address" size="50"
			value="" /><br />
	</form>
	<a href="<c:url value='/order/OrderServlet?method=updatePay&orderID=${order.orderID }'/>">Make Payment</a>

</body>
</html>
