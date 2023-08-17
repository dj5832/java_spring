package kr.or.dw.mailApi;

import java.util.Map;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import com.sun.mail.util.logging.MailHandler;


@Service("mailService")
public class MailServiceImpl implements MailService{

	@Autowired
	private JavaMailSender mailSender;
	
	@Override
	public Map<String, Object> sendEmail(String email, String title, String body) {
		
		MailHandler mail;
		try {
			mail = new MailHandler(mailSender);
		} catch (Exception e) {
		}
	}

}
