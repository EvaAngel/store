<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath() %>/jquery/jquery-easyui-1.4.4/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath() %>/jquery/jquery-easyui-1.4.4/themes/icon.css">
<script type="text/javascript"
	src="<%=request.getContextPath() %>/jquery/jquery-easyui-1.4.4/jquery.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath() %>/jquery/jquery-easyui-1.4.4/jquery.easyui.min.js"></script>
<title>Insert title here</title>
<!-- ajax动态加载分类信息 -->

</head>
<body>
	<h1 align="center">网上商城</h1>
	<hr>
	<!--获取动态加载的分类信息，并以li标签的形式展示  -->
	<ul id="h_ul"></ul>
    <p>个人订单</p>
</body>
<script type="text/javascript">
$(function(){
	$.ajax({
		  type:"get",
		  url:"<%=request.getContextPath()%>/category",
		  data:{'method':"findAll"},
		  datatype:"json",
		  success : function(data) {
              var obj=JSON.parse(data);
              //alert(obj);
 			  $(obj).each(function(){  //这句有问题，jQuery如何获取返回值
			    //alert(this.name);
 			    $("#h_ul").append("<li><a href='${pageContext.request.contextPath}/category?method=findByPage&pageNumber=1&cid="+this.id+"'>"+this.name+"</a></li>");
 			  });
		  }
			});
		});

</script>
</html>