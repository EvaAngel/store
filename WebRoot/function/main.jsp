<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page isELIgnored="false" %>
<%@taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="/comp/head.jsp" %>
  ${user.name}欢迎您  <!-- EL表达式没生效 -->
  <br>
  <a href="${pageContext.request.contextPath}/order?method=queryOrder">个人订单</a>
  <br>
  <a href="${pageContext.request.contextPath}/cart?method=watchCart">我的购物车</a>
  <br>
  <a href="<%=request.getContextPath()%>/user?method=logout">退出</a>
  <br>
</body>
</html>