<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script>
/*改变提交的servlet*/
  function signup(){
	  var f = document.forms[0];
	  f.action = "Sig_controlor";
	  f.submit();
  }
</script> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="Log_servlet" method="post">
<div>
账号：<input type="text" name="name">
</div>

<div>
密码：<input type="password" name="password">
</div>

<div>
<input type="submit" value="sign in">
<input type="reset" value="clear">
<input type="button" value="sign up" onclick="signup()">
</div>
</form>
</body>
</html>