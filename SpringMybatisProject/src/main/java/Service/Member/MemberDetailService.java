package Service.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;


import Model.DTO.MemberDTO;
import Repository.Member.MemberDetailRepository;

@Service
public class MemberDetailService {
	@Autowired
	MemberDetailRepository  memberDetailRepository;
	  
		  
		 public void memberDetail(String userId, Model model) {
			 System.out.println("Mdetailservice= "+ userId);
			 MemberDTO D = new MemberDTO();
			 D.setUserId(userId);
			 D = memberDetailRepository.selectByUserId(D);	 
			
			 
			 model.addAttribute("memberCommand", D);
		 }
}
