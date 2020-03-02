package Service.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Model.DTO.MemberDTO;
import Repository.Member.MemberDMLRepository;

@Service
public class MemberDeleteService {
	@Autowired
	MemberDMLRepository  memberDMLRepository;
    	
	public void memDel(String userId) {
		MemberDTO DTO = new MemberDTO();
		DTO.setUserId(userId);
		
		memberDMLRepository.memDel(DTO);
		
	}
 
}
