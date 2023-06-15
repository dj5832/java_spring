package kr.or.dw.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.dw.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {

	private static final Logger logger = LoggerFactory.getLogger(CommonController.class);

	@Autowired
	private BoardService boardService;
	
	@RequestMapping("/main")
	public String main() {
		String url = "board/main.open";
		
		return url;
	}
	
	
}
