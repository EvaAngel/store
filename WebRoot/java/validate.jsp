<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String rand = (String) session.getAttribute("code");
		String input = request.getParameter("active");
		if (rand.equals(input))
		{
			out.print("<script>alert('验证通过！');</script>");
		} else
		{
			out.print("<script>alert('请输入正确的验证码！');location.href='../user/login.jsp';</script>");
		}
	%>
</body>
</html>