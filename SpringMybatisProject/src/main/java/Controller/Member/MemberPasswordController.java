package Controller.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import Command.Member.ChangePwdCommand;
import Command.Member.MemberCommand;
import Controller.Encrypt;
import Model.DTO.MemberDTO;
import Service.Member.PwModifyService;

//@ModelAttribute는 컨트롤러에서만 사용가능 !
@Controller
@RequestMapping(value="/edit/changePassword")
public class MemberPasswordController {
	@Autowired
	private PwModifyService pwModifyService;
	
	@RequestMapping(method =  RequestMethod.GET )
	public String memPw(MemberCommand memerCommand ) {
		return "member/pwModify";	
		}

	@RequestMapping(method= RequestMethod.POST)
	public String changePw(MemberCommand memberCommand, Errors errors,Model model ) {	
	
		return pwModifyService.execute(memberCommand, errors, model);			
	}
}
