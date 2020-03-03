package Service.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;

import Command.Member.ChangePwdCommand;
import Command.Member.MemberCommand;

import Model.DTO.MemberDTO;
import Repository.Member.LoginRepository;
import Repository.Member.MemberDMLRepository;

@Service
public class PwModifyService {
	@Autowired
	LoginRepository loginRepository;
	@Autowired
	BCryptPasswordEncoder  bCryptPasswordEncoder;
	public String execute(MemberCommand memberCommand,Errors errors,Model model) {
		MemberDTO DTO = new MemberDTO();
		DTO.setUserId(memberCommand.getUserId());
		
		DTO = loginRepository.selectByUserId(DTO);
		
	if(bCryptPasswordEncoder.matches(memberCommand.getUserPw(),DTO.getUserPw())) {
		ChangePwdCommand CPC = new ChangePwdCommand();
		      CPC.setUserId(memberCommand.getUserId());
			 model.addAttribute("changePwdCommand" ,CPC);
			 return "member/pwModify_1";
		  }else {			  
			 errors.rejectValue("userPw", "badPw");
			 return "member/pwModify";			  
		  }
		
		
		
		
	
	}
}
