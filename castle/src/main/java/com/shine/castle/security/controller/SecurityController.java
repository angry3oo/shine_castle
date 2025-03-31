package com.shine.castle.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shine.castle.security.service.SecurityService;
import com.shine.castle.security.vo.MailInfoVo;
import com.shine.castle.security.vo.UserVo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class SecurityController {
	
	@Value("${sms.send.message.yn}")
	private String message;
	
	public static String url = "login";
	
	@Autowired
	private SecurityService securityService;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model) {
		model.addAttribute("title", "로그인");
		return url+"/login";
	}
	
	@RequestMapping(value = "/login/memberShip", method = RequestMethod.GET)
	public String memberShip(Model model) {
		model.addAttribute("title", "회원가입");
		return url+"/memberShip";
	}
	
	@RequestMapping(value = "/login/idCheck", method = RequestMethod.POST)
	public @ResponseBody int memberShip(@RequestBody UserVo userVo) {
		return securityService.idCheck(userVo);
	}

	@RequestMapping(value = "/login/emailCheck", method = RequestMethod.POST)
	public @ResponseBody Boolean emailCheck(@RequestBody MailInfoVo mailInfoVo) {
		return securityService.emailCheck(mailInfoVo);
	}
}
