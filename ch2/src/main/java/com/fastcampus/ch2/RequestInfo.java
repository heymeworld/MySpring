package com.fastcampus.ch2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class RequestInfo {
    @RequestMapping("/requestInfo")
//        public static void main(String[] args) {
    public void main(HttpServletRequest request,
    		HttpServletResponse response)
//    		String name,
//    		String age,
//    		int age)
    	throws IOException
    {
    	// 1. 입력받기
    	String name = request.getParameter("name");
    	String age = request.getParameter("age");
    	
    	int koreanAge = Integer.parseInt(age);
    	
    	// 2. 처리
    	System.out.println("name="+name);
    	System.out.println("age="+age);
    	System.out.println("koreanAge="+(age+1));
    	
    	// 3.출력 - 응답보내기(브라우저로) --> Servlet : JAVA 속의 HTML
    	PrintWriter out = response.getWriter();
    	out.println("<html>");
    	out.println("<h1>name="+name+"</h1>");
    	out.println("<h1>age="+age+"</h1>");
    	
    	out.close();
    	
//        System.out.println("request.getCharacterEncoding()="+request.getCharacterEncoding()); // 요청 내용의 인코딩
//        System.out.println("request.getContentLength()="+request.getContentLength());  // 요청 내용의 길이. 알수 없을 때는 -1
//        System.out.println("request.getContentType()="+request.getContentType()); // 요청 내용의 타입. 알 수 없을 때는 null
//
//        System.out.println("request.getMethod()="+request.getMethod());      // 요청 방법
//        System.out.println("request.getProtocol()="+request.getProtocol());  // 프로토콜의 종류와 버젼 HTTP/1.1
//        System.out.println("request.getScheme()="+request.getScheme());      // 프로토콜
//
//        System.out.println("request.getServerName()="+request.getServerName()); // 서버 이름 또는 ip주소
//        System.out.println("request.getServerPort()="+request.getServerPort()); // 서버 포트
//        System.out.println("request.getRequestURL()="+request.getRequestURL()); // 요청 URL
//        System.out.println("request.getRequestURI()="+request.getRequestURI()); // 요청 URI
//
//        System.out.println("request.getContextPath()="+request.getContextPath()); // context path
//        System.out.println("request.getServletPath()="+request.getServletPath()); // servlet path
//        System.out.println("request.getQueryString()="+request.getQueryString()); // 쿼리 스트링
//
//        System.out.println("request.getLocalName()="+request.getLocalName()); // 로컬 이름
//        System.out.println("request.getLocalPort()="+request.getLocalPort()); // 로컬 포트
//
//        System.out.println("request.getRemoteAddr()="+request.getRemoteAddr()); // 원격 ip주소
//        System.out.println("request.getRemoteHost()="+request.getRemoteHost()); // 원격 호스트 또는 ip주소
//        System.out.println("request.getRemotePort()="+request.getRemotePort()); // 원격 포트

//        return "home";
    }
}