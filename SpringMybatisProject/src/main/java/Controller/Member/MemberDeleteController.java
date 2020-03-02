package Controller.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Service.Member.MemberDeleteService;

@Controller
public class MemberDeleteController {
	@Autowired
	MemberDeleteService  memberDeleteService;
	
	@RequestMapping("/edit/memberInfoDel")
	public String deleteMember(@RequestParam(value="id") String userId) {
		
		memberDeleteService.memDel(userId);
		
		
		return "redirect:/member/memberList";		 		
		//삭제일경우
		//return "redirect:/edit/logout";
	}
	
}
