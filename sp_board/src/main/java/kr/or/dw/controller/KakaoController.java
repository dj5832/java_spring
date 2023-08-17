package kr.or.dw.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.or.dw.kakao.KakaoService;


@Controller
public class KakaoController {

	@Autowired
	private KakaoService ka;
	
	@RequestMapping("/kakaoLogin")
	public String kakaoLogin() {
		
		return "/kakao/kakaoLogin";
		
	}
	
	@RequestMapping(value="/kakaoCode", method=RequestMethod.GET)
	public String kakaoCode(@RequestParam(value = "code", required = false) String code) throws Exception {
		
		
		System.out.println("#########" + code);
		
		String access_Token = ka.getAccessToken(code);
		System.out.println("###access_Token#### : " + access_Token);
		return "/kakao/kakaoLogin";
		/*
		 * 리턴값의 testPage는 아무 페이지로 대체해도 괜찮습니다.
		 * 없는 페이지를 넣어도 무방합니다.
		 * 404가 떠도 제일 중요한건 #########인증코드 가 잘 출력이 되는지가 중요하므로 너무 신경 안쓰셔도 됩니다.
		 */
    	}
	
	@RequestMapping(value="/kakao/callback", method= {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView callback(ModelAndView mnv, @RequestParam String code) {
		String url = "/kakao/callback";
		
		System.out.println("#########" + code);
		String access_Token = ka.getAccessToken(code);
		
		HashMap<String, Object> userInfo = ka.getUserInfo(access_Token);
		
		System.out.println("###access_Token#### : " + access_Token);
		System.out.println("###nickname#### : " + userInfo.get("nickname"));
		System.out.println("###email#### : " + userInfo.get("email"));
		
		mnv.addAllObjects(userInfo);
		mnv.setViewName(url);
		
		return mnv;
	}
}