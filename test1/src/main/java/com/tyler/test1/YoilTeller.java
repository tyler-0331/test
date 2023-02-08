package com.tyler.test1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// 년월일을 입력하면 요일을 알려주는 프로그램
@Controller
public class YoilTeller {
	@RequestMapping("/getYoil")
	public void main(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 1. 입력
		String year = request.getParameter("years");
		String month = request.getParameter("months");
		String day = request.getParameter("days");

		// 2. 작업
		int yyyy = Integer.parseInt(year);
		int mm = Integer.parseInt(month);
		int dd = Integer.parseInt(day);

		Calendar cal = Calendar.getInstance();
		cal.set(yyyy, mm - 1, dd);

		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		char yoil = " 일월화수목금토".charAt(dayOfWeek);

		// 3. 출력

//		response.setContentType("text/html");
//		response.setCharacterEncoding("utf-8");
//		PrintWriter out = response.getWriter();
//		out.println(year + "년 " + month + "월 " + day + "일은");
//		out.println(yoil + "요일 입니다.");
	}
}
