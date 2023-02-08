package com.tyler.test1;

import java.io.FileNotFoundException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExceptionController {
	
//	@ExceptionHandler({NullPointerException.class, FileNotFoundException.class})
//	public String catcher2(Exception ex, Model model) {
//		model.addAttribute("ex", ex);
//		return "error";
//	}
//	
//	@ExceptionHandler(Exception.class)
//	public String catcher(Exception ex, Model model) {
//		model.addAttribute("ex", ex);
//		return "error";
//	}
	
	@RequestMapping("/ex")
	public String main() throws Exception {
		throw new Exception("예외가 발생함");
	}
	
	@RequestMapping("/ex2")
	public String main2() throws Exception {
//		throw new NullPointerException("예외가 발생함2");
		throw new FileNotFoundException("예외 발생홤");

	}
	
	
}
