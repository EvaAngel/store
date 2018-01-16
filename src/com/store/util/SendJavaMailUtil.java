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
		// �����˵����������
		String myEmailAccount = "sdnuxg902@163.com";
		String myEmailPassword = "a7365937034a";
		// �����������SMTP��������ַ
		String myEmailSMTPHost = "smtp.163.com";
		// �ռ�������
		String receiveMailAccount = "1358823605@qq.com";
		// �������ò��������������ʼ��������Ĳ�������
		Properties props = new Properties();
		props.setProperty("mail.transport.protocol", "smtp");
		props.setProperty("mail.smtp.host", myEmailSMTPHost);
		props.setProperty("mail.smtp.auth", "true");
		// �������ô����Ự�������������������
		Session session = Session.getInstance(props);
		session.setDebug(true);
		// ����һ���ʼ�
		MimeMessage message = createMimeMessage(session, myEmailAccount, receiveMailAccount,test);
		try
		{
			Transport transport = session.getTransport();
			// �����ʼ�
			transport.connect(myEmailAccount, myEmailPassword);
			transport.sendMessage(message, message.getAllRecipients());
			// �ر�
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
			// 2. From: �����ˣ��ǳ��й�����ɣ����ⱻ�ʼ�����������Ϊ���ķ������������ʧ�ܣ����޸��ǳƣ�
			message.setFrom(new InternetAddress(myEmailAccount, "����", "UTF-8"));
			// 3. To: �ռ��ˣ��������Ӷ���ռ��ˡ����͡����ͣ�
			message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(receiveMailAccount, "�û�", "UTF-8"));

			// 4. Subject: �ʼ����⣨�����й�����ɣ����ⱻ�ʼ�����������Ϊ���ķ������������ʧ�ܣ����޸ı��⣩
			message.setSubject("�ɱ���offer֪ͨ", "UTF-8");

			// 5. Content:
			// �ʼ����ģ�����ʹ��html��ǩ���������й�����ɣ����ⱻ�ʼ�����������Ϊ���ķ������������ʧ�ܣ����޸ķ������ݣ�
			message.setContent(test, "text/html;charset=UTF-8");

			// 6. ���÷���ʱ��
			message.setSentDate(new Date());

			// 7. ��������
			message.saveChanges();
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return message;
	}
}
