package Service.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Command.Member.ChangePwdCommand;
import Controller.Encrypt;


@Service
public class PasswordModifyService {
	//@Autowired

	
   public Integer updatePassword(ChangePwdCommand changePwdCommand ) {	  
	   return memberDAO.pwUpdate(
			   											changePwdCommand.getUserId(),
			   			Encrypt.getEncryption(changePwdCommand.getPw()),
			   			Encrypt.getEncryption(changePwdCommand.getNewPw())
			   					);
	}
}