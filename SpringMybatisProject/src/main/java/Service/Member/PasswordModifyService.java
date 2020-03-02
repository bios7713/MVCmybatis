package Service.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;

import Command.Member.ChangePwdCommand;
import Controller.Encrypt;
import Model.DTO.MemberDTO;
import Model.DTO.UserPasswordChangeDTO;
import Repository.Member.LoginRepository;
import Repository.Member.MemberDMLRepository;


@Service
public class PasswordModifyService {
	@Autowired
	private LoginRepository loginRepository;
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	MemberDMLRepository  memberDMLRepository;
   public String updatePassword(ChangePwdCommand changePwdCommand,
		                                                                 Errors errors, Model model ) {	  
	  MemberDTO DTO = new MemberDTO();
	  DTO.setUserId(changePwdCommand.getUserId());
	  
	   
	  DTO = loginRepository.selectByUserId(DTO);
	  if(bCryptPasswordEncoder.matches(changePwdCommand.getPw(), DTO.getUserPw())) {
		  UserPasswordChangeDTO pwDTO = new UserPasswordChangeDTO(
				  													changePwdCommand.getUserId(),
				  																			DTO.getUserPw(),
				     bCryptPasswordEncoder.encode(changePwdCommand.getNewPw()));
		  
		  memberDMLRepository.chanPw(pwDTO);
		  
		  return "redirect:/member/memberList";  		  
	  }else {
		
		  errors.rejectValue("pw", "notCurrent"); 

		  return "member/pwModify_1";
	  }

	   
	}
}