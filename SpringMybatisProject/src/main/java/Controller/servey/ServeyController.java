package Controller.servey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import Command.Servey.AnsweredData;

import Service.Servey.ServeyService;

@Controller
@RequestMapping("servey/serveyForm")
public class ServeyController {
	@Autowired
	private ServeyService serveyService;


	@RequestMapping(method = RequestMethod.GET)
	public String servey(Model model) {
		serveyService.execute(model);
		return "servey/serveyForm"; 
	}


	
	 @RequestMapping(method = RequestMethod.POST)
	 public String servey1(@ModelAttribute("ansData") AnsweredData data) {
		 
		 return "servey/submitted";
		 
		 
	 }
	 
}
