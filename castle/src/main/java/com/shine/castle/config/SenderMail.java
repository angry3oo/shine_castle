package com.shine.castle.config;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import com.shine.castle.security.vo.MailInfoVo;


@Component
public class SenderMail {
	
	@Autowired
	private JavaMailSender mailSender;
	
    public MimeMessage CreateMail(String mail) {
        MimeMessage message = mailSender.createMimeMessage();

        try {
            message.setFrom("eogh20001@naver.com");
            message.setRecipients(MimeMessage.RecipientType.TO, mail);
            message.setSubject("이메일 인증");
            String body = "";
            body += "<h3>" + "요청하신 인증 번호입니다." + "</h3>";
            body += "<h1>" + "</h1>";
            body += "<h3>" + "감사합니다." + "</h3>";
            message.setText(body,"UTF-8", "html");
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        return message;
    }
    
    
    public void simpleCreateMessage(MailInfoVo info) {
    	SimpleMailMessage simpleMsg = new SimpleMailMessage();
    	simpleMsg.setFrom(info.getFrom());
    	simpleMsg.setTo(info.getToEmail()+"@"+info.getToDoMain());
    	simpleMsg.setSubject(info.getSubject());
    	simpleMsg.setText(info.getText());
    	mailSender.send(simpleMsg);
    	//메일 전송 테이블 생성 후 저장
    }
}
