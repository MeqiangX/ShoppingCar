<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="Sig_servlet" method="post">
<div	>
登录名：<input type="text" name="name">
</div>

<div>
密码：<input type="password" name="password">
</div>

<div>
确认密码：<input type="passwd" name="passwd">
</div>

<div>
<p>${Mes }</p>
</div>
<div>
<input type="submit"  value="sign up">
</div>
</form>
</body>
</html>