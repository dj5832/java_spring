package kr.or.dw.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pds")
public class pdsController {
	
	private static final Logger logger = LoggerFactory.getLogger(pdsController.class);

	@RequestMapping("/main")
	public String main() {
		String url = "/pds/main";
		return url;
	}

}
