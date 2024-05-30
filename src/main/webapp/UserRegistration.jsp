<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Registration</title>
</head>
<body>
	<h1> User Registration</h1>
	<form action='UserRegistration' method='post'>
		<div class="form-group">
		<label>
		<b>Name</b><input name='name' class="form-control">
		</label>
		<div class="form-group">
		<label><b>Username</b> </label> <input class="form-control" type='text' name = 'username' size = '90' value='' >
		</div>
		<div class="form-group">
		<label><b>Password</b> </label> <input class="form-control" type='text' name = 'password' size='90' value=''>
		</div>
		<div class="form-group">
		</div>
		<b>Editor?</b><select name='editor' class="form-control">
		<option value='1'>Yes</option>
		<option value='0'>No</option>
		</select>
		<b>Author</b><select name='author' class="form-control">
		<option value='1'>Yes</option>
		<option value='0'>No</option>
		</select>
		<button type="submit" class="btn btn-primary btn-md float-middle">Register</button></div>
		
		</form>

</body>
</html>