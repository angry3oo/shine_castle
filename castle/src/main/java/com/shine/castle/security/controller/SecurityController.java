package com.shine.castle.security.controller;

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
public class SecurityController {
	
	@Value("${sms.send.message.yn}")
	private String message ;
	
	public static String url = "login";

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String main() {
		return url+"/login";
	}
}
