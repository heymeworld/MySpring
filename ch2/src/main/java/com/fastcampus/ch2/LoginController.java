package com.fastcampus.ch2;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	@RequestMapping("/login")
	public String login(HttpServletRequest request, HttpServletResponse response,
			String id, String pwd, boolean rememberId) throws Exception {
//		System.out.println("id : "+id);
//		System.out.println("pwd : "+pwd);
//		System.out.println("rememberId : "+rememberId);
		
		// 2-2. id와 pwd가 일치하면,
		//  세션 객체를 얻어오기
		HttpSession session = request.getSession();
		//  세션 객체에 id를 저장
		session.setAttribute("id", id);
				
		if(rememberId) {
			// true : 쿠키를 생성
			Cookie cookie = new Cookie("id", id);
			// 응답에 저장
			response.addCookie(cookie);
//			System.out.println("쿠키 저장 완료");
			
			// 로그인 성공 후, 아이디 값 다시 넘기기
			request.setAttribute("rememberedId", id);
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			
		} else {
			// false : 쿠키를 생성
			Cookie cookie = new Cookie("id", id);
			cookie.setMaxAge(0);
			// 응답에 저장
			response.addCookie(cookie);
//			System.out.println("쿠키 삭제");
		}
        
//		toURL = toURL==null || toURL.equals("") ? "/" : toURL;
//
//        return "redirect:"+toURL;
		return "login";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		// 1. 세션을 종료 	
		session.invalidate();
		// 2. 홈으로 이동		
		
		return "redirect:/";
	}
	
//	@RequestMapping("/login")
//	public String login(String id, String pwd, boolean idCheck) {
//		// 1. id와 pwd가 일치하면 userInfo로 이동
//		if(loginCheck(id, pwd)) {
//			
//		} else {
//		// 2. 일치하지 않으면 login.html으로 redirect
//		}
//		
//	}
//	
//	public boolean loginCheck(id, pwd) {
//		// DB에서 정보 읽어와서 처리하게 변경
//		return true;
//	}
//	@RequestMapping("/logout")
////	public String logout(HttpServletRequest request) {
////		HttpSession session = request.getSession();
//	public String logout(HttpSession session) {
//		session.invalidate();
//		
//		return "redirect:/"; // 홈으로 이동
//	}
	
	@RequestMapping("/userInfo")
	public String userInfo(HttpServletRequest request, String id, String pwd, Model model) {
//		String id = request.getParameter("id");
//		String pwd = request.getParameter("pwd");
		model.addAttribute("id",id);
		model.addAttribute("pwd",pwd);
		System.out.println("id : "+id);
		System.out.println("pwd : "+pwd);
		
		return "userInfo";
	}
}
