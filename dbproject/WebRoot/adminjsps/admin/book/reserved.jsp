<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>Reserved Book List</title>

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
	<h1>Reserved Books</h1>

	<table border="1" width="100%" cellspacing="0" background="black">
		<c:forEach items="${bookList }" var="book">
			<tr bgcolor="gray" bordercolor="gray" align="center">
				<td width="15%">
					<div>
						<c:choose>
							<c:when test="${fn:startsWith(book.cover, 'book_img') }">
								<img src="<c:url value='/${book.cover }'/>" height="75" />
							</c:when>
							<c:otherwise>
								<img src="${book.cover }" height="75" />
							</c:otherwise>
						</c:choose>
					</div>
				</td>
				<td>Title: ${book.title }</td>
				<td>Authors: <c:forEach items="${book.authors }"
						var="author">${author.firstname } ${author.lastname }    
						</c:forEach>
				</td>
				<td>
			<form action="<c:url value='/admin/AdminBookServlet?method=addReserved&isbn=${book.isbn }'/>" method="post">
				Price: $ <input name="price" type="text" value="${book.price }"/><br/>
				<input type="submit" value="Add"/>
				</form>
				</td>
				
			</tr>
		</c:forEach>

	</table>
</body>
</html>
