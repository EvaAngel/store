<%@page import="java.awt.image.BufferedImage"
import="java.awt.*" import="javax.imageio.*"
%>
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
int width=60; int heigh=25;
BufferedImage image=new BufferedImage(width,heigh,BufferedImage.TYPE_INT_RGB);
Graphics graphics=image.getGraphics();
Font font=new Font("新宋体",Font.PLAIN,12);  
graphics.setFont(font);  
graphics.fillRect(0, 0, width, heigh);  
graphics.setColor(new Color(255,212,212));//设置黑色字体,同样可以graphics.setColor(Color.black);
graphics.drawString("付鑫", 10, 10);
ImageIO.write(image, "PNG",response.getOutputStream());
response.getOutputStream().flush();
response.getOutputStream().close();
%>
</body>
</html>