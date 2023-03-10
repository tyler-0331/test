package com.tyler.test1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

// 년월일을 입력하면 요일을 알려주는 프로그램
@Controller
public class YoilTellerMVC2 {
	
	@ExceptionHandler(Exception.class)
	public String catcher(Exception e) {
		e.printStackTrace();
		return "yoilError";
	}
	
	
	
	@RequestMapping("/getYoilMVC2")
	public String main(@RequestParam(required = false) int year, 
			@RequestParam(required = false) int month, 
			@RequestParam(required = false) int day, 
			Model model) throws IOException {
		// 1. 유효성 검사 
		if(!isvalid(year, month, day)) {
			return "yoilError";
		}
		
		// 2. 요일 계산
		char yoil= getYoil(year, month, day);

		
		// 3. 계산한 결과를 model에 저장
		model.addAttribute("year", year);
		model.addAttribute("month", month);
		model.addAttribute("day", day);
		model.addAttribute("yoil", yoil);
		

//		response.setContentType("text/html");
//		response.setCharacterEncoding("utf-8");
//		PrintWriter out = response.getWriter();
//		out.println(year + "년 " + month + "월 " + day + "일은");
//		out.println(yoil + "요일 입니다.");
		
		return "yoil";
	}

	

	private boolean isvalid(int year, int month, int day) {
		
		return true;
	}



	private char getYoil(int year, int month, int day) {
		Calendar cal = Calendar.getInstance();
		cal.set(year, month - 1, day);

		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		return  " 일월화수목금토".charAt(dayOfWeek);
	}
}
