package com.shine.castle.main.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
	
	@RequestMapping(value = "/vue")
	public String vue() {
		return "exam/vue";
	}
	
}
