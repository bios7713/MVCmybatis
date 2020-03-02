package Service.Member;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import Command.Member.MemberCommand;
import Controller.Encrypt;

import Model.DTO.MemberDTO;
import Repository.Member.MemberDMLRepository;

@Service
public class MemberModifyService {
	@Autowired
    private MemberDMLRepository memberDMLRepository;
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	public Integer memberModify(MemberCommand memberCommand , Model model) {
		MemberDTO DTO = new MemberDTO();
		
		DTO.setUserBirth(
				new Timestamp(memberCommand.getUserBirth().getTime()));
		DTO.setUserId(memberCommand.getUserId());
		DTO.setUserEmail(memberCommand.getUserEmail());		
		DTO.setUserAddr(memberCommand.getUserAddr());
		DTO.setUserGender(memberCommand.getUserGender());
		DTO.setUserPh1(memberCommand.getUserPh1());
		DTO.setUserPh2(memberCommand.getUserPh2());
		DTO.setUserName(memberCommand.getUserName());
		DTO.setUserPw(
			   bCryptPasswordEncoder.encode(memberCommand.getUserPw()));

		return memberDMLRepository.memberUpdate(DTO);
	}
}
