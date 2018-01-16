<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
   <%@include file="/comp/head.jsp"%>
   <!-- 以表格的形式做一个展示 -->
   <c:forEach items="${pb.proAll}" var="lpb">
      <p align="center">商品名称：<a href="${pageContext.request.contextPath }/product?method=getProById&id=${lpb.id}">${lpb.describe}</a><br></p>
   </c:forEach><hr>
   <p align="center">这是第${pb.curPage }页，共${pb.numPage }页。<br>
   每页展示${pb.sumPage } 条记录，共${pb.sumCount }条记录。</p>
   <hr>
   <!-- 下面来一个具体的分页选择器 -->
   <ul>
   <c:forEach begin="1" end="${pb.numPage}" var="n">
       <c:if test="${pb.curPage!=n}">
       <li><a href="${pageContext.request.contextPath }/category?method=findByPage&pageNumber=${n}&cid=${param.cid}">${n}</a></li>
       </c:if>
       <c:if test="${pb.curPage==n}">
       <li><a href="javascript:void(0)">${n }</a></li>
       </c:if>
   </c:forEach>
   </ul>
</body>
</html>