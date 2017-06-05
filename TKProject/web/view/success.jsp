<%@ page language="java" contentType="text/html; charset=utf-8"
		 pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=Windows-31J">
	<title>成功画面</title>

	<style type="text/css">
		.main_container {
			width: 600px;
			height: 300px;
			padding: 2%;
			border: 1px ridge black;
			margin: 10% auto 0 auto;
			text-align: center;
		}
		div.main_container p {

			font-size: 40px;
			margin-top: 15%;
			margin-left: 25%;
			margin-right: 25%;

		}

		div.main_container input {

            margin-left: 60%;
		}

	</style>
</head>
<body>
<div class="main_container">
	<p><%= request.getAttribute("message") %></p>
	<form action="<%= request.getAttribute("link") %>" method="POST" >

		<input type="submit" name = "button" value="<%= request.getAttribute("link_view") %>">

	</form>
</div>
</body>
</html>