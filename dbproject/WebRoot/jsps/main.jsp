<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<title>Welcome to Bibliophile</title>
<link href="./css/bootstrap.css" rel="stylesheet">
<style type="text/css">
body{
	background-color: #f7f7f9;
}

#Title {
	font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;
	font-size: 24px;
}

#nav {
	
}

iframe {
	width: 100%;
	height: 100%;
}
</style>

</head>

<body>
	<table width="1024" height="100%" align="center">
		<tr style="background: #C0C0C0; height: 200px; ">
			<td colspan="2" align="center"><iframe frameborder="0"
					src="<c:url value='/IndexServlet?method=top' />" name="top"></iframe></td>
		</tr>
		<tr>
			<td width="200" height=100%; style="padding:0px;" align="center" valign="top">
				<iframe frameborder="0"
					src="<c:url value='/IndexServlet?method=left' />" name="left"></iframe>
			</td>
			<td><iframe frameborder="0" src="<c:url value='/IndexServlet?method=body'/>" name="body" ></iframe></td>
		</tr>
	</table>
</body>
</html>

