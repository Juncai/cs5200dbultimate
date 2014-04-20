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
                <a class="navbar-brand" href="#home">Bookstore</a>
            </div>
         <div class="collapse navbar-collapse navbar-ex1-collapse navbar-left">
                <ul class="nav navbar-nav">
                    <li><a href="about.jsp">About</a>
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
                    <li><a href="<c:url value='/cart/CartServlet?method=showCart'/>" target="body">Shopping Cart</a>
                    </li>
                    <li><a href="<c:url value='/order/OrderServlet?method=myOrders'/>" target="body">My Order</a>
                    </li>
                    <li><a href="<c:url value='/UserServlet?method=quit'/>" target="_parent">Exit</a>
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

        <div class="row" >

            <div class="col-md-3">
                <p class="lead">Category</p>
			 <iframe frameborder="0" height=100% width=100%
					src="<c:url value='/IndexServlet?method=left' />" name="left"></iframe> 
               
            </div>

            <div class="col-md-9">

                <div class="row carousel-holder">

                    <div class="col-md-12">
                        <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
                            <ol class="carousel-indicators">
                                <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                                <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                                <li data-target="#carousel-example-generic" data-slide-to="2"></li>
                            </ol>
                            <div class="carousel-inner">
                                <div class="item active">
                                    <img class="slide-image" src="http://www.weupcycle.com/wp-content/uploads/2012/02/kindlebuch1-800x300.jpg" alt="">
                                </div>
                                <div class="item">
                                    <img class="slide-image" src="http://www.rojaksite.com/wp-content/uploads/2011/12/book-sculptures-guy-laramee-800x300.jpg" alt="">
                                </div>
                                <div class="item">
                                    <img class="slide-image" src="http://isocialtv.com/sites/default/files/vth/townhalls/splashes/image_027-800x300.jpg?1340545140" alt="">
                                </div>
                            </div>
                            <a class="left carousel-control" href="#carousel-example-generic" data-slide="prev">
                                <span class="glyphicon glyphicon-chevron-left"></span>
                            </a>
                            <a class="right carousel-control" href="#carousel-example-generic" data-slide="next">
                                <span class="glyphicon glyphicon-chevron-right"></span>
                            </a>
                        </div>
                    </div>

                </div>

                <div class="row">

		<iframe id="iFrame1" frameborder="0" height=100% src="<c:url value='/IndexServlet?method=body' />" name="body"  ></iframe>

            </div>

        </div>

    </div>
    </div>
    <!-- /.container -->

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
    <!-- /.container -->

    <!-- JavaScript -->
    <script src="./js/jquery-2.1.0.js"></script>
    <script src="./js/bootstrap.js"></script>

</body>

</html>