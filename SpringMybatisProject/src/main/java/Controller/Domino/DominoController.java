package Controller.Domino;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Service.Domino.DominoService;

@Controller
public class DominoController {
	@Autowired
	private DominoService dominoService;
	@RequestMapping("/domino") 
	public String domino(Model model) {

		dominoService.execute(model);

		return "domino/dominoMain";	
	}
	
	@RequestMapping("/dominoB")
	public String dominoB(@RequestParam(value="num") Integer a1 ,Model model) {
		dominoService.execute1(a1,model);
		
	return "domino/dominoB";	
	}
	
	@RequestMapping("/dominoC")
	public String dominoC(Model model,@RequestParam(value="a1") Integer a1,
			                                            @RequestParam(value="b1") Integer b1) {
		dominoService.execute2(model,a1,b1);
		return "domino/dominoC";	
	}

}
