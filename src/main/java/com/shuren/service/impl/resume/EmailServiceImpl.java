package com.shuren.service.impl.resume;

import java.io.File;
import java.security.GeneralSecurityException;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

import com.shuren.bean.resume.Email;
import com.shuren.constants.wechat.EmailConfigProperties;
import com.shuren.service.resume.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import com.sun.mail.util.MailSSLSocketFactory;



/**
 * @author wen.xu 2016.6.4
 */
@Service("emailService")
public class EmailServiceImpl implements EmailService {


	@Autowired
	private EmailConfigProperties emailConfigProperties;
	
	public boolean sendAccessory(final Email email) {
		try {
			// 有可能要添加的附件信息
			Multipart multipart = new MimeMultipart();		
			Properties prop = new Properties();
			final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
			prop.setProperty("mail.transport.protocol", "smtp");
			prop.setProperty("mail.smtp.host", email.getSmtp());
			prop.setProperty("mail.smtp.auth", "true");
			prop.setProperty("mail.smtp.port", Integer.toString(email.getPort()));
			System.setProperty("mail.mime.charset","UTF-8");
			prop.setProperty("mail.smtp.ssl.enable", "true");
			//prop.setProperty("mail.smtp.localaddress", "140.210.2.130");
			//prop.setProperty("mail.smtp.localport", "465");
			//ssl加密
			prop.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);  			  
			prop.setProperty("mail.smtp.socketFactory.fallback", "false");
			prop.setProperty("mail.smtp.socketFactory.port", Integer.toString(email.getPort()));
			prop.setProperty("mail.smtp.starttls.enable","true");    
			//ssl加密
		    MailSSLSocketFactory sf = null;
			try {
			    sf = new MailSSLSocketFactory();
			    sf.setTrustAllHosts(true); 
			} catch (GeneralSecurityException e) {
			    e.printStackTrace();
			}
			prop.put("mail.smtp.ssl.socketFactory", sf);
			
			//ssl加密 账号和密码
			Session session = Session.getDefaultInstance(prop, new Authenticator(){
			      protected PasswordAuthentication getPasswordAuthentication() { 
			          return new PasswordAuthentication(email.getUsername(), email.getPassword());
			      }});			
			
			//ssl加密 账号和密码
			Message msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress(email.getFrom()));
			msg.setRecipients(RecipientType.TO, new InternetAddress[] { new InternetAddress(email.getTo()) });
			// 添加文件标题
			String subject = email.getSubject();
			//subject = new String(subject.getBytes("GB2312"), "utf-8");
			msg.setSubject(subject);			
			// 添加邮件正文
			BodyPart contentPart = new MimeBodyPart();
			contentPart.setContent(email.getContent(), "text/html;charset=UTF-8");
			multipart.addBodyPart(contentPart);
			// 若传入的有附件则设置要添加的附件
			if (email.getFilename() != null && email.getFilename().length() > 0) {			
				File file = new File(email.getFilePath());
				contentPart = new MimeBodyPart();
				DataSource source = new FileDataSource(file);
				contentPart.setDataHandler(new DataHandler(source));
				// 解决文件名的乱码
				contentPart.setFileName(MimeUtility.encodeWord(file.getName()));
				multipart.addBodyPart(contentPart);
			}
			// 设置附件内容
			msg.setContent(multipart);
			//System.setProperty("sun.security.ssl.allowUnsafeRenegotiation", "true");			
			Transport.send(msg);
		} catch (Exception e) {
			e.printStackTrace();			
			return false;
		}
		return true;
	}
	
	public boolean send(String smtp, String from, String to, String subject, String content, String filePath, String username,
			String password, Integer port) {
		Email email = new Email();
		email.setSmtp(smtp);
		email.setFrom(from);
		email.setTo(to);
		email.setSubject(subject);
		email.setContent(content);
		email.setUsername(username);
		email.setPassword(password);
		email.setPort(port);
		email.setFilePath(filePath);
		boolean b = sendAccessory(email);
		return b;
	}
	
	public boolean sendPdf(String to,String filePath) {
		String smtp = emailConfigProperties.getSmtp();
		String from = emailConfigProperties.getUsername();
		String subject = emailConfigProperties.getSubject();
		String content = emailConfigProperties.getContent();
	    String username = emailConfigProperties.getUsername();
	    String password = emailConfigProperties.getPassword();
		return send(smtp, from, to, subject, content, filePath,username, password,465) ;
	}


	@Override
	public Boolean SendAttachMail(String sendTo, String filePath) {
		return sendPdf(sendTo,filePath);
	}
}
