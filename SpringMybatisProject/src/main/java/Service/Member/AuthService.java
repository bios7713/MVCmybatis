package Service.Member;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;

import Command.Member.LoginCommand;
import Controller.Encrypt;

import Model.DTO.AuthInfo;
import Model.DTO.MemberDTO;
import Repository.Member.LoginRepository;


@Service
public class AuthService {
	
	@Autowired
	private LoginRepository loginRepository;
	
	
	
	@Autowired
	 private BCryptPasswordEncoder bcryptPasswordEncoder;
	
	public void authenticate(LoginCommand loginCommand,Errors errors , HttpSession session, HttpServletResponse response) {
		MemberDTO dto = new MemberDTO();
		 dto.setUserId(loginCommand.getId1());
		dto = loginRepository.selectByUserId(dto);
	
		 if(dto == null) {
			 errors.rejectValue("id1", "notId");
			 
		 }else { 			 
			 if( bcryptPasswordEncoder.matches(
		               loginCommand.getPw() , dto.getUserPw())) {
					AuthInfo authInfo = new AuthInfo(							
							 dto.getUserId(),
								 dto.getUserEmail(),
								 dto.getUserName(),
								 dto.getUserPw()							
							);	 
			 	 	   session.setAttribute("authInfo", authInfo);				 	 
			 }
		 }
	
		 

		 
		 
		 
	
	
		 
		
		
	}
	 

}
