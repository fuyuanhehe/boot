package com.boot.boot.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Map;
 
@Service
public class EmailServiceImpl implements EmailService {
 
	@Autowired
	private EmailConfig emailConfig;
	@Autowired
	private JavaMailSender mailSender;
	
	public void sendSimpleMail(String sendTo, String titel, String content) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(emailConfig.getEmailFrom());
		message.setTo(sendTo);
		message.setSubject(titel);
		message.setText(content);
		mailSender.send(message);
	}

	@Override
	public void sendAttachmentsMail(String sendTo, String titel, String content,
			Map<String, File> attachments) throws MessagingException {
		MimeMessage mimeMessage = mailSender.createMimeMessage();

		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
		helper.setFrom(emailConfig.getEmailFrom());
		helper.setTo(sendTo);
		helper.setSubject(titel);
		helper.setText(content);

		FileSystemResource file = new FileSystemResource(new File("src/main/webapp/img/book.png"));
		helper.addAttachment("附件-1.jpg", file);

		mailSender.send(mimeMessage);
		
	}

	@Override
	public void sendTemplateMail(String sendTo, String titel, Map<String, Object> content,
			List<Map<String, File>> attachments)throws Exception {
		// TODO Auto-generated method stub
		MimeMessage mimeMessage = mailSender.createMimeMessage();

		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
		helper.setFrom(emailConfig.getEmailFrom());
		helper.setTo(sendTo);
		helper.setSubject(titel);
		helper.setText(content.get("kay").toString()); //内容
		helper.setSentDate(new Date());


		FileSystemResource file = new FileSystemResource(new File("src/main/webapp/img/book.png"));
		FileSystemResource file2 = new FileSystemResource(new File("src/main/webapp/img/book.png"));


	}
 
	
	
	
	
	
}
