package com.store.util;

import java.io.PrintWriter;
import java.util.Date;
import java.util.Properties;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.store.domain.User;

public class SendJavaMailUtil
{
	public static void sendMal(String test)
	{
		// 发件人的邮箱和密码
		String myEmailAccount = "sdnuxg902@163.com";
		String myEmailPassword = "a7365937034a";
		// 发件人邮箱的SMTP服务器地址
		String myEmailSMTPHost = "smtp.163.com";
		// 收件人邮箱
		String receiveMailAccount = "1358823605@qq.com";
		// 设置配置参数，用于链接邮件服务器的参数配置
		Properties props = new Properties();
		props.setProperty("mail.transport.protocol", "smtp");
		props.setProperty("mail.smtp.host", myEmailSMTPHost);
		props.setProperty("mail.smtp.auth", "true");
		// 根据配置创建会话对象，由于与服务器交互
		Session session = Session.getInstance(props);
		session.setDebug(true);
		// 创建一封邮件
		MimeMessage message = createMimeMessage(session, myEmailAccount, receiveMailAccount,test);
		try
		{
			Transport transport = session.getTransport();
			// 发送邮件
			transport.connect(myEmailAccount, myEmailPassword);
			transport.sendMessage(message, message.getAllRecipients());
			// 关闭
			transport.close();

		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static MimeMessage createMimeMessage(Session session, String myEmailAccount, String receiveMailAccount,String test)
	{
		MimeMessage message = new MimeMessage(session);

		try
		{
			// 2. From: 发件人（昵称有广告嫌疑，避免被邮件服务器误认为是滥发广告以至返回失败，请修改昵称）
			message.setFrom(new InternetAddress(myEmailAccount, "鑫鑫", "UTF-8"));
			// 3. To: 收件人（可以增加多个收件人、抄送、密送）
			message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(receiveMailAccount, "用户", "UTF-8"));

			// 4. Subject: 邮件主题（标题有广告嫌疑，避免被邮件服务器误认为是滥发广告以至返回失败，请修改标题）
			message.setSubject("猩便利offer通知", "UTF-8");

			// 5. Content:
			// 邮件正文（可以使用html标签）（内容有广告嫌疑，避免被邮件服务器误认为是滥发广告以至返回失败，请修改发送内容）
			message.setContent(test, "text/html;charset=UTF-8");

			// 6. 设置发件时间
			message.setSentDate(new Date());

			// 7. 保存设置
			message.saveChanges();
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return message;
	}
}
