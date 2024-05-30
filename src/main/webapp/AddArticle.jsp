<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AddArticle</title>
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
		Add Article
	</ol>
	
	
</nav>
	<h1>New Article</h1>
	<form action='AddArticle' method='post'>
		<div class="form-group">
		<label>
		<b>Category</b><select name='Category' class="form-control">
		<option value='Biz & IT'>Biz & IT</option>
		<option value='Tech'>Tech</option>
		<option value='Science'>Science</option>
		<option value='Policy'>Policy</option>
		<option value='Cars'>Cars</option>
		<option value='Gaming & Culture'>Gaming & Culture</option></select></label>
		</div>
		<div class="form-group">
		<label><b>Title</b> </label> <input class="form-control" type='text' name = 'title' size = '90' value='' >
		</div>
		<div class="form-group">
		<label><b>Excerpt</b> </label> <input class="form-control" type='text' name = 'excerpt' size='90' value=''>
		</div>
		<div class="form-group">
		<label><b>Content</b></label><textarea class="form-control" name = 'content' rows='5' cols='90'></textarea>
		</div>
		<div class="form-group">
		<button type="submit" class="btn btn-primary btn-md float-middle">Add</button></div>
	
		</form>
		
	
</body>
</html>