package Service.Member;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


import org.springframework.mail.javamail.JavaMailSender;

public class RegMailService {

	private JavaMailSender mailSender;
	
	public void sendMail(String reciver , String userId) {
		
		MimeMessage msg = mailSender.createMimeMessage();
		SimpleDateFormat dateForm = new SimpleDateFormat("yyyyMMddmmss");
		String num = dateForm.format(new Date());
		String content = "<html><body>"
							  +"하이 ' " + userId + " ' 님 가입환영이염. <br/> " 
							  + "아래 링크를 누르면 가입이 완료됩니다. <br/> "
							  +"<a href = 'http://192.168.4.111:8080/SpringMybatisProject/"
							  + "memberMail?num="+num+"&reciver="+reciver+"&userId="+userId+" '>"
							  +"<strong><b>"
							  + " 가입을 하려면 눌러 <a/>"
							  +"</b></strong>"
							  +"</body></html>";
		
		String subject = "가입환영";
		try {
			msg.setHeader("context-type", "text/html; charset=UTF-8");
			msg.setContent(content, "text/html; charset=UTF-8" );
			msg.setSubject(subject);
			msg.setRecipient(MimeMessage.RecipientType.TO , new InternetAddress(reciver));
			mailSender.send(msg);
			
		} catch (MessagingException e) {
			
			e.printStackTrace();
		}
	}
}
