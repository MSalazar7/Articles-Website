<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ListArticles</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<h2>Articles</h2>
<h2> <a href = 'UserRegistration'> Sign Up</a></h2>
<h3><a href = 'Login'> Login</a></h3>
<h3><a href = 'AddArticle'> New Article</a></h3>

<table border='1' class="table table-md table-align-middle" cell-padding='3'>
	<thead class="table-secondary"><tr>
		<th>Article</th>
		<th>Category</th>
		<th>Submitted</th>
		<th>Published</th>
		<th>Operations</th></thead>
<tbody class="table-light">
<c:forEach items = "${articles}" var ="article">
<tr>
	<td> <a href = "DisplayArticle?id=${article.id}">${article.title}</a><br>
	${article.excerpt}</td>
	<td>${article.category}</td>
	
	<td>${article.submitTime}</td>
			
	<c:if test = "${article.publishTime == null}"> 
	<td><a href='PublishArticle?id=${article.id}'> Publish</a></td>
	</c:if>
	<c:if test = "${article.publishTime != null }">
	
	<td>${article.publishTime}</td>
	
	</c:if>
	<td><a href='EditArticle?id=${article.id} '> Edit</a></td>
</tr>
</c:forEach>
</tbody>
</table>

</body>
</html>