package kr.or.dw.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CommonController {

//	@RequestMapping(value="/common/loginForm")
	@GetMapping(value="/common/loginForm")
//	@PostMapping(value="/common/loginForm")
	public String loginForm(HttpServletResponse res) throws Exception {
		String url = "/common/loginForm";
		
		return url;
	}
}
