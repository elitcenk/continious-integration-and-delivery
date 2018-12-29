package tr.cenk.continuous_deployment.controller.mail;

import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

	@RequestMapping ("/sendemail/")
	public String sendEmail() throws MessagingException {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setHost("127.0.0.1");
		mailSender.setPort(1025);
		mailSender.setUsername("");
		mailSender.setPassword("");

		Properties props = mailSender.getJavaMailProperties();
		props.put("mail.transport.protocol", "smtp");

		MimeMessage mimeMessage = mailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
		mimeMessageHelper.setText("Sample text message.\nSample text message.\nSample text message.\nSample text message.\nSample text message.", true);
		mimeMessageHelper.setTo(InternetAddress.parse("ecenkalp@mailll.com"));
		mimeMessage.setSubject("Sample Subject");

		mailSender.send(mimeMessage);
		return "Email Sended";
	}

}
