package com.fastcampus.ch2;

import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller // 원격 프로그램 등록
public class YoilTeller {
	@RequestMapping("/yoil")
//	public void main(String year, String month, String day) {
//	public void main(int year, int month, int day) {
//	public void main(MyDate myDate) {
	public String main(@ModelAttribute MyDate date, Model model) {
//		String year = request.getParameter("year");
//		int yyyy = Integer.parseInt("year";)
//		System.out.println("year="+myDate.getYear());
//		System.out.println("month="+myDate.getMonth());
//		System.out.println("day="+myDate.getDay());
		
		char yoil = getYoil(date);
		
//		model.addAttribute("year", myDate.getYear());
//		model.addAttribute("month", myDate.getMonth());
//		model.addAttribute("day", myDate.getDay());
		
		model.addAttribute("myDate", date);
		model.addAttribute("yoil2", yoil);
		
		return "yoil";
	}
	
	// 붙어있는 메서드 실행
	@ModelAttribute("yoil2") // ModelAttribute 변수명 
	private char getYoil(MyDate date) {
       Calendar cal = Calendar.getInstance();
       cal.set(date.getYear(), date.getMonth() - 1, date.getDay());

       int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
       return " 일월화수목금토".charAt(dayOfWeek);
	}
}
