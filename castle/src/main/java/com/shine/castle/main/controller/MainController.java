package com.shine.castle.main.controller;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MainController {
	
	@Value("${sms.send.message.yn}")
	private String message ;
	
	public static String url = "main";

	@RequestMapping(value = "/")
	public String main() {
		return url+"/main";
	}
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public @ResponseBody String testGet(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Enumeration names = session.getAttributeNames();
			while(names.hasMoreElements()){
				String name = names.nextElement().toString();
				String value = session.getAttribute(name).toString();
				log.info(name + " "+ value);
			}
		log.info("GET 등록");
		return url+"/main";
	}
	
	@RequestMapping(value = "/test", method = RequestMethod.POST)
	public @ResponseBody String testPost(HttpServletRequest request) {
		String a = request.getParameter("input");
		log.info(a+" POST 등록");
		return url+"/main";
	}
}
