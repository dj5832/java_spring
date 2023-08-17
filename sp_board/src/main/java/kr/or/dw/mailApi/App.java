package kr.or.dw.mailApi;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class App {

	 public static void main(String args[]) {
		 
	        Mail mail = new Mail();
	        mail.setMailFrom("ehdehdwn131@gmail.com");
	        mail.setMailTo("ehdwn7056@gmail.com");
	        mail.setMailSubject("This is Email test.");
	        mail.setMailContent("Learn how to send email using Spring.");
	 
	        AbstractApplicationContext context = new AnnotationConfigApplicationContext(MailConfig.class);
	        MailService mailService = (MailService) context.getBean("mailService");
	        mailService.sendEmail(mail);
	        context.close();
	    }
}
