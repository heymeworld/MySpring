package com.fastcampus.ch2;

import java.io.IOException;
import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

// 년월일을 입력하면 요일을 알려주는 프로그램
@Controller
public class YoilTellerMVC {
	@RequestMapping("/getYoilMVC")
	// request 까지만 입력하면 console 에서는 잘 보이지만, 우리는 브라우저에서도 결과값을 띄우고 싶다
	// 그러려면 response 를 사용해야 한다
//	public static void main(HttpServletRequest request, HttpServletResponse response) throws IOException {
	public static String main(int year, int month, int day,
//	public static void main(int year, int month, int day,
		Model model) throws IOException {
//	public ModelAndView main(int year, int month, int day) throws IOException {
//		ModelAndView mv = new ModelAndView();
		
		// 1. 유효성 검사
//		if(!isValid(year, month, day))
//			return "yoilError";
		
		// 2. 작업
		char yoil = getYoil(year, month, day);
		
		// 3. 계산한 결과를 model에 저장
		model.addAttribute("year", year);
		model.addAttribute("month", month);
		model.addAttribute("day", day);
		model.addAttribute("yoil", yoil);
		
		return "yoil2"; // /WEB-INF/views/yoil2.jsp
		
//		mv.addObject("year", year);
//		mv.addObject("month", month);
//		mv.addObject("day", day);
//		mv.addObject("yoil", yoil);
		
		// 4. 계산한 결과를 model에 저장
//		mv.setViewName("yoil2");
//		return mv;
	}

	private static boolean isValid(int year, int month, int day) {
		// TODO Auto-generated method stub
		return true;
	}

	private static char getYoil(int year, int month, int day) {
		Calendar cal = Calendar.getInstance();
		cal.set(year,  month -1, day);
		
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK); // 1:일요일, 2:월요일 ...
		return " 일월화수목금토".charAt(dayOfWeek);
	}
}