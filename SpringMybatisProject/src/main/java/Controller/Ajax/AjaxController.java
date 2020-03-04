package Controller.Ajax;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class AjaxController {
	@RequestMapping(value="/ajaxTest")
	public String ajax() {

		return "ajax/ajaxTest";
	}
	@RequestMapping(value="/ajaxTest1")
	public String ajax1(@ModelAttribute(value="n") String n) {
		
		
		return "ajax/ajaxTest1";
	}
	@RequestMapping(value="/ajaxTest2")
	public String ajax2(@ModelAttribute(value="n") String n) {
		
		
		return "ajax/ajaxTest2";
	}

}
