package kr.or.dw.mailApi;

import java.util.Map;

public interface MailService {

	public Map<String, Object> sendEmail(String email, String title, String body);
	
	
}
