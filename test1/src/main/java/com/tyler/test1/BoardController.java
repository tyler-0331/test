package com.tyler.test1;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@RequestMapping(value = "/list",method = RequestMethod.GET)
	public String list(HttpServletRequest request) {
		if(!loginCheck(request)) {
//			StringBuffer toURL = request.getRequestURL();
			return "redirect:/login/login?URL=" + request.getRequestURL();  // 로그인을 안했으면 로그인 화면으로 이동
		}
		
		return "boardList"; // 로그인이 되어있으면, 게시판 화면으로 이동 
	}

	private boolean loginCheck(HttpServletRequest request) {
		// 1. 세션을 얻어서
		HttpSession session = request.getSession();
		// 2. 세션에 id가 있는지 확인, 있으면 true를 반환
		
		return session.getAttribute("id") != null;
	}
	
}
