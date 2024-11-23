package com.fastcampus.ch2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// 년월일을 입력하면 요일을 알려주는 프로그램
@Controller
public class YoilTeller2 {
	@RequestMapping("/getYoil")
	// request 까지만 입력하면 console 에서는 잘 보이지만, 우리는 브라우저에서도 결과값을 띄우고 싶다
	// 그러려면 response 를 사용해야 한다
	public static void main(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 1. 입력
		String year = request.getParameter("year");
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		
		// 2. 작업
		int yyyy = Integer.parseInt(year);
		int mm = Integer.parseInt(month);
		int dd = Integer.parseInt(day);
		
		Calendar cal = Calendar.getInstance();
		cal.set(yyyy,  mm -1, dd);
		
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK); // 1:일요일, 2:월요일 ...
		char yoil = " 일월화수목금토".charAt(dayOfWeek);
		
		// 3. 출력
		response.setContentType("text/html"); // 출력 전 해줘야 할 일 : 출력할 내용의 타입을 설정해줘야 함. 브라우저는 내가 text를 보낼지 binary를 보낼지 몰라서
		response.setCharacterEncoding("utf-8"); // 이게 없으면 한글이 깨진다
		// response 객체에서 getWriter()를 호출해야 브라우저로의 출력 스트림을 얻는다
		PrintWriter out = response.getWriter(); // getWriter() 가 예외를 던지도록 설정되어 있어서, 예외 던지기 선언해줘야 함
		out.println(year + "년 " + month + "월 " + day + "일은 ");
		out.println(yoil + "요일입니다.");
		
		// 아래 부분만 쓰면 콘솔에서만 출력
//		System.out.println(year + "년 " + month + "월 " + day + "일은 ");
//		System.out.println(yoil + "요일입니다.");
	}
}