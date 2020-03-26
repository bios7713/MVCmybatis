package Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Mcontroller {
	@RequestMapping("/finalMain")
	public String M() {
		return "/main/newMain";
	}
}
