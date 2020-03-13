package Service.Member;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import Command.Member.MemberCommand;
import Controller.Encrypt;

import Model.DTO.MemberDTO;
import Repository.Member.MemberJoinRepository;


@Service
public class MemberJoinService {
	@Autowired
	MemberJoinRepository memberJoinRepository;
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	RegMailService regMailService;
	
	
	public Integer execute(MemberCommand memberCommand) throws ParseException  {
		Integer i= 0;
		MemberDTO memberDTO = new MemberDTO();
		
		
		memberDTO.setUserAddr(memberCommand.getUserAddr());
		Timestamp userBirth = new Timestamp(
													memberCommand.getUserBirth().getTime());
		memberDTO.setUserBirth(userBirth);
		memberDTO.setUserEmail(memberCommand.getUserEmail());
		memberDTO.setUserGender(memberCommand.getUserGender());
		memberDTO.setUserId(memberCommand.getUserId());
		memberDTO.setUserName(memberCommand.getUserName());
		memberDTO.setUserPh1(memberCommand.getUserPh1());
		memberDTO.setUserPh2(memberCommand.getUserPh2());
		memberDTO.setUserPw(
	            bCryptPasswordEncoder.encode(memberCommand.getUserPw()));

			i = memberJoinRepository.insertMember(memberDTO);
			
			
		if( i != null) {
			regMailService.sendMail(memberDTO.getUserEmail(), memberDTO.getUserId());		
		}
		
		return i;
	}
	
	public Integer numUpdate(String num, String reciver, String userId) {
		MemberDTO DTO = new MemberDTO();
		
		DTO.setJoinOK(num);
		DTO.setUserEmail(reciver);
		DTO.setUserId(userId);
	return memberJoinRepository.joinOkUpdate(DTO);
	}

}
