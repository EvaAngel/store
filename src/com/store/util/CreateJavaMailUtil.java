package com.store.util;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class CreateJavaMailUtil
{
   static void sendMail()
   {
	   //创建一封邮件
	   Properties props =new Properties();
       Session session=Session.getInstance(props);
       MimeMessage message=new MimeMessage(session);
       //from:发件人
       try
	{
		message.setFrom(new InternetAddress("1358823605@qq.com","鑫鑫","UTF-8"));
		//收件人：这里可设置多个收件人与抄送人
		message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress("fuxinxinxin@163.com"));
		//邮件主题：
		String test="恭喜付鑫先生，您已获得我公司猩便利offer，若同意入职，请点击以下链接";
		message.setSubject(test, "UTF-8");
		//设置显示的发件时间
		message.setSentDate(new Date());
		//保存前面的设置
		message.saveChanges();
		//将邮件保存到本地
		OutputStream out;
		try
		{
			out = new FileOutputStream("D://MyEmail.eml");
			message.writeTo(out);
			out.flush();
			out.close();
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	} catch (UnsupportedEncodingException e)
	{
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (MessagingException e)
	{
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
       
   }
}
