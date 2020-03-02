package Controller.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import Command.Member.ChangePwdCommand;
import Repository.Member.LoginRepository;
import Service.Member.PasswordModifyService;
import Validator.ChangePwdCommandValidator;

@Controller
public class PwModifyProController {
	@Autowired
	private PasswordModifyService passwordModifyService;

	@RequestMapping(value="/edit/pwModifyPro" , method = RequestMethod.POST)
	public String pwModifyPro(ChangePwdCommand changePwdCommand , Errors errors ,Model model) {
		
	return	passwordModifyService.updatePassword(changePwdCommand,errors,model);
	}
}
