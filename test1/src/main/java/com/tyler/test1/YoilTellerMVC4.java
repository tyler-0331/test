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
public class YoilTellerMVC4 {
	
	@ExceptionHandler(Exception.class)
	public String catcher(Exception e) {
		e.printStackTrace();
		return "yoilError";
	}
	
	
	
	@RequestMapping("/getYoilMVC4")
	public String main(MyDate date, Model model) throws IOException {
		// 1. 유효성 검사 
		if(!isvalid(date)) {
			return "yoilError";
		}
		
		// 2. 요일 계산
		char yoil= getYoil(date);

		
		// 3. 계산한 결과를 model에 저장
		model.addAttribute("myDate", date);
		model.addAttribute("yoil", yoil);
		

//		response.setContentType("text/html");
//		response.setCharacterEncoding("utf-8");
//		PrintWriter out = response.getWriter();
//		out.println(year + "년 " + month + "월 " + day + "일은");
//		out.println(yoil + "요일 입니다.");
		
		return "yoil";
	}

	

	private boolean isvalid(MyDate date) {
		// TODO Auto-generated method stub
		return isValid(date.getYear(), date.getMonth(), date.getDay());
	}

	private char getYoil(MyDate date) {
		
		return getYoil(date.getYear(), date.getMonth(), date.getDay());
	}

	private boolean isValid(int year, int month, int day) {    
    	if(year==-1 || month==-1 || day==-1) 
    		return false;
    	
    	return (1<=month && month<=12) && (1<=day && day<=31); // 간단히 체크 
    }

	private char getYoil(int year, int month, int day) {
		Calendar cal = Calendar.getInstance();
		cal.set(year, month - 1, day);

		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		return  " 일월화수목금토".charAt(dayOfWeek);
	}
}
