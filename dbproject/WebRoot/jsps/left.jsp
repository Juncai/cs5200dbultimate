<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base target="body" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>LeftNavigationBar</title>
<style type="text/css">
	*{
		font-size:10pt;
		text-align: center;
	}
	div {
		background: #87CEFA; 
		margin: 3px; 
		padding: 3px;
	}
	a {
		text-decoration: none;
	}
</style>
</head>

<body>
	<div>
    	<a href="<c:url value='/BookServlet?method=all'/>">All Category</a>
    </div>
    
    <c:forEach items="${list }" var="category">
	<div>
    	<a href="<c:url value='/BookServlet?method=query&categoryID=${category.categoryID }'/>">${category.categoryname }</a>
    </div>
	</c:forEach>   
</body>
</html>

