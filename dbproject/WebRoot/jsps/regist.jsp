<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

<title>User Sign up</title>


    <!-- Bootstrap core CSS -->
    <link href="./css/bootstrap.css" rel="stylesheet">


<style type="text/css">
body {
  padding-top: 40px;
  padding-bottom: 40px;
  background-color: #eee;
}

.form-signin {
  max-width: 330px;
  padding: 15px;
  margin: 0 auto;
}
.form-signin .form-signin-heading,
.form-signin .checkbox {
  margin-bottom: 10px;
}
.form-signin .checkbox {
  font-weight: normal;
}
.form-signin .form-control {
  position: relative;
  font-size: 16px;
  height: auto;
  padding: 10px;
  -webkit-box-sizing: border-box;
     -moz-box-sizing: border-box;
          box-sizing: border-box;
}
.form-signin .form-control:focus {
  z-index: 2;
}
.form-signin input[type="text"] {
  margin-bottom: -1px;
  border-bottom-left-radius: 0;
  border-bottom-right-radius: 0;
}
.form-signin input[type="password"] {
  margin-bottom: 10px;
  border-top-left-radius: 0;
  border-top-right-radius: 0;
}
</style>

</head>

<body>
   <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#home">Bookstore</a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse navbar-ex1-collapse">
                <ul class="nav navbar-nav">
                    <li><a href="#about">About</a>
                    </li>
                    <li><a href="#services">Services</a>
                    </li>
                    <li><a href="#contact">Contact</a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>
    
      <div class="container">
		<p style="color: red; font-weight: 900">${msg }</p>
		<form class="form-signin" role="form" id="form1" name="form1" method="post" action="<c:url value='/UserServlet' />">
 		<input type="hidden" name="method" value="regist"/>
        <h2 class="form-signin-heading">Sign up</h2>
        <p>Email:<span class="glyphicon glyphicon-asterisk" style="float:right;"></span>
     		<input type="text" class="form-control" placeholder="Email address" required autofocus name="email" id="email" />
  		 </p>
  		  <p>Password:<span class="glyphicon glyphicon-asterisk" style="float:right;"></span> 
    		 <input type="password" class="form-control" placeholder="Password" required name="password" id="password" />
  		 </p>
  		 <p>First Name:<span class="glyphicon glyphicon-asterisk" style="float:right;"></span> 
   		  <input type="text" class="form-control" placeholder="First Name" required name="firstname" id="firstname" />
  		 </p>
  		 <p>Last Name:<span class="glyphicon glyphicon-asterisk" style="float:right;"></span>
   			<input type="text" class="form-control" placeholder="Last Name" required name="lastname" id="lastname" />
  		 </p>
  		 <p>Middle Name:
    		 <input type="text" class="form-control" placeholder="Middle Name" name="middlename" id="middlename" />
 		  </p>
 		  <p>Gender:
     		<select class="form-control" name="gender" id="gender">
       		<option value="null"> </option>
       		<option value="male">Male</option>
       		<option value="female">Female</option>
     		</select>
   		  </p>
   		  <p>Cellphone:
  		   <input type="text" class="form-control" placeholder="Cellphone" name="cellphone" id="cellphone" />
   		</p>
   		
     
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign up</button>
      </form>

    </div> 
</body>
</html>

