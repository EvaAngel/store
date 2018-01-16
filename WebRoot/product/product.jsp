<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file="/comp/head.jsp"%>
<table align="center">
   <tr><td>商品名称：</td><td>${product.describe}</td></tr>
   <tr><td>商品售价：</td><td>${product.custom_price}</td></tr>
   <tr><td>商品市场价：</td><td>${product.market_price}</td></tr>
   <tr><td>购买数量：</td><td><input type="text" id="count"/></td></tr>
   <tr><td><input type="button" value="加入购物车" onclick="submit()"/></td><td><input type="hidden" value="${product.id}" name="id"/></td></tr>
</table>
</body>
<script type="text/javascript">
function submit()
{
	//alert("哈哈");  这个地方可以以异步Ajax的方式做一个提交，然后返回添加成功即可，这里按照它的来做
	var count=document.getElementById("count").value;
	location.href="${pageContext.request.contextPath }/cart?method=add2Cart&id=${product.id}&count="+count;
	}
</script>
</html>