<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Bookstore</title>

    <!-- Bootstrap core CSS -->
    <link href="./css/bootstrap.css" rel="stylesheet">

    <!-- Add custom CSS here -->
    <link href="./css/shop-homepage.css" rel="stylesheet">
    

<style type="text/css">
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

    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
        <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.jsp">Bookstore</a>
            </div>
         <div class="collapse navbar-collapse navbar-ex1-collapse navbar-left">
                <ul class="nav navbar-nav">
                    <li><a href="#about">About</a>
                    </li>
                    <li><a href="#services">Services</a>
                    </li>
                    <li><a href="#contact">Contact</a>
                    </li>
                </ul>
            </div>
            
         <div class="navbar-collapse collapse navbar-ex1-collapse navbar-right">
        <c:choose>
			<c:when test="${empty sessionScope.user }">
			<form class="navbar-form navbar-right" role="form">
			<a href="<c:url value='/UserServlet?method=loginPre'/>" target="_parent" class="btn btn-default" role="button">Sign in </a>
			<a href="<c:url value='/UserServlet?method=registPre'/>" target="_parent" class="btn btn-default" role="button">Register</a>            
          </form>
			</c:when>
          <c:otherwise>
			 <div class="collapse navbar-collapse navbar-ex1-collapse navbar-right">
                <ul class="nav navbar-nav">
                    <li><a href="#">Hello, ${sessionScope.user.firstname }! </a>
                    </li>
                    <li><a href="#">Shopping Cart</a>
                    </li>
                    <li><a href="#">My Order</a>
                    </li>
                    <li><a href="#">Exit</a>
                    </li>
                </ul>
            </div>
			</c:otherwise>
			</c:choose>
        </div>
          
        </div>
        <!-- /.container -->
    </nav>
    <div class="container">

        <div class="row">

            <div class="col-lg-12">
                <h1 class="page-header">About Us
                    <small>It's Nice to Meet You!</small>
                </h1>
                <p>Our team planed to build a bookstore which can be accessed by both a web browser and a mobile app.</p>
                <p>We used J2EE techniques to program on the server part. Tomcat is our local server. In our local database, we stored the books we have in the bookstore at the moment, the rating, the comment of each book and all the other local information. We will retrieve from the cloud some other information such as all the books of an author.</p>
            	<p>We also programed an Android app on the client part. The app will have the same function as the browser, but more adaptive on the mobile.</p>
            </div>

            <div class="col-lg-12">
                <h1 class="page-header">Project Description

                </h1>
                <p>  The goal of our project is to implement an online book store that provides both front end and back end functionalities. The front end functionalities include customer signup and sign in, book searching and shopping, order placing and paying, book rating and review. The back end functionalities include inventory management, order management.
                 The online book store is implemented as a web application which can be accessed from standard HTML browsers. The web application is power by Java EE platform including Tomcat web server, Java servlets, web pages implemented with JavaServer Page (JSP) and JavaServer Pages Standard Tag Library (JSTL). A relational database is built to store 
                 information about customers, books, orders and reviews. The database is implemented on MySQL database server and can interact with our Java web application through Java DataBase Connectivity (JDBC). Book relevant information is acquired through Amazon Product Advertising API which implements the Representational State Transfer (REST) API. Information of books that are currently available or reserved by the customers would have a copy and be stored in local database. Information about other books would be acquired from the Amazon Product Advertising API when a search is performed. Thus we can maintain a good balance between space requirement and response speed.</p>
            </div>
            
            <div class="col-lg-12">
                <h2 class="page-header">Our Team</h2>
            </div>

        </div>

        <div class="row">
            <div class="col-lg-4 col-sm-6">
                <img class="img-circle img-responsive" src="http://placehold.it/200x200">
                <h3>Tengjiao Chen
                    
                </h3>
                <p>What does this team member to? Keep it short! This is also a great spot for social links!</p>
            </div>
            <div class="col-lg-4 col-sm-6">
                <img class="img-circle img-responsive" src="http://placehold.it/200x200">
                <h3>Jun Cai
                    
                </h3>
                <p>What does this team member to? Keep it short! This is also a great spot for social links!</p>
            </div>
            <div class="col-lg-4 col-sm-6">
                <img class="img-circle img-responsive" src="http://placehold.it/200x200">
                <h3>Tancheng Zhuang
                    
                </h3>
                <p>What does this team member to? Keep it short! This is also a great spot for social links!</p>
            </div>

        </div>
        
            <div class="container">

        <hr>

        <footer>
            <div class="row">
                <div class="col-lg-12">
                    <p>Copyright &copy; Database Group Project
                    </p>
                </div>
            </div>
        </footer>

    </div>