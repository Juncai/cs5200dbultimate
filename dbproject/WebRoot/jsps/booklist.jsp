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
	.icon {
		margin:10px;
		border: solid 2px gray;
		width: 160px;
		height: 180px;
		text-align: center;
		float: left;
	}
</style>
  </head>
  
  <body>
  <c:forEach items="${list }" var="book"> 
  <div class="icon">
  	<%--book_img/9317290-1_l.jpg --%>
  	<%-- <a href="<c:url value='/BookServlet?method=load&isbn=${book.isbn }'/>"><img src="/onlinebookstore/book_img/9317290-1_l.jpg"/></a> --%>
    <a href="<c:url value='/BookServlet?method=load&isbn=${book.isbn }'/>"><img src="<c:url value='/${book.cover }'/>"/></a>
      <br/>
   	<a href="<c:url value='/BookServlet?method=load&isbn=${book.isbn }'/>">${book.title }</a>
  </div>
</c:forEach>
  </body>
 
</html>
