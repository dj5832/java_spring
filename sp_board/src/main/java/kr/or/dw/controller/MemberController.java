package kr.or.dw.controller;

import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.or.dw.service.MemberService;
import kr.or.dw.vo.MemberVO;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping("/main")
	public String main() {
		String url = "/member/main.open";
		return url;
	}
	
	@RequestMapping("/list")
	public ModelAndView list(ModelAndView mnv) {
		String url = "/member/list.open";
		List<MemberVO> memberList = null;
		
		
		try {
			memberList = memberService.selectMemberList();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		mnv.addObject("memberList", memberList);
		mnv.setViewName(url);
		
		return mnv;
	}
	
	// 회원등록
	@RequestMapping("/registForm")
	public String registForm() {
		String url = "member/regist.open";
		
		return url;
	}
	
	
}
