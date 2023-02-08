package com.tyler.test1;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegisterController {
	@RequestMapping(value = "/register/add", method = {RequestMethod.GET, RequestMethod.POST})
//	@RequestMapping("/register/add")
//	@GetMapping("/register/add")
	public String register() {
		
		return "RegisterForm";
	}
	
//	@RequestMapping(value = "/register/save", method = RequestMethod.POST)
	@PostMapping ("/register/save")  // 4.3 부터 사용 가능
	public String info(User user, Model model) throws Exception {
		// 1. 유효성 검사 
		if (!isValid(user)) {
			String msg = URLEncoder.encode("아이디를 잘못 입력했네요.","utf-8");
			
			model.addAttribute("msg", msg);
			return "forward:/register/add";
//			return "redirect:/register/add?msg=" + msg; // URL 재작성(rewriting)
			
		}
		
		model.addAttribute("user", user);
			
		// 2. DB에 신규회원 정보를 저장 
		return "registerinfo";
	}

	private boolean isValid(User user) {
		return false;
	}
}
