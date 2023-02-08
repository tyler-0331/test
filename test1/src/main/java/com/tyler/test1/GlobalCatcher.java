package com.tyler.test1;

import java.io.FileNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

//@ControllerAdvice   // 모든 패키지에 적용
@ControllerAdvice("com.tyler.test1")
public class GlobalCatcher {
	

	
	
	@ExceptionHandler({NullPointerException.class, FileNotFoundException.class})
	public String catcher2(Exception ex, Model model) {
		return "error";
	}
	
	@ExceptionHandler(Exception.class)
	public String catcher(Exception ex, Model model) {
		System.out.println(ex);
		System.out.println(ex.getMessage());
		return "error";
	}
}
