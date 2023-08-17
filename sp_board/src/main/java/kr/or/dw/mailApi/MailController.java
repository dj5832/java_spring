package kr.or.dw.mailApi;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MailController {

	@Autowired
	private MailService mailService;
	
	@RequestMapping("/mail/send") // 메일 내용을 작성하기 위한 페이지로 이
	public String showSend() {
		return "carshop/mailsend";
	}
	
	@RequestMapping("/mail/doSend")	// 매일내용폼에서 "메일보내기"를 클릭하면 실행되는 코드
	@ResponseBody
	public String doSend(String email, String title, String body) {
		
		Map<String, Object> sendRs = mailService.sendEmail(email, title, body);
		System.out.println("sendRs" + sendRs);
		return (String) sendRs.get("msg");
	}
}
