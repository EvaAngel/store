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
	   //����һ���ʼ�
	   Properties props =new Properties();
       Session session=Session.getInstance(props);
       MimeMessage message=new MimeMessage(session);
       //from:������
       try
	{
		message.setFrom(new InternetAddress("1358823605@qq.com","����","UTF-8"));
		//�ռ��ˣ���������ö���ռ����볭����
		message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress("fuxinxinxin@163.com"));
		//�ʼ����⣺
		String test="��ϲ�������������ѻ���ҹ�˾�ɱ���offer����ͬ����ְ��������������";
		message.setSubject(test, "UTF-8");
		//������ʾ�ķ���ʱ��
		message.setSentDate(new Date());
		//����ǰ�������
		message.saveChanges();
		//���ʼ����浽����
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
