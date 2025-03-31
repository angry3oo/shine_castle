package com.shine.castle.config;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import com.shine.castle.security.vo.MailInfoVo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class SenderMail {
	
	@Autowired
	private JavaMailSender mailSender;
	
    /**
     * @param mail
     * @return
     */
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
    
    
    /**
     * @param info
     * @return
     */
    public Boolean simpleCreateMessage(MailInfoVo info) {
    	try {
    		String to = info.getToEmail()+"@"+info.getToDoMain();
    		this.toAddrVdt(to);
    		
    		SimpleMailMessage simpleMsg = new SimpleMailMessage();
        	simpleMsg.setFrom(info.getFrom());
        	simpleMsg.setTo(to);
        	simpleMsg.setSubject(info.getSubject());
        	simpleMsg.setText(info.getText());
        	mailSender.send(simpleMsg);
        	//메일 전송 테이블 생성 후 저장
        	return true;
    	}catch (AddressException ad) {
    		log.debug(ad.getMessage());
    		return false;
		}catch (Exception e) {
			log.debug(e.getMessage());
			return false;
		}
    	
    }
    
    /**
     * @param to
     * @throws AddressException
     */
    public void toAddrVdt(String to) throws AddressException {
    	new InternetAddress(to).validate();
    }
}
