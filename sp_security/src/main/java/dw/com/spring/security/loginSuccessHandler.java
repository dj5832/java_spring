package dw.com.spring.security;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

public class loginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler{

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws ServletException, IOException {
		
		Map<String, String> loginUser = new HashMap<>();
		loginUser.put("id", authentication.getName());
		
		// 인증된 사용자의 정보가져오기
//		Object obj = authentication.getPrincipal();
//		System.out.println(obj.toString());
//		System.out.println(authentication.getDetails().toString());
		// 인증된 사용자의 정보가져오기 end
		
		HttpSession session = request.getSession();
		session.setAttribute("loginUser", loginUser);
		
		super.onAuthenticationSuccess(request, response, authentication);
	}

}
