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
	var currentPage = 1;

	$(function() {
		$("#tabs").tabs();
	});

	jQuery(init);

	function init() {
		jQuery("#searchBook").click(searchBookClicked);
		jQuery(".fPage").click(searchBookClicked);
		jQuery(".pPage").click(prevPage);
		jQuery(".nPage").click(nextPage);
	}

	function searchBookClicked() {

		var title = jQuery("#title").val();
		var author = $("#author").val();
		var publisher = $("#publisher").val();
		var isbn = $("#isbn").val();
		startIndex = 0;
		var searchUrl = urlGen(title, author, publisher, isbn, startIndex,
				itemsPerPage);
		// initialize the page link
		$(".pageLink").hide();
		currentPage = 1;

		// use books api to get search results
		jQuery.ajax({
			url : searchUrl,
			dataType : "jsonp",
			success : handleResponseOfNewSearch
		});
	}

	var urlGen = function(title, author, publisher, isbn, startIndex,
			itemsPerPage) {
		var key = "AIzaSyCeqxZ0MaP49o78WFBW2T3d qnlNcYUKM5s";
		var searchUrl = "https://www.googleapis.com/books/v1/volumes?key="
				+ key + "&q=";
		if (title != null && title != "") {
			searchUrl += "+intitle:" + title;
		}
		if (author != null && author != "") {
			searchUrl += "+inauthor:" + author;
		}
		if (publisher != null && publisher != "") {
			searchUrl += "+inpublisher" + publisher;
		}
		if (isbn != null && isbn != "") {
			searchUrl += "+isbn" + isbn;
		}
		searchUrl += "&startIndex=" + startIndex;
		searchUrl += "&maxResults=" + itemsPerPage;

		return searchUrl;
	};

	function handleResponseOfNewSearch(response) {

		totalItems = response.totalItems;
		var volumes = response.items;
		totalPages = Math.ceil(totalItems / itemsPerPage);

		var list = jQuery("#bookList");
		list.empty();
		if (volumes) {
			var liStr = '<li id="123"><img height="100" src="http://123.456"/><span class="title"></span><span class="isbn"></span><button class="reserveButton">Reserve</button></li>';
			for (var m = 0; m < volumes.length; m++) {
				var volume = volumes[m];
				var isbn = null;
				var identifierType = null;
				var isSale = (volume.saleInfo && volume.saleInfo.saleability) ? volume.saleInfo.saleability
						: false;
				if (volume.volumeInfo.industryIdentifiers) {

					for (var n = 0; n < volume.volumeInfo.industryIdentifiers.length; n++) {
						var identifier = volume.volumeInfo.industryIdentifiers[n];

						if (identifier.type == "ISBN_10") {
							isbn = identifier.identifier;
							identifierType = identifier.type;
						} else if (identifierType != "ISBN_10"
								&& identifier.type == "ISBN_13") {
							isbn = identifier.identifier;
							identifierType = identifier.type;
						} else {
							isbn = identifier.identifier;
							identifierType = identifier.type;
						}
					}
				}
				var id = volume.id;
				var title = volume.volumeInfo.title;
				var thumbnail = volume.volumeInfo.imageLinks ? volume.volumeInfo.imageLinks.thumbnail
						: null;

				var li = jQuery(liStr);

				li.attr("id", id);
				li.find("img").attr("src", thumbnail);
				li.find(".title").html(title);
				li.find(".isbn").html(isbn);
				if (!isSale) {
					li.find(".reserveButton").hide();
				}
				list.append(li);
			}
		}
		
		$(".pageLink").show();
		$(".pageLink").find("#cPage").text(currentPage);
		$(".pageLink").find("#tPage").text(totalPages);
		if (currentPage == 1) {
			$(".pageLink").find(".fPage").hide();
			$(".pageLink").find(".pPage").hide();
			$(".pageLink").find(".nPage").show();
		} else if(currentPage == totalPages) {
			$(".pageLink").find(".nPage").hide();
			$(".pageLink").find(".pPage").show();
			$(".pageLink").find(".fPage").show();
		} else {
			$(".pageLink").find(".nPage").show();
			$(".pageLink").find(".pPage").show();
			$(".pageLink").find(".fPage").show();
		}

	}

	function prevPage() {
		if (currentPage > 1) {
			currentPage -= 1;
			var title = jQuery("#title").val();
			var author = $("#author").val();
			var publisher = $("#publisher").val();
			var isbn = $("#isbn").val();
			startIndex = (currentPage - 1) * itemsPerPage;
			var searchUrl = urlGen(title, author, publisher, isbn, startIndex,
					itemsPerPage);

			// use books api to get search results
			jQuery.ajax({
				url : searchUrl,
				dataType : "jsonp",
				success : handleResponseOfNewSearch
			});
		}

	}

	function nextPage() {
		if (currentPage < totalPages) {
			
			currentPage += 1;
			var title = jQuery("#title").val();
			var author = $("#author").val();
			var publisher = $("#publisher").val();
			var isbn = $("#isbn").val();
			startIndex = (currentPage - 1) * itemsPerPage;
			var searchUrl = urlGen(title, author, publisher, isbn, startIndex,
					itemsPerPage);

			// use books api to get search results
			jQuery.ajax({
				url : searchUrl,
				dataType : "jsonp",
				success : handleResponseOfNewSearch
			});
		}
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
		<form method="post" action="<c:url value='/BookServlet?method=search' />">
			Title <input name="title" /> &nbsp;&nbsp; Author <input name="author" />
			&nbsp;&nbsp; <br /> Publisher <input name="publisher" /> &nbsp;&nbsp;
			ISBN <input name="isbn" />
			<!-- <select name="categories" id="categoryType">
				<c:forEach items="${categories }" var="category">
					<option value="${category.categoryname }">${category.categoryname }</option>
				</c:forEach>
			</select> -->
			<button type="submit">Search</button>
		
		</form>
			
			<br /> <br />
			<c:choose>
				<c:when test="${empty msg }">
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
				</c:when>
				<c:otherwise>
				<p>${msg }</p>
				</c:otherwise>
			</c:choose>

			
		</div>
		<div id="tabs-2">
			
			Title <input id="title" /> &nbsp;&nbsp; Author <input id="author" />
			&nbsp;&nbsp; <br /> Publisher <input id="publisher" /> &nbsp;&nbsp;
			ISBN <input id="isbn" />
			<button id="searchBook">Search</button>
			<br /> <br />
		
		<div class="pageLink" hidden>
				<button class="fPage">FIRST</button>
				<button class="pPage">PREV</button>
				Page <b id="cPage">12</b> / <b id="tPage">10</b>
				<button class="nPage">NEXT</button>
			</div>
		<div>
			<ol id="bookList">
			</ol>
		</div>
		<div class="pageLink" hidden>
			<button class="fPage">FIRST</button>
			<button class="pPage">PREV</button>
			Page <b id="cPage">12</b> / <b id="tPage">10</b>
			<button class="nPage">NEXT</button>
		</div>
	</div>
	</div>
</body>
</html>
