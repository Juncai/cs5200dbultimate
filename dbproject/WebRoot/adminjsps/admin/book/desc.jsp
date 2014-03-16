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
  	<script type="text/javascript">
  		function _del(e) {
  			var flag = window.confirm("Do you want to delete the book?");
  			if(!flag) {
  				if (e && e.preventDefault) {//FireFox
  					e.preventDefault();
  				} else {//IE
  			   		window.event.returnValue = false;
  				}
  			}
  		}
  	</script>
<style type="text/css">
	body {
		font-size: 10pt;
		background: rgb(254,238,189);
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
  <form style="margin:20px;" id="form" action="<c:url value='/admin/AdminBookServlet'/>" method="post">
  	<input type="hidden" name="isbn" value="${book.isbn }"/>
  	Title: <input type="text" name="title" value="${book.title }"/><br/>
  	Price: $ <input type="text" name="price" value="${book.price }"/><br/>
  	Author: <input type="text" name="author" value=""/><br/>
  	Category: <select style="width: 150px; height: 20px;" name="categoryID"> 
			<c:forEach items="${categoryList }" var="category">
     		<c:choose>
     			<c:when test="${category.categoryID == book.category.categoryID }">
     				<c:set var="ok" value="selected='selected'"/>
     			</c:when>
     			<c:otherwise>
     				<c:set var="ok" value=""/>
     			</c:otherwise>
     		</c:choose>
     		<option value="${category.categoryID }" ${ok }>${category.categoryname }</option>
     		</c:forEach>

		</select><br/>
  	<input type="submit" name="method" value="del" onclick="_del(event);"/>
  	<input type="submit" name="method" value="mod"/>
  </form>
  </body>
</html>
