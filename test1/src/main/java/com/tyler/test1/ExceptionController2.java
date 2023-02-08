package com.tyler.test1;

import java.util.Enumeration;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExceptionController2 {

	@RequestMapping("/ex3")
	public String main() throws Exception {
		throw new Exception("예외가 발생함2");
	}

	@RequestMapping("/ex4")
	public String main2(HttpServletRequest req) throws Exception {
		throw new NullPointerException("예외가 발생함2");
//		throw new FileNotFoundException("2번쨰 예외 발생홤");

	}

	@RequestMapping("/ex5")
	public String main3() throws Exception {
		try {
			throw new Exception("예외가 발생했으요");
		} catch (Exception e) {
			return "error";
		}
	}

}
