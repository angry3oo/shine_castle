package com.shine.castle.security.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class SecurityController {
	
	@Value("${sms.send.message.yn}")
	private String message ;
	
	public static String url = "login";

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return url+"/login";
	}
	
	@RequestMapping(value = "/login/memberShip", method = RequestMethod.GET)
	public String memberShip() {
		return url+"/memberShip";
	}
}
