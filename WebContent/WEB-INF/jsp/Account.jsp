<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script>
function Confirm(){
	
	if (confirm("您确认清空吗？")){
		return true;
	}
	else 
		return false;
}

function Confirm2(){
	
	if (confirm("您确认删除吗？")){
		return true;
	}
	else 
		return false;
}

function Confirm3(input,name,id,oldvalue){
	 var val = input.value;
    document.write(val);
	
}

</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>购物车</h1>
<c:if test="${empty(sessionScope.Car) }">
  您还没购买任何东西
</c:if>

<c:if test="${!empty(sessionScope.Car) }">
<!-- sessionScope得到保存在session中的属性 -->
<table border="1">
 <tr>
            <th>书名</th>
            <th>作者</th>
            <th>单价</th>
            <th>数量</th>
            <th>小计</th>
            <th>操作</th>
        </tr>


<c:forEach var="x" items="${sessionScope.Car.getList() }">
 <tr>
 <!-- x是取到的car的Map的一对键值对,x.value 可以取到值，x.key可以取到键,之后可以对他们操作
   这里就是<String(Book_Id) CartItem>  x.value对应购物项 -->
            <td>${x.value.book.name }</td>
            <td>${x.value.book.auther }</td>
            <td>${x.value.book.price }</td>
            
            <td>
            <form action="Opreater_servlet?action=3&id=${x.key }" method="post">
            <input type="text" name="count" value="${x.value.count }">
            </form>
            </td>
            
            <td>${x.value.total }</td>
            <td align="center"><a href="Opreater_servlet?action=1&id=${x.key }" onclick="return Confirm2()">删除</a></td>
        </tr>
</c:forEach>

  <tr>
            <td colspan="3" align="center">总价</td>
            <td colspan="2">${sessionScope.Car.getAll_prices() }元</td>
            <td colspan="1">
                <a href="Opreater_servlet?action=2" onclick="return Confirm()">清空购物车</a>
            </td>
    </tr>
    
    </table>
</c:if>

<a href="Show_controlor">返回首页</a>
<a href="Buy_servlet">购买</a>
</body>
</html>