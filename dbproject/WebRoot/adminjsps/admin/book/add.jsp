<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>Add Book</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<meta http-equiv="content-type" content="text/html;charset=utf-8">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link
	href="<c:url value='/jsps/css/ui-lightness/jquery-ui-1.9.2.custom.css'/>"
	rel="stylesheet">

<script src="<c:url value='/jsps/js/jquery-1.8.3.js'/>"></script>
<script src="<c:url value='/jsps/js/jquery-ui-1.9.2.custom.js'/>"></script>

<script>
	var totalItems = 0;
	var startIndex = 0;
	var itemsPerPage = 1;

	jQuery(init);

	function init() {
		jQuery("#searchISBN").click(searchISBNClicked);
	}

	function searchISBNClicked() {
		var isbn = $("#isbn").val();
		if(isbn != null &&  isbn != ""){			
		var searchUrl = urlGen(isbn, startIndex, itemsPerPage);
		

		// use books api to get search results
		jQuery.ajax({
			url : searchUrl,
			dataType : "jsonp",
			success : handleISBNSearch
		});
		}
	}

	var urlGen = function(isbn, startIndex, itemsPerPage) {
		var key = "AIzaSyCeqxZ0MaP49o78WFBW2T3dqnlNcYUKM5s";
		var searchUrl = "https://www.googleapis.com/books/v1/volumes?key="
				+ key + "&q=";
		if (isbn != null && isbn != "") {
			searchUrl += "+isbn:" + isbn;
		}
		searchUrl += "&startIndex=" + startIndex;
		searchUrl += "&maxResults=" + itemsPerPage;

		return searchUrl;
	}

	function handleISBNSearch(response) {
		var volumes = response.items;
		if (volumes) {
			
			for (var m = 0; m < volumes.length; m++) {
				var volume = volumes[m];
				
				// get isbn
				var isbn = null;
				var identifierType = null;
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
				
				// add authors to the author list
				var authorList = jQuery("#authors");
				authorList.empty();
				for(var m=0; m < volume.volumeInfo.authors.length; m++){
					// get first name and last name
					var nameArray = volume.volumeInfo.authors[m].split(" ");
					var firstName = nameArray[0];
					var lastName = "";
					if (nameArray.length == 2){
						lastName = nameArray[1];
					} else if(nameArray.legnth == 3){
						lastName = nameArray[2];
					}
					var liStr = '<li><p id="firstName"></p> &nbsp; <p id="lastName"></p></li>';
					var li = jQuery(liStr);
					li.find("#firstName").text(firstName);
					li.find("#lastName").text(lastName);
					authorList.append(li);
				}
				
				// add category to the selects
				var category = volume.volumeInfo.categories[0];
				var categorySelect = jQuery("#category");
				var categoryLiStr = '<option selected="selected" value="">abc</option>';
				var categoryLi = jQuery(categoryLiStr);
				categoryLi.attr("value", category);
				categoryLi.text(category);
				categorySelect.append(categoryLi);
				
				// display the book info on the page
				var id = volume.id;
				var title = volume.volumeInfo.title;
				var thumbnail = volume.volumeInfo.imageLinks ? volume.volumeInfo.imageLinks.thumbnail
						: "http://www.pizzapizza.ca/wpf/wp-content/themes/PPLWebFinal_v1/images/no-image.gif";
				var publisher = volume.volumeInfo.publisher;
				var price = volume.saleInfo.listPrice;
				$("#isbn").attr("value", isbn);
				$("#title").text(title);
				$("#publisher").text(publisher);
				 $("#cover").attr("src", thumbnail);
				$("#price").attr("value", price);
				

				// generate json string of book and add to the hidden input
					var jbook = {
							isbn: isbn,
							title: title,
							cover: thumbnail,
							publisher: publisher,
							categories: volume.volumeInfo.categories,
							authors: volume.volumeInfo.authors,
							price: price
					};
					$("#bookJson").attr("value", JSON.stringify(jbook, null, 2));
			}
		} else {
			alert("No record for the entered ISBN");
			$("#isbn").val(null);
			$("#title").text(null);
			$("#publisher").text(null);
			 $("#cover").attr("src", null);
			$("#price").attr("value", null);
			$("#authors").empty();
			$("#bookJson").attr("value", null);
		}
	}

</script>

<style type="text/css">
body {
	background: rgb(254, 238, 189);
}
</style>
</head>

<body>
	<h1>Add Book</h1>
	<p style="font-weight: 900; color: red">${msg }</p>
	<div>
		<form action="<c:url value='/admin/AdminBookServlet?method=add'/>"
			method="post">
			ISBN: <input id="isbn" style="width: 150px; height: 20px;" type="text"
				name="isbn" value=""/>
			<br /> Title: <p id="title"></p> <br /> 
			Cover: <img id="cover" src="" border="0"/><br />
			Price: <input id="price" style="width: 150px; height: 20px;" type="text"
				name="price" value=""/><br /> 
				Author: 
				<ol id="authors">
				</ol> 
				Publisher: <p></p><br />
			Category: <select id="category" style="width: 150px; height: 20px;"
				name="category">
				<c:forEach items="${categoryList }" var="category">
					<option value="${category.categoryname }">${category.categoryname }</option>
				</c:forEach>
			</select> <br /> 
			<input id="bookJson" name="bookJson" type="hidden" value=""/>
			<input type="submit" value="Add book" />
		</form>
		<button id="searchISBN">Search</button>
	</div>
</body>
</html>
