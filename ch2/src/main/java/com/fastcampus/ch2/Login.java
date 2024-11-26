package com.fastcampus.ch2;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//HttpServletResponse response,

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Login {
	@RequestMapping("/login")
	public void main(HttpServletRequest request) {

	}
	
	@RequestMapping("/user-info")
	public String login2(HttpServletRequest request, HttpServletResponse response, String id, String pw, Model model) {
//		String id = request.getParameter("id");
//		String pw = request.getParameter("pw");
		model.addAttribute("id",id);
		model.addAttribute("pw",pw);
		System.out.println("id : "+id);
		System.out.println("pw : "+pw);
		
		return "user-info";
	}
}
