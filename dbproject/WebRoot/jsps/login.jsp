<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>User Login</title>
</head>

<body>
<h1>User Login</h1>
<p style="color: red; font-weight: 900">${msg }</p>
<form id="form1" name="form1" method="post" action="<c:url value='/UserServlet?method=login' />">
  <p>Email:
    <input type="text" name="email" id="email"  />
  </p>
  <p>Password:
    <input type="password" name="password" id="password" />
  </p>
  <p>
    <input type="submit" name="login" id="login" value="login" />
  </p>
</form>
</body>
</html>

