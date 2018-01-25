<%--
  Created by IntelliJ IDEA.
  User: fuxin
  Date: 2018/1/23
  Time: 20:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" import="java.util.List" %>
<%@ page import="com.store.Bo.OrderAndProductBo" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>订单详情</title>
</head>
<body>
<%@include file="/function/main.jsp" %>
<br>
<%--<%List<OrderAndProductBo> list=(List)request.getAttribute("list");%>
<%=list.get(0).getProduct().getDescribe()%>--%>
<table align="center" width="50%">
    <c:forEach items="${list}" var="p">
        <tr>
            <td>订单编号</td>
            <td>订单价格</td>
            <td>订单地址</td>
            <td>订单详细信息</td>
            <td>支付订单</td>
            <td>删除订单</td>
        </tr>
        <tr>
            <td>${p.order_id}</td>
            <td>${porder_account}</td>
            <td>${p.order_address}</td>
            <td><a href="">订单详细地址</a></td>
            <td><a href="">支付</a></td>
            <td><a href="">删除</a> </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
