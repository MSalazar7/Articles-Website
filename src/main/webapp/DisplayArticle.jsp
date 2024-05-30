<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>DisplayArticle</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<nav aria-label="breadcrumb">
	<ol class="breadcrumb">
	<li class="breadcrumb-item">
		<a href="ListArticles">
		Home
		</a>
		</li>
	<li class="breadcrumb-item active" aria-current="page">
		Display Article
	</ol>
	
	
</nav>

<a href='ListArticles'> Back to Articles</a>
		<p><b>${a.title}</b></p>
		<p><i>${a.excerpt}</i></p>
		<p>${a.content}</p>
		
		

</body>
</html>