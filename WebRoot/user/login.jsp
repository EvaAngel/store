<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function refresh() {
		//IE存在缓存,需要new Date()实现更换路径的作用  
		document.getElementById("image").src ="<%=request.getContextPath()%>/java/image.jsp?"
				+ new Date();
	}
</script>
</head>
<body>
	<%@include file="/comp/head.jsp" %>
	<form action="${pageContext.request.contextPath}/user">
	<table align="center">
	<tr>
			<td></td>
			<td><input type="hidden" name="method" value="login"></td>
		</tr>
		<tr>
			<td>用户名：</td>
			<td><input type="text" name="username" id="username"></td>
		</tr>
		<tr>
			<td>密码：</td>
			<td><input type="text" name="password" id="password"></td>
		</tr>
		<tr>
			<td>验证码：</td>
			<td><input type="text" name="active" id="active" size="12"><img
				id="image" border="0" onclick="refresh()" src="<%=request.getContextPath()%>/java/image.jsp"
				title="点击更换图片"></td>
		</tr>
		<tr><td><input type="checkbox" name="savename" value="ok"></td><td>记住用户名</td></tr>
		<tr>
			<td><input type="submit" value="登陆"></td>
			<td><a href="${pageContext.request.contextPath }/user?method=registerUI"><input type="button" value="注册"></a></td>
		</tr>
	</table>
	<hr>
	<h2 align="center">热门商品：</h2>
	<p align="center">
	<c:forEach items="${hpro}" var="p">
	    <span><a href="${pageContext.request.contextPath}/product?method=getProById&id=${p.id}">${p.describe }</a></span>
	    <span><a href="${pageContext.request.contextPath}/product?method=getProById&id=${p.id}">${p.market_price }</a></span>
	    <br>
	</c:forEach>
	</p><hr>
	<h2 align="center">最新商品：</h2>
	<p align="center">
	<c:forEach items="${npro}" var="p">
	    <span><a href="${pageContext.request.contextPath}/product?method=getProById&id=${p.id}">${p.describe}</a></span>
	    <span><a href="${pageContext.request.contextPath}/product?method=getProById&id=${p.id}">${p.market_price }</a></span>
	    <br>
	</c:forEach>
	</p>
	</form>
</body>
<script type="text/javascript">
   var val="${cookie.saveName.value}";
   document.getElementById("username").value=decodeURI(val); 
</script>
</html>