<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML>
<html>
<head>

<title>Book Search Page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
			<link rel="stylesheet" type="text/css" href="styles.css">
			
<link href="css/ui-lightness/jquery-ui-1.9.2.custom.css"
	rel="stylesheet">
			-->

<link
	href="<c:url value='/jsps/css/ui-lightness/jquery-ui-1.9.2.custom.css'/>"
	rel="stylesheet">

<script src="<c:url value='/jsps/js/jquery-1.8.3.js'/>"></script>
<script src="<c:url value='/jsps/js/jquery-ui-1.9.2.custom.js'/>"></script>
<script>
	var totalItems = 0;
	var startIndex = 0;
	var itemsPerPage = 10;
	var totalPages = 0;
	
	$(function() {
		$("#tabs").tabs();
	});

	jQuery(init);

	function init() {
		
		jQuery("#searchBook").click(searchBookClicked);
	}

	function searchBookClicked() {
		
		var title = jQuery("#title").val();
		var author = $("#author").val();
		var publisher = $("#publisher").val();
		var isbn = $("#isbn").val();
		var category = $("#categoryType").val();
		var key = "AIzaSyCeqxZ0MaP49o78WFBW2T3d qnlNcYUKM5s";
		var searchUrl = "https://www.googleapis.com/books/v1/volumes?key=" + key + "&q="; 
		if(title!=null && title!="") {
			searchUrl += "+intitle:" + title;
		}
		if(author!=null && author!="") {
			searchUrl += "+inauthor:" + author;
		}
		if(publisher!=null && publisher !="") {
			searchUrl += "+inpublisher" + publisher;
		}
		if(isbn!=null && isbn!="") {
			searchUrl += "+isbn" + isbn;
		}
		searchUrl += "&startIndex=" + startIndex;
		searchUrl += "&maxResults=" + maxResults;
		
		
		jQuery.ajax({
			url : searchUrl,
			dataType : "jsonp",
			success : handleResponseOfNewSearch
		});
	}
	
	function handleResponseOfNewSearch(response) {
		
		totalItems = response.totalItems;
		var volumes = response.items;
		startIndex = 0;
		totalPages = totalItems/itemsPerPage;
		
		var list = jQuery("#bookList");
		list.empty();
		if(volumes) {
			var liStr = '<li id="123"><img height="100" src="http://123.456"/><span class="title"></span><span class="isbn"></span><button class="reserveButton">Reserve</button></li>';
			$("#itemCount").html(volumes.length);
			for(var m=0; m<volumes.length; m++) {
				var volume = volumes[m];
				var isbn = null;
				var identifierType = null;
				var isSale = (volume.saleInfo&&volume.saleInfo.saleability)?volume.saleInfo.saleability:false;
					if(volume.volumeInfo.industryIdentifiers) {
						
					for(var n=0; n<volume.volumeInfo.industryIdentifiers.length; n++) {
						var identifier = volume.volumeInfo.industryIdentifiers[n];
						
						if (identifier.type=="ISBN_10") {
							isbn=identifier.identifier;
							identifierType = identifier.type;
						} else if (identifierType!="ISBN_10" && identifier.type=="ISBN_13") {
							isbn=identifier.identifier;
							identifierType = identifier.type;
						} else {
							isbn=identifier.identifier;
							identifierType = identifier.type;
						}
					}
					}
					var id = volume.id;
					var title = volume.volumeInfo.title;
					var thumbnail = volume.volumeInfo.imageLinks? volume.volumeInfo.imageLinks.thumbnail : null;
					console.log([id, title]);
					
					var li = jQuery(liStr);
					
					li.attr("id", id);
					li.find("img").attr("src", thumbnail);
					li.find(".title").html(title);
					li.find(".isbn").html(isbn);
					if(!isSale) {
						li.find(".reserveButton").hide();
					}
					list.append(li);					
			} 
		}
		
		var pageStr='<a href=""></a>';
	}
	
	
	
</script>
<!-- 


 -->
<style type="text/css">
body {
	font-size: 10pt;
}

.icon {
	margin: 10px;
	border: solid 2px gray;
	width: 160px;
	height: 180px;
	text-align: center;
	float: left;
}
</style>

</head>

<body>
	<div id="tabs">
		<ul>
			<li><a href="#tabs-1">In Store Book Search</a></li>
			<li><a href="#tabs-2">Online Book Search</a></li>
		</ul>
		<div id="tabs-1">
		
		<select name="categories" id="categoryType">
			<c:forEach items="${categories }" var="category">
			  <option value="${category.categoryname }">${category.categoryname }</option>
			</c:forEach>
			</select>	
			<!-- 
		 -->
			<c:forEach items="${list }" var="book">
				<div class="icon">
					<%--book_img/9317290-1_l.jpg --%>
					<%-- <a href="<c:url value='/BookServlet?method=load&isbn=${book.isbn }'/>"><img src="/onlinebookstore/book_img/9317290-1_l.jpg"/></a> --%>
					<a
						href="<c:url value='/BookServlet?method=load&isbn=${book.isbn }'/>"><img
						src="<c:url value='/${book.cover }'/>" /></a> <br /> <a
						href="<c:url value='/BookServlet?method=load&isbn=${book.isbn }'/>">${book.title }</a>
				</div>
			</c:forEach>
		</div>
		<div id="tabs-2">
		
			Title <input id="title" /> &nbsp;&nbsp;
			Author <input id="author" /> &nbsp;&nbsp; <br/>
			Publisher <input id="publisher" /> &nbsp;&nbsp;
			ISBN <input id="isbn" />
					
			<button id="searchBook">Search</button>
			<div>
			<p id="itemCount">initial</p>
			<p id="GlobalTest">null</p>
			
			</div>
			<ol id="bookList">
			</ol>
			<div id="pageLink">
			</div>



		</div>

	</div>
</body>
</html>
