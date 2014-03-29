<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
	body {
		font-size: 10pt;
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


</style>
  </head>
  
  <body>
  <div>
    <img src="<c:url value='/${book.cover }'/>" border="0"/>
  </div>
  <ul>
    <li>Title: ${book.title }</li>
    <li>Authors: <c:forEach items="${book.authors }" var="author">${author.firstname } ${author.lastname }    </c:forEach></li>
    <li>Price: $ ${book.price }</li>
  </ul>
  <form id="form" action="<c:url value='/cart/CartServlet'/>" method="post">
  	<input type="hidden" name="method" value="add"/>
  	<input type="hidden" name="isbn" value="${book.isbn }"/>
  	<input type="text" size="3" name="count" value="1"/>
  </form>
  <a href="javascript:document.getElementById('form').submit();">Buy</a>
  </body>
</html>
