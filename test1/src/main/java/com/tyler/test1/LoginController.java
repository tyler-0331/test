package com.tyler.test1;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/login")
public class LoginController {
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginForm() {
		return "loginForm";
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		// 1. 세션을 종료 
		session.invalidate();
		// 2. 홈으로 리턴
		return "index";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(String id, String pwd, String toURL, boolean rememberId, 
			HttpServletResponse response, HttpServletRequest request) throws Exception {
		System.out.println("id="+id);
		System.out.println("pwd="+pwd);
		System.out.println("toURL=" +toURL);
		System.out.println("rememberId="+rememberId);
		
		// 1. id와 pwd 확인
		if (!loginCheck(id,pwd)) {
			// 2.1    일치하지 않으면, loginForm으로 이동
			String msg = URLEncoder.encode("id 또는 pwd가 일치하지 않습니다.","utf-8");
			return "redirect:/login/login?msg=" + msg;
		}
		
		// 2.2  id와 pwd가 일치하면,
		// 세션 객체를 얻어오기
		HttpSession session = request.getSession();
		// 세션에 객체 저장하기!
		session.setAttribute("id", id);
		
		
		// 세션 객체에 id를 저장한다!

		if(rememberId) {
			//     1. 쿠키 생성
			Cookie cookie = new Cookie("id", id);
			cookie.setMaxAge(10); // 60초 동안 쿠키정보 가지고 있기! 
			//     2. 응답에 저장
			response.addCookie(cookie);
		} else {
			Cookie cookie = new Cookie("id", id);
			cookie.setMaxAge(0);  // 혹시 남아있을 쿠키 삭제
			response.addCookie(cookie);
		}
		
		//     3. 홈으로 이동
		toURL = toURL == null || toURL.equals("") ? "/" : toURL;	
		
		return "redirect:" + toURL;
	}

	private boolean loginCheck(String id, String pwd) {
		return "asdf".equals(id)&&"1234".equals(pwd);
	}
}
