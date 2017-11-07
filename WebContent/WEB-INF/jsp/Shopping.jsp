<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
 <tr>
 <th>id</th>
  <th>书名</th>
   <th>author</th>
  <th>price</th>
 </tr>

 <c:forEach var="x" items="${list }">
 <tr>
 <td>${x.getId() }</td>
  <td>${x.getName() }</td>
   <td>${x.getAuther() }</td>
    <td>${x.getPrice() }</td>
    <td><a href="Addtocar_servlet?bookid=${x.getId() }">加入购物车</a></td>
 </tr>
 </c:forEach>
 
 
 
 
</table>

<a href="Account_controlor">查看购物车</a>
</body>
</html>