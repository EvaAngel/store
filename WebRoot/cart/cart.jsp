<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%@include file="/comp/head.jsp" %>
<body>
  <table align="center" width="50%">
    <tr><td>商品名称</td><td>商品个数</td><td>商品总价格</td><td>删除商品</td></tr>
   <c:if test="${empty cart || empty cart.cts }">没东西啊</c:if>
   <c:if test="${not empty cart.cts }"> 
   <c:forEach items="${cart.cts }" var="idct">
        <tr>
           <td>${idct.value.product.describe }</td>
           <td>${idct.value.count }</td>
           <td>${idct.value.subtotal }</td>
        </tr>
        <br>
   </c:forEach>
   </c:if> 
   </table>
</body>
</html>