package Controller.Goods;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import Command.Goods.GoodsCommand;
import Service.Goods.GoodsWriteService;

@Controller
public class GoodsWriteController {
@Autowired
private GoodsWriteService goodsWriteService;


@RequestMapping(value="/goods/goodsWriter")
public String goodsWrite() {
	
	
	return "goodsView/goodsForm";
}

@RequestMapping(value="/goods/goodsPro" , method = RequestMethod.POST)
public String goodsWritePro(GoodsCommand goodsCommand ,HttpSession session ,HttpServletRequest request) {
	
	System.out.println("ControllerCommand:" +goodsCommand.getGoodsContent());
	goodsWriteService.goodsWritePro(goodsCommand,session,request);
	
	
	return "redirect:/goods/goodsList";
}
	
}
