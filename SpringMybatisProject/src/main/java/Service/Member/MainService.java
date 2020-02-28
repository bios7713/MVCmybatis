package Service.Member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import Model.DTO.AuthInfo;
import Model.DTO.MemberDTO;

@Service
public class MainService {
	//@Autowired


	public void autoLogin(String userId, HttpSession session) {
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setUserId(userId);
		memberDAO.selectByUserId(memberDTO);
		AuthInfo authInfo = new AuthInfo(memberDTO.getUserId() ,
												  memberDTO.getUserEmail(),
												  memberDTO.getUserName(),
												  memberDTO.getUserPw());
		session.setAttribute("authInfo", authInfo);
		
		
		
		
		
		
	}
}
