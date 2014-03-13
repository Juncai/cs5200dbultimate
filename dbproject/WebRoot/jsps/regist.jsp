<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>User Signup</title>
</head>

<body>
 <h1>Signup </h1>
 <p style="color: red; font-weight: 900">${msg }</p>
 <form id="form1" name="form1" method="post" action="<c:url value='/UserServlet' />">
 	<input type="hidden" name="method" value="regist"/>
   <p>Email*: 
     <input type="text" name="email" id="email" />
   </p>
   <p>Password*: 
     <input type="password" name="password" id="password" />
   </p>
   <p>First Name*: 
     <input type="text" name="firstname" id="firstname" />
   </p>
   <p>Last Name*:
   <input type="text" name="lastname" id="lastname" />
   </p>
   <p>Middle Name:
     <input type="text" name="middlename" id="middlename" />
   </p>
   <p>Gender:
     <select name="gender" id="gender">
       <option value="null"> </option>
       <option value="male">Male</option>
       <option value="female">Female</option>
     </select>
   </p>
   <p>Cellphone:
     <input type="text" name="cellphone" id="cellphone" />
   </p>
   <p>
     <input type="submit" name="submit" id="submit" value="Signup" />
     <br />
   </p>
 </form>
 <p>&nbsp;</p>
</body>
</html>

