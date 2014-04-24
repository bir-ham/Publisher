<html>
<head>
<title>Publisher</title>
<!-- <link rel="stylesheet" type="text/css" href="styles.css" /> -->
	<style type="text/css">
		span.error 
			{color: red;}
	</style>
</head>
<body align="center">
	<br/><br/><br/><br/>
	<h2>Login</h2>
	<% 
   String message = (String) request.getAttribute("message");
   if (message != null) {
      out.println("<span class=\"error\">" + message + "</span>");
   }
%>
	
	<form method="post" action="">
		<div>
			Username: <input type="text" name="username" size="36" />

		</div>
		<div>
			Password: <input type="password" name="password" size="36" />

		</div>
		<div>
			<input type="submit" value="Login" />
		</div>

	</form>
</html>