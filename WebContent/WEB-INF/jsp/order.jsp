<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>订单</h1>

<div>
<table border="1">
<tr>
<th>id</th>
<th>name</th>
<th>订单号</th>
<th>创建时间</th>
</tr>

<tr>
<td>${order.getBuyerId() }</td>
<td>${order.getBuyerName() }</td>
<td>${order.getListId() }</td>
<td>${order.getDate() }</td>
</tr>

</table>
</div>
   <div>
   <table border="1">
   <tr>

	<th>物品ID</th>
	<th>物品</th>
	<th>数量</th>
	<th>单价</th>
	<th>总价</th>
</tr>
  <c:forEach var="x" items="${list }">
        <tr>
		
		<td>${x.goodsid }</td>
		<td>${x.goodsName }</td>
		<td>${x.goodsnum }</td>
		<td>${x.count }</td>
		<td>${x.total }</td>
       </tr>
  </c:forEach>
  <tr>
  <td align="center" colspan="2">总价</td>
  <td align="center" colspan="3">${sessionScope.Car.all_prices }</td>
  </tr>
  </table>
  </div>
  <a href="">返回首页</a>
  
</body>
</html>