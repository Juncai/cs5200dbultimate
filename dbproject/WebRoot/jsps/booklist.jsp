<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'bookdesc.jsp' starting page</title>
        <!-- Bootstrap core CSS -->
    <link href="./css/bootstrap.css" rel="stylesheet">
    
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
function iframeAutoFit()
{
    
    try
    {
        if(window!=parent)
        {
            var a = parent.document.getElementsByTagName("IFRAME");
            for(var i=0; i<a.length; i++) //author:meizz
            {
                if(a[i].contentWindow==window)
                {
                    var h1=0, h2=0;
                    if(document.documentElement&&document.documentElement.scrollHeight)
                    {
                        h1=document.documentElement.scrollHeight;
                    }
                    if(document.body) h2=document.body.scrollHeight;
                    var h=Math.max(h1, h2);
                    if(document.all) {h += 0;}
                    if(window.opera) {h += 1;}
                    a[i].style.height = h +"px";
                }
            }
        }
    }
    catch (ex){}
}
if(document.attachEvent)
{
    window.attachEvent("onload",  iframeAutoFit);
    window.attachEvent("onresize",  iframeAutoFit);
}
else
{
    window.addEventListener('load',  iframeAutoFit,  false);
    window.addEventListener('resize',  iframeAutoFit,  false);
}
</script> 


	
<style type="text/css">
	body {
		font-size: 10pt;
		background-color: #f7f7f9;
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
   <div class="col-sm-4 col-lg-4 col-md-4 col-xs-4">
                        <div class="thumbnail">
                            <img src="<c:url value='/${book.cover }'/>" />
                            <div class="caption">
                                <h4 class="pull-right">$ ${book.price }</h4>
                                <h5> 	<a href="<c:url value='/BookServlet?method=load&isbn=${book.isbn }'/>">${book.title }</a>
                                </h5>
                                <p>See more books like this online store item at.</p>
                            </div>
                            <div class="ratings">
                                <p class="pull-right">15 reviews</p>
                                <p>
                                    <span class="glyphicon glyphicon-star"></span>
                                    <span class="glyphicon glyphicon-star"></span>
                                    <span class="glyphicon glyphicon-star"></span>
                                    <span class="glyphicon glyphicon-star"></span>
                                    <span class="glyphicon glyphicon-star"></span>
                                </p>
                            </div>
                        </div>
                    </div> 

</c:forEach>

    <!-- JavaScript -->
    <script src="./js/jquery-2.1.0.js"></script>
    <script src="./js/bootstrap.js"></script>

  </body>
 
</html>
