<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base target="body" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>LeftNavigationBar</title>
<link href="./css/bootstrap.css" rel="stylesheet">

<style type="text/css">
body{
	background-color: #f7f7f9;
}
</style>
</head>

<body>
 	
    	
    	<a href="<c:url value='/BookServlet?method=all'/>" class="list-group-item">All Category</a>

     <c:forEach items="${list }" var="category">
	<div >
    	<a href="<c:url value='/BookServlet?method=query&categoryID=${category.categoryID }'/>" class="list-group-item">${category.categoryname }</a>
    </div>
	</c:forEach>   

          
</body>
</html>

