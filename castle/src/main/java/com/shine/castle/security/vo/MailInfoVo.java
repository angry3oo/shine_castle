package com.shine.castle.security.vo;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@Component
public class MailInfoVo{
	
	private String from;
	
	private String toEmail;
	private String toDoMain;
	
	private String subject;
	private String text;
	
}
