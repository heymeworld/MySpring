package com.fastcampus.ch2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TwoDice {
    @RequestMapping("/rollDice")
    //    public static void main(String[] args) {
    public void main(HttpServletResponse response) throws IOException {
    	int idx1 = (int)(Math.random()*6)+1;   
    	int idx2 = (int)(Math.random()*6)+1;
    	
    	response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
    	out.println("<!DOCTYPE html>");
    	out.println("<html lang='en'>");
    	out.println("<head>");
    	out.println("    <meta charset='UTF-8'>");
    	out.println("    <meta name='viewport' content='width=device-width, initial-scale=1.0'>");
    	out.println("    <title>Document</title>");
    	out.println("</head>");
    	out.println("<body>");
    	out.println("    <img src='resources/dice/dice"+idx1+".jpg'>");
    	out.println("    <img src='resources/dice/dice"+idx2+".jpg'>");
    	out.println("</body>");
    	out.println("</html>");
    }
}