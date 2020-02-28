package Service.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;

import Command.Member.MemberCommand;

import Model.DTO.MemberDTO;

@Service
public class PwModifyService {
	//@Autowired

	
	
	public MemberDTO execute(MemberCommand memberCommand) {
		MemberDTO memberDTO = new MemberDTO();


		memberDTO.setUserId(memberCommand.getUserId());
		memberDTO.setUserPw(memberCommand.getUserPw());
		memberDTO = memberDAO.selectByUserId(memberDTO);
	
		return memberDTO;
	}
}
