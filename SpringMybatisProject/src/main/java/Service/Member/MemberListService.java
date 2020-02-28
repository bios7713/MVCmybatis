package Service.Member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;


import Model.DTO.MemberDTO;
import Repository.Member.MemberListRepository;

@Service
public class MemberListService {
	@Autowired
	MemberListRepository memberListRepository;

	
	public void memberList(Model model ,Integer page) {
              int limit = 10;
              int limitPage =10;
              
			List<MemberDTO> dto = 
					memberListRepository.selectList(page,limit,limitPage);		
		int listCount = 	memberListRepository.ListCount();
			if(dto != null) {
				model.addAttribute("memberList" , dto);	
				model.addAttribute("count", listCount );
			}
		int maxPage = (int)((double)listCount / limit + 0.95) ;
		int startPage = (int)(((double)page /limitPage +0.9 ) -1) * limitPage +1 ;
		int endPage = startPage + limitPage -1;
		if(endPage > maxPage) endPage = maxPage;
		
		model.addAttribute("maxPage" , maxPage);
		model.addAttribute("startPage" , startPage);
		model.addAttribute("endPage" , endPage);
		model.addAttribute("page" , page);
		model.addAttribute("count" , listCount);
		model.addAttribute("memberList" , dto);
		
	}


}
